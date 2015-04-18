package com.heike.domain.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 招聘信息-学生
 * 一条招聘信息可以用多个学生
 * 一个学生可以报名多条招聘信息
 * @author Geek_ymv
 */
@Entity
@Table(name="t_recruit_students")
public class RecruitStu {
	private Long id;
	private Long recId; // 招聘信息id
	private Long empId; // 发布招聘信息的用工单位
	private Long stuId;	// 学生id
	
	private String applyDate;	// 报名时间
	private Integer status; // 状态(1审核通过, 0等待审核, -1审核不通过)
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="recruit_id")
	public Long getRecId() {
		return recId;
	}
	public void setRecId(Long recId) {
		this.recId = recId;
	}
	
	@Column(name="employer_id")
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
	
	@Column(name="student_id")
	public Long getStuId() {
		return stuId;
	}
	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}
	@Column(columnDefinition="int(1) default 1")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Column(length=14)
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
}
