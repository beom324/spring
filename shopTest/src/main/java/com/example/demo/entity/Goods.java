package com.example.demo.entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Goods {
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="no")
	private Long id;
	private String name;
	private int qty;
	private int price;
	private String fname;
	@Transient//파일업로드를 위한 속성이므로 테이블에서 제외
	private MultipartFile uploadFile;
	
}
