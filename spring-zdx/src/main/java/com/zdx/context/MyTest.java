package com.zdx.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.zdx.context")
@Configuration
public class MyTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyTest.class);
		System.out.println(context.getBeanFactory().getBeanPostProcessorCount());
	}
}
