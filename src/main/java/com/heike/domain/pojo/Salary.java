package com.heike.domain.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private String salary;	//基本工资
	private String bonus;	//奖金
	private String toolFee;	//工具费
	private Long empId;	// 用工单位
	private Long stuId;	//多对一的关联关系，Student是一的一方
	private Integer status; // 工资状态 1正常， -1已被删除
	private String remarks;		//备注
	private String date;
	
	public Salary() {
	}

	public Salary(String salary, String bonus, String toolFee) {
		this.salary = salary;
		this.bonus = bonus;
		this.toolFee = toolFee;
	}



	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(length=10)
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}

	@Column(length=20)
	public String getWorktime() {
		return worktime;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}

	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public String getToolFee() {
		return toolFee;
	}
	public void setToolFee(String toolFee) {
		this.toolFee = toolFee;
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
	
	@Column(columnDefinition="int(1) default 1")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Column(length=14)
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
