package com.mashibing.UserAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("/User")
public interface UserApi {

	/**
	 * translatedText，translatedTextapitranslatedText
	 * 
	 * translatedText~~~
	 * @return (* ￣3)(ε￣ *)
	 */
	@GetMapping("/User/alive")
	public String alive();
	
	@GetMapping("/User/getById")
	public String getById(Integer id);
	
	
	@PostMapping("/User/postPserson")
	public Person postPserson(@RequestBody Person person);
}
