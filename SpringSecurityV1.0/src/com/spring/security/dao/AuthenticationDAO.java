package com.spring.security.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.spring.security.domain.common.UserDetailsDTO;

@Repository
public class AuthenticationDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public UserDetails getDetailsForUserId(String userId){
		
		return null;
	}
	
	public void updateUser(UserDetailsDTO userDetails){
		
		System.out.println("Updated user details");
	}

	public void updatePasswordForUser(String query, UserDetailsDTO userDetailsDTO , String newPassword){
		
		System.out.println("Updaing new password");
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
