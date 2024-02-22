package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CartDAO;
import com.example.demo.dao.GoodsDAO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Goods;

import jakarta.persistence.EntityManager;

@Service
public class CartService {
	
	@Autowired
	private  EntityManager em;

	@Autowired
	private CartDAO dao;
	@Autowired
	private GoodsDAO goodsdao;
			

	public CartService(EntityManager em, CartDAO dao, GoodsDAO goodsdao) {
		super();
		this.em = em;
		this.dao = dao;
		this.goodsdao = goodsdao;
	}


	public void insert(Cart cart) {
		
		cart.setQty(1);
		String id = cart.getId();
		Long gno = cart.getGno();
		Optional<Goods>  o= goodsdao.findById(gno);
		Goods goods = null;
		
		if(o.isPresent()) {
			goods=o.get();
		}
		
		cart.setGoods(goods);		
		
		
		Cart old = dao.findByIdAndGno(id, gno);
		if(old != null) {
			cart.setQty(old.getQty()+1);			
			cart.setNo(old.getNo());
		}
		dao.save(cart);
	}
	
	
	
	public List<Cart> findAllById(String id){
			return dao.findAllById(id);
	}			
	
}