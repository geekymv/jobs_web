package com.heike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.base.SysCode;
import com.heike.dao.EmployerDao;
import com.heike.domain.pojo.Employer;
import com.heike.domain.service.AdminService;
import com.heike.util.DateUtils;
import com.heike.util.EncryptUtil;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private EmployerDao employerDao;
	
	
	public boolean isExist(String account) {
		Employer employer = employerDao.queryByAccount(account);
		return employer != null ? true : false;
	}
	
	@Override
	public boolean addEmployer(Employer employer) {
		employer.setPwd(EncryptUtil.md5Encrypt(employer.getPwd())); // 对密码加密处理
		employer.setAuthority(SysCode.EmployerCode.EMPLOYER_AUTHORITY);
		employer.setRegDate(DateUtils.getCurrentGaDate());
		employer.setStatus(SysCode.UserStatus.USER_NORMAL);
		
		Long res = employerDao.save(employer);
		return res != null ? true : false;
	}

}
