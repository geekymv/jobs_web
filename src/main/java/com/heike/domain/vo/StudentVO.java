package com.heike.domain.vo;


public class StudentVO {
	private Long id;
	private String num;	//学号
	private String name; // 姓名
	private String gender;  //性别
	private Long collegeId; // 学院id
	private String college;	//学院
	private Long professionId;	// 专业id
	private String profession;	//专业
	private String mobile; // 联系方式
	private String email;	// 邮箱
	private String introduce;	//自我介绍
	private String regTime;	//注册时间
	
	public StudentVO() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentVO(Long id, String num, String name, String gender, Long collegeId,
			String college, Long professionId, String profession, String mobile, String email,
			String introduce, String regTime) {
		this.id = id;
		this.num = num;
		this.name = name;
		this.gender = gender;
		this.collegeId = collegeId;
		this.college = college;
		this.professionId = professionId;
		this.profession = profession;
		this.mobile = mobile;
		this.email = email;
		this.introduce = introduce;
		this.regTime = regTime;
	}
	
	public StudentVO(Long id, String num, String name, String gender,
			String college, String profession, String mobile, String email,
			String introduce, String regTime) {
		this.id = id;
		this.num = num;
		this.name = name;
		this.gender = gender;
		this.college = college;
		this.profession = profession;
		this.mobile = mobile;
		this.email = email;
		this.introduce = introduce;
		this.regTime = regTime;
	}

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
	
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	
	public Long getProfessionId() {
		return professionId;
	}
	public void setProfessionId(Long professionId) {
		this.professionId = professionId;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
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
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	
}
