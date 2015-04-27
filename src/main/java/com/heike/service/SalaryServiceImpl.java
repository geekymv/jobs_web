package com.heike.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.base.SysCode;
import com.heike.dao.EmployerDao;
import com.heike.dao.SalaryDao;
import com.heike.domain.dto.Pager;
import com.heike.domain.dto.SalaryDto;
import com.heike.domain.dto.SalaryQueryDto;
import com.heike.domain.pojo.Salary;
import com.heike.domain.service.SalaryService;
import com.heike.util.DateUtils;

@Service
public class SalaryServiceImpl implements SalaryService {
	@Autowired
	private SalaryDao salaryDao;
	@Autowired
	private EmployerDao employerDao;

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

	@Override
	public void getSalaryPage(Pager<SalaryDto> pager, SalaryQueryDto sqd) {
		String month = sqd.getMonth();
		if(StringUtils.isBlank(month)) {
			sqd.setMonth(DateUtils.formatYearMonth(new Date()));
		}
		
		salaryDao.queryByPage(pager, sqd);
	}

	@Override
	public void getSalaryPage2(Pager<SalaryDto> pager, SalaryQueryDto sqd) {
		String month = sqd.getMonth();
		if(StringUtils.isBlank(month)) {
			sqd.setMonth(DateUtils.formatYearMonth(new Date()));
		}
		
		salaryDao.queryByPage2(pager, sqd);
	}

	@Override
	public String edit(Salary salary) {
		String month = salary.getMonth();
//		// 当前年月
//		String currentMonth = DateUtils.formatYearMonth(new Date());
//		
//		if(!currentMonth.equals(month)) {	// 不是当前年月
//			return "noEdit";	// 不可编辑
//		}
//		// 判断当前时间是否在提交工资时间范围
//		if(!DateUtils.isLast7Day()) {
//			return "noEdit";	// 不可编辑
//		}
		
		// 判断本月已提交的工资 + 正要提交的工资之和是否大于 用工单位总金额
		Long empId = salary.getEmpId();
		int totalMoney = employerDao.queryTotalMoney(empId);
		
		// 获得该用工单位本月已提交的总金额除了当前要提交的
		List<Salary> salaries = salaryDao.queryByEmpIdAndMonthExceptId(empId, month, salary.getId());
		
		float total = 0;
		for (Salary s : salaries) {
			total += (Float.valueOf(s.getSalary()) 
					+ Float.valueOf(s.getToolFee()) 
					+ Float.valueOf(s.getBonus())); 
		}
		
		// 当前要提交的总工资
		float currentTotal = (Float.valueOf(salary.getSalary()) + Float.valueOf(salary.getToolFee()) 
									+ Float.valueOf(salary.getBonus())); 
		
		if((total + currentTotal) > totalMoney) {
			return "overspend";	// 超支了
		}	
		
		int res = salaryDao.update(salary);
		return res == 1 ? "success" : "fail";
	}

	@Override
	public String isEdit(String month) {
		// 当前年月
		String currentMonth = DateUtils.formatYearMonth(new Date());
		
		if(!currentMonth.equals(month)) {	// 不是当前年月
			return "noEdit";	// 不可编辑
		}
		// 判断当前时间是否在提交工资时间范围
		if(!DateUtils.isLast7Day()) {
			return "noEdit";	// 不可编辑
		}

		return "ok";
	}
	

}
