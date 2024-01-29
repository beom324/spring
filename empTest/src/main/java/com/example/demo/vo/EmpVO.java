package com.example.demo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	private int eno;
	private String ename;
	private String job;
	private Date hiredate;
	private int salary;
	private int dno;
	private int mgr;
	private int comm;
	private String jumin;
	private String email;
	public EmpVO(int eno, String ename, String job, Date hiredate, int salary, int dno, int mgr, int comm, String jumin,
			String email) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
		this.salary = salary;
		this.dno = dno;
		this.mgr = mgr;
		this.comm = comm;
		this.jumin = jumin;
		this.email = email;
	}
	
	
	
	

}
