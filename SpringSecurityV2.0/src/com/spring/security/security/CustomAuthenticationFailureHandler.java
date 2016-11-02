package com.spring.security.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;



public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler  {
	
	private Logger logger = Logger.getLogger(CustomAuthenticationFailureHandler.class);
	
	public CustomAuthenticationFailureHandler(){
		super();
	}
	

	@Override
	public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, AuthenticationException authException)
			throws IOException, ServletException {
		//DaoAuthenticationProvider
		
		logger.debug("#########################:" + super.isUseForward());
		String deviceType = httpServletRequest.getParameter("deviceType");
		logger.debug("deviceType:: " + deviceType);
		logger.debug(authException.getLocalizedMessage());
		
		if(null != deviceType && !"".equals(deviceType)){
			RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("/loginFailure.htm");
			dispatcher.forward(httpServletRequest, httpServletResponse);
		}else{
			super.onAuthenticationFailure(httpServletRequest, httpServletResponse, authException);
		}

	}

}