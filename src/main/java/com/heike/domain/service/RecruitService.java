package com.heike.domain.service;

import java.util.List;

import com.heike.domain.dto.Pager;
import com.heike.domain.dto.RecruitQueryDto;
import com.heike.domain.pojo.Recruit;
import com.heike.domain.vo.ApplyRecordVO;
import com.heike.domain.vo.RecruitStuVO;
import com.heike.domain.vo.RecruitVO;

public interface RecruitService {

	/**
	 * 分页显示
	 * @param currentPage
	 * @return
	 */
	public Pager<RecruitVO> list(int currentPage);
	
	/**
	 * 分页查询已发布的招聘信息
	 * @param pager
	 * @param dto
	 * @return
	 */
	public Pager<RecruitVO> findPage(int pageOffSet, RecruitQueryDto dto);
	
	/**
	 * 根据id获得招聘信息详情
	 * @param id
	 * @return
	 */
	public RecruitVO getById(Long id);
	
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
	
	/**
	 * 根据学生id查询该学生的报名记录
	 * @param stuId
	 * @return
	 */
	public List<ApplyRecordVO> getApplyRecords(Long stuId);
}
