package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TestController {

	@GetMapping("/test1")
	public void test1(String name, int age) {
		System.out.println("이름 : " + name + "나이 : " + age);
	}
	
	@GetMapping("/test2/{name}/{age}")
	public String test2(@PathVariable String name, @PathVariable int age){
		System.out.println(name);
		System.out.println(age);
		
		return "test2";
		}
}
