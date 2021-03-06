package com.spring.security.utils;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class BootLoader {

	@PostConstruct
	public void init(){

		System.out.println("Loading properties..");
		try {
			ApplicationMaps.PMT_PROPERTIES.load(this.getClass().getResourceAsStream("/config.properties"));
			System.out.println("Properties loaded successfuly");
			System.out.println(ApplicationMaps.PMT_PROPERTIES);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
