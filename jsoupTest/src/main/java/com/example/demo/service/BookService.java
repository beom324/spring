package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;

@Service
public class BookService {
	
	@Autowired
	private BookDAO dao;

	public BookService(BookDAO dao) {
		super();
		this.dao = dao;
	}

	
}

