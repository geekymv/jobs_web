package com.heike.domain.service;

import com.heike.domain.dto.ApproveDto;
import com.heike.domain.dto.EmployerDto;
import com.heike.domain.dto.Pager;
import com.heike.domain.pojo.Employer;
import com.heike.domain.vo.EmployerStudentVO;
import com.heike.domain.vo.RecruitStuVO;

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
	 * 在职学生列表
	 * @param pager
	 * @param empId 用工单位id
	 */
	public void getStudentPage(Pager<EmployerStudentVO> pager, Long empId);
	
	/**
	 * 获得待审核学生列表
	 * @param pager
	 * @param empId
	 */
	public void getWaitStudents(Pager<RecruitStuVO> pager, Long empId);
	
	/**
	 * 用工单位审核学生的报名
	 * @param dto
	 */
	public void approve(ApproveDto dto);
	
	/**
	 * 解聘学生
	 * @param stuId 学生id
	 * @param empId 用工单位id
	 * @return
	 */
	public boolean layoff(Long stuId, Long empId);

}
