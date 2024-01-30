package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.entity.GoodsVO;

@Service
public class GoodsService {
	@Autowired
	private GoodsDAO dao;

	public GoodsService(GoodsDAO dao) {
		super();
		this.dao = dao;
	}
	
	public List<GoodsVO> findAll(){		
		return dao.findAll();
	}
			
}
