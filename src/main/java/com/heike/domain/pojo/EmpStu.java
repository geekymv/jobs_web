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
@Table(name="t_empstus")
public class EmpStu {
	private Long id;
	private Long empId; // 用工单位id
	private Long stuId; // 学生id
	private String postName;	// 岗位名称
	private Integer status; // 状态(1-在职，0-离职)
	
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
	@Column(name="student_id")
	public Long getStuId() {
		return stuId;
	}
	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	@Column(columnDefinition="int default 1", length=1)
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
