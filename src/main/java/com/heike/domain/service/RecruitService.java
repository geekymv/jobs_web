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
	public void findPage(Pager<RecruitVO> pager);
	
	/**
	 * 分页查询已发布的招聘信息
	 * @param pager
	 * @param dto
	 * @return
	 */
	public Pager<RecruitVO> findPage(Pager<RecruitVO> pager, RecruitQueryDto dto);
	
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
	 * @return "notApply"还未报名， "isApplyed"已经报名
	 */
	public String isApply(Long stuId, Long recId);
	
	/**
	 * 根据学生id查询该学生的报名记录
	 * @param stuId
	 * @return
	 */
	public List<ApplyRecordVO> getApplyRecords(Long stuId);
	
	/**
	 * 发布招聘信息
	 * @param recruit
	 */
	public void add(Recruit recruit, Long empId);
	
	/**
	 * 编辑招聘信息
	 * @param recruit
	 */
	public int edit(Recruit recruit);
	
	/**
	 * 删除招聘信息
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);
	
	/**
	 * 判断某条招聘信息是否有学生报名
	 * @param recId
	 * @return
	 */
	public boolean isApplyed(Long recId);
}
