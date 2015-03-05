package com.heike.domain.service;

import com.heike.domain.pojo.Student;


public interface StudentService {
	
	/**
	 * 根据学号获得学生信息
	 * @param num
	 * @return
	 */
	public Student getByNum(String num);

}
