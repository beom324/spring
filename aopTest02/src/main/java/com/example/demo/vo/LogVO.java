package com.example.demo.vo;

import lombok.Data;

@Data
public class LogVO {

	private String ip;
	private String uri;
	private String methodname;
	private String reqtime;
	private long delaytime;
	public LogVO(String ip, String uri, String methodname, String reqtime, long delaytime) {
		super();
		this.ip = ip;
		this.uri = uri;
		this.methodname = methodname;
		this.reqtime = reqtime;
		this.delaytime = delaytime;
	}
	

	
}
