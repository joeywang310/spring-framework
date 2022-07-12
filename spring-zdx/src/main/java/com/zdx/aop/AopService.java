package com.zdx.aop;

import com.zdx.context.A;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AopService {

	@Resource
	private B b;

	@MyRound
	public void playSnake() {
		try {
			Thread.sleep(2_000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("玩蛇");
	}
}
