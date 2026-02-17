package com.mashibing.spring.service;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mashibing.spring.dao.UserDao;
import com.mashibing.spring.entity.User;

/**
 * ҵ߼
 * translatedTextУ˺Ƿȷ
 * @author Administrator
 *
 */

// @Component עbean  ൱ <bean id=""

@Service
public class MainService {

	@Autowired
	@Qualifier("daoMysql")
	UserDao dao;
	
	public User login(String loginName, String password) {

		System.out.println("loginName:" + loginName);
		System.out.println("Service ӵ ʼ");
		User user = dao.getUserByName(loginName);
		
		System.out.println(ToStringBuilder.reflectionToString(user));
		
		return user;
	}

}
