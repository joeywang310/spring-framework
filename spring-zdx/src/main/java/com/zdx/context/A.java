package com.zdx.context;


import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class A {

	@Resource
	private B b;

	public B getB() {
		return b;
	}
}
