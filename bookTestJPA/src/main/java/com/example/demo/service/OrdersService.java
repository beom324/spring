package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrdersDAO;
import com.example.demo.vo.OrdersVO;

@Service
public class OrdersService {

	@Autowired
	private OrdersDAO dao;

	public OrdersService(OrdersDAO dao) {
		super();
		this.dao = dao;
	}
	
	public int getNextNo() {
		return dao.getNextNo();
	}
	public void insertOrders(OrdersVO vo) {
		dao.insert(vo);
	}
	
	public List<OrdersVO> findAll(){
		return dao.findAll();
	}
}
