package com.heike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.StudentDao;
import com.heike.domain.pojo.Student;
import com.heike.domain.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	public Student getByNum(String num) {
		
		return studentDao.queryByNum(num);
	}

}
