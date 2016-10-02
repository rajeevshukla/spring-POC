package com.devstringx.pmt.utils;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class ApplicationUtilities {

	public static String getHashValue(String param) {
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder(256);
		return passwordEncoder.encodePassword(param, null);
	}

	public static String getCustomProperty(String key, String defaultValue) {

		  if(null== defaultValue ||  defaultValue.trim().equals("")){
		  return   	ApplicationMaps.PMT_PROPERTIES.getProperty(key);
		    }else  {
		   return 	 ApplicationMaps.PMT_PROPERTIES.getProperty(key, defaultValue);
		    }
	  }
	
}
