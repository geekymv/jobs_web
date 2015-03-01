package com.heike.domain.pojo;

import java.util.Date;

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
	private String number;	//学号
	private String password;
	private String name;
	private String gender;
	private String college;	//学院
	private String profession;	//专业
	private String mobile;
	private String introduce;	//自我介绍
	private Date regTime;	//注册时间
	
	public Student() {
	}

	public Student(String number, String password, String name, String gender,
			String college, String profession, String mobile, String introduce) {
		this.number = number;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.college = college;
		this.profession = profession;
		this.mobile = mobile;
		this.introduce = introduce;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getNumber() {
		return number;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getCollege() {
		return college;
	}
	public String getProfession() {
		return profession;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

}
