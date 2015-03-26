package com.heike.service;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.base.SysCode;
import com.heike.dao.DictDao;
import com.heike.dao.EmployerDao;
import com.heike.dao.StudentDao;
import com.heike.domain.pojo.Dict;
import com.heike.domain.pojo.Employer;
import com.heike.domain.pojo.Student;
import com.heike.domain.service.CommonService;
import com.heike.util.EncryptUtil;


@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private EmployerDao employerDao;
	@Autowired
	private DictDao dictDao;
	
	public String login(String account, String password, HttpSession session) {
		password = EncryptUtil.md5Encrypt(password);
		
		Student student = studentDao.queryByNumAndPwd(account, password);
		if(null != student) {
			session.setAttribute("user", student);
			return "student";
		}
		Employer employer = employerDao.queryByNumAndPwd(account, password);
		if(null != employer) {
			session.setAttribute("user", employer);
			
			int authority = employer.getAuthority();
			if(authority == SysCode.EmployerCode.EMPLOYER_AUTHORITY) { // 用工单位
				return "employer";
			}else if (authority == SysCode.EmployerCode.ADMIN_AUTHORITY) { // 管理员
				return "admin";
			}
		}
		return "error";
	}

	public List<Dict> getColleges() {
		return dictDao.queryAll(SysCode.DictCode.COLLEGE_TYPE);
	}
	
	public List<Dict> getProfessions(Long colId) {
		List<Dict> dicts = dictDao.queryProfessions(colId);
//		if(dicts == null || dicts.size() == 0) {
//			Dict dict = new Dict();
//			dict.setId(1L);
//			dict.setName("其他");
//		}
		return dicts;
	}

	public List<String> getSalaryCommitDate() {
		Dict startDate = dictDao.queryByType(SysCode.DictCode.SALARY_COMMIT_START);		
		Dict endDate = dictDao.queryByType(SysCode.DictCode.SALARY_COMMIT_END);		
		
		return Arrays.asList(startDate.getName(), endDate.getName());
	}
	
}
