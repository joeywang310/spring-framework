package com.zdx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Aspect
@Component
@EnableAspectJAutoProxy
public class ExecuteTimeCounter {

	@Pointcut(" execution(* com.zdx.aop.AopService.*(..))")
	private void counter() {}

	@Pointcut("@annotation(com.zdx.aop.MyRound)")
	private void myRound() {}

	@Around("myRound()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		// start stopwatch
		long begin = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		long end = System.currentTimeMillis();
		System.out.println("execute time is :" + (end-begin));
		// stop stopwatch
		return retVal;
	}
}
