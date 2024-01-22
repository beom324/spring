package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.GoodsDAO;

@Controller
public class GoodsController {

	private static GoodsDAO dao;

	
	public GoodsController(GoodsDAO dao) {
		this.dao = dao;
		// TODO Auto-generated constructor stub
	}


	@GetMapping("/listGoods")
	public String listGoods(Model model) {
		model.addAttribute("list",dao.findAll());
		return "listGoods";
	}
	@GetMapping("/detailGoods")
	public String detailGoods(Model model,int no) {
		model.addAttribute("list",dao.findById(no));
		return "detailGoods";
	}
}
