package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="pay")
public class PayVO {
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String imp_uid;
	private Long card_number;
	private int paid_amount;
	private String merchant_uid;
	

}
