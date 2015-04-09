package com.heike.web.employer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heike.domain.dto.EmployerDto;
import com.heike.domain.dto.Pager;
import com.heike.domain.dto.RecruitQueryDto;
import com.heike.domain.pojo.Employer;
import com.heike.domain.pojo.Recruit;
import com.heike.domain.service.EmployerService;
import com.heike.domain.service.RecruitService;
import com.heike.domain.vo.EmployerStudentVO;
import com.heike.domain.vo.RecruitVO;

@Controller
@RequestMapping("/employer")
public class EmployerController {
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private EmployerService employerService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/home")
	public String home(HttpServletRequest request, HttpSession session, Model model,
			RecruitQueryDto dto) {
		Employer employer = (Employer)session.getAttribute("user");
		dto.setEmpId(employer.getId());
		
		String offSet = request.getParameter("pager.offset");
		int pageOffSet = 0;
		if(StringUtils.isNotBlank(offSet)){
			pageOffSet = Integer.parseInt(offSet);
		}
		
		Pager<RecruitVO> pager = recruitService.findPage(pageOffSet, dto);
		model.addAttribute("pager", pager);
		
		return "employer/home";
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
	
	@RequestMapping("/edit")
	@ResponseBody
	public String edit(EmployerDto dto){
		
		employerService.edit(dto);
		
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
	 * 学生列表-分页
	 * @param pager
	 * @param session
	 * @return
	 */
	@RequestMapping("/studentPage")
	@ResponseBody
	public Pager<EmployerStudentVO> getList(Pager<EmployerStudentVO> pager, HttpSession session){
		Employer employer = (Employer)session.getAttribute("user");
		employerService.getStudentPage(pager, employer.getId());
	//	pager.setTotalPage(200);
		return pager;
	}
	
	@RequestMapping("/addRecruit")
	public void add(){
		for (int i = 4; i < 20; i++) {
			Recruit recruit = new Recruit();
			recruit.setTitle("标题" + i);
			recruit.setContext("内容" + i);
			recruit.setPostName("岗位名称" + i);
			recruit.setReleaseDate("20150409113730");
			recruit.setEndDate("20150412113730");
			recruit.setEmpId(2L);
			recruit.setSalary("100");
			
			recruitService.add(recruit );
		}
		
	}
}
