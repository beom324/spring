package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
  
	@Autowired 
	private CartService cs; 
	
	
	public CartController(CartService cs) {
		super();
		this.cs = cs;
	}
 
	@GetMapping("/insertCart")
	@ResponseBody
	public String insert(Cart cart) {
		cs.insert(cart);
		
		return "ok";
	}   
	   
	@GetMapping("/{id}")
	public String list(@PathVariable String id,Model model) {
		
		model.addAttribute("list",cs.findAllById(id));
	 
		return "/cart/listCart";
	}
}
