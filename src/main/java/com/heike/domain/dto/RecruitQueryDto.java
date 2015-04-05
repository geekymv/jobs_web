package com.heike.domain.dto;

public class RecruitQueryDto {
	/**
	 * 用工单位id
	 */
	private Long empId;
	/**
	 * 开始日期
	 */
	private String startDate;
	/**
	 * 结束日期
	 */
	private String endDate;
	
	/**
	 * 标题
	 */
	private String title;
	
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Long getEmpId() {
		return empId;
	}

	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	
	
}
