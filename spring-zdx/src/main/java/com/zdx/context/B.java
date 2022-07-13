package com.zdx.context;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class B {

	@Resource
	private A a;

	public A getA() {
		return a;
	}
}
