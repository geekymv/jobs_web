package com.heike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.EmployerDao;
import com.heike.domain.pojo.Employer;
import com.heike.domain.service.EmployerService;

@Service
public class EmployerServiceImpl implements EmployerService {
	@Autowired
	private EmployerDao employerDao;
	
	@Override
	public Employer getInfo(Long id) {
		return employerDao.queryById(id);
	}

	public void edit(Employer employer) {
		employerDao.saveOrUpdate(employer);
	}
	
}
