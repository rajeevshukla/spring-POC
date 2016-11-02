package com.devstringx.pmt.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private Logger logger = Logger.getLogger(CustomAuthenticationSuccessHandler.class);

	public void onAuthenticationSuccess(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse,
			Authentication authentication) throws IOException, ServletException {
		logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%% inside custom class");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%% inside custom class");
		
		try {
			logger.debug(httpservletrequest.getHeader("User-Agent"));
			String deviceType = httpservletrequest.getParameter("deviceType");
			logger.debug("deviceType:: " + deviceType);
			
			if(null != deviceType && !"".equals(deviceType)){
				RequestDispatcher dispatcher = httpservletrequest.getRequestDispatcher("loginSuccess.htm");
				dispatcher.forward(httpservletrequest, httpservletresponse);
			}else{
				httpservletresponse.sendRedirect("validateUser.htm");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 logger.error("Error in custom Authentication success handlerrr", e);
		}
	}
}
