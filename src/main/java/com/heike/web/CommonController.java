package com.heike.web;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heike.domain.pojo.Employer;
import com.heike.domain.service.CommonService;
import com.heike.domain.service.EmployerService;
import com.heike.domain.service.StudentService;
import com.heike.domain.vo.StudentVO;

@Controller
public class CommonController {
	@Autowired
	private CommonService commonService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private EmployerService employerService;
	
	/**
	 * 系统简介
	 * @return
	 */
	@RequestMapping("/introduce")
	public String introduce() {
		return "introduce";
	}
	
	/**
	 * 开发团队
	 * @return
	 */
	@RequestMapping("/hkkj")
	public String hkkj() {
		return "hkkj";
	}
	
	/**
	 * 帮助中心
	 * @return
	 */
	@RequestMapping("/help")
	public String help() {
		return "help";
	}
	
	/**
	 * 工资下载
	 * @param month
	 * @param response
	 * @param session
	 */
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
	public StudentVO stuInfo(Long stuId) {
		 return studentService.getById(stuId);
	}
	
	/**
	 * 验证学生学号是否和其他学号重复
	 * @param empId
	 * @param account
	 * @return
	 */
	@RequestMapping("/stuIsExist")
	@ResponseBody
	public String stuIsExist(Long stuId, String num) {
		if(studentService.isExist(stuId, num)) {
			return "isExist";	
		}
		return "notExist";
	}
	
	/**
	 * 查看用工单位资料
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/empinfo")
	@ResponseBody
	public Employer empInfo(Long empId){
		return employerService.getInfo(empId);
	}
	
	/**
	 * 验证用工单位账号是否和其他账号重复
	 * @param empId
	 * @param account
	 * @return
	 */
	@RequestMapping("/empIsExist")
	@ResponseBody
	public String empIsExist(Long empId, String account) {
		if(employerService.isExist(empId, account)) {
			return "isExist";	
		}
		return "notExist";
	}
	
	
}
