package com.mashibing.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyAuthProvider implements AuthenticationProvider {

	
	@Autowired
	MyDetailsService userSrv;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		
		// translatedText  translatedText translatedText~
		
		System.out.println("translatedText translatedText");
		
		// translatedText
		String username = authentication.getPrincipal().toString();
		String rawPassword = authentication.getCredentials().toString();
		
		
		System.out.println("authentication" + authentication);
		// translatedText UsertranslatedText
		UserDetails userDetails = userSrv.loadUserByUsername(username);
		
		// translatedText
			// translatedText ，translatedText
		// translatedText~
	
			if(new BCryptPasswordEncoder().matches(rawPassword, userDetails.getPassword())) {
				// translatedText translatedText
				
				//
				UsernamePasswordAuthenticationToken authenticationToken = 
						new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
					//JWT  translatedText sign
			return authentication;
			}else {
				
				throw new BadCredentialsException("translatedText translatedText translatedText");
			}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
