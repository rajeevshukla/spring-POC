package com.facebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.facebook")
public class SpringFacebookMain {

	public static void main(String[] args) {
		SpringApplication.run(SpringFacebookMain.class, args);
	}
}
