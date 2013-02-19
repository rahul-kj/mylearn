package com.rahul.learn;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyWorkerApp {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "/META-INF/spring/applicationContext.xml" });
		ctx.start();
		System.out.println("Successfully started : " + ctx);
	}

}
