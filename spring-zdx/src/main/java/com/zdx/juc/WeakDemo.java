package com.zdx.juc;

import com.zdx.domain.Student;

import java.lang.ref.WeakReference;

/**
 * @author : wangzhicheng
 * @version : 1.0
 * @since : 2022/7/12 17:31
 */
public class WeakDemo {

	public static void main(String[] args) {
		Student a = new Student("a", 21);
		WeakReference<Student> stringWeakReference = new WeakReference<>(a);
		//通过WeakReference的get()方法获取Apple
		System.out.println("Apple:" + stringWeakReference.get());
		System.gc();
		Runtime.getRuntime().runFinalization();
		System.gc();
		try {
			//休眠一下，在运行的时候加上虚拟机参数-XX:+PrintGCDetails，输出gc信息，确定gc发生了。
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//如果为空，代表被回收了
		if (stringWeakReference.get() == null) {
			System.out.println("clear Apple。");
		}

	}

}
