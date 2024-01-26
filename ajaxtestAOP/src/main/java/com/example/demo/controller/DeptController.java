package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.DeptDAO;
import com.example.demo.vo.DeptVO;

@Controller
public class DeptController {
	@Autowired
	private DeptDAO dao;
	
	@GetMapping("/listDept")
	@ResponseBody
	public List<DeptVO> listDept(){
		return dao.findAll();
	}
	
	@GetMapping("/insertDept")
	@ResponseBody
	public String insertDept(DeptVO vo) {
		
		int re = dao.insertDept(vo);
		
		return re+"";
	}
	
	
	@GetMapping("/updateDept")
	@ResponseBody
	public String updateDept(DeptVO vo) {
		int re = dao.updateDept(vo);
		return re+"";
	}
	@GetMapping("/deleteDept")
	@ResponseBody
	public String deleteDept(int dno) {
		int re = dao.deleteDept(dno);
		return re+"";
	}
	
}
