package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
	
	public Goods findById(int no) {
		Goods goods = new Goods();
		Optional<Goods> o = dao.findById(no);
		if(o.isPresent()) {
			goods = o.get();
		}
		return goods;
		
		
	}
	public void updateGoods(Goods g) {
		dao.save(g);
	}
	
	public void deleteGoods(int no) {
		dao.deleteById(no);
	}
		

}
