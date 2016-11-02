package com.devstringx.pmt.security;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devstringx.pmt.domain.common.UserDetailsDTO;



@Transactional(propagation=Propagation.REQUIRED)
public class AuthenticationService implements UserDetailsManager {
	
	private Logger logger = Logger.getLogger(AuthenticationService.class);
	
	private AuthenticationDAO authenticationDAO;
	
	public UserDetailsDTO loadUserByUsername(String username) {
		logger.debug("in method loadUserByUsername");
		UserDetailsDTO userDetailsDTO = authenticationDAO.getDetailsForUserId(username); 
		
		return userDetailsDTO;
	}


	public AuthenticationDAO getAuthenticationDAO() {
		return authenticationDAO;
	}



	public void setAuthenticationDAO(AuthenticationDAO authenticationDAO) {
		this.authenticationDAO = authenticationDAO;
	}



	public void changePassword(String oldPassword, String newPassword) {
		UserDetailsDTO userDetails = (UserDetailsDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.debug("inside change password function for user: " + userDetails.getUsername());
		String updatePwdQuery = "update UserDetailsDTO u set u.password = :newPassword, u.version = :version, " +
				"u.strUpdatedAuthor = :updatedAuthor, updatedDate = :updatedDate where u.username = :userId";
		
		authenticationDAO.updatePasswordForUser(updatePwdQuery,userDetails,newPassword);
		userDetails.setPassword(newPassword);
	}



	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}



	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}


	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}