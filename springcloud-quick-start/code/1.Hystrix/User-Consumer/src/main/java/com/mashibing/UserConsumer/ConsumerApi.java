package com.mashibing.UserConsumer;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mashibing.UserAPI.UserApi;

/*
 * translatedTexteureka，translatedTextclienttranslatedText。translatedTexturltranslatedText translatedText。url=“http://ip:port/”
 */
@FeignClient(name = "user-provider",fallbackFactory = UserProviderBackFactory.class)
public interface ConsumerApi extends UserApi {
	
	/**
	 * translatedText getMapping translatedTextFeigntranslatedText gettranslatedText user-provider/getMap?id={1}
	 * @RequestParam("id") translatedTextFeigntranslatedText
	 * 
	 * HttpClient HttptranslatedText
	 * @param id
	 * @return
	 */
	@GetMapping("/getMap")
	Map<Integer, String> getMap(@RequestParam("id") Integer id);
	
	
	
	@GetMapping("/getMap2")
	Map<Integer, String> getMap2(@RequestParam("id") Integer id,@RequestParam("name") String name);
	
	@GetMapping("/getMap3")
	Map<Integer, String> getMap3(@RequestParam Map<String, Object> map);
	
	@PostMapping("/postMap")
	Map<Integer, String> postMap(Map<String, Object> map);
	
	

	
}
