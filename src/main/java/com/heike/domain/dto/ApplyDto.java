package com.heike.domain.dto;

public class ApplyDto {
	/**
	 * 学生id
	 */
	private Long stuId;
	/**
	 * 招聘信息id
	 */
	private Long recId;
	/**
	 * 用工单位id
	 */
	private Long empId;
	
	public Long getStuId() {
		return stuId;
	}
	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}
	public Long getRecId() {
		return recId;
	}
	public void setRecId(Long recId) {
		this.recId = recId;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

}
