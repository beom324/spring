package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.DeptDAO;
import com.example.demo.vo.DeptVO;

@Controller
public class DeptController {

	private DeptDAO dao; //spring환경에서는 알아서 객체를 생성해줌. 
	
	public DeptController(DeptDAO dao) {
		super();
		this.dao = dao;
	}

	@GetMapping("/listDept")
	public void listDept(Model model) {											
		model.addAttribute("list",dao.findAll());	
		
	}
	
	@GetMapping("/insertDept")
	public void inertDept() {
		
	}
	
	@PostMapping("/insertDept")
	public String insertDept(DeptVO vo,Model model) {				
		
		int re = dao.insertDept(vo);
		
		if(re!=1) {
			model.addAttribute("msg","부서등록에 실패하였습니다");
			return "error";
		}
						
		return "redirect:/listDept";
	}
	@GetMapping("/updateDept")
	public String updateDept(int dno,Model model) {

		DeptVO vo = dao.findByDno(dno);
		model.addAttribute("list",vo);
		
		return "updateDept";
	}
	
	@PostMapping("/updateDept")
	public String updateSubmit(DeptVO vo,Model model) {
		int re = dao.updateDept(vo);
		
		if(re==1) {
			return "redirect:/listDept";
		}
		else {
			model.addAttribute("msg","부서 수정에 실패하였습니다");
			return "error";
		}
				
		
		
	}
	@GetMapping("/deleteDept")
	public String deleteDept(int dno,Model model) {				
		int re = dao.deleteDept(dno);
		if(re!=1) {
			model.addAttribute("msg","삭제에 실패했습니다.");
			return "error.jsp";
		}else {
			return "redirect:/listDept";
			
		}
		
	}	
	
}
