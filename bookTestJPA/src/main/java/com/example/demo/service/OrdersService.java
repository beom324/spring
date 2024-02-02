package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<OrdersVO> findAllByOrderid(String search){
		if (search == null) {
			return dao.findAllByOrderByOrderidAsc();
		}else {
			return dao.findByCustomer_Name(search);
		}
	}
	public OrdersVO findById(int orderid) {
		OrdersVO vo = null;
		Optional<OrdersVO> o = dao.findById(orderid);
		if(o.isPresent()) {
			vo=o.get();
		}
		return vo;
	}
	public void delete(int orderid) {
		dao.deleteById(orderid);
	}
	
}
