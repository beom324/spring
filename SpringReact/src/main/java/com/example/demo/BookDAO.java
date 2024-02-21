package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer>{
	
	@Query(value = "select nvl(max(bookid),0) + 1 bookid from book100",
			nativeQuery = true)
			public int getNextBookID();

}
