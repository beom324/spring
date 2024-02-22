package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Dept;
import com.example.demo.service.DeptService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DeptController {
	
	private final DeptService ds;
	
	
	@GetMapping("/listDept")
	@ResponseBody
	public List<Dept> listDept() {
		
		return ds.listAll(); 
	}

}
