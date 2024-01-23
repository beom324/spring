package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.BoardVO;

@Repository
public class BoardDAO {
	
	public List<BoardVO> findAll(){
		return DBManager.listBoard();
	}
	public BoardVO findById(int no) {
		return DBManager.findByIdBoard(no);
	}
}
