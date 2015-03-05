package com.heike.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Repeat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heike.domain.dto.Pager;
import com.heike.domain.pojo.Recruit;
import com.heike.domain.service.CommonService;
import com.heike.domain.service.RecruitService;

@Controller
public class IndexController {
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private CommonService commonService;
	
	/**
	 * 跳转到首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model, HttpServletRequest request) {
		Pager<Recruit> pager = recruitService.list(1);
		model.addAttribute("pager", pager);
		
//		System.out.println(pager.getDatas());
		return "index";
	}
	
	@RequestMapping("/detail/{id}")
	@ResponseBody
	public Recruit detail(@PathVariable("id")Integer id){

		return null;
	}

	/**
	 * 跳转到用户登录页面
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	/**
	 * 处理用户登录请求
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String login(String account, String password, String rember, HttpSession session) {
		return commonService.login(account, password, session);
	}
	
	/**
	 * 跳转到学生首页
	 * @return
	 */
	@RequestMapping("/student/index")
	public String goStudent() {
		return "student/index";
	}
	
	/**
	 * 跳转到用工单位首页
	 * @return
	 */
	@RequestMapping("/employer/index")
	public String goEmployer() {
		return "employer/index";
	}
	
	/**
	 * 跳转到管理员首页
	 * @return
	 */
	@RequestMapping("/admin/index")
	public String goAdmin() {
		return "admin/index";
	}
	
}














