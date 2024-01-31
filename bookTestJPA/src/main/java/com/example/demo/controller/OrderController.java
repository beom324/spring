package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.BookService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrdersService;
import com.example.demo.vo.OrdersVO;

import lombok.Setter;

@Controller
@Setter
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private BookService bs;
	
	@Autowired
	private CustomerService cs;
	
	@Autowired
	private OrdersService os;
	
	@GetMapping("/insertOrders")
	public String insert(Model model) {
		
		model.addAttribute("bList",bs.listBook());
		model.addAttribute("cList",cs.findAll());
		model.addAttribute("no",os.getNextNo());
		
		return "/orders/insertOrders";
	}
	@PostMapping("/insertOrders")
	public String insert(OrdersVO vo) {
		os.insertOrders(vo);
		return "/orders/listOrders";
	}
	@GetMapping("/listOrders")
	public String list(Model model) {
		model.addAttribute("list",os.findAll());
		return "/orders/listOrders";
				
	}
	
}
