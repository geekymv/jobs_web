package com.heike.web;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heike.domain.pojo.Employer;
import com.heike.domain.service.CommonService;

@Controller
public class CommonController {
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/download")
	public void download(HttpServletResponse response, HttpSession session) {
		Employer employer = new Employer();
		employer.setId(1L);
		employer.setAuthority(1);
		session.setAttribute("user", employer);
		
		Object object = session.getAttribute("user");
		commonService.download(object, response);
	}
	
}
