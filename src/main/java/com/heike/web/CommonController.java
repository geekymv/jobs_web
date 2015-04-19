package com.heike.web;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heike.domain.service.CommonService;

@Controller
public class CommonController {
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/download/{month}")
	public void download(@PathVariable("month")String month, 
			HttpServletResponse response, HttpSession session) {
		Object object = session.getAttribute("user");
		commonService.download(object,  month, response);
	}
	
}
