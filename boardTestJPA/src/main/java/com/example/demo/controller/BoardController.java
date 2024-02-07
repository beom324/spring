package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.BoardDAO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.service.BoardService;
import com.example.demo.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDAO dao;
	@Autowired
	private BoardService bs;
	@Autowired
	private MemberService ms;
	
	
	public BoardController(BoardDAO dao) {
		super();
		this.dao = dao;
	}
	@GetMapping("/listBoard")
	public String listBoard(Model model,@PageableDefault Pageable pageable,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		//이 인증객체를 통해서 인증된(로그인에 성공한) User객체를 받아 옵니다.
		
		User user = (User)authentication.getPrincipal();
		
		//이, 인증된 User를 통해서 로그인한 회원의 아이디를 갖고 옵니다.
		
		String id = user.getUsername();
		
		
		//이 정보를 세션에 상태유지 합니다.
		//만약 id뿐 아니라 로그인 한 회원의 다른 정보도 필요하다면 dao를 통해 회원의 정보를 갖고 와서 상태유지합니다
		
		
		Page<Board> boardList = bs.getBoardList(pageable);

		Member m = ms.findById(id);
		
		session.setAttribute("user", m);
		model.addAttribute("list",boardList);
		
		return "/board/listBoard";
	}
	
	
	@GetMapping("/insertBoard")
	public String insertBoardForm(@RequestParam(value="no", defaultValue = "0")int no, Board board,Model model) {
												//새글 작성시에는 no가 null이기때문에 int에 null값을 담기위해 RequestParam사용
		model.addAttribute("no",no);
		model.addAttribute("list",bs.findById(no));
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
	@GetMapping("/myList/{id}")
	public String myList(@PageableDefault Pageable pageble,@PathVariable String id,Model model) {
		
		model.addAttribute("list",bs.findMyList(pageble, id));
		
		return "/board/myList";
	}
	
	
	@GetMapping("/updateBoard/{no}")
	public String updateForm(Model model,@PathVariable int no,Board board) {
		model.addAttribute("list",bs.findById(no));
		return "/board/updateBoard";
	}
	@GetMapping("/deletePop/{no}")
	public String deletePop(@PathVariable int no,Model model) {
		model.addAttribute("no",no);
		return"/popup/deletePop";
	}
	@PostMapping("updateBoard/{no}")
	public String updateBoard(Board board,HttpServletRequest request,@PathVariable int no,Model model) {
		
		model.addAttribute("list",bs.findById(no));
		String oldFile = board.getFname();
		System.out.println("oldFile : " + oldFile);
		MultipartFile uploadFile = board.getUploadFile();
		
		String path = request.getServletContext().getRealPath("images");
		String fileName = uploadFile.getOriginalFilename();
		if(uploadFile!=null && !uploadFile.equals("")) {
			board.setFname(fileName);
			try {
				
				
				FileOutputStream fos = new FileOutputStream(path+"/"+fileName);
				FileCopyUtils.copy(uploadFile.getBytes(), fos);
				fos.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
		int re =dao.updateBoard(board);
		if(re==1 &&uploadFile!=null && !uploadFile.equals("")&&oldFile!=null&&oldFile.equals("") ) {
			File file = new File(path+"/"+oldFile);
			file.delete();
		}
		
		return "redirect:/board/listBoard";
				
	}
	@GetMapping("/deleteBoard")
	public String delete(int no) {
		dao.deleteById(no);
		
		return "redirect:/board/listBoard";
	}
	
}
