package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="goods")
public class GoodsVO {

	@Id
	private int no;
	private String name;
	private int price;
	private int qty;
	private String fname;
	public GoodsVO(int no, String name, int price, int qty, String fname) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.fname = fname;
	}
	
	

	
}
