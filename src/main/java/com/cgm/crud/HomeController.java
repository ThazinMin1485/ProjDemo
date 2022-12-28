package com.cgm.crud;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	@RequestMapping(value= {"/"})
	public String viewHome() {
		return "home";
	}
	
	@RequestMapping(value= {"/login"})
	public String viewLogin() {
		return "login";
	}
	
	
	@RequestMapping(value= {"/logout"},method=RequestMethod.GET)
	public String viewLogOut(HttpServletRequest req,HttpServletResponse res) {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			new SecurityContextLogoutHandler().logout(req,res,auth);
		}
		return "home";
	}
	
	@RequestMapping(value= {"/passwordReset"})
	public String viewPasswordReset() {
		return "passwordReset";
	}
	
	@RequestMapping(value= {"/error"})
	public String error() {
		return "denied";
	}
}
