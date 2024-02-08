
package com.example.demo.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
		String addr="https://www.hanbit.co.kr/data/books/B7027415255_l.jpg";//이미지가 있는 URL
		try {
			URL url = new URL(addr); //url객체생성
			String fname = "퀵드로윙.jpg"; //컴퓨터에 저장 할 파일이름
			InputStream is =url.openStream(); //스트림 얻기
			FileOutputStream fos = new FileOutputStream("c:/data/"+fname);//출력을 할 스트림 생성
			FileCopyUtils.copy(is.readAllBytes()	,fos);//모두 읽어와서 fos에 출력
			
			is.close();
			fos.close();
			System.out.println("이미지를 다운로드 하였습니다");
		}catch(Exception e) {
			System.out.println("사진다운오류"+e.getMessage());
		}
		
		return "ok";
		
	}
	
		
	@GetMapping("/newbook")	
	public List<NewBook> newBook() {
		List<NewBook> bookList = new ArrayList<NewBook>();
		String base = "https://www.hanbit.co.kr";
		//전체페이지수를 알아내서 수집하도록 코드를 수정 해 봅니다.		
		try {
			int i=1;
			while(true) {		
					String url = "https://www.hanbit.co.kr/store/books/new_book_list.html?page="+i;
					Document doc= Jsoup.connect(url).get();
					Elements list =  doc.select(".book_tit");
					if(list.size() == 0) {
						break;
					}
					for(Element e :list) {
						Element a = e.firstElementChild();
						String text = a.text();
						String link =  base + a.attr("href");
						bookList.add(new NewBook(text, link));
					}
				System.out.println(i+"페이지를 수집하였습니다.");
				i++;
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return bookList;
	}
	
	@GetMapping("/seat")
	public int seat() {
		int seat =0;
		String url = "http://mpllc-seat.sen.go.kr/seatinfo/Seat_Info/1_count.asp";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements list = doc.select(".wating_f");
			Element a = list.first();
			seat = Integer.parseInt(a.text());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return seat;
	}
	
//	@GetMapping("/newbook")	
//	public String newBook() {
//		String base = "https://www.hanbit.co.kr";
//		String url = "https://www.hanbit.co.kr/store/books/new_book_list.html";
//		try {
//			Document doc= Jsoup.connect(url).get();
//			Elements list =  doc.select(".book_tit");
//			for(Element e :list) {
//				Element a = e.firstElementChild();
//				String text = a.text();
//				String link =  base + a.attr("href");
//				System.out.println(text);
//				System.out.println(link);
//				System.out.println("---------------------------");
//			}
//			
//		}catch (Exception e) {
//			System.out.println("예외발생:"+e.getMessage());
//		}
//		return "OK";
//	}
}
