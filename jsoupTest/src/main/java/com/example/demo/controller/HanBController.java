package com.example.demo.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator.IsRoot;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.NewBook;

@RestController
public class HanBController {

	@GetMapping("/downImg")
	public String downImg() {
		List<String> addrList = new ArrayList<>();
		List<String> titleList = new ArrayList<>();
		int b = 1;
		try {
			while (true) {
				String url = "https://www.hanbit.co.kr/store/books/new_book_list.html?page=" + b;
				Document doc = Jsoup.connect(url).get();
				Elements elements = doc.select(".view_box");
				Elements elements2 = doc.select(".book_tit");
				if (elements.size() == 0) {
					break;
				}
				for (Element e : elements) {
					Elements img = e.getElementsByTag("img");
					String src = img.get(img.size() - 1).attr("src");// 배열의 마지막꺼에 사진의 src가있음.
					addrList.add(src);
				}
				for (Element f : elements2) {
					Element bookname = f.firstElementChild();
					String title = bookname.text();
					titleList.add(title);
				}				
				b++;
			}
			for (int i = 0; i < titleList.size(); i++) {
				

				imgDownload("https://www.hanbit.co.kr/" + addrList.get(i), titleList.get(i));

				System.out.println(titleList.get(i));
				System.out.println(i + "번째 데이터를 저장했습니다");
			}
		} catch (Exception e) {
			System.out.println("오류발생 :" + e.getMessage());
		}

		return "Ok";
	}

	public void imgDownload(String addr, String fname) {
		fname = fname.replace("/", "_");
		fname = fname.replace("?", "_");
		fname = fname.replace("#", "_");
		fname = fname.replace(":", "_");
		try {
			URL url = new URL(addr);
			InputStream is = url.openStream();
			FileOutputStream fos = new FileOutputStream("c:/data/" + fname + ".jpg");
			FileCopyUtils.copy(is.readAllBytes(), fos);
			fos.close();
			is.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

//	
//
//		
//	@GetMapping("/newbook")	
//	public List<NewBook> newBook() {
//		List<NewBook> bookList = new ArrayList<NewBook>();
//		String base = "https://www.hanbit.co.kr";
//		//전체페이지수를 알아내서 수집하도록 코드를 수정 해 봅니다.		
//		try {
//			int i=1;
//			while(true) {		
//					String url = "https://www.hanbit.co.kr/store/books/new_book_list.html?page="+i;
//					Document doc= Jsoup.connect(url).get();
//					Elements list =  doc.select(".book_tit");
//					if(list.size() == 0) {
//						break;
//					}
//					for(Element e :list) {
//						Element a = e.firstElementChild();
//						String text = a.text();
//						String link =  base + a.attr("href");
//						bookList.add(new NewBook(text, link));
//					}
//				System.out.println(i+"페이지를 수집하였습니다.");
//				i++;
//			}
//		}catch (Exception e) {
//			System.out.println("예외발생:"+e.getMessage());
//		}
//		return bookList;
//	}
//	
//	@GetMapping("/seat")
//	public int seat() {
//		int seat =0;
//		String url = "http://mpllc-seat.sen.go.kr/seatinfo/Seat_Info/1_count.asp";
//		try {
//			Document doc = Jsoup.connect(url).get();
//			Elements list = doc.select(".wating_f");
//			Element a = list.first();
//			seat = Integer.parseInt(a.text());
//			
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//
//		
//		return seat;
//	}

}
