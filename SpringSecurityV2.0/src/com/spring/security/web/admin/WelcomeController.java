package com.spring.security.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping(value="welcome.htm")
	public void bootLoader(){
		System.out.println("this method is called.");
	}
}
