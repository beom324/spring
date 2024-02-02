package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDAO;
import com.example.demo.entity.Board;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;

	public List<Board> listBoard(){
		return dao.findAll();
	}
	public BoardService(BoardDAO dao) {
		super();
		this.dao = dao;
	}
	
	public int getNextNo() {
		return dao.getNextNo();
	}
	
	public void insertBoard(Board board) {
		dao.insert(board);
	}
	public Board findById(int no) {
		Optional<Board> o = dao.findById(no);
		Board board = null;
		if(o.isPresent()) {
			board=o.get();
		}
		return board;
	}
	public void incHit(int no) {
		dao.incHit(no);
	}
	
}
