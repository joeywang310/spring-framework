package com.zdx.transaction.service;

import com.zdx.domain.Student;
import com.zdx.transaction.aop.MyRound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService{

	@Override
	@MyRound
	@Transactional(rollbackFor = Exception.class)
	public Student query() throws Exception {
		System.out.println("query");
		Thread.sleep(1_000);
//		if (true)
//			throw new Exception("12");
		return new Student("zdx",18);
	}

}
