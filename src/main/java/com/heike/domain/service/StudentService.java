package com.heike.domain.service;

import java.util.List;

import com.heike.domain.pojo.Student;
import com.heike.domain.vo.ApplyRecruitVO;



public interface StudentService {
	
	/**
	 * 根据学号获得学生信息
	 * @param num
	 * @return
	 */
	public Student getByNum(String num);
	
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
