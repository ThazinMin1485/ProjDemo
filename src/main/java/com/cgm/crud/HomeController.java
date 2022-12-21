package com.cgm.crud;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	@RequestMapping(value= {"/"})
	public String viewHome() {
		return "home";
	}

}
