package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

@Service
public class BookService {

	@Autowired
	private BookDAO dao;
	
	
	public BookVO findById(int bookid) {
		//JPA의 findById는 VO를 바로 반환하지 않고 Optional로 포장해서 반환한다.
		BookVO vo = null;
		Optional<BookVO> o = dao.findById(bookid);
		if(o.isPresent()) {
			vo=o.get();
		}else {
			System.out.println("Optional이 존재하지 않습니다");
		}
		
		return vo;
	}
	
	public BookService(BookDAO dao) {
		super();
		this.dao = dao;
	}


	public List<BookVO> listBook(){

		return dao.findAllByOrderByBookname();
	}
	
	public void save(BookVO vo){
		dao.save(vo);
	}
	
	public BookVO update(int bookid) {
		BookVO vo = null;
		Optional<BookVO> o =dao.findById(bookid);
		
		if(o.isPresent()) {
			vo=o.get();
		}
		return dao.save(vo);
		
		
		
	}
	public void delete(int bookid) {
		
		dao.deleteById(bookid);
	}
	public List<BookVO> findByBookname(String bookname){
		return dao.findAllByBooknameLike(bookname);
	}
	public List<BookVO> findByBookid(int bookid){
		return dao.findAllByBookid(bookid);
	}
	public List<BookVO> findByPublisher(String publisher){
		return dao.findAllByPublisherContaining(publisher);
	}
	public List<BookVO> findByprice(int price){
		return dao.findAllByPrice(price);
	}
	
	
}
