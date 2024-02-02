package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.BoardDAO;
import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;



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
	public String listBoard(Model model) {
		model.addAttribute("list",bs.listBoard());
		
		return "/board/listBoard";
	}
	@GetMapping("/insertBoard")
	public String insertBoardForm(Board board,Model model) {
		
		model.addAttribute("board",board);
		return "/board/insertBoard";
	}
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		
		int no = bs.getNextNo();
		int b_ref=no;
		int b_level=0;
		int b_step=0;
		board.setNo(no);
		board.setB_level(b_level);
		board.setB_ref(b_ref);
		board.setB_step(b_step);
		
		bs.insertBoard(board);
		
		
		return "redirect:/board/listBoard";
	}
	@GetMapping("/detailBoard")
	public String detailBoard(Model model,int no) {
		
		bs.incHit(no);
		model.addAttribute("list",bs.findById(no));
		return "/board/detailBoard";
	}
}
