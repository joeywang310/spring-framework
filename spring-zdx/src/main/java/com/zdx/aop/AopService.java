package com.zdx.aop;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AopService {


	@MyRound
	public void playSnake() {
		try {
			Thread.sleep(2_000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("玩蛇");
	}

	public static void main(String[] args) {
		System.out.println(16 - (16 >>> 2));
	}
}
