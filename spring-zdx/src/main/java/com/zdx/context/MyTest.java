package com.zdx.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyTest.class);
		System.out.println(context.getBeanFactory().getBeanPostProcessorCount());
	}
}
