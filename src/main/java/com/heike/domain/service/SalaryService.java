package com.heike.domain.service;

import com.heike.domain.dto.Pager;
import com.heike.domain.dto.SalaryDto;
import com.heike.domain.dto.SalaryQueryDto;
import com.heike.domain.pojo.Salary;

public interface SalaryService {
	
	/**
	 * 提交工资
	 * @param salary
	 * @return "overspend"超支了， "success"保存成功， "fail"保存失败
	 */
	public String pubSalary(Salary salary);
	
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
	
	/**
	 * 判断工资是否可以编辑
	 * @param month
	 * @return "noEdit"不可编辑，"ok"可编辑
	 */
	public String isEdit(String month);
	
	/**
	 * 更新工资
	 * @param salary
	 * @return "noEdit"不可编辑 ，"overspend"超支了， "success" 更新成功，"fail" 更新失败
	 */
	public String edit(Salary salary);
	
	/**
	 * 根据工资id删除工资
	 * @param sId
	 * @return "success"删除成功 ，"fail"删除失败
	 */
	public String delete(Long sId);

}
