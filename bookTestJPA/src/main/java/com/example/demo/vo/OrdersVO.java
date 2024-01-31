package com.example.demo.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class OrdersVO {
	
	@Id
	private int orderid;
	
	@JoinColumn(name = "custid", insertable = true, updatable = true)
	@ManyToOne
	private CustomerVO customer;
	
	
	@JoinColumn(name = "bookid", insertable = true, updatable = true)
	@ManyToOne
	private BookVO book;
	
	private int saleprice;
	private String orderdate;		
}
