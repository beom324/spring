package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data 
@Entity
@SequenceGenerator(name = "cart_seq_generator",sequenceName = "cart_seq",allocationSize = 1,initialValue = 1)
public class Cart {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long no;
	
	private String id; //회원의아이디
	private Long gno;
 
	@OneToOne
	@JoinColumn(name="goods_id")
	private Goods goods;
	 
	private int qty;

}
