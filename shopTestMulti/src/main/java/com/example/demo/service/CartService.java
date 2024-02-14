package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CartDAO;
import com.example.demo.entity.Cart;

@Service
public class CartService {

	@Autowired
	private CartDAO dao;
	
	
	public CartService(CartDAO dao) {
		super();
		this.dao = dao;
	}
 

	public void insert(Cart cart) {
		
		cart.setQty(1);
		String id = cart.getId();
		Long gno = cart.getGno();
		
		
		Cart old = dao.findByIdAndGno(id, gno);
		if(old != null) {
			cart.setQty(old.getQty()+1);			
			cart.setNo(old.getNo());
		}
		dao.save(cart);
	}
}
