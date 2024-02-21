package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
@Table(name = "book100")
public class Book {
	
	@Id
	private int bookid;
	
	private String bookname;
	private int price;
	private String publisher;

}
