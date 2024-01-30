package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.BookService;

@Controller
public class BookController {

	
	@Autowired
	private BookService bs;
	
	
	public BookController(BookService bs) {
		super();
		this.bs = bs;
	}


	@GetMapping("listBook")
	public String listBook(Model model) {
		model.addAttribute("list",bs.listBook());
		
		return "listBook";
	}
}
