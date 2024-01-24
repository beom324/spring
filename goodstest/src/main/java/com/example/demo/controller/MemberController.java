package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MailSender mailSender;
	@Autowired
	private MemberDAO dao;
		
	
	
	public MemberController(MemberDAO dao) {
		this.dao = dao;
		
	}
	
	@GetMapping("/sendCodeEmail")
	@ResponseBody
	public String sendCodeEmail(String email) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setFrom("tjfkqm1@gmail.com");//보내는사람
		mailMessage.setTo(email);//받는사람
		mailMessage.setSubject("인증번호");//제목
		//mailMessage.setText("얍얍얍!");//내용
		
		Random r = new Random();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		int c = r.nextInt(10);
		int d = r.nextInt(10);
		
		String text = "회원님의 인증번호는 ";
		String data = a+""+b+""+c+""+d;
		
		mailMessage.setText(text+data);
		try {
			mailSender.send(mailMessage);
		}catch(Exception e) {
			System.out.println("메일전송 오류 발생 : " + e.getMessage());
		}
		
		return data;
	}

	@GetMapping("/join")
	public String joinForm() {				
		return "join";
	}
	
	@PostMapping("/join")
	@ResponseBody
	public String joinSubmit(MemberVO vo) {
		int re =dao.join(vo);

		
		return "OK";
		
		
	}
}
