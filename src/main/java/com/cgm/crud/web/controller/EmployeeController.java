package com.cgm.crud.web.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.Validator;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cgm.crud.bl.dto.EmployeeDto;
import com.cgm.crud.bl.service.EmployeeServices;
import com.cgm.crud.persistence.entity.Employee;
import com.cgm.crud.web.form.CreateEmpForm;

/**
 * <h2>EmployeeController Class</h2>
 * <p>
 * Process for Displaying EmployeeController
 * </p>
 * 
 * @author User
 *
 */
@Controller
public class EmployeeController {

	/**
	 * <h2>service</h2>
	 * <p>
	 * service
	 * </p>
	 */
	@Autowired
	private EmployeeServices service;

	/**
	 * <h2>lcappEmailService</h2>
	 * <p>
	 * lcappEmailService
	 * </p>
	 */
	/**
	 * <h2>showRegister</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param model
	 * @return
	 * @return String
	 */
	@RequestMapping(value = { "/addEmployee" }, method = RequestMethod.GET)
	public String showRegister(Model model) {
		model.addAttribute("employee", new Employee());
		return "register";
	}

	/**
	 * <h2>insertEmployee</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param emp
	 * @param result
	 * @return
	 * @return String
	 */
	@RequestMapping(value = { "/insertEmployee" }, method = RequestMethod.POST)
	public String insertEmployee(@Valid @ModelAttribute("employee") CreateEmpForm emp, BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		} else {
			service.addEmp(emp);
			return "redirect:/addEmployee";
		}

	}

	/**
	 * <h2>lodeEmployee</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return ModelAndView
	 */
	@GetMapping("employeeReport")
	public ModelAndView lodeEmployee() {
		ModelAndView report = new ModelAndView("employeeReport");
		List<EmployeeDto> emp = service.getAllEmp();
		report.addObject("employee", emp);
		report.addObject("title", "Employee Report");

		return report;
	}

	/**
	 * <h2>lodeEditForm</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param id
	 * @param m
	 * @return
	 * @return String
	 */
	@GetMapping("/editEmployee/{id}")
	public String lodeEditForm(@PathVariable(value = "id") int id, Model m) {
		Employee emp = service.getById(id);

		System.out.println(emp);
		m.addAttribute("employee", emp);
		m.addAttribute("title", "Edit Employee");

		return "editEmployee";
	}

	/**
	 * <h2>updateEmp</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param emp
	 * @return
	 * @return String
	 */
	@PostMapping("/editEmployee/updateEmployee")
	public String updateEmp(@ModelAttribute("updateEmployee") Employee emp) {
		service.updateEmp(emp);

		return "redirect:/employeeReport";
	}

	/**
	 * <h2>deleteEmployee</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param id
	 * @return
	 * @return String
	 */
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);

		return "redirect:/employeeReport";
	}

	/**
	 * <h2>downloadExcel</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = { "/exportEmployee" }, method = RequestMethod.GET)
	public ModelAndView downloadExcel() {
		List<EmployeeDto> empList = service.getAllEmp();
		return new ModelAndView("excelView", "empList", empList);
	}

    @RequestMapping(value = "/importEmployee", method = RequestMethod.POST)
	public String uploadExcel(@RequestParam("file") MultipartFile file, RedirectAttributes redirect) throws IOException {

		String message=service.doImportEmp(file);
		redirect.addFlashAttribute("message", message);
		return "redirect:/employeeReport";
	}

}
