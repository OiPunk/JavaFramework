package com.mashibing.UserConsumer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashibing.UserAPI.Person;
import com.mashibing.UserAPI.UserApi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MainController {

	@Autowired
	ConsumerApi api;
	
	
	@Autowired
	RestService rest;
	
	
//	
//	@Autowired
//	MashibingApi mapi;

	
	// translatedTextSpringMVC translatedTextservlet
	@GetMapping("/alive2")
	@HystrixCommand(defaultFallback = "back")
	public String alive2() {
		/**
		 * URL translatedText 
		 * 
		 * jar
		 * translatedText
		 */
		return rest.alive();
	}
	
	
	public String back() {
		
		return "translatedText";
	}
	
	
	@GetMapping("/alive")
	public String alive() {
		/**
		 * URL translatedText 
		 * 
		 * jar
		 * translatedText
		 */
		return api.alive();
	
	
	/**
	 * 
	 * translatedText
	 * 
	 * 
	 * translatedText
	 * 
	 * translatedText
	 * 
	 * translatedText
	 * 
	 * 
	 * try{
	 * 
	 *     1.   translatedText;
	 *     		1.1 translatedText
	 *     			-> translatedText translatedText
	 *     		httptranslatedText  translatedText
	 *     
	 *     
	 *     		map(URI,translatedText) 
	 *     		translatedText（translatedText）
	 *        translatedText translatedText
	 *        
	 *        translatedText translatedText translatedText 
	 *        count ++；
	 *     if(count == 10){
	 *     
	 *     new romdom  == 1  translatedText
	 *       translatedText
	 *     
	 *     
	 *     	throw exception;
	 *     }
	 *     
	 *     
	 *         translatedText/translatedText/translatedText
	 *         translatedText      translatedText         translatedText
	 *     
	 *     if （translatedText）{
	 *     	throw exception
	 *     }
	 *     		
	 *     
	 *     		1.2 translatedText
	 *     
	 *     
	 *     translatedText
	 *     
	 *     
	 *     2. translatedText
	 *     
	 *     }catch(Exception e){
	 *     
	 *     	1.	translatedText
	 *     			-> translatedText  translatedText translatedText
	 *     
	 *     		
	 *     	2.	return translatedText translatedTextMQtranslatedText admin translatedText
	 *     
	 *     		return "translatedText"；
	 *     
	 *     }
	 *     
	 *     
	 *     Hystrix translatedText
	 */
	
	
	}
	
	
//	@GetMapping("/vip")
//	public String vip() {
//		
//		return mapi.getVip();
//	}
//	
	@GetMapping("/map")
	public Map<Integer, String> map(Integer id) {
		System.out.println(id);
		return api.getMap(id);
	}
	
	@GetMapping("/map2")
	public Map<Integer, String> map2(Integer id,String name) {
		System.out.println(id);
		return api.getMap2(id,name);
	}
	
	
	@GetMapping("/map3")
	public Map<Integer, String> map3(@RequestParam Map<String, Object> map) {
		HashMap<String, Object> map1 = new HashMap<>(2);
		
		map1.put("id", 2000);
		map1.put("name", "translatedText");
		return api.getMap3(map1);
	}
	
	
	@GetMapping("/map4")
	public Map<Integer, String> map4(@RequestParam Map<String, Object> map) {
//		System.out.println(id);
//		HashMap<String, Object> map = new HashMap<>(2);
//		
//		map.put("id", id);
//		map.put("name", name);
//		syso
		System.out.println(map);
		return api.postMap(map);
	}
	
	
	
	
	@GetMapping("/postPerson")
	public Person postPerson(@RequestParam Map<String, Object> map) {
		
		System.out.println(map);
		
		Person person = new Person();
		person.setId(Integer.parseInt(map.get("id").toString()));
		person.setName("xxoo");
		return api.postPserson(person);
	};
}
