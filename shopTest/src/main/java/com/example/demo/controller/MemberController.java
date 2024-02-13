package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	@GetMapping("/join")
	public void joinForm() {		
		
	}
	
	@PostMapping("/join")
	public String joinSubmit(Member m,Model model) {
		model.addAttribute("member",m);
		ms.insert(m);
		
		return "redirect:/member/login"; 
	} 
	
	
	
	@GetMapping("/login")
	public void loginForm() {	
		
	}
	@GetMapping("/logout")
	public void logout() {
		
	}



}






