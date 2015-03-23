package com.heike.domain.vo;

import java.util.Date;

/**
 * 学生申请的岗位
 * @author Geek_ymv
 */
public class ApplyRecruitVO {
	private Long recruitId;	// 岗位id
	private String recruitName;	// 岗位名称
	private Date date;	// 报名时间
	private Long employerId;	// 发布单位id
	private String employer;	// 发布单位
	private String salary; // 薪水
	private Integer status;
	
	public ApplyRecruitVO() {
	}

	public ApplyRecruitVO(Long recruitId, String recruitName, Date date,
			Long employerId, String employer, String salary, Integer status) {
		this.recruitId = recruitId;
		this.recruitName = recruitName;
		this.date = date;
		this.employerId = employerId;
		this.employer = employer;
		this.salary = salary;
		this.status = status;
	}

	public Long getRecruitId() {
		return recruitId;
	}
	public void setRecruitId(Long recruitId) {
		this.recruitId = recruitId;
	}

	public String getRecruitName() {
		return recruitName;
	}
	public void setRecruitName(String recruitName) {
		this.recruitName = recruitName;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Long getEmployerId() {
		return employerId;
	}
	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
