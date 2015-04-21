package com.heike.web.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heike.base.SysCode;
import com.heike.domain.dto.Pager;
import com.heike.domain.dto.SalaryDto;
import com.heike.domain.dto.SalaryQueryDto;
import com.heike.domain.dto.StudentDto;
import com.heike.domain.pojo.Dict;
import com.heike.domain.pojo.Employer;
import com.heike.domain.service.AdminService;
import com.heike.domain.service.DictService;
import com.heike.domain.service.SalaryService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private DictService dictService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private SalaryService salaryService;
	
	@RequestMapping("/home")
	public String home(){
		return "admin/home";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<Dict> list(){
		return dictService.list(SysCode.DictCode.COLLEGE_TYPE);
	}
	
	@RequestMapping("/add")
	public void add() {
		Dict dict = new Dict();
		dict.setName("test");
		dict.setType("test");
		
		dictService.add(dict);
	}
	
	/**
	 * 跳转到添加用工单位页面
	 * @return
	 */
	@RequestMapping(value="/addemployer", method=RequestMethod.GET)
	public String addEmployer() {
		return "admin/addEmployer";
	}

	/**
	 * 判断用工单位账户名是否已经存在
	 * @param account
	 * @return
	 */
	@RequestMapping("/isExist")
	@ResponseBody
	public String isExist(String account) {
		if(adminService.isExist(account)) {
			return "isexist";	// 存在
		}
		
		return "notexist";	// 不存在
	}
	
	/**
	 * 处理添加用工单位请求
	 * @param employer
	 * @return
	 */
	@RequestMapping(value="/addemployer", method=RequestMethod.POST)
	@ResponseBody
	public String addEmployer(Employer employer) {
		if(adminService.addEmployer(employer)) {
			return "success";
		}
		
		return "fail";
	}
	
	/**
	 * 跳转到用工单位列表
	 * @return
	 */
	@RequestMapping(value="/employerList", method=RequestMethod.GET)
	public String employerList() {
		return "admin/employerList";
	}
	
	/**
	 * 分页显示用工单位列表
	 * @param pager
	 * @return
	 */
	@RequestMapping(value="/employerList", method=RequestMethod.POST)
	@ResponseBody
	public Pager<Employer> employerList(Pager<Employer> pager) {
		adminService.getEmployerByPage(pager);
		return pager;
	}
	
	
	/**
	 * 跳转到学生列表
	 * @return
	 */
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public String students() {
		return "admin/students";
	}

	/**
	 * 分页显示学生列表
	 * @param pager
	 * @return
	 */
	@RequestMapping(value="/students", method=RequestMethod.POST)
	@ResponseBody
	public Pager<StudentDto> students(Pager<StudentDto> pager) {
		adminService.getStudentByPage(pager);
		return pager;
	}
	
	
	/**
	 * 跳转到工资列表页面
	 * @return
	 */
	@RequestMapping("/salaryList")
	public String salaryList() {
		return "admin/salaryList";
	}
	
	/**
	 * 查询工资列表
	 * @param month
	 */
	@RequestMapping(value="/salaryList", method=RequestMethod.POST)
	@ResponseBody
	public Pager<SalaryDto> salaryList(Pager<SalaryDto> pager, SalaryQueryDto sqd, HttpSession session) {
		salaryService.getSalaryPage2(pager, sqd);
		return pager;
	}
	
}
