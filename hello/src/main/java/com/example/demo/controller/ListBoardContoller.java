package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListBoardContoller {
	
	@GetMapping("/listBoard")//요청한 이름의 뷰를 자동으로 찾는다.
	public void list(Model model) {
		model.addAttribute("name","kim");//model을 매개변수로 받아 model객체로 상태유지를 한다.
		model.addAttribute("age",20);				
	}
	
	/*
	@GetMapping("/listBoard")
	public String list(Model model) {
		model.addAttribute("name","kim");//model을 매개변수로 받아 model객체로 상태유지를 한다.
		model.addAttribute("age","20");
		
		return "listBoard";
	}
	*/
	/*
	@GetMapping("/listBoard")
	public ModelAndView list() { //모델과 뷰를 하나의 세트로 만들어둠
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","홍길동"); //mav로 상태유지할 수 있다
		mav.addObject("age","20");
		mav.setViewName("listBoard"); //application.properties에 prifix,suffix를 설정해 두었기 때문에 앞 뒤에 자동으로 붙음
		
		return mav;
		
	}
	*/
}
