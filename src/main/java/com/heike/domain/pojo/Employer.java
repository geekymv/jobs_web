package com.heike.domain.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用工单位
 * @author Geek_ymv
 */
@Entity
@Table(name="t_employers")
public class Employer {
	private Long id;
	private String account;	//账号
	private String pwd; // 密码
	private String name;	//用工单位名称
	private String teacher;	//负责老师
	private String mobile; // 电话号码
	private Integer totalMoney;	//申请月总金额
	private Integer postNum;	//岗位数
	private Integer authority;	//权限(1-管理员， 2-用工单位)
	private String regDate;	// 注册时间
	private Integer status; // 账号是否可用(1可用 ，0冻结，-1删除)
	private String remarks;		//备注
	
	public Employer() {
		// TODO Auto-generated constructor stub
	}
	public Employer(Long id, String account, String name, Integer authority) {
		this.id = id;
		this.account = account;
		this.name = name;
		this.authority = authority;
	}
	
	public Employer(Long id, String account, String name, String teacher,
			String mobile, Integer totalMoney, Integer postNum,
			String regDate, Integer status, String remarks) {
		this.id = id;
		this.account = account;
		this.name = name;
		this.teacher = teacher;
		this.mobile = mobile;
		this.totalMoney = totalMoney;
		this.postNum = postNum;
		this.regDate = regDate;
		this.status = status;
		this.remarks = remarks;
	}
	
	public Employer(Long id, String account, String name, String teacher,
			String mobile, Integer totalMoney, Integer postNum, Integer status) {
		this.id = id;
		this.account = account;
		this.name = name;
		this.teacher = teacher;
		this.mobile = mobile;
		this.totalMoney = totalMoney;
		this.postNum = postNum;
		this.status = status;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	@Column(length=40)
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Column(length=60)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length=20)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Column(columnDefinition="float default 0")
	public Integer getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	public Integer getPostNum() {
		return postNum;
	}
	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}
	
	public Integer getAuthority() {
		return authority;
	}
	public void setAuthority(Integer authority) {
		this.authority = authority;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	@Column(length=14)
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Column(columnDefinition="int(1) default 1")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
