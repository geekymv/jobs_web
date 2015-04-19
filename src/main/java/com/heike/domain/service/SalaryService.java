package com.heike.domain.service;

import com.heike.domain.dto.Pager;
import com.heike.domain.dto.SalaryDto;
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
	 * 判断用工单位是否提交该月工资
	 * @param stuId
	 * @param month
	 * @return true 已经提交了，false还未提交
	 */
	public boolean isPubSalary(SalaryQueryDto sqd);
	
	/**
	 * 用工单位-分页查询工资列表
	 * @param pager
	 * @param sqd
	 */
	public void getSalaryPage(Pager<SalaryDto> pager, SalaryQueryDto sqd);
	
	
	/**
	 * 管理员分页查询工资列表
	 * @param pager
	 * @param sqd
	 */
	public void getSalaryPage2(Pager<SalaryDto> pager, SalaryQueryDto sqd);
	

}
