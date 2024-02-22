package com.example.demo.entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="goods") 
@Getter@Setter
public class Goods {
	
	@Id
	@Column(name = "no")
	private int id;
	
	private String name;
	private int price;
	private int qty;
	
	private String fname;
	
	@Transient
	private MultipartFile uploadFile;

}
