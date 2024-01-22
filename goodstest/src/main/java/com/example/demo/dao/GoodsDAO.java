package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.GoodsVO;

@Repository
public class GoodsDAO {


	public List<GoodsVO> findAll(){
		return DBManager.findAll();
		
	}
	public int nextNo() {
		return DBManager.nextNo();
	}
	public int insertGoods(GoodsVO vo) {
		return DBManager.insertGoods(vo);
	}
	public GoodsVO findById(int dno) {
		return DBManager.findById(dno);
	}
	public int updateGoods(GoodsVO vo) {
		return DBManager.updateGoods(vo);
	}
	
}
