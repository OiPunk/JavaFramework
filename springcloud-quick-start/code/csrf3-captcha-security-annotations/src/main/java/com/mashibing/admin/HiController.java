package com.mashibing.admin;

import java.util.Random;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HiController {
	
	@GetMapping("/hi")
	// translatedText translatedText
	@Secured({"ROLE_admin","ROLE_user"})
	public String hi() {
	//	UserDetailsServiceAutoConfiguration
		System.out.println("translatedText~！");
		return "hi";
	}
	
	@GetMapping("/admin/hi")
	// translatedText admintranslatedText
	@PreAuthorize("hasRole('ROLE_admin')")
	public String hi1() {
	//	UserDetailsServiceAutoConfiguration
		System.out.println("translatedText~！");
		return "hi admin";
	}
	
	
	@GetMapping("/admin/hi2")
	@PreAuthorize("hasAnyRole('ROLE_admin','ROLE_guest')")
	public String hi3() {
	//	UserDetailsServiceAutoConfiguration
		System.out.println("translatedText~！");
		return "hi admin";
	}
	
	@GetMapping("/admin/hi4")
	@PreAuthorize("hasRole('ROLE_admin') AND hasRole('ROLE_user')")
	public String hi4() {
	//	UserDetailsServiceAutoConfiguration
		System.out.println("translatedText~！");
		return "hi admin";
	}
	
	@GetMapping("/admin/hi5")
	// Spring ELtranslatedText
	// translatedText translatedTexttruetranslatedText translatedText false translatedText403
	@PostAuthorize("returnObject==1")
	public int hi5() {
	//	UserDetailsServiceAutoConfiguration
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println("user" + authentication);
		System.out.println("translatedText~！" );
		// translatedText translatedText translatedTextservice (translatedText)
		return new Random().nextInt(2);
	}
	
	@GetMapping("/user/hi")
	public String hi2() {
	//	UserDetailsServiceAutoConfiguration
		System.out.println("translatedText~！");
		return "hi user";
	}
}
