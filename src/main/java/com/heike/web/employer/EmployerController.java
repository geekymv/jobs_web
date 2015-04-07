package com.heike.web.employer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heike.domain.dto.EmployerDto;
import com.heike.domain.dto.Pager;
import com.heike.domain.dto.RecruitQueryDto;
import com.heike.domain.pojo.Employer;
import com.heike.domain.service.EmployerService;
import com.heike.domain.service.RecruitService;
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
		
		return "success";
	}
}
