package com.mashibing.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * ORMӳ��
 * �̰߳�ȫ����Ա���ԣ����ܱ�����
 * @author Administrator
 *
 */

@Component
@Scope("prototype")
public class User {

	@Value("zhangfg")
	private String loginName;
	@Value("123123")
	private String password;
	@Autowired
	private Pet pet;
	
}
