package com.example.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cart;


@Repository
public interface CartDAO extends JpaRepository<Cart, Long> {
	
	public Cart findByIdAndGno(String id, Long gno);

	public List<Cart> findAllById(String id);
	
}
