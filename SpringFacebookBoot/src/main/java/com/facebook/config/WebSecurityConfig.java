package com.facebook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;

@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{

	
	@Autowired
	ConnectionFactoryLocator connectionFactoryLocator;
	
	@Autowired
	UsersConnectionRepository userConnectionRepository;
	
	@Autowired
	FacebookConnectionSignup facebookConnectionSignup;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login*","/signin/**","/signup/**").permitAll().and().csrf().disable();
	}
	
	@Bean
	public ProviderSignInController providerSignInController() {
		((InMemoryUsersConnectionRepository)userConnectionRepository).setConnectionSignUp(facebookConnectionSignup);;
		return new ProviderSignInController(connectionFactoryLocator, userConnectionRepository, new FacebookSignInAdapter());
		
	}
}
