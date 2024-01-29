package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/menu1")
	public void menu1() {
		
	}
	@GetMapping("/menu2")
	public void menu2() {
		
	}
}
