package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDAO;
import com.example.demo.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
		private MemberService ms ;

		
		
		
		public AdminController(MemberService ms) {
			super();
			this.ms = ms;
		}




		@GetMapping("/index")
		public void index(Model model) {
			model.addAttribute("list", ms.findAll());
			
		}
		
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable String id) {
			ms.delete(id);
			return "redirect:/admin/index";
			
		}

}
