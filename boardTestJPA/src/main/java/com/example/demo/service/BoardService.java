package com.example.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDAO;
import com.example.demo.entity.Board;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;

	public Page<Board> getBoardList(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
        pageable = PageRequest.of(page, 10);

        return dao.findAll(pageable);
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
	public Board getOne(int no) {
		return dao.getOne(no);
	}

	public void updateStep(int b_ref, int b_step) {
		dao.updateStep(b_ref, b_step);
	};
	
}
