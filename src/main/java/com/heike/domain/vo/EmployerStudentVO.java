package com.heike.domain.vo;


public class EmployerStudentVO {
	private Long id;	// 学生id
	private String name;	// 学生姓名
	private String num;	// 学生学号
	private String profession;	// 学生专业
	private String postName;	// 岗位名称
	private String salary;	// 基本工资
	private String date;	// 审核时间
	private Integer status; // 状态(1在职，-1离职)
	
	public EmployerStudentVO() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployerStudentVO(Long id, String num, String name, String profession, 
			String postName, String salary, String date,
			Integer status) {
		this.id = id;
		this.name = name;
		this.num = num;
		this.profession = profession;
		this.postName = postName;
		this.salary = salary;
		this.date = date;
		this.status = status;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
