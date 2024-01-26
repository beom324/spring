package com.example.demo.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public HelloController(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}


	@GetMapping("/send")
	@ResponseBody
	public String send() {
		javaMailSender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// TODO Auto-generated method stub
				MimeMessageHelper message
				= new MimeMessageHelper(mimeMessage, true, "utf-8");//multipart 모드 하려면 true해야함
				message.setFrom("tjfkqm1@gmail.com");
				message.setTo("tjfkqm1@gmail.com");
				String text = "<h2>회원가입성공</h2>";
	            text += "<table border='1'>";
	            text += "<tr>";
	            text += "<td>아이디</td>";
	            text += "<td>tiger</td>";
	            text += "<td>이름</td>";
	            text += "<td>홍길동</td>";
	            text += "</tr>";
	            text += "</table>";
	            text += "<br><br>";
	            text += "<img src='cid:ball'>";

	            message.addInline("ball", new ClassPathResource("com/example/demo/img/ball2.jpg"));

				message.setSubject("html메일발송");
				message.setText(text,true);
								
			}
		});
	
		return "OK";
	}
	
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
}
