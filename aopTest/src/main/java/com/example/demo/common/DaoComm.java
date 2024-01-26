package com.example.demo.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //AOP설정하는 클래스입니다.
@Component // 자동으로 객체를 생성
public class DaoComm {		
	
	
	@Pointcut("execution(public * com.example.demo.dao..*(..))") //접근명시자가 public이고 반환하는값이 어떤것이라도 * 
														//com.example.demo.dao패키지안에있는 
														//그안에있는 어떤 하위패키지라도..*
														//매개변수가 어떤것이라도(..)
	public void pro() {}
	
//	@Before("pro()")//pointcut의 메소드 이름을 괄호까지 ""안에 적어준다
//	public void before() {
//		System.out.println("pro 동작함");
//	}
	@AfterReturning("pro()")
	public void afterReturning() {
		System.out.println("AfterReturning pro동작함");
	}
	
}
