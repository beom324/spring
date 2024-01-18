package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.DeptDAO;

@Controller
public class DeptController {

	
	
	@Autowired
	private DeptDAO dao; //spring환경에서는 알아서 객체를 생성해줌. 
	
	@GetMapping("listDept")
	public void listDept(Model model) {											
		model.addAttribute("list",dao.findAll());	
		
	}
}
