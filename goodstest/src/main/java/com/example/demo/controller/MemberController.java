package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

@Controller
public class MemberController {

	private MemberDAO dao;
		
	
	public MemberController(MemberDAO dao) {
		this.dao = dao;
		
	}

	@GetMapping("/join")
	public String joinForm() {				
		return "join";
	}
	
	@PostMapping("/join")
	@ResponseBody
	public String joinSubmit(MemberVO vo,Model model) {
		int re =dao.join(vo);

		
		return "OK";
		
		
	}
}
