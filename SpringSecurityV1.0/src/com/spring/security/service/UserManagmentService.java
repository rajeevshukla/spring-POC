package com.spring.security.service;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.spring.security.dao.AuthenticationDAO;
import com.spring.security.domain.common.UserDetailsDTO;


@Service
public class UserManagmentService extends AuthenticationService implements UserDetailsManager{

	public void changePassword(String arg0, String arg1) {
		
		UserDetailsDTO userDetails = (UserDetailsDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PasswordEncoder encoder = new ShaPasswordEncoder(256);
		String encPassword = encoder.encodePassword(arg1, null);
		userDetails.setPassword(encPassword);
		//userDetails.setAuthorities(userDetails.getAdditionalAuthorities());
		AuthenticationDAO authenticationDAO = getAuthenticationDAO();
		authenticationDAO.updateUser(userDetails);
		
	}

	public void createUser(UserDetails arg0) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUser(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(UserDetails arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean userExists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void accountLocked(UserDetailsDTO detailsDTO){
		
		int count = detailsDTO.getFailureCount();
		count ++ ;
		detailsDTO.setFailureCount(count);
		
		
		
		if(count >= 5){
			detailsDTO.setAccountNonLocked(true);
			detailsDTO.setFailureCount(0);
		}
		AuthenticationDAO authenticationDAO = getAuthenticationDAO();
		authenticationDAO.updateUser(detailsDTO);
	}
	

}