package com.heike.domain.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用工单位-学生
 * 一个用工单位可以有多个学生
 * 一个学生可以属于多个用工单位
 * @author Geek_ymv
 */
@Entity
@Table(name="t_employer_students")
public class EmpStu {
	private Long id;
	private Long empId; // 用工单位id
	private Long recruitId;	// 招聘信息
	private Long stuId; // 学生id
	private Integer status; // 状态(1在职，-1离职)
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="employer_id")
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	@Column(name="recruit_id")
	public Long getRecruitId() {
		return recruitId;
	}
	public void setRecruitId(Long recruitId) {
		this.recruitId = recruitId;
	}
	@Column(name="student_id")
	public Long getStuId() {
		return stuId;
	}
	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}
	//   length属性表示字段的长度，当字段的类型为varchar时，该属性才有效，默认为255个字符。
	@Column(columnDefinition="int(1) default 1")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
