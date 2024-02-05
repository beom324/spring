package com.example.demo.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.BoardDAO;
import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDAO dao;
	@Autowired
	private BoardService bs;
	
	
	public BoardController(BoardDAO dao) {
		super();
		this.dao = dao;
	}
	@GetMapping("/listBoard")
	public String listBoard(Model model,@PageableDefault Pageable pageable) {
		Page<Board> boardList = bs.getBoardList(pageable);

		model.addAttribute("list",boardList);
		
		return "/board/listBoard";
	}
	@GetMapping("/insertBoard")
	public String insertBoardForm(@RequestParam(value="no", defaultValue = "0")int no, Board board,Model model) {
												//새글 작성시에는 no가 null이기때문에 int에 null값을 담기위해 RequestParam사용
		model.addAttribute("no",no);
		model.addAttribute("board",board);
		return "/board/insertBoard";
	}
	@PostMapping("/insertBoard")
	public String insertBoard(Board board,HttpServletRequest request) {
		
		int pno = board.getNo();
		
		int no = bs.getNextNo();	
		int b_ref=no;
		int b_level=0;
		int b_step=0;
		
		if(pno!=0) {
			Board b = bs.getOne(pno); //부모글에 대한 정보를 가져온다
			b_ref = b.getB_ref();
			b_level = b.getB_level();
			b_step=b.getB_step();
			
			bs.updateStep(b_ref, b_step);
			b_level++;
			b_step++;
		}

		board.setNo(no);
		board.setB_level(b_level);
		board.setB_ref(b_ref);
		board.setB_step(b_step);
		
		
		MultipartFile uploadFile = board.getUploadFile();//이걸로는 null값을 판단할 수 없다.
		String path = request.getServletContext().getRealPath("images"); 
		String fileName = uploadFile.getOriginalFilename();
		System.out.println("uploadFile : "+uploadFile);
		System.out.println("path : " + path);
		
		if(uploadFile!=null&&!uploadFile.equals("")) {
			
			board.setFname(fileName);
			try {
				byte[] fileData = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path +"/"+fileName);
				fos.write(fileData);
				fos.close();
				board.setFname(fileName);
			} catch (IOException e) {
				System.out.println("사진등록오류 : "+ e.getMessage());
			}
			
		}
		
		bs.insertBoard(board);		
		
		return "redirect:/board/listBoard";
	}
	@GetMapping("/detailBoard/{no}")
	public String detailBoard(Model model,@PathVariable int no) {
		
		bs.incHit(no);
		model.addAttribute("list",bs.findById(no));
		return "/board/detailBoard";
	}
}
