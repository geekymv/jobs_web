package com.heike.web.employer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heike.domain.dto.ApproveDto;
import com.heike.domain.dto.EmployerDto;
import com.heike.domain.dto.Pager;
import com.heike.domain.dto.RecruitQueryDto;
import com.heike.domain.dto.SalaryDto;
import com.heike.domain.dto.SalaryQueryDto;
import com.heike.domain.pojo.Employer;
import com.heike.domain.pojo.Recruit;
import com.heike.domain.pojo.Salary;
import com.heike.domain.service.EmployerService;
import com.heike.domain.service.RecruitService;
import com.heike.domain.service.SalaryService;
import com.heike.domain.vo.EmployerStudentVO;
import com.heike.domain.vo.RecruitStuVO;
import com.heike.domain.vo.RecruitVO;
import com.heike.util.DateUtils;

@Controller
@RequestMapping("/employer")
public class EmployerController {
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private EmployerService employerService;
	@Autowired
	private SalaryService salaryService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/home")
	public String home() {
		return "employer/home";
	}

	/**
	 * 用工单位查看自己发布的招聘信息
	 * @param session
	 * @param dto
	 * @param pager
	 * @return
	 */
	@RequestMapping("/myRecruits")
	@ResponseBody
	public Pager<RecruitVO> pager(HttpSession session, RecruitQueryDto dto,
			Pager<RecruitVO> pager) {
		Employer employer = (Employer)session.getAttribute("user");
		dto.setEmpId(employer.getId());
		
		return recruitService.findPage(pager, dto);
	}
	
	/**
	 * 查看招聘详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable("id")Long id, Model model) {
		RecruitVO recruitVO = recruitService.getById(id);
		model.addAttribute("recruit", recruitVO);
		
		return "employer/detail";
	}
	
	/**
	 * 用工单位查看个人资料
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/myinfo")
	public String myInfo(HttpSession session, Model model){
		Employer employer = (Employer)session.getAttribute("user");
		employer = employerService.getInfo(employer.getId());
		
		model.addAttribute("employer", employer);

		return "employer/myinfo";
	}
	
	/**
	 * 编辑个人信息
	 * @param dto
	 * @param session
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public String edit(EmployerDto dto, HttpSession session){
		employerService.edit(dto);
		// 更新session
		Employer employer = (Employer)session.getAttribute("user");
		employer = employerService.getInfo(employer.getId());
		session.setAttribute("user", employer);
				
		return "success";
	}
	
	/**
	 * 跳转到学生列表页面
	 * @return
	 */
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public String listStudent() {
		return "employer/students";
	}
	
	/**
	 * 在职学生列表-分页
	 * @param pager
	 * @param session
	 * @return
	 */
	@RequestMapping("/studentPage")
	@ResponseBody
	public Pager<EmployerStudentVO> getList(Pager<EmployerStudentVO> pager, HttpSession session){
		Employer employer = (Employer)session.getAttribute("user");
		employerService.getStudentPage(pager, employer.getId());
		return pager;
	}
	
	/**
	 * 解聘学生
	 * @return
	 */
	@RequestMapping("/layoff")
	@ResponseBody
	public String layoff(HttpSession session, Long stuId) {
		Employer employer = (Employer)session.getAttribute("user");
		if(employerService.layoff(stuId, employer.getId())) {
			return "success";
		}

		return "fail";
	}
	
	/**
	 * 跳转到待审核学生列表页面
	 * @return
	 */
	@RequestMapping(value="/approveStudents", method=RequestMethod.GET)
	public String waitStudents() {
		return "employer/approveStudents";
	}
	
	/**
	 * 获得待审核学生列表
	 * @param pager
	 * @param empId
	 */
	@RequestMapping(value="/approveStudents", method=RequestMethod.POST)
	@ResponseBody
	public Pager<RecruitStuVO> getWaitStudents(Pager<RecruitStuVO> pager, HttpSession session) {
		Employer employer = (Employer)session.getAttribute("user");
		employerService.getWaitStudents(pager, employer.getId());

		return pager;
	}
	
