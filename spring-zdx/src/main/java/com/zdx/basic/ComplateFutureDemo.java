package com.zdx.basic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author : wangzhicheng
  * @version : 1.0
 * @since : 2022/7/20 16:05
 */
public class ComplateFutureDemo {

//	public static void main(String[] args) {
//		CompletableFuture<String> stage1 = CompletableFuture.supplyAsync(() -> {
//			System.out.println("stage1");
//			System.out.println(Thread.currentThread().getName());
//			return "stage1";
//		});
//		CompletableFuture<String> stage2 = CompletableFuture.supplyAsync(() -> {
//			System.out.println("stage2");
//			System.out.println(Thread.currentThread().getName());
//			return "stage2";
//		});
//		stage2.thenCombineAsync(stage1, (result1, result2) -> {
//			System.out.println(result1 + " , " + result2);
//			System.out.println("执行step 3");
//			return "step3 result";
//		}).thenApply((result1) -> {
//			System.out.println(result1);
//			System.out.println("执行step 3");
//			return "step3 result";
//		});
//
//		CompletableFuture<Object> objectCompletableFuture = CompletableFuture.supplyAsync();
//		objectCompletableFuture.thenApply()
//		objectCompletableFuture.thenApply()
//		try {
//			stage1.get();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
//	}
}
