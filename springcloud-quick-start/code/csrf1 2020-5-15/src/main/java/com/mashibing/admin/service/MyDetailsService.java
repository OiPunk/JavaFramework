package com.mashibing.admin.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// User Service
@Service
public class MyDetailsService implements UserDetailsService {
	// translatedText translatedText  translatedText translatedText
	@Override
	
//	@Autowired
//	UserDao userDao;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// translatedTextredis translatedText，mysql translatedText，jpa
		
		if(new Random().nextBoolean()) {
			

			// translatedText
			throw new CredentialsExpiredException("translatedText，translatedText translatedText");
			
		}else {
			
			throw new LockedException("translatedText，translatedText");
		}
	}
	
	

}
