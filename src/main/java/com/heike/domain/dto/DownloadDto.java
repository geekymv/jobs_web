package com.heike.domain.dto;

import java.util.List;

public class DownloadDto {
	/**
	 * 文件名
	 */
	private String fileName;
	/**
	 * 标题
	 */
	private List<String> titles;
	
	/**
	 * 月份
	 */
	private String month;
	
	/**
	 * 内容
	 */
	private List<SalaryDto> contents;
	
	/**
	 * 身份，权限
	 */
	private Integer authority;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<String> getTitles() {
		return titles;
	}
	public void setTitles(List<String> titles) {
		this.titles = titles;
	}

	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	public List<SalaryDto> getContents() {
		return contents;
	}
	public void setContents(List<SalaryDto> contents) {
		this.contents = contents;
	}
	
	public void setAuthority(Integer authority) {
		this.authority = authority;
	}
	public Integer getAuthority() {
		return authority;
	}
	
}
