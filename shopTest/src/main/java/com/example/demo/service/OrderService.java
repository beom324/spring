package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDAO;
import com.example.demo.entity.Order;

@Service
public class OrderService {

	
	@Autowired
	private OrderDAO dao;
	
	public Order insert(Order order) {
		return dao.save(order);
	}
}
