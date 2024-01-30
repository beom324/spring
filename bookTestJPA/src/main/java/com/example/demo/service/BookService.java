package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

@Service
public class BookService {

	@Autowired
	private BookDAO dao;
	
	
	public BookService(BookDAO dao) {
		super();
		this.dao = dao;
	}


	public List<BookVO> listBook(){

		return dao.findAll();
	}
}
