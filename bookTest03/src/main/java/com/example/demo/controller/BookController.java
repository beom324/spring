package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

	@GetMapping("/listBook")
	public void listBook(HttpSession session) { //매개변수로 session받기
		//인증된(로그인에 성공한) 회원의 정보를 갖고 오기 위하여 먼저 시큐리티의 인증객체가 필요합니다
		
		
		
		//SecurityContextHolder.getContext().getAuthentication() = security의 authentication을 반환해줌
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		//이 인증객체를 통해서 인증된(로그인에 성공한) User객체를 받아 옵니다.
		
		User user = (User)authentication.getPrincipal();
		
		//이, 인증된 User를 통해서 로그인한 회원의 아이디를 갖고 옵니다.
		
		String id = user.getUsername();
		
		//이 정보를 세션에 상태유지 합니다.
		//만약 id뿐 아니라 로그인 한 회원의 다른 정보도 필요하다면 dao를 통해 회원의ㅣ 정보를 갖고 와서 상태유지합니다
		
		session.setAttribute("id", id);
				
		
	}
}
