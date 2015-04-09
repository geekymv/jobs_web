package com.heike.domain.vo;


public class RecruitVO {
	private Long id;
	private String title;	// 标题
	private String postName;	//招聘岗位名
	private Integer postNum;	//招聘人数
	private String salary;	//薪资待遇
	private String context;	//工作要求
	private String releaseDate;	//发布时间
	private int applyNum;		//已报名人数
	private String endDate;	//报名截止时间
	private String remarks;	//备注
	private Integer status;	//  状态(1已发布，0已关闭，-1已删除)
	private String empName;	// 用工单位名称
	
	
	public RecruitVO() {
	}

	public RecruitVO(Long id, String title, String postName, String releaseDate,
			String endDate, String empName) {
		this.id = id;
		this.title = title;
		this.postName = postName;
		this.releaseDate = releaseDate;
		this.endDate = endDate;
		this.empName = empName;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public Integer getPostNum() {
		return postNum;
	}
	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public int getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(int applyNum) {
		this.applyNum = applyNum;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
}
