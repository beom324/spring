package com.example.demo.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	
	@Around("pro()")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) {//AroundAdvide는 반드시 ProcdeedingJoinPoint 필요
																//object를 반환해주어아햠
		String methodName = joinPoint.getSignature().toShortString();
		Object re = null;//object를 반환해주기 위한 변수 선언.
		long start = System.currentTimeMillis(); //현재시간을 ms으로 알려줌,타겟동작전에 시간을 알아옴
		System.out.println(methodName +"이 동작하기전");
		try {
			
			re =joinPoint.proceed();//타겟을 동작시킴 위로는 타겟이 동작전에할 일 , 위로는 동작한 후 할일 , Object를 반환함
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(methodName +"이 동작한 후");
		System.out.println("re : " + re);
		long end = System.currentTimeMillis();//타겟동작후에 시간을 알아롬
		long delay = end-start; //타겟이 동작하는데 걸린시간
		System.out.println("걸린시간 : " + delay +"ms");
		return re;
	}
	
	
//	@AfterThrowing("pro()")
//	public void afterThrowing(JoinPoint joinPoint) {
//		String methodName = joinPoint.getSignature().toLongString();
//		System.out.println(methodName +"동작중에 오류가 남");
//	}
	
//	@Before("pro()")//pointcut의 메소드 이름을 괄호까지 ""안에 적어준다
//	public void before() {
//		System.out.println("pro 동작함");
//	}
//	@AfterReturning("pro()")
//	public void afterReturning(JoinPoint joinPoint) {//타겟메소드의 정보가필요하거나 할때 JoinPoint를 매개변수로 줌
//		String methodName1 = joinPoint.getSignature().toShortString();//메소드의 헤드부분을 가져옴						
//		String methodName2 = joinPoint.getSignature().toLongString();//메소드의 헤드부분을 가져옴
//		System.out.println("methodName ShortString : " + methodName1);
//		System.out.println("methodName LongString : " + methodName2);
//		System.out.println("AfterThrowing pro동작함");
//	}
	
}
