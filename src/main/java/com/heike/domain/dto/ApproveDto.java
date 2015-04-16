package com.heike.domain.dto;

/**
 * 用工单位审核Dto
 * @author miying
 */
public class ApproveDto {
	/**
	 * 学生id
	 */
	private Long stuId;
	/**
	 * 用工单位id
	 */
	private Long empId;
	/**
	 * 招聘信息id
	 */
	private Long recId;
	/**
	 * -1不录用，1录用
	 */
	private Integer status;
	
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
	
	public Long getRecId() {
		return recId;
	}
	public void setRecId(Long recId) {
		this.recId = recId;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
