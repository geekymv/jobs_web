package com.heike.domain.service;

import javax.servlet.http.HttpSession;

public interface CommonService {

	public String login(String account, String password, HttpSession session);

}
