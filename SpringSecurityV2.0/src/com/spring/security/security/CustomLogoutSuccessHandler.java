package com.devstringx.pmt.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;



public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication arg2) throws IOException,
			ServletException {
		String deviceType = request.getParameter("deviceType");
		if(null != deviceType && !"".equals(deviceType)){
			RequestDispatcher dispatcher = request.getRequestDispatcher("logoutSuccess.htm");
			dispatcher.forward(request, response);
		}else{
			
			super.onLogoutSuccess(request, response, arg2);
		}

	}

}