package com.example.demo.common;

import java.io.FileWriter;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ControllerCommon {

	
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	public void pro() {}
	
	
	@Around("pro()")
	public Object fileLog(ProceedingJoinPoint joinPoint) {
		Object ob = null;
		Object args[]=joinPoint.getArgs();//타겟목록의 매개변수를 배열형태로 갖고옴
		HttpServletRequest request =(HttpServletRequest)args[0];//0번째(실습을 위해 모든 메소드에 request로 만들어둠)
		
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		
		long start = System.currentTimeMillis();
		Date date = new Date(start);
		String time = date.toLocaleString();//날짜를 문자열로 만들어줌
		
		try {
			ob = joinPoint.proceed();
		} catch (Throwable e) {
				
		}
		long end = System.currentTimeMillis();		
		long delay = end-start;
		
		String row = "uri : "+uri+"/"+"ip : "+ip+"/ time : "+time+"/ delay : "+delay+"\n";
		 
		System.out.println(row);
		
		try {
			int year= date.getYear()+1900;
			int month =date.getMonth();
			int day = date.getDate();
			
			String fname ="c:/sist_log/";
			fname+=year;
			if(month<10) {
				fname+="0";
			}
			fname+=month;
			if(day<10) {
				fname+="0";
			}
			fname+=day;
			fname+=".txt";
			
			FileWriter fw = new FileWriter(fname,true);//true 값을 주면 이미있는 파일에 추가가 됨.
			fw.write(row);
			fw.close();
			
			
			
		}catch(Exception e) {
			System.out.println("파일처리 오류"+e.getMessage());
		}
		
		
		
		return ob;
	}
}
