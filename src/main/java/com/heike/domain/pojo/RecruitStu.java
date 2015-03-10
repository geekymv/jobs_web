package com.heike.domain.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private Long stuId;	// 学生id
	private Long empId;	// 用工单位id
	private Date applyDate;	// 报名时间
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
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
}
