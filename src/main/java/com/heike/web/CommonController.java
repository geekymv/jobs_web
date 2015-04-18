package com.heike.web;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heike.domain.service.CommonService;

@Controller
public class CommonController {
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/download")
	public void download(HttpServletResponse response, HttpSession session, String month) {
		Object object = session.getAttribute("user");
		commonService.download(object,  month, response);
	}
	
}
