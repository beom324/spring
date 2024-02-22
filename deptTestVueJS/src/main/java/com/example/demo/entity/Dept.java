package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dept")
@Getter@Setter
public class Dept {
	
	@Id
	@Column(name = "dno")
	private int id;
	private String dname;
	private String dloc;
	


}
