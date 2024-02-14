package com.example.demo.entity;

 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="orders")
@Data
public class Order {

	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orders_id")
	private Long id;
	
	private String name;
	private String tel;
	private String email;
	private String addr;
	private String goodsName;
	private String price;
}
