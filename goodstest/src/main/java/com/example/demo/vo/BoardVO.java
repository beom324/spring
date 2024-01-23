package com.example.demo.vo;

import java.util.Date;

import lombok.Data;


@Data
public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private String pwd;
	private String content;
	private Date regdate;
	private int hit;
	private String fname;
	private String ip;
	private int b_ref;
	private int b_level;
	private int b_step;
	
	
	public BoardVO(int no, String title, String writer, String pwd, String content, Date regdate, int hit, String fname,
			String ip, int b_ref, int b_level, int b_step) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.pwd = pwd;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.fname = fname;
		this.ip = ip;
		this.b_ref = b_ref;
		this.b_level = b_level;
		this.b_step = b_step;
	}
	
	
}
