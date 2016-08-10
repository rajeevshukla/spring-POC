package com.spring.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@PostConstruct
	void init(){
		System.out.println("bean instantiated");
	}

	@GetMapping("/login.htm")
	public String getLoginPage(){
		return "login";
	}
}
