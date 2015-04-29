package com.heike.web.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heike.domain.dto.EmployerDto;
import com.heike.domain.dto.Pager;
import com.heike.domain.dto.SalaryDto;
import com.heike.domain.dto.SalaryQueryDto;
import com.heike.domain.dto.StudentDto;
import com.heike.domain.pojo.Dict;
import com.heike.domain.pojo.Employer;
import com.heike.domain.pojo.Student;
import com.heike.domain.service.AdminService;
import com.heike.domain.service.DictService;
import com.heike.domain.service.EmployerService;
import com.heike.domain.service.SalaryService;
import com.heike.domain.service.StudentService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private DictService dictService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private SalaryService salaryService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private EmployerService employerService;
	
	@RequestMapping("/home")
	public String home(){
		return "admin/home";
	}
	
	/**
	 * 跳转到学院管理页面
	 * @return
	 */
	@RequestMapping("/colleges")
	public String college() {
		return "admin/colleges";
	}
	
	/**
	 * 添加学院
	 * @param name 学院名称
	 * @return
	 */
	@RequestMapping("/addCollege")
	@ResponseBody
	public String addCollege(Dict dict) {
		return dictService.addCollege(dict);
	}
	
	/**
	 * 跳转到专业列表页面
	 * @return
	 */
	@RequestMapping("/professions/{colId}")
	public String professions(@PathVariable Long colId, Model model) {
		System.out.println(colId);
		
		Dict dict = dictService.findById(colId);
		model.addAttribute("dict", dict);
		
		return "admin/professions";
	}
	
	/**
	 * 添加专业、更新
	 * @param dto
	 * @return
	 */
	@RequestMapping("/addProfession")
	@ResponseBody
	public String addProfession(Dict dict) {
		return dictService.addProfession(dict);
	}
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteDict")
	@ResponseBody
	public String deleteDict(Long id) {
		if(dictService.delete(id)) {
			return "success";
		}
		return "fail";
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
	@RequestMapping(value="/employers", method=RequestMethod.GET)
	public String employerList() {
		return "admin/employers";
	}
	
	/**
	 * 分页显示用工单位列表
	 * @param pager
	 * @return
	 */
	@RequestMapping(value="/employerList", method=RequestMethod.POST)
	@ResponseBody
	public Pager<Employer> employerList(Pager<Employer> pager, String name) {
		adminService.getEmployerByPage(pager, name);
		return pager;
	}

	@RequestMapping("/editEmployer")
	@ResponseBody
	public String editEmployer(EmployerDto dto) {
		employerService.edit(dto);
		return "success";
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
	public Pager<StudentDto> students(Pager<StudentDto> pager, String content) {
		adminService.getStudentByPage(pager, content);
		return pager;
	}
	
	/**
	 * 更新学生信息
	 * @param student
	 * @return
	 */
	@RequestMapping("/editStudent")
	@ResponseBody
	public String editStudent(Student student) {
		if(studentService.update(student)) {
			return "success";
		}
		return "fail";
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
