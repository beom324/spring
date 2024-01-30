package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@Setter
@Slf4j
public class MemberController {
	@Autowired
	private MemberDAO dao;	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/login")
	public void login() {
		log.info("로그인 컨트롤러 동작");
	}
	
	
	@GetMapping("/join")
	public void joinForm() {
		
	}
	
	@PostMapping("/join")
	public String joinForm(MemberVO vo) {
		
		vo.setPwd(passwordEncoder.encode(vo.getPwd()));//암호를 암호화 해서 설정
		vo.setRole("user");
		dao.insertMember(vo);
		return "redirect:/";
	}

	
	
}
