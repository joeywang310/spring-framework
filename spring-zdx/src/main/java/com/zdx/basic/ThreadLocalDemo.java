package com.zdx.basic;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		int n = 1;
		System.out.println(n >>>= 1);
		ThreadLocal<String> tl = new ThreadLocal<>();
		ThreadLocal<String> tl1 = new ThreadLocal<>();
		ThreadLocal<String> tl2 = new ThreadLocal<>();
		tl.set("main");
		tl1.set("main1");
		tl2.set("main2");
		tl1 = null;
		System.gc();
		Thread thread = Thread.currentThread();
		System.out.println(1111);
	}
}
