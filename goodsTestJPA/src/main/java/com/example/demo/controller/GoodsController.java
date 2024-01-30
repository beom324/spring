package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.GoodsVO;
import com.example.demo.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	private GoodsService gs;
	
	
	public GoodsController(GoodsService gs) {
		super();
		this.gs = gs;
	}

	@GetMapping("/listGoods")
	public String listGoods(Model model	) {
		model.addAttribute("list",gs.findAll());
		
		return "listGoods";
	}
	@PostMapping("/save")
	public String insertGoods(GoodsVO vo) {
		
		gs.insertGoods(vo);
		return "redirect:/listGoods";
	}
	
}
