package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PayDAO;
import com.example.demo.entity.Pay;

@Service
public class PayService {
	
	@Autowired
	private PayDAO dao;
	
	public void insert(Pay pay) {
		dao.save(pay);
	}

}
