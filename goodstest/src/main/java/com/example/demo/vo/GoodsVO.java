package com.example.demo.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class GoodsVO {
	

	private int no;
	private String name;
	private int price;
	private int qty;
	private String fname; //파일의 이름
	private MultipartFile uploadFile; //파일의 내용
	
	
}
