package com.heike.domain.service;

import com.heike.domain.dto.SalaryQueryDto;
import com.heike.domain.pojo.Salary;

public interface SalaryService {
	
	/**
	 * 提交工资
	 * @param salary
	 * @return
	 */
	public boolean pubSalary(Salary salary);
	
	/**
	 * 
	 * @param stuId
	 * @param month
	 * @return true 已经提交了，false还未提交
	 */
	public boolean isPubSalary(SalaryQueryDto sqd);

}
