package com.mashibing.eurekaserver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EurekaServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.discovery.EurekaClient;

@RestController
public class MainController2 {

	
	
	//      /User          translatedText translatedText
	
	/*
	 *     http://xxx/User
	 *     
	 *     
	 *     http://xxx/User/getUserList  Get
	 *     http://xxx/users  	        Get   translatedText  translatedText
	 *     http://xxx/v1/User/getUserList
	 * 
	 * 	   http://xxx/v1/User/deleteById     Get/Post
	 * 	   
	 * 		http://xxx/v1/users/1             Get= translatedTextid=1translatedText  DeletetranslatedText = translatedText put=translatedText
	 * 	   http://xxx/v2/users/1
	 * 
	 *     translatedText translatedTextcrud SpringData Rest
	 * 
	 * 
	 */
	
	
	@Autowired
	// translatedText
	DiscoveryClient client;
	
	@Autowired
	EurekaClient client2;
	
	@Autowired
	LoadBalancerClient lb;
	
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/client6")
	public Object client6() {
		
		// ribbon translatedText，translatedTextdowntranslatedText
		ServiceInstance instance = lb.choose("provider");
		
		String url ="http://" + instance.getHost() +":"+ instance.getPort() + "/HelloWorld/getHi";
		   
		String respStr = restTemplate.getForObject(url, String.class);

		return respStr;
	}
	
	/**
	 * translatedText
	 * @return
	 */
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	
	@GetMapping("/client7")
	public Object client7() {
		
		
		List<ServiceInstance> instances = discoveryClient.getInstances("provider");
		
		// translatedText
		
		// translatedText
		int nextInt = new Random().nextInt(instances.size());
		AtomicInteger atomicInteger = new AtomicInteger();
	
		// translatedText
		int i = atomicInteger.getAndIncrement();
		instances.get(i % instances.size());
		
		// translatedText。。
		for (ServiceInstance serviceInstance : instances) {
	//	int quanzhong = 	serviceInstance.getMetadata(); // translatedText  1-9
		
		
		}
		
		
		
		ServiceInstance instance = instances.get(nextInt);
		
		// ribbon translatedText，translatedTextdowntranslatedText
	//	ServiceInstance instance = lb.choose("provider");
		
		String url ="http://" + instance.getHost() +":"+ instance.getPort() + "/getHi";
		   
		String respStr = restTemplate.getForObject(url, String.class);

		return respStr;
	}
	
	
	
	@GetMapping("/client8")
	public Object client8() {
		
		
		
		// ribbon translatedText，translatedTextdowntranslatedText
		ServiceInstance instance = lb.choose("provider");
		
		String url ="http://" + instance.getHost() +":"+ instance.getPort() + "/getHi";
		   
		String respStr = restTemplate.getForObject(url, String.class);
		
		System.out.println(respStr);
		return respStr;
	}
	
	
	@GetMapping("/client9")
	public Object client9() {
		// translatedTextURL
		String url ="http://provider/getHi";
		   
		String respStr = restTemplate.getForObject(url, String.class);
		
		System.out.println(respStr);
		return respStr;
	}
		
}
