package com.zdx.transaction.service;

import com.zdx.domain.Student;
import com.zdx.transaction.aop.MyRound;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AService {

	@Resource
	private StudentService studentService;


	public void query() throws Exception {

		System.out.println(AopUtils.isAopProxy(studentService));
		Student query = studentService.query();
		System.out.println(query);
	}
}
