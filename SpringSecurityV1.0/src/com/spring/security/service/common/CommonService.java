package com.spring.security.service.common;

import org.springframework.stereotype.Service;

@Service
public class CommonService {

	
	/*@Qualifier("pmtEmailService")
	@Autowired
	PmtEmailService emailService;*/
	
	
	 public void registerNewUser(String userName,String emailId){

		 System.out.println("registering..");
		 //emailService.sendRegistrationEmail(emailId, userName);
	 
	 }
	
	
	
}
