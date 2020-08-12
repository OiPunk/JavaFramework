package com.mashibing.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestGetBean {

	
	public static void main(String[] args) {

		final Girl girl = new Girl();
		
		Human prxyGirl = (Human)Proxy.newProxyInstance(Girl.class.getClassLoader(), Girl.class.getInterfaces(), new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				System.out.println(method.getName() + " ->> ������ִ��");
				
				if (method.getName().equals("bath")) {
					System.out.println("͵��ϴ��");
					Object invoke = method.invoke(girl, args);
					System.out.println("6��6��");
					return invoke;
				}else {
					System.out.println("��ǰ");
					Object invoke = method.invoke(girl, args);
					System.out.println("����");
					return invoke;
				}
			}
		});
		
		
		
		prxyGirl.eat();
		System.out.println("-----");
		prxyGirl.bath();
		
	}
}
