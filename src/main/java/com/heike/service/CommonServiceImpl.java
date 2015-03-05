package com.heike.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.base.SysCode;
import com.heike.dao.EmployerDao;
import com.heike.dao.StudentDao;
import com.heike.domain.pojo.Employer;
import com.heike.domain.pojo.Student;
import com.heike.domain.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private EmployerDao employerDao;
	
	public String login(String account, String password, HttpSession session) {
		Student student = studentDao.queryByNumAndPwd(account, password);
		if(null != student) {
			session.setAttribute("user", student);
			return "student";
		}
		
		Employer employer = employerDao.queryByNumAndPwd(account, password);
		if(null != employer) {
			session.setAttribute("user", employer);
			
			int authority = employer.getAuthority();
			if(authority == SysCode.Employer.EMPLOYER_AUTHORITY) { // 用工单位
				return "employer";
		
			}else if (authority == SysCode.Employer.ADMIN_AUTHORITY) { // 管理员
				return "admin";
			}
		}
		
		return "error";
	}

}
