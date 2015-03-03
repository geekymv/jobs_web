package com.heike.domain.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 薪水类
 * @author Geek_ymv
 */
@Entity
@Table(name="t_salaries")
public class Salary {
	private Long id;
	private String month;	//月份
	private String worktime;	//工作时间
	private float salary;	//基本工资
	private float bonus;	//奖金
	private float toolFee;	//工具费
	private Employer employer;	// 用工单位
	private Student student;	//多对一的关联关系，Student是一的一方
	private Integer status; // 工资状态 1正常， -1已被删除
	private String remarks;		//备注
	private Date date;
	
	public Salary() {
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="student_id")
	public Student getStudent() {
		return student;
	}
	@ManyToOne
	@JoinColumn(name="employer_id")
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public Date getDate() {
		return date;
	}
	public String getMonth() {
		return month;
	}
	@Column(columnDefinition="float default 0")
	public float getSalary() {
		return salary;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Column(columnDefinition="float default 0")
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	@Column(columnDefinition="float default 0")
	public float getToolFee() {
		return toolFee;
	}
	public void setToolFee(float toolFee) {
		this.toolFee = toolFee;
	}

	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getWorktime() {
		return worktime;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	@Column(columnDefinition="int(1) default 1")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
