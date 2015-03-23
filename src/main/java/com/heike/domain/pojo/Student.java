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
 * 学生类
 * @author Geek_ymv
 */
@Entity
@Table(name="t_students")
public class Student {
	private Long id;
	private String num;	//学号
	private String pwd; // 密码
	private String name; // 姓名
	private String gender;  //性别
	private Long collegeId;	//学院
	private Long professionId;	//专业
	private String mobile; // 联系方式
	private String email;	// 邮箱
	private String introduce;	//自我介绍
	private Date regTime;	//注册时间
	private Integer status;	// 账号状态(1正常， 0冻结， -1删除)
	
	public Student() {
	}
	public Student(String num, String name) {
		this.num = num;
		this.name = name;
	}
	public Student(Long id, String num, String name) {
		this.id = id;
		this.num = num;
		this.name = name;
	}

	


	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}
	public Long getProfessionId() {
		return professionId;
	}
	public void setProfessionId(Long professionId) {
		this.professionId = professionId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	@Column(columnDefinition="int(1) default 1")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
