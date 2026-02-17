package com.mashibing.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		String pass1 = new BCryptPasswordEncoder().encode("123");
		String pass2 = new BCryptPasswordEncoder().encode("123");
		
		System.out.println("pass1:" + pass1);
		System.out.println("pass2:" + pass2);
		http.
		// translatedText translatedText
		authorizeRequests()
		//translatedText
		.anyRequest().authenticated()
		.and()
		
		
		//permitAll translatedText translatedText
		//translatedText
		.formLogin().loginPage("/login.html")
		
		.loginProcessingUrl("/login").permitAll()
		// translatedText translatedText
		.failureUrl("/login.html?error")
		// translatedText
		.defaultSuccessUrl("/ok",true).permitAll()
		// translatedText translatedText translatedTextname   admin -> translatedText translatedText
		.passwordParameter("oo")
		.usernameParameter("xx")
		
		
		.failureHandler(new AuthenticationFailureHandler() {
			
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {
				// TODO Auto-generated method stub
				exception.printStackTrace();
				
				// translatedText translatedText translatedText translatedText
				request.getRequestDispatcher(request.getRequestURL().toString()).forward(request, response);
				
				// translatedText translatedText
				
			}
		})
		
		
		//translatedText translatedTextposttranslatedText translatedText
		.and()
		.csrf()
		.csrfTokenRepository(new HttpSessionCsrfTokenRepository());
		
		;
	}
	
	
	// session translatedText  translatedText -> jwt

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.
		inMemoryAuthentication()
			.withUser("123").password(new BCryptPasswordEncoder().encode("123")).roles("admin")
		.and()
			.withUser("321").password("321").roles("user")
		;
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
}
