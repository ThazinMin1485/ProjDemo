package com.cgm.crud.web.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.crud.bl.dto.EmployeeDto;
import com.cgm.crud.bl.service.EmployeeServices;
import com.cgm.crud.bl.service.PasswordServices;
import com.cgm.crud.web.form.ResetForm;
import com.cgm.crud.web.form.ResetPasswordForm;

/**
 * <h2>PasswordController Class</h2>
 * <p>
 * Process for Displaying PasswordController
 * </p>
 * 
 * @author User
 *
 */
@Controller
public class PasswordController {
	/**
	 * <h2>service</h2>
	 * <p>
	 * service
	 * </p>
	 */
	@Autowired
	private EmployeeServices service;

	/**
	 * <h2>javaMailSender</h2>
	 * <p>
	 * javaMailSender
	 * </p>
	 */
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private PasswordServices pwService;

	@Autowired
	private MessageSource msg;

	/**
	 * <h2>sendEmail</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param model
	 * @return
	 * @return String
	 */

	@RequestMapping(value = { "/sendEmail" }, method = RequestMethod.GET)
	public String sendEmail(Model model) {
		model.addAttribute("resetForm", new ResetForm());
		return "forgetPassword";
	}

	/**
	 * <h2>processEmail</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param resetForm
	 * @param result
	 * @param request
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = { "/processEmail" }, method = RequestMethod.POST)
	public ModelAndView processEmail(@Valid @ModelAttribute("resetForm") ResetForm resetForm, BindingResult result,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("forgetPassword");
		if (result.hasErrors()) {
			return mv;
		}
		EmployeeDto empDto = service.findByEmail(resetForm.getEmail());
		if (empDto == null) {
			mv.addObject("errorMsg", msg.getMessage("M_SC_USR_0003", null, null));
			return mv;
		}

		resetForm = pwService.createResetToken(resetForm.getEmail());
		String url = getBaseUrl(request) + request.getServletPath() + '/' + resetForm.getToken();
		this.sendEmail(url, resetForm);
		mv.setViewName("redirect:/");
		return mv;
	}

	/**
	 * <h2>showResetPasswordForm</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param token
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/processEmail/{token}", method = RequestMethod.GET)
	public ModelAndView showResetPasswordForm(@PathVariable String token) {
		ModelAndView mv = new ModelAndView("404");

		ResetForm resetForm = pwService.getDataByToken(token);

		if (resetForm == null) {
			mv.addObject("errorMsg", msg.getMessage("M_SC_USR_0005", null, null));
			return mv;
		}

		if (isTokenExpired(resetForm.getExpired_at())) {
			mv.addObject("errorMsg", msg.getMessage("M_SC_USR_0005", null, null));
			return mv;
		}

		ResetPasswordForm newResetForm = new ResetPasswordForm();
		newResetForm.setToken(token);

		mv.setViewName("resetForm");
		mv.addObject("resetForm", newResetForm);

		return mv;
	}

	/**
	 * <h2>resetPassword</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param resetForm
	 * @param result
	 * @param request
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = { "/resetPassword" }, method = RequestMethod.POST)
	public ModelAndView resetPassword(@Valid @ModelAttribute("resetForm") ResetPasswordForm resetForm,
			BindingResult result, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("resetForm");
		if (result.hasErrors()) {
			return mv;
		}

		if (!resetForm.getPassword().equals(resetForm.getConfirm_password())) {
			mv.addObject("errorMsg", msg.getMessage("M_SC_USR_0007", null, null));
			return mv;
		}

		String email = pwService.getDataByToken(resetForm.getToken()).getEmail();

		ResetForm newResetForm = new ResetForm();
		newResetForm.setEmail(email);
		newResetForm.setPassword(resetForm.getPassword());

		pwService.updatePassword(newResetForm);

		pwService.deleteToken(email);

		mv.setViewName("redirect:/login");
		mv.addObject("msg", msg.getMessage("M_SC_USR_0004", null, null));

		return mv;
	}

	/**
	 * <h2>sendEmail</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param url
	 * @param resetForm
	 * @throws UsernameNotFoundException
	 * @return void
	 */
	public void sendEmail(String url, @Valid ResetForm resetForm) throws UsernameNotFoundException {
		SimpleMailMessage newEmail = new SimpleMailMessage();
		newEmail.setFrom("jensonarial@gmail.com");
		newEmail.setTo(resetForm.getEmail());
		newEmail.setSubject("Password Reset Link");
		newEmail.setText("Hello," + "\n\n" + "You have requested to reset your password." + "\n\n"
				+ "Click the link below to change your password:" + "\n\n" + url
				+ "\n\nIgnore this email if you do remember your password or you have not make the request");
		javaMailSender.send(newEmail);
	}

	/**
	 * <h2>getBaseUrl</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param request
	 * @return
	 * @return String
	 */
	private String getBaseUrl(HttpServletRequest request) {
		String url = request.getScheme() + "://" + request.getServerName();
		if (request.getServerPort() != 0) {
			url = url + ":" + request.getServerPort();
		}
		url = url + request.getContextPath();
		return url;
	}

	/**
	 * <h2>isTokenExpired</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param expired_at
	 * @return
	 * @return boolean
	 */
	private boolean isTokenExpired(Timestamp expired_at) {
		Timestamp now = new Timestamp(new Date().getTime());
		return now.after(expired_at);

	}

}
