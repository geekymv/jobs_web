package com.heike.domain.vo;

import java.util.Date;

import com.heike.domain.pojo.Student;

public class RecruitStuVO {
	private String num;	// 学号
	private String name;	// 姓名 
	private String profession; // 专业
	private Date signUpDate;	// 报名时间
	private Integer status; // 状态(1通过, 0等待审核, -1审核不通过)
	
	public RecruitStuVO() {
		// TODO Auto-generated constructor stub
	}
	
	public RecruitStuVO(String num, String name, String profession,
			Date signUpDate, Integer status) {
		this.num = num;
		this.name = name;
		this.profession = profession;
		this.signUpDate = signUpDate;
		this.status = status;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Date getSignUpDate() {
		return signUpDate;
	}
	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
