package com.example.demo.service;


import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.entity.Goods;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class GoodsService {

	@Autowired
	private GoodsDAO dao;
	
	public List<Goods> findAll() {
		return dao.findAll();
	} 
	
	public void insert(Goods goods) {
		
		dao.save(goods);
		
	}
	public Goods findById(Long id) {
		Goods goods = null;
		Optional<Goods> o = dao.findById(id);
		if(o.isPresent()) {
			goods=o.get();
		}
		return goods;
	}
	
	
}
