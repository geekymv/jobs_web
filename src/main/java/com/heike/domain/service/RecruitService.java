package com.heike.domain.service;

import com.heike.domain.dto.Pager;
import com.heike.domain.pojo.Recruit;

public interface RecruitService {

	/**
	 * 分页显示
	 * @param currentPage
	 * @return
	 */
	public Pager<Recruit> list(int currentPage);
	
	/**
	 * 根据id获得招聘信息详情
	 * @param id
	 * @return
	 */
	public Recruit getById(Long id);
}
