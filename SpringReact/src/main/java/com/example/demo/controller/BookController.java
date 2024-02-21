package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bs;
	
	@GetMapping("/listBook")
	@ResponseBody
	public List<Book> listBook(){
		return bs.listBook();
	}
	
	//bookid가 설정되지 않는 상태로 오면 오류가 발생
	//html에서 bookid의 값을 임의의 값을 설정하여 오류를 해결
	@PostMapping("/insertBook")
	public String insertBook(Book b) {		
		System.out.println("insertBook 동작함.");
//		System.out.println(b);
		b.setBookid(bs.getNextNo());
		bs.insertBook(b);;
		return "OK";
	}

}
