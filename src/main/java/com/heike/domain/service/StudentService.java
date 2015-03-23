package com.heike.domain.service;

import java.util.List;

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
	 */
	public void apply(Long stuId, Long recId); 
	
	/**
	 * 学生查看在职的岗位
	 * @param stuId
	 * @return
	 */
	public List<ApplyRecruitVO> getOnJobList(Long stuId);
	
	
}
