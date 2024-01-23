package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.BoardDAO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {	
	private final BoardDAO dao;

	
	
	@GetMapping("/listBoard")
	public String listBoard(Model model) {
		model.addAttribute("list",dao.findAll());
		return "listBoard";
	}
	@GetMapping("/detailBoard")
	public String detailBoard(Model model,int no) {
		model.addAttribute("list", dao.findById(no));
		return "detailBoard";
		
	}
	
	
}
