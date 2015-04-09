package com.heike.domain.service;

import com.heike.domain.dto.EmployerDto;
import com.heike.domain.dto.Pager;
import com.heike.domain.pojo.Employer;
import com.heike.domain.vo.EmployerStudentVO;

public interface EmployerService {
	
	/**
	 * 根据id获取用工单位信息
	 * @param id
	 * @return
	 */
	public Employer getInfo(Long id);
	
	/**
	 * 编辑个人资料
	 * @param employer
	 */
	public void edit(EmployerDto dto);
	
	/**
	 * 学生列表
	 * @param pager
	 * @param empId 用工单位id
	 */
	public void getStudentPage(Pager<EmployerStudentVO> pager, Long empId);

}
