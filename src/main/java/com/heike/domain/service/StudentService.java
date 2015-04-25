package com.heike.domain.service;

import java.util.List;

import com.heike.domain.dto.ApplyDto;
import com.heike.domain.pojo.Student;
import com.heike.domain.vo.ApplyRecruitVO;
import com.heike.domain.vo.StudentVO;



public interface StudentService {
	
	/**
	 * 根据学号获得学生信息
	 * @param id 学生id
	 * @return
	 */
	public Student getByNum(String num);
	
	/**
	 * 根据id获得学生信息
	 * @param id 学生id
	 * @return
	 */
	public StudentVO getById(Long id);
	
	
	/**
	 * 学生注册
	 * @param student
	 * @return
	 */
	public Student register(Student student);
	
	/**
	 * 学生报名活动
	 * @param stuId 学生id
	 * @param recId 招聘信息id
	 * @return "onJob" 在职, "isApplyed"已申请该用工单位的信息,
	 *  "isPastDue"过期， "success"报名成功，"fail"报名失败
	 */
	public String apply(ApplyDto applyDto); 
	
	/**
	 * 学生查看在职的岗位
	 * @param stuId
	 * @return
	 */
	public List<ApplyRecruitVO> getOnJobList(Long stuId);
	
	/**
	 * 更新信息
	 * @param student
	 * @return
	 */
	public boolean update(Student student);

	/**
	 * 判断该学号是否和其他学号重复
	 * @param stuId
	 * @param num
	 * @return true 重复， false不重复
	 */
	public boolean isExist(Long stuId, String num);
	
	
}
