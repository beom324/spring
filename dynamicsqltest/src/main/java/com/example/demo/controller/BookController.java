package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;

@Controller
@Setter
public class BookController {

	@Autowired
	private BookDAO dao;

	@GetMapping("/listBook")
	public void listBook(String sColumn,String search,Model model,String select){
		
		model.addAttribute("search",search);
		model.addAttribute("select",select);
		model.addAttribute("list",dao.findAll(sColumn,search,select));
	}
		
}
