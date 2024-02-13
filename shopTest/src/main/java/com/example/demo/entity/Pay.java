package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/*
 * 
 $("#imp_uid").val(res.imp_uid)
$("#card_number").val(res.card_number)
$("#merchant_uid").val(res.merchant_uid)
$("#paid_amount").val(res.paid_amount)
 */
@Entity
@Data
public class Pay {

	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pay_id")
	private Long id;
	private String imp_uid;
	private String merchant_uid;
	private String paid_amount;
	private String goodsName;
	private String name;
	private String tel;
	private String email;
	private String addr;
}
