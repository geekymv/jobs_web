package com.heike.domain.service;

import com.heike.domain.dto.Pager;
import com.heike.domain.dto.StudentDto;
import com.heike.domain.pojo.Employer;

public interface AdminService {
	
	/**
	 * 判断用工单位账户名是否已经存在
	 * @param account
	 * @return true 存在，false 不存在
	 */
	public boolean isExist(String account);
		
	/**
	 * 添加用工单位
	 * @param employer
	 * @return
	 */
	public boolean addEmployer(Employer employer);
	
	
	/**
	 * 分页获得学生列表
	 * @param pager
	 * @return
	 */
	public void getEmployerByPage(Pager<Employer> pager);
	
	
	/**
	 * 分页获得学生列表
	 * @param pager
	 * @return
	 */
	public void getStudentByPage(Pager<StudentDto> pager);
	
	

}
