package com.heike.domain.vo;


public class RecruitStuVO {
	private String num;	// 学号
	private String name;	// 姓名 
	private String profession; // 专业
	private String applyDate;	// 报名时间
	private Integer status; // 状态(1审核通过, 0等待审核, -1审核不通过)
	
	public RecruitStuVO() {
		// TODO Auto-generated constructor stub
	}
	
	public RecruitStuVO(String num, String name, String profession,
			String applyDate, Integer status) {
		this.num = num;
		this.name = name;
		this.profession = profession;
		this.applyDate = applyDate;
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
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
