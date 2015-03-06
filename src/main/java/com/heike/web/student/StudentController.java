package com.heike.web.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heike.domain.pojo.Student;
import com.heike.domain.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
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
	
	
}
