package com.zdx.basic;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintNum1 {
	static volatile boolean flag = false;

	public static void main(String[] args) throws InterruptedException {
		AtomicInteger i = new AtomicInteger(1);
		Thread thread1 = new Thread(() -> {
				while (true){
					if (i.get()> 100)
						return;
					if (flag){
						System.out.println(i.getAndIncrement() + Thread.currentThread().getName());
						flag = false;
					}
				}
		},"thread1");
		Thread thread2 = new Thread(() -> {
				while (true){
					if (i.get()> 100)
						return;
					if (!flag){
						System.out.println(i.getAndIncrement() + Thread.currentThread().getName());
						flag = true;
					}
				}
		},"thread2");
		thread1.start();
		thread2.start();
//		Thread.currentThread().join();
	}
}
