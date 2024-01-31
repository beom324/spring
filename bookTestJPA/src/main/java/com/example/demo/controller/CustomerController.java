package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.CustomerService;
import com.example.demo.vo.CustomerVO;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cs ;
	
	
	public CustomerController(CustomerService cs) {
		super();
		this.cs = cs;
	}


	@GetMapping("/listCustomer")
	public String listCustomer(Model model) {
		model.addAttribute("list",cs.findAll());
		return "customer/listCustomer";
	}
	@GetMapping("/insertCustomer")
	public String insertCustomer(Model model) {
		model.addAttribute("no",cs.getNextNo());
		return "customer/insertCustomer";
	}
	
	@PostMapping("/insertCustomer")
	public String insertCustomer(CustomerVO vo) {
		cs.save(vo);
		return "redirect:/customer/listCustomer";
	}
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(int custid) {
		cs.delete(custid);
		return "redirect:/customer/listCustomer";
	}
	@GetMapping("/updateCustomer")
	public String updateCustomer(int custid,Model model) {
		model.addAttribute("list",cs.findById(custid));
		return "customer/updateCustomer";
	}
	@PostMapping("/updateCustomer")
	public String updateCustomer(CustomerVO vo) {
		cs.update(vo);
		return "redirect:/customer/listCustomer";
	}
	@GetMapping("/detailCustomer")
	public String detailCustomer(Model model,int custid) {
		model.addAttribute("list",cs.findById(custid));
		return "customer/detailCustomer";
	}
}
