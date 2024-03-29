package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

@RestController
public class BookController {

	@Autowired
	private BookDAO dao;

	public BookController(BookDAO dao) {
		super();
		this.dao = dao;
	}	
	
	@GetMapping("/listBook")
	public List<BookVO> listBook(){
		return dao.findAll();
	}
		
}
