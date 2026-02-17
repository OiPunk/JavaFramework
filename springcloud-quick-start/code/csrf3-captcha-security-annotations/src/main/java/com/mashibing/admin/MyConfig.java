package com.mashibing.admin;

import java.io.IOException;
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

import com.mashibing.admin.service.MyAuthProvider;
import com.mashibing.admin.service.MyDetailsService;

//@Configuration
//@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		// translatedText
		
		web.ignoring().antMatchers("/img/**");
	//	super.configure(web);
	}


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
	//	.antMatchers("/img/**").permitAll()
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
	
	
	@Autowired
	DataSource dataSource;	
	// session translatedText  translatedText -> jwt

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		auth.
//		inMemoryAuthentication()
//			.withUser("123").password(new BCryptPasswordEncoder().encode("123")).roles("admin")
//		.and()
//			.withUser("321").password("321").roles("user")
//		;
		
		
//		JdbcUserDetailsManager manager = 
		auth.userDetailsService(new MyDetailsService())
		
		// translatedText
		.and()
		.authenticationProvider(new MyAuthProvider());
		
		
		;
		
//		
//		.	jdbcAuthentication()
//				.dataSource(dataSource).
//					getUserDetailsService()
//					
//					;
//					
//					
					;
		
		// translatedText
//		boolean userExists = manager.userExists("xishi");
//		System.out.println("userExists" + userExists);
//		if(!userExists) {
//			
//			manager.createUser(User.withUsername("xishi").password(new BCryptPasswordEncoder().encode("111")).roles("admin","xxoo").build());
//		}
		
		
		// translatedTextORM
		
		
	}
	
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		
//		// translatedText
//		// UserDetails
////		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////
////		
////		// translatedText translatedText translatedText usertranslatedText
////	//	manager.loadUserByUsername(username)
////		
////	//	changePassword(oldPassword, newPassword);
////		
////		User user = new User("a", new BCryptPasswordEncoder().encode("1"), true, true, true, true, Collections.singletonList(new SimpleGrantedAuthority("xx")));
////		manager.createUser(user);
////		manager.createUser(User.withUsername("yiming").password(new BCryptPasswordEncoder().encode("xx")).roles("xxz").build());
////	
//		
//		// translatedTextJDBCtranslatedText translatedText
//		
//		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
//		
//		manager.createUser(User.withUsername("xishi").password(new BCryptPasswordEncoder().encode("111")).roles("admin","xxoo").build());
//		
//		return manager;
//	}
	
	
	
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
}
