package com.zdx.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author : wangzhicheng
 * @version : 1.0
 * @since : 2022/7/11 10:30
 */
public class ExecuteDemo {

	public static void main(String[] args) throws InterruptedException {
		List<Callable<Void>> tasks = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int finalI = i;
			tasks.add(() -> {
				System.out.println("callable " + finalI);
				Thread.sleep(500);
				return null;
			});
		}
//		ExecutorService executor = new ThreadPoolExecutor(
//				1,
//				1,
//				1,
//				TimeUnit.SECONDS,
//				new ArrayBlockingQueue<>(1),
//				new ThreadPoolExecutor.DiscardPolicy()
//		);
        ExecutorService executor = Executors.newFixedThreadPool(2);
		Thread executorInvokerThread = new Thread(() -> {
			try {
				executor.invokeAll(tasks);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("invokeAll returned");
		});
		executorInvokerThread.start();

		Thread.sleep(800);
		System.out.println("shutdown");
		List<Runnable> runnables = executor.shutdownNow();
		for (Runnable r : runnables) {
			if (r instanceof Future) ((Future<?>)r).cancel(false);
		}
		System.out.println("Shutdown complete");

		System.out.println("CAPACITY  " + Integer.toBinaryString(CAPACITY));
		System.out.println("RUNNING   " + Integer.toBinaryString(RUNNING));
		System.out.println("SHUTDOWN  " + Integer.toBinaryString(SHUTDOWN));
		System.out.println("STOP      " + Integer.toBinaryString(STOP));
		System.out.println("TIDYING   " + Integer.toBinaryString(TIDYING));
		System.out.println("TERMINATED" + Integer.toBinaryString(TERMINATED));
	}


	private static final int COUNT_BITS = Integer.SIZE - 3;
	private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

	// runState is stored in the high-order bits
	private static final int RUNNING    = -1 << COUNT_BITS;
	private static final int SHUTDOWN   =  0 << COUNT_BITS;
	private static final int STOP       =  1 << COUNT_BITS;
	private static final int TIDYING    =  2 << COUNT_BITS;
	private static final int TERMINATED =  3 << COUNT_BITS;

}
