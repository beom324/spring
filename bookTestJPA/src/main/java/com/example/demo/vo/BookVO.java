package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="book")
@Entity
public class BookVO {

	@Id
	private int bookid;
	private String bookname;
	private int price;
	private String publisher;
	
}