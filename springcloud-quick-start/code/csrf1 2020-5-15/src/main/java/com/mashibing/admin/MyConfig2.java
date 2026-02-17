package com.mashibing.admin;

import java.io.IOException;
import java.util.Base64;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.mashibing.admin.service.MyAuthProvider;
import com.mashibing.admin.service.MyDetailsService;

@Configuration
@EnableWebSecurity
public class MyConfig2 extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		// translatedText translatedText
		authorizeRequests()
		//translatedText
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.sessionManagement()
		// translatedText translatedText
		.maximumSessions(1)
		// translatedText， translatedText
		.maxSessionsPreventsLogin(true).
		
		
		// cookies translatedText token ，translatedText translatedText translatedText/ translatedText  translatedText
//		.rememberMe()
//		.and()
		
		and().and()
		.csrf().disable();
		
	}

	@Autowired
	DataSource dataSource;
	// session translatedText translatedText -> jwt

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
	HttpSessionEventPublisher httpSessionEventPublisher() {
	    return new HttpSessionEventPublisher();
	}
	@Bean
	PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		
		byte[] decode = Base64.getDecoder().decode("MTIzOjE1OTA3NjA2NjkxMTQ6YTc4OGNhOTJhMGE4MzYyN2MzNjhkNzkxZjA5ZGVmZDM");
	//123:1590760669114:a788ca92a0a83627c368d791f09defd3*(translatedText translatedText translatedText) sign
	//translatedText+ translatedText + translatedText + translatedText + secret  = translatedText translatedText（translatedText translatedText）
	System.out.println(new String(decode));
	// translatedText translatedText
	
	}

}
