package com.heike.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.base.SysCode;
import com.heike.dao.StudentDao;
import com.heike.domain.pojo.Student;
import com.heike.domain.service.StudentService;
import com.heike.util.EncryptUtil;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	public Student getByNum(String num) {
		return studentDao.queryByNum(num);
	}

	public Student register(Student student) {
		// 设置注册时间
		student.setRegTime(new Date());
		// 设置用户状态为正常
		student.setStatus(SysCode.UserStatus.USER_NORMAL);
		// 对密码加密
		student.setPwd(EncryptUtil.md5Encrypt(student.getPwd()));
		
		return studentDao.save(student) != null ? student : null;
	}

}
