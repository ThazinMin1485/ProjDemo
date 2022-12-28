package com.cgm.crud;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <h2>HomeController Class</h2>
 * <p>
 * Process for Displaying HomeController
 * </p>
 * 
 * @author User
 *
 */
@Controller
public class HomeController {
	// for home page
	/**
	 * <h2>viewHome</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	@RequestMapping(value = { "/" })
	public String viewHome() {
		return "home";
	}

	// for login page
	/**
	 * <h2>viewLogin</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	@RequestMapping(value = { "/login" })
	public String viewLogin() {
		return "login";
	}

	// do logout
	/**
	 * <h2>viewLogOut</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param req
	 * @param res
	 * @return
	 * @return String
	 */
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String viewLogOut(HttpServletRequest req, HttpServletResponse res) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(req, res, auth);
		}
		return "home";
	}

	// for passwordReset page
	/**
	 * <h2>viewPasswordReset</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	@RequestMapping(value = { "/passwordReset" })
	public String viewPasswordReset() {
		return "passwordReset";
	}

	// for error page
	/**
	 * <h2>error</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	@RequestMapping(value = { "/error" })
	public String error() {
		return "denied";
	}
}
