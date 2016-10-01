package com.spring.security.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping("admin/welcome.htm")
	public ModelAndView welcomeAdmin(){
		ModelAndView modelAndView = new ModelAndView("admin/welcome");
		System.out.println("inside admin welcome");
		 return modelAndView;
	}
}
