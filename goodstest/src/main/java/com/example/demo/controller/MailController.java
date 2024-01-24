package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

@Controller
@Setter
public class MailController {

	@Autowired
	private MailSender mailSender;
	
	@GetMapping("/sendMail")
	@ResponseBody
	public String send() {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setFrom("tjfkqm1@gmail.com");//보내는사람
		mailMessage.setTo("scarlet2010@nate.com");//받는사람
		mailMessage.setSubject("메일전송실험");//제목
		mailMessage.setText("얍얍얍!");//내용
		
		try {
			mailSender.send(mailMessage);
		}catch(Exception e) {
			System.out.println("메일전송 오류 발생 : " + e.getMessage());
		}
		
		return "ok";
	}
}
