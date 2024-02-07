package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HanBController {

	@GetMapping("/newbook")
	public String newBook(Model model) {
		Map<String,String> map = new HashMap<>();

		String url = "https://www.hanbit.co.kr/store/books/bestseller_list.html";
		String base = "https://www.hanbit.co.kr";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements list = doc.select(".book_tit");
			for (Element e : list) {
				Element a = e.firstElementChild(); // a태그
				String link = base + a.attr("href"); //a태그의 속성(href)을 갖고옴
				String text = a.text();
				map.put(link,text);
			

			}
			model.addAttribute("map",map);

		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());

		}

		return "newBook";

	}

}
