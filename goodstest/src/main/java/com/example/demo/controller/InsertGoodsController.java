package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/insertGoods")
public class InsertGoodsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit() {
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}

}
