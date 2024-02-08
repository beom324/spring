package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class BookVO {

	@Id
	private String bookname;
	
	private String publicationdate;
	private String writer;
	private int price;
	
}
