package com.example.demo.vo;

import lombok.Data;

@Data
public class DeptVO {
	private int dno;
	private String dname;
	private String dloc;

	public DeptVO(int dno, String dname, String dloc) {
		super();
		this.dno = dno;
		this.dname = dname;
		this.dloc = dloc;
	}
	
	
}
