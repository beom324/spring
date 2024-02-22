package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.entity.Goods;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GoodsService {
	
	private final GoodsDAO dao;
	
	public void save(Goods g) {
		dao.save(g);
		
	}
	public List<Goods> listGoods(){
		return dao.findAll();
	}
	public int getNextNo() {
		return dao.getNextNo();
	}

}
