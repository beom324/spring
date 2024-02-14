package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "pay")
@SequenceGenerator(name = "pay_seq_generator",allocationSize = 1,initialValue = 1,sequenceName = "pay_seq")
public class Pay {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "pay_id")
	private Long id; 
	private String pay_method;
	private String merchant_uid;
	private String name;
	private int amount;
	private String buyer_id;
	private String buyer_email;
	private String buyer_name;
	private String buyer_tel;
	private String buyer_addr;
	private String buyer_postcode;
	private String imp_uid;
	private String apply_num;
}
