package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.BookService;
import com.example.demo.vo.BookVO;

@Controller
@RequestMapping("/book")
public class BookController {

	
	@Autowired
	private BookService bs;
	
	
	public BookController(BookService bs) {
		super();
		this.bs = bs;
	}


	@GetMapping("/listBook")
	public String listBook(Model model) {
		model.addAttribute("list",bs.listBook());
		
		return "book/listBook";
	}
	@PostMapping("/save")
	public String save(BookVO vo) {
		
		bs.save(vo);
		return "redirect:/book/listBook";
	}
	@GetMapping("/detailBook")
	public String detailBook(int bookid,Model model) {
		
		model.addAttribute("list",bs.findById(bookid));
		
		return "book/detailBook";
		
	}
	@GetMapping("updateBook")
	public String updateBook(Model model,int bookid) {
		model.addAttribute("list",bs.findById(bookid));
		return "book/updateBook";
	}
	
	@PostMapping("updateBook")
	public String updateBook(BookVO vo) {
		bs.save(vo);
		
		return "redirect:/book/listBook";
	}
	@GetMapping("deleteBook")
	public String deleteBook(int bookid) {
		
		bs.delete(bookid);
		return "redirect:/book/listBook";
	}
}
