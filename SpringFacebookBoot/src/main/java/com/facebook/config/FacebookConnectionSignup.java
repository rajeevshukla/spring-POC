package com.facebook.config;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

@Service
public class FacebookConnectionSignup  implements ConnectionSignUp{

	
	
	@Override
	public String execute(Connection<?> connection) {

		System.out.println("Signing up "+ connection.getDisplayName());
		System.out.println(connection.getProfileUrl());
		
		return connection.getDisplayName();
	}
}
