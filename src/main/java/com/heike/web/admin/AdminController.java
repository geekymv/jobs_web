package com.heike.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heike.domain.pojo.Dict;
import com.heike.domain.service.DictService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private DictService dictService;
	
	@RequestMapping("/home")
	public String home(){
		return "admin/home";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<Dict> list(){
		return dictService.list();
	}

}
