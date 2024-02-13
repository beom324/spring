package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PayVO {
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String imp_uid;
	private Long card_number;
	private int paid_amount;
	

}
