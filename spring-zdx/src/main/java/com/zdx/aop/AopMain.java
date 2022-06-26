package com.zdx.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan("com.zdx.aop")
@Configuration
public class AopMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopMain.class);
		AopService aopService = context.getBean("aopService", AopService.class);
		aopService.playSnake();
	}
}
