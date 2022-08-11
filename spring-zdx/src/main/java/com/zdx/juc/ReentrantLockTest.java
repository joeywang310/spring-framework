package com.zdx.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : wangzhicheng
 * @version : 1.0
 * @since : 2022/6/28 9:44
 */
public class ReentrantLockTest {


	public static void main(String[] args) {

		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		new Thread(() -> {
			lock.lock();
			try {
				Thread.sleep(10000_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.unlock();
		}).start();
		new Thread(() -> {
			lock.lock();
			try {
				Thread.sleep(10000_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.unlock();
		}).start();


		try {
			Thread.sleep(4_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();

	}
}
