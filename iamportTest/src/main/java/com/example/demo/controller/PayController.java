package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PayDAO;
import com.example.demo.vo.PayVO;

@Controller
@RequestMapping("/pay")
public class PayController {		
	
	@Autowired
	private PayDAO dao;
	
	@PostMapping("/payok")
	public String payOK(PayVO vo) {
		
		dao.save(vo);				
		return "ok";
	}	
	@GetMapping("/payok")
	public String pay(PayVO vo) {
		
		return "/payok";
	}	
}
