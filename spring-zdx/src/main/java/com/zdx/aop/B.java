package com.zdx.aop;


import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class B {

	@Resource
	private AopService aopService;

	public AopService getB() {
		return aopService;
	}
}
