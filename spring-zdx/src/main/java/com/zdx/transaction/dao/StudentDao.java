package com.zdx.transaction.dao;

import com.zdx.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

	public Student query() {
		return new Student("zsx", 18);
	}
}
