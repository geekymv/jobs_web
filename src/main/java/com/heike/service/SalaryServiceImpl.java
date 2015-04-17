package com.heike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.SalaryDao;
import com.heike.domain.dto.SalaryDto;
import com.heike.domain.service.SalaryService;

@Service
public class SalaryServiceImpl implements SalaryService {
	@Autowired
	private SalaryDao salaryDao;
	
	@Override
	public List<SalaryDto> getList() {
		return salaryDao.queryList();
	}

}
