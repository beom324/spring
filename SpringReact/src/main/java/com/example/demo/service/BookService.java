package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.BookDAO;
import com.example.demo.entity.Book;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
	
	private final BookDAO dao;
	
	
	
	public int getNextNo() {
		return dao.getNextBookID();
		
	}
	public List<Book> listBook(){
		return dao.findAll();
	}
	@Transactional
	public void insertBook(Book book) {
		dao.save(book);
	}

}
