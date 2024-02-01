package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.BookVO;

@Repository
public interface BookDAO extends JpaRepository<BookVO, Integer> {

	//도서명순으로 도서목록을 출력하는 메소드
	public List<BookVO> findAllByOrderByBookname();
	
	public List<BookVO> findAllByBooknameLike(String bookname);
	public List<BookVO> findAllByBookid(int bookid);
	public List<BookVO> findAllByPublisherContaining(String publisher);
	public List<BookVO> findAllByPrice(int price);
}
