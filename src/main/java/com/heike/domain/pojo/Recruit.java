package com.heike.domain.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 招聘信息
 * @author Geek_ymv
 */
@Entity
@Table(name="t_recruits")
public class Recruit {
	private Long id;
	private String title;	// 标题
	private String postName;	//招聘岗位名
	private Integer postNum;	//招聘人数
	private String salary;	//薪资待遇
	private String context;	//工作要求
	private String releaseDate;	//发布时间
	private String updateDate;	// 更新时间
	private int applyNum;		//已报名人数
	private String endDate;	//报名截止时间
	private String remarks;	//备注
	private Integer status;	//  状态(1已发布，0已关闭，-1已删除)
	private Long empId; //用工单位
	
	public Recruit() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="employer_id")
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
	public void setContext(String context) {
		this.context = context;
	}
	public String getContext() {
		return context;
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

	@Column(length=14)
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	@Column(length=14)
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	@Column(columnDefinition="int(11) default 0")
	public int getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(int applyNum) {
		this.applyNum = applyNum;
	}
	
	@Column(length=14)
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
	@Column(columnDefinition="int(1) default 1")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
