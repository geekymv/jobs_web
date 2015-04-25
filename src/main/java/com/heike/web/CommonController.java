package com.heike.web;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heike.domain.service.CommonService;
import com.heike.domain.service.StudentService;
import com.heike.domain.vo.StudentVO;

@Controller
public class CommonController {
	@Autowired
	private CommonService commonService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/download/{month}")
	public void download(@PathVariable("month")String month, 
			HttpServletResponse response, HttpSession session) {
		Object object = session.getAttribute("user");
		commonService.download(object,  month, response);
	}
	
	/**
	 * 查看学生信息
	 */
	@RequestMapping("/stuinfo")
	@ResponseBody
	public StudentVO myInfo(HttpSession session, Long stuId) {
		 return studentService.getById(stuId);
	}
	
	
}
