package com.heike.domain.service;

import java.util.List;

import com.heike.domain.dto.Pager;
import com.heike.domain.pojo.Recruit;
import com.heike.domain.vo.RecruitStuVO;

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
	
	/**
	 * 根据招聘信息id获得所有已报名学生的信息
	 * @param id
	 * @return
	 */
	public List<RecruitStuVO> getApplyStudents(Long id);
	
	/**
	 * 判断学生是否已经报名了招聘信息
	 * @param stuId
	 * @param recId
	 * @return
	 */
	public String isApply(Long stuId, Long recId);
}
