package com.heike.domain.service;

import com.heike.domain.pojo.Employer;

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
	public void edit(Employer employer);

}
