package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.vo.CustomerVO;

@Service
public class CustomerService {

	
	@Autowired
	private CustomerDAO dao;
	
	
	public CustomerService(CustomerDAO dao) {
		super();
		this.dao = dao;
	}


	public List<CustomerVO> findAll(){
		return dao.findAll(); 
	}
	public CustomerVO findById(int custid) {
		CustomerVO vo = null;
		Optional<CustomerVO> o = dao.findById(custid);
		if(o.isPresent()) {
			vo=o.get();
		}
		return vo;
		
	}
	public void save(CustomerVO vo) {
		dao.save(vo);
	}
	
	public void update(CustomerVO vo) {
		dao.save(vo);
	}
	public void delete(int custid) {
		dao.deleteById(custid);
	}
	public int getNextNo() {
		return dao.getNextNo();
	}
	
}
