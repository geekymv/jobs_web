package com.heike.web.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/register")
	public String resgister() {
		return "register";
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
