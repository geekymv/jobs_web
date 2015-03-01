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
@Table(name="t_recstus")
public class RecStu {
	private Long id;
	private Long recId; // 招聘信息id
	private Long stuId;	// 学生id
	private Integer status; // 状态(1已报名，0取消报名)
	private Date signUpDate;	// 报名时间
	
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getSignUpDate() {
		return signUpDate;
	}
	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	
	
}
