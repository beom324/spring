package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.BookService;
import com.example.demo.vo.BookVO;

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
	@PostMapping("/save")
	public String save(BookVO vo) {
		
		bs.save(vo);
		return "redirect:/listBook";
	}
}
