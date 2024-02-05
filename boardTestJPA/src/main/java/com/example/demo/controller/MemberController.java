package com.example.demo.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	
	private MemberService ms ;
	
	private PasswordEncoder passwordEncoder;
	
	
	public MemberController(MemberService ms, PasswordEncoder passwordEncoder) {
		super();
		this.ms = ms;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping("/login")
	public void login() {
		
	}



}
