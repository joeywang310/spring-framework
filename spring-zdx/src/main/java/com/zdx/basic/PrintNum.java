package com.zdx.basic;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintNum {

	public static void main(String[] args) throws InterruptedException {
		AtomicInteger num = new AtomicInteger(1);
		Object lock = new Object();
		Thread thread1 = new Thread(() -> {
			for (;;) {
				if (num.get() > 10)
					return;
				synchronized (lock) {

					try {
						if (num.get() %2 ==0)
							lock.wait();

						System.out.println(num.getAndIncrement() + Thread.currentThread().getName());
						lock.notifyAll();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}

		},"thread1");

		Thread thread2 = new Thread(() -> {
			for (;;) {
				if (num.get() > 10)
					return;
				synchronized (lock) {

					try {
						if (num.get() %2 ==1)
							lock.wait();
						System.out.println(num.getAndIncrement() + Thread.currentThread().getName());
						lock.notifyAll();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}

		},"thread2");
		thread1.start();
		thread2.start();
//		Thread.currentThread().join();
	}
}
