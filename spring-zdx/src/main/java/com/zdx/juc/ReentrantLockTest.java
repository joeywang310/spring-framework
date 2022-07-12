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
		lock.unlock();
		ReentrantLock fairLock = new ReentrantLock(true);
		fairLock.lock();
		fairLock.unlock();
	}
}
