package com.heike.web.student;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heike.domain.pojo.Student;
import com.heike.domain.service.RecruitService;
import com.heike.domain.service.StudentService;
import com.heike.domain.vo.ApplyRecordVO;
import com.heike.domain.vo.ApplyRecruitVO;
import com.heike.domain.vo.RecruitVO;
import com.heike.domain.vo.StudentVO;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private RecruitService recruitService;
	/**
	 * 进入学生首页
	 * @return
	 */
	@RequestMapping("/student/home")
	public String home(){
		return "student/home";
	}

	/**
	 * 查看个人信息
	 */
	@RequestMapping("/student/myinfo")
	public String myInfo(HttpSession session, Model model) {
		Student student = (Student) session.getAttribute("user");
		StudentVO studentVO = studentService.getById(student.getId());
		model.addAttribute("student", studentVO);

		return "student/myinfo";
	}
	
	/**
	 * 学生查看自己的工作列表
	 * @param id 学生id
	 * @param model
	 * @return
	 */
	@RequestMapping("/student/jobs")
	public String jobList(HttpSession session, Model model) {
		Student student = (Student) session.getAttribute("user");
		List<ApplyRecruitVO> jobs = studentService.getOnJobList(student.getId());

		model.addAttribute("jobs", jobs);
		return "student/myjob";
	}
	
	/**
	 * 跳转到学生注册页面
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String resgister() {
		return "register";
	}
	
	/**
	 * 学生注册
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public String register(Student student) {
		student = studentService.register(student);
		return student != null ? "success" : "fail";
	}
	
	/**
	 * 判断学号是否已经被注册
	 * @param num
	 * @return yes已经被注册， no没有被注册
	 */
	@RequestMapping("/isRegistered")
	@ResponseBody
	public String isRegistered (String num){
		Student student = studentService.getByNum(num);
		return student == null ? "no" : "yes"; // 被注册
	}
	
	/**
	 * 学生查看招聘详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/student/detail/{id}")
	public String detail(@PathVariable("id")Long id, Model model, HttpSession session) {
		RecruitVO recruit = recruitService.getById(id);
		model.addAttribute("recruit", recruit);
		
		// 判断学生是否已经报名了
		Student student = (Student) session.getAttribute("user");
		String isApply = recruitService.isApply(student.getId(), id);
		model.addAttribute("isApply", isApply);
		
		return "student/detail";
	}
	
	
	/**
	 * 学生报名
	 * @param recId 招聘信息id
	 * @return
	 */
	@RequestMapping("/student/apply")
	@ResponseBody
	public String apply(Long recId, HttpSession session) {
		Student student = (Student) session.getAttribute("user");
		studentService.apply(student.getId(), recId);
		return "success";
	}
	
	/**
	 * 学生查看报名记录
	 */
	@RequestMapping("/student/records")
	public String record(HttpSession session, Model model){
		Student student = (Student) session.getAttribute("user");
		List<ApplyRecordVO> records = recruitService.getApplyRecords(student.getId());
		
		model.addAttribute("records", records);
		return "student/records";
	}
	
}
