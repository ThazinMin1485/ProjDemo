package com.cgm.crud;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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
	
	@RequestMapping(value= {"/passwordReset"})
	public String viewPasswordReset() {
		return "passwordReset";
	}
	
	@RequestMapping(value= {"/error"})
	public String error() {
		return "denied";
	}
}
