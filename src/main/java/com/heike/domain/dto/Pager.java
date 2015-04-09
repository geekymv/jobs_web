package com.heike.domain.dto;

import java.util.List;

public final class Pager<T> {
	private int currentPage = 1;	// 当前页
	private int pageIndex;	// 第几页，从0开始
	private int pageSize = 5;	// 每页显示多少条记录
	private int totalRecord; // 总记录数
	private int totalPage; // 总页数
	private int pageOffSet;
	private List<T> datas;

	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageOffSet() {
		return pageOffSet;
	}
	public void setPageOffSet(int pageOffSet) {
		this.pageOffSet = pageOffSet;
	}

	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

}