	/**
	 * 审核学生报名
	 * @param dto
	 * @param session
	 * @return
	 */
	@RequestMapping("/approve")
	@ResponseBody
	public String approve(ApproveDto dto, HttpSession session) {
		Employer employer = (Employer)session.getAttribute("user");
		dto.setEmpId(employer.getId());
	
		employerService.approve(dto);
		
		return "success";
	}

	/**
	 * 跳转到发布招聘信息页面
	 * @return
	 */
	@RequestMapping(value="/publish", method=RequestMethod.GET)
	public String publish() {
		return "employer/publish";
	}
	
	/**
	 * 用工单位发布招聘信息
	 * @param session
	 * @param recruit
	 * @return
	 */
	@RequestMapping(value="/publish", method=RequestMethod.POST)
	@ResponseBody
	public String publish(HttpSession session, Recruit recruit) {
		Employer employer = (Employer)session.getAttribute("user");
		recruitService.add(recruit, employer.getId());
		
		return "success";
	}
	
	/**
	 * 判断招聘信息是否被报名
	 * @param recId
	 * @return
	 */
	@RequestMapping("/isApply")
	@ResponseBody
	public String isApply(Long recId) {
		boolean res = recruitService.isApplyed(recId);
		if(res) {
			return "isApplyed";
		}
		
		return "notApplyed";
	}
	
	/**
	 * 编辑招聘信息
	 * @param session
	 * @return
	 */
	@RequestMapping("/editRecruit")
	@ResponseBody
	public String edit(HttpSession session, Recruit recruit) {
		int res = recruitService.edit(recruit);
		if(res == 2) {	// 被申请了
			return "applyed";
			
		}else if(res == 1) { // 更新成功
			return "success";
		}

		return "fail";
	}
	
	/**
	 * 删除招聘信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteRecruit")
	@ResponseBody
	public String delete(Long id) {
		if(recruitService.delete(id)) {
			return "success";
		}

		return "fail";
	}

	/**
	 * 跳转到提交工资列表页面
	 * @return
	 */
	@RequestMapping(value="/pubSalary", method=RequestMethod.GET)
	public String pubSalary() {	
		return "employer/pubSalary";
	}

	/**
	 * 判断当前时间是否是提交工资的时间
	 * @return
	 */
	@RequestMapping("/isPubSalaryDate")
	@ResponseBody
	public String isPubSalaryDate() {
		if (!DateUtils.isLast7Day()) {	// 不是提交工资的日期
			return "noTime";
		}
		return "ok";
	}
	
	/**
	 * 判断学生某月的工资是否已经提交
	 * @param sqd
	 * @return
	 */
	@RequestMapping("/isPubSalary")
	@ResponseBody
	public String isPubSalary(SalaryQueryDto sqd, HttpSession session) {
		Employer employer = (Employer)session.getAttribute("user");
		sqd.setEmpId(employer.getId());
		
		if(salaryService.isPubSalary(sqd)) {
			return "isPublished";	// 已经提交
		}

		return "noPublished";	// 未提交
	}
	
	/**
	 * 提交工资
	 * @param session
	 * @param salary
	 * @return
	 */
	@RequestMapping(value="/pubSalary", method=RequestMethod.POST)
	@ResponseBody
	public String pubSalary(HttpSession session, Salary salary) {
		Employer employer = (Employer)session.getAttribute("user");
		salary.setEmpId(employer.getId());
		if(salaryService.pubSalary(salary)) {
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
		return "employer/salaryList";
	}
	
	/**
	 * 查询工资列表
	 * @param month
	 */
	@RequestMapping(value="/salaryList", method=RequestMethod.POST)
	@ResponseBody
	public Pager<SalaryDto> salaryList(Pager<SalaryDto> pager, SalaryQueryDto sqd, HttpSession session) {
		Employer employer = (Employer)session.getAttribute("user");
		
		sqd.setEmpId(employer.getId());
		salaryService.getSalaryPage(pager, sqd);
		return pager;
	}
	
	
}














