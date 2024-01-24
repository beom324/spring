package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.youiwe.webservice.BitSms;

@Controller
public class SmsController {

	@Autowired
	private BitSms sms;

	public SmsController(BitSms sms) {
		this.sms = sms;
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("/sendSms")
	@ResponseBody
	public String sendSms() {
		String from = "01025598279";
		String to = "01064345192";
		String msg = "악";
		sms.sendMsg(from, to, msg);
		
		return "ok";
	}
}
