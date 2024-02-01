package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.BookService;
import com.example.demo.vo.BookVO;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class BookController2 {
	@Autowired
	private BookService bs;
	
	@GetMapping("/book/delete")
	public String delete(int bookid) {
		String view = "redirect:/book/list";
		bs.delete(bookid);
		return view;
	}
	
	
	@GetMapping("/book/update")
	public void update(int bookid, Model model) {
		model.addAttribute("list", bs.findById(bookid));
	}
	
	@GetMapping("/book/detail")
	public void detail(int bookid, Model model) {
		model.addAttribute("list", bs.findById(bookid));
	}
	
	
	@GetMapping("/book/list")
	public void list(Model model,String cname, String keyword,String sname,HttpSession session) {
		HashMap<String, String> map = new HashMap<String,String>();	
		String cname2=null; //2번째 옵션
		String keyword2 = null; // 2번째검색어
		
		if(session.getAttribute("keyword") !=null) {//검색을 했을 때 세션에 검색된 정보가 있다면
			cname2 = (String)session.getAttribute("cname"); //전에 검색된정보를 변수에담는다
			keyword2 = (String)session.getAttribute("keyword");
		}
		
		if(keyword != null) { //새로운 검색어가 온다면 우선순위가 더 높아야 하기 때문에
			cname2= cname;
			keyword2 = keyword;
			session.setAttribute("cname", cname);
			session.setAttribute("keyword", keyword);
		}
		
		
		map.put("cname", cname2);
		map.put("keyword", keyword2);
		map.put("sname", sname);
		model.addAttribute("list", bs.findAll(map));
	}
	
	@PostMapping("/book/save")
	public String save(BookVO b) {
		String view = "redirect:/book/list";
		bs.save(b);
		return view;
	}
}
