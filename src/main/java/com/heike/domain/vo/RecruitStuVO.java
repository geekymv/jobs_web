package com.heike.domain.vo;


public class RecruitStuVO {
	private Long stuId;	// 学生id
	private String num;	// 学号
	private String name;	// 姓名 
	private String mobile; 	// 联系方式
	private String profession; // 专业
	private String applyDate;	// 报名时间
	private Long recId;	// 报名的招聘信息id
	private String postName;	// 岗位名称
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
	
	public RecruitStuVO(Long stuId, String num, String name, String profession,
			String applyDate, String postName, Long recId) {
		this.stuId = stuId;
		this.num = num;
		this.name = name;
		this.profession = profession;
		this.applyDate = applyDate;
		this.postName = postName;
		this.recId = recId;
	}
	
	public RecruitStuVO(Long stuId, String num, String name, String mobile, String profession,
			String applyDate, String postName, Long recId) {
		this(stuId, num, name, profession, applyDate, postName, recId);
		this.mobile = mobile;
	}
	
	public Long getStuId() {
		return stuId;
	}
	public void setStuId(Long stuId) {
		this.stuId = stuId;
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
	
	public Long getRecId() {
		return recId;
	}
	public void setRecId(Long recId) {
		this.recId = recId;
	}

	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
