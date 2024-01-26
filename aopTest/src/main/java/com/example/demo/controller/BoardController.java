package com.example.demo.controller;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
public class BoardController {	
	@Autowired
	private final BoardDAO dao;


	public BoardController(BoardDAO dao) {
		this.dao=dao;
	}
	
	@GetMapping("/listBoard")
	public String listBoard(Model model,@RequestParam(value="pageNum",defaultValue ="1")int pageNum) {
		
		
		
		BoardDAO.totalRecord=dao.getTotalRecord();
		BoardDAO.totalPage=(int)Math.ceil(BoardDAO.totalRecord*1.0/BoardDAO.pageSize);
		
		int start =(pageNum-1)*BoardDAO.pageSize+1;
		int end = start+BoardDAO.pageSize-1;
		if(end>BoardDAO.totalRecord) {
			end=BoardDAO.totalRecord;
		}
		HashMap<String, Object> map = new HashMap<String ,Object>();
		map.put("start", start);
		map.put("end", end);
		
		model.addAttribute("list",dao.findAll(map));
		model.addAttribute("totalPage",dao.totalPage);
		return "listBoard";
	}
	@GetMapping("/detailBoard")
	public String detailBoard(Model model,int no) {
		model.addAttribute("list", dao.findById(no));


		return "detailBoard";

	}

	@PostMapping("/insertBoard")
	public String insertSubmit(BoardVO b, HttpServletRequest request ) {
		String view = "redirect:/listBoard";
		String path = 
		request.getServletContext().getRealPath("upload");
		
		b.setIp(request.getRemoteAddr());
		
		
		System.out.println("path:"+path);
		
		//일단은 새글이라고 보고 처리합니다.
		int no = dao.nextNo();
		int b_ref = no;
		int b_level = 0;
		int b_step = 0;
		
		int pno = b.getNo();
		if(pno != 0) {
			BoardVO p = dao.findById(pno);
			b_ref = p.getB_ref();
			b_level = p.getB_level();
			b_step = p.getB_step();
			
			dao.updateStep(b_ref, b_step);
			
			b_level++;
			b_step++;
		}
		

		b.setNo(no);
		b.setB_ref(b_ref);
		b.setB_level(b_level);
		b.setB_step(b_step);
		
		String fname = null;
		MultipartFile uploadFile = b.getUploadFile();
		fname = uploadFile.getOriginalFilename();
		b.setFname(fname);
		
		int re = dao.insertBoard(b);
		
		//db에 insert를 성공했고
		//파일도 업로드 했다면
		//파일복사를 합니다.
		if(re == 1 && fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				FileOutputStream fos 
				= new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}
		
		return view;
	}
	
	@GetMapping("/insertBoard")
	public void insertForm(String no,Model model) {
		int bno=0;
		if(no!=null&&!no.equals("")) {
			bno=Integer.parseInt(no);			
		}
		model.addAttribute("no",bno);	
	}	
}

