package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PayDAO;
import com.example.demo.vo.PayVO;

@RestController
public class PayController {		
	
	@Autowired
	private PayDAO dao;
	
	@PostMapping("/payok")
	public String payOK(PayVO vo) {
		System.out.println("결제번호 : "+vo.getImp_uid());
		System.out.println("카드번호 : "+vo.getCard_number());
		System.out.println("주문가격 : "+vo.getPaid_amount());
		
		dao.save(vo);
		
		
		return "ok";
	}
	

}
