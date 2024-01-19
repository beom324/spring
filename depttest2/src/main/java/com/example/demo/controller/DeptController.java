package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.DeptDAO;
import com.example.demo.vo.DeptVO;
@Controller
public class DeptController {
	
	@Autowired
	private static DeptDAO dao;
	
	
		
	public DeptController(DeptDAO dao) {
		super();
		this.dao = dao;
	}



	@GetMapping("/listDept")
	public void deptList(Model model) {
		model.addAttribute("list",dao.findAll());
	}
	
	@GetMapping("/insertDept")
	public void insertDept() {
		
	}
	@PostMapping("/insertDept")
	public String insertDept(DeptVO vo,Model model) {
		int re = dao.insertDept(vo);
		if(re!=1) {
			model.addAttribute("msg","부서등록에 실패하였습니다");
			return "error.jsp";
		}
		return "redirect:/listDept";
	}
	
}
