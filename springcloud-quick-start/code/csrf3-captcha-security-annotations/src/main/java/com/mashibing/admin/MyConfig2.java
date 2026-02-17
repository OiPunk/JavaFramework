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
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
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
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.mashibing.admin.service.MyAuthProvider;
import com.mashibing.admin.service.MyDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true ,prePostEnabled = true)
public class MyConfig2 extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.addFilterBefore(new CodeFilter(), UsernamePasswordAuthenticationFilter.class);
		
		
		
		http.
		// translatedText translatedText
		authorizeRequests()
		// translatedText  -> URL
		// Role = translatedText
		// Authority = translatedText
//		.antMatchers("/admin/**").hasRole("admin")
//		.antMatchers("/user/**").hasRole("user")
//		
		
		//translatedText
//		.anyRequest().authenticated()
		
		// translatedText translatedText
	//	.antMatchers("url").hasIpAddress("127.0.0.1")
		// iptranslatedText，translatedTextiptranslatedText
		
		.and()
	
		
		// translatedText translatedText
	
		.formLogin().loginPage("/login.html")
		
		.loginProcessingUrl("/login").permitAll()
		// translatedText translatedText
		.failureUrl("/login.html?error")
		// translatedText
		.defaultSuccessUrl("/ok",true).permitAll()
		// translatedText translatedText translatedTextname   admin -> translatedText translatedText
		.passwordParameter("oo")
		.usernameParameter("xx")
		
		// translatedText
		// translatedText translatedText
		.successHandler(new AuthenticationSuccessHandler() {
			
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				// TODO Auto-generated method stub
				Object user = authentication.getPrincipal();
				System.out.println(user);
			}
		})
		
		
		.failureHandler(new AuthenticationFailureHandler() {
			// translatedText
			// translatedText，translatedText
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {
				// TODO Auto-generated method stub
				
				// translatedText exception
				
				exception.printStackTrace();
			}
		})
		
		
		.and().logout()
		// translatedText
		// translatedText
		.addLogoutHandler(new LogoutHandler() {
			
			@Override
			public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
				// TODO Auto-generated method stub
				System.out.println("translatedText。。。");
			}
		})
		
		.addLogoutHandler(new LogoutHandler() {
			
			@Override
			public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
				// TODO Auto-generated method stub
				System.out.println("translatedText");
			}
		})
		
		
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
			.withUser("111").password(new BCryptPasswordEncoder().encode("123")).roles("admin")
		.and()
			.withUser("112").password(new BCryptPasswordEncoder().encode("123")).roles("user")
	
		.and()
			.withUser("113").password(new BCryptPasswordEncoder().encode("123")).roles("guest")
		
		.and()
			.withUser("114").password(new BCryptPasswordEncoder().encode("123")).roles("admin","user")
		
			;
	}
	
	@Bean
	RoleHierarchy roleHierarchy() {
		
		RoleHierarchyImpl impl = new RoleHierarchyImpl();
		impl.setHierarchy("ROLE_admin > ROLE_user");
		
		return impl;
		
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
