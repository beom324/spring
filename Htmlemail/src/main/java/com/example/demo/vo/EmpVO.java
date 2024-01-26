package com.example.demo.vo;

import lombok.Data;

@Data
public class EmpVO {

	private int eno;
	private String ename;
	private int salary;
	private int comm;
	private String email;
	private int dno;
	public EmpVO(int eno, String ename, int salary, int comm, String email, int dno) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
		this.comm = comm;
		this.email = email;
		this.dno = dno;
	}
	public EmpVO() {
		// TODO Auto-generated constructor stub
	}
	
	
}
