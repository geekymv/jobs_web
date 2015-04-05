package com.heike.domain.vo;

import java.util.Date;

/**
 * 报名记录
 */
public class ApplyRecordVO {
	private String postName;	// 岗位名称
	private String 	employer;	// 发布单位
	private String salary;	// 薪资待遇
	private Date applyTime;	// 报名时间
	private Integer status;	//审核状态(1审核通过, 0等待审核, -1审核不通过)
	
	public ApplyRecordVO() {
	}
	
	public ApplyRecordVO(String postName, String employer, String salary,
			Date applyTime, Integer status) {
		this.postName = postName;
		this.employer = employer;
		this.salary = salary;
		this.applyTime = applyTime;
		this.status = status;
	}



	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
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
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
