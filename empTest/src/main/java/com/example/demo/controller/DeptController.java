package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.DeptDAO;

@Controller
public class DeptController {
	
	
	@Autowired
	private DeptDAO dao ;
	
	
	
	public DeptController(DeptDAO dao) {
		super();
		this.dao = dao;
	}



	@GetMapping("/listDept")
	public String index(Model model) {				
		
		model.addAttribute("list",dao.findAll());
		
		return "listDept";
	}

}
