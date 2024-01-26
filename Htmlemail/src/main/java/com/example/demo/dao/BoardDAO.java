package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.BoardVO;

@Repository
public class BoardDAO {

	public static int pageSize=5;
	public static int totalRecord=0;
	public static int totalPage=0;
	
	
	
	public List<BoardVO> findAll(HashMap<String, Object> map){

		return DBManager.listBoard(map);
	}
	
	public BoardVO findById(int no) {
		return DBManager.findByIdBoard(no);
	}
	public int insertBoard(BoardVO vo) {
		return DBManager.insertBoard(vo);
	}
	public int nextNo() {
		return DBManager.nextBoardNo();
	}
	public void updateStep(int b_ref, int b_step) {
		DBManager.updateStep(b_ref,b_step);
	}
	public int getTotalRecord() {
		return DBManager.getTotalRecord();
	}
	
}
