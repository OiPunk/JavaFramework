package com.mashibing.UserConsumer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HystrixTest extends HystrixCommand {

	protected HystrixTest(HystrixCommandGroupKey group) {
		super(group);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		
	//	HystrixTest hystrixTest = new HystrixTest(HystrixCommandGroupKey.Factory.asKey("ext"));
		/**
		 * execute()：translatedTextrun()。translatedTextdemotranslatedText，translatedTextexecute()translatedText，
		 * hystrixtranslatedTextrun()，
		 * 	translatedTextexecute()translatedText，translatedTextrun()translatedText 
		 */
	//	System.out.println("result:" + hystrixTest.execute());
		
		/**
		 * queue()：translatedTextrun()。translatedTextdemotranslatedText，
		 * 	translatedTextqueue()translatedTextFuturetranslatedText，
		 * 	translatedTexthystrixtranslatedTextrun()，
		 * 	translatedTextFuture.get()translatedTextrun()translatedText，
		 * 	translatedTextFuture.get()translatedText
		 */
		Future<String> futureResult = new HystrixTest(HystrixCommandGroupKey.Factory.asKey("ext")).queue();
		String result = "";
		try {
			result = futureResult.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("translatedText："+result);
	}

	@Override
	protected Object run() throws Exception {
		// TODO Auto-generated method stub
		// try
		System.out.println("translatedText");
		int i = 1/1;
		return "xxoo";
	}

	@Override
	//catch  translatedText
	protected Object getFallback() {
		// TODO Auto-generated method stub
		return "getFallbackgetFallback";
	}
	
	
	
}