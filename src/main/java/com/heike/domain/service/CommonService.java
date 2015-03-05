package com.heike.domain.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.heike.domain.pojo.Dict;

public interface CommonService {

	/**
	 * 用户登录
	 * @param account
	 * @param password
	 * @param session
	 * @return
	 */
	public String login(String account, String password, HttpSession session);
	
	/**
	 * 获得所有的学院
	 * @return
	 */
	public List<Dict> getColleges();
	
	/**
	 * 根据学院id获得该学院所有的专业
	 * @param colId 学院专业
	 * @return
	 */
	public List<Dict> getProfessions(Long colId);

}
