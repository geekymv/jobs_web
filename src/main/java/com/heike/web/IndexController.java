package com.heike.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heike.base.SysCode;
import com.heike.domain.dto.Pager;
import com.heike.domain.pojo.Dict;
import com.heike.domain.pojo.Employer;
import com.heike.domain.pojo.Student;
import com.heike.domain.service.CommonService;
import com.heike.domain.service.RecruitService;
import com.heike.domain.vo.RecruitStuVO;
import com.heike.domain.vo.RecruitVO;

@Controller
public class IndexController {
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private CommonService commonService;
	
	/**
	 * 进入首页 
	 * @return
	 */
	@RequestMapping(value={"/", "/index"})
	public String index() {
		return "index";
	}
	
	/**
	 * 首页分页显示招聘信息
	 * @param pager
	 * @return
	 */
	@RequestMapping("/recruits")
	@ResponseBody
	public Pager<RecruitVO> recruits(Pager<RecruitVO> pager) {
		recruitService.findPage(pager);
		return pager;
	}
	
	/**
	 * 招聘信息详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable Long id, Model model){
		RecruitVO recruit = recruitService.getById(id);
		model.addAttribute("recruit", recruit);
		
		return "detail";
	}
	
	/**
	 * 根据招聘信息id查询已报名学生列表
	 * @param id 招聘信息id
	 * @return
	 */
	@RequestMapping("/getApplyStudents")
	@ResponseBody
	public List<RecruitStuVO> getApplyStudents(Long id) {
		return recruitService.getApplyStudents(id);
	}
	
	/**
	 * 获得所有的学院
	 * @return
	 */
	@RequestMapping("/getColleges")
	@ResponseBody
	public List<Dict> getColleges(){
		return commonService.getColleges();
	}
	
	/**
	 * 获得该学院的所有专业
	 * @param colId
	 * @return
	 */
	@RequestMapping("/getProfessions")
	@ResponseBody
	public List<Dict> getProfessions(Long colId) {
		return commonService.getProfessions(colId);
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
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public String login(String account, String password, String rember, HttpSession session) {
		return commonService.login(account, password, session);
	}

	/**
	 * 用户退出
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
	
	/**
	 * 进入我的主页
	 * @return
	 */
	@RequestMapping("/home")
	public String home(HttpSession session) {
		Object object = session.getAttribute("user");
		String path = "";
		if(object != null) {
			if(object instanceof Student) {	// 学生
				path = "student/home";
			}else if(object instanceof Employer) {
				Employer employer = (Employer)object;
				int authority = employer.getAuthority();
				if(authority == SysCode.EmployerCode.ADMIN_AUTHORITY) { // 管理员
					path = "admin/home";
				}else if(authority == SysCode.EmployerCode.EMPLOYER_AUTHORITY) { // 用工单位
					path = "employer/home";
				}
			}
		}
		return "redirect:" + path;
	}
	
}














