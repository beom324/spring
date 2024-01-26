package com.example.demo.common;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.LogDAO;
import com.example.demo.vo.LogVO;

import jakarta.servlet.http.HttpServletRequest;

@Component
@Aspect
public class AopCommon {

	@Autowired
	private LogDAO dao;
	
	
	
	public AopCommon(LogDAO dao) {
		super();
		this.dao = dao;
	}


	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	public void pro() {}
	
	
	@Around("pro()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Date date = new Date(); 
		
		Object ob = null;
		Object args[]=joinPoint.getArgs();//타겟목록의 매개변수를 배열형태로 갖고옴
		HttpServletRequest req =(HttpServletRequest)args[0];
		String ip = req.getRemoteAddr();
		String uri = req.getRequestURI();
		long start =System.currentTimeMillis(); 
		
		int year= date.getYear()+1900;
		int month =date.getMonth()+1;
		int day = date.getDate();
		
		String reqtime = year+"";
		
		if(month<10) {
			reqtime+="0";
		}
		reqtime+=month;
		if(day<10) {
			reqtime+="0";
		}
		reqtime+=day;
		
		String methodName = req.getMethod();
		try {
			ob = joinPoint.proceed();
		} catch (Throwable e) {

		}
		long end = System.currentTimeMillis();
		long delay = end-start;
		
		dao.insertLog(new LogVO(ip, uri, methodName, reqtime, delay));
		
		
		return ob;
		
	}
	
	
}
