package com.spring.security.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/user")
@Controller
public class UserController {

	@RequestMapping("welcomeUser.htm")
	public ModelAndView welcomeUser(){
		ModelAndView mav=new ModelAndView();
		System.out.println("inside welcome user");

		return mav;
	}
}
