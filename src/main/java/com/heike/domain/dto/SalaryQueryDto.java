package com.heike.domain.dto;

public class SalaryQueryDto {
	/**
	 * 学生id
	 */
	private Long stuId;
	/**
	 * 用工单位id
	 */
	private Long empId;
	/**
	 * 月份
	 */
	private String month;
	
	public Long getStuId() {
		return stuId;
	}
	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
}
