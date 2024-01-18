package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("/hello")//사용자가 hello라고 요청하면 아래 메소드가 동작함, get,post방식 정할수있다
	@ResponseBody//이 annotation이 없으면 viwe로 이동하고 있으면 브라우저에 리턴값을 출력해줌
	public String hello() {
		return "hello spring!!";
	}
	
	
	
}
