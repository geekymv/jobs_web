package com.heike.domain.dto;

public class SalaryDto {
	
	public SalaryDto() {
		// TODO Auto-generated constructor stub
	}
	
	public SalaryDto(String name, String num, String profession,
			String postName, String empName, String worktime, String salary,
			String toolFee, String bonus, String remarks) {
		this.name = name;
		this.num = num;
		this.profession = profession;
		this.postName = postName;
		this.empName = empName;
		this.worktime = worktime;
		this.salary = salary;
		this.toolFee = toolFee;
		this.bonus = bonus;
		this.remarks = remarks;
	}

	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 学号
	 */
	private String num;
	/**
	 * 专业
	 */
	private String profession;
	/**
	 * 岗位名称
	 */
	private String postName;
	/**
	 * 所在单位
	 */
	private String empName;
	/**
	 * 工作时间
	 */
	private String worktime;
	/**
	 * 基本工资
	 */
	private String salary;
	/**
	 * 工具费
	 */
	private String toolFee;
	/**
	 * 奖金
	 */
	private String bonus;
	
	/**
	 * 备注
	 */
	private String remarks;

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

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

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

	public String getToolFee() {
		return toolFee;
	}

	public void setToolFee(String toolFee) {
		this.toolFee = toolFee;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
