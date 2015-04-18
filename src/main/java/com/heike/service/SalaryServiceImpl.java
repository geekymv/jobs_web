package com.heike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.base.SysCode;
import com.heike.dao.SalaryDao;
import com.heike.domain.dto.SalaryQueryDto;
import com.heike.domain.pojo.Salary;
import com.heike.domain.service.SalaryService;
import com.heike.util.DateUtils;

@Service
public class SalaryServiceImpl implements SalaryService {
	@Autowired
	private SalaryDao salaryDao;

	@Override
	public boolean pubSalary(Salary salary) {
		salary.setDate(DateUtils.getCurrentGaDate());
		salary.setStatus(SysCode.SalaryStatus.NORMA);
		
		Long res = salaryDao.save(salary);
		return res != null ? true : false;
	}

	@Override
	public boolean isPubSalary(SalaryQueryDto sqd) {
		Salary s = salaryDao.query(sqd);
		return s != null ? true : false;
	}
	

}
