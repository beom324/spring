package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Order;
import com.example.demo.service.GoodsService;
import com.example.demo.service.MemberService;
import com.example.demo.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private GoodsService gs;
	@Autowired
	private MemberService ms;
	@Autowired
	private OrderService os;
	
	@GetMapping("/orderCheck/{id}/{qty}")
	public String orderCheck(@PathVariable Long id,@PathVariable(required = false) Integer qty, Model model,HttpSession session) {
		if(qty==null	) {
			qty=1;
		}
		String username = (String)session.getAttribute("id");
		model.addAttribute("list",ms.findById(username));
		model.addAttribute("goods",gs.findById(id));
		model.addAttribute("qty",qty);
		return "order/orderCheck"; 
		
	}
	
	@PostMapping("/payok")
	public void orderSubmit() {
				
	}
}
