package com.heike.domain.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 字典
 * @author Geek_ymv
 */
@Entity
@Table(name="t_dicts")
public class Dict{
	private Long id;
	private String name;	// 名称
	private String type;	// 类别(XY学院)
	private Long superiorId;	// 上级编号
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(length=30)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getSuperiorId() {
		return superiorId;
	}
	public void setSuperiorId(Long superiorId) {
		this.superiorId = superiorId;
	}
}
