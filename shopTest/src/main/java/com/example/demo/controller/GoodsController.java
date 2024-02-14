package com.example.demo.controller;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Goods;
import com.example.demo.entity.Pay;
import com.example.demo.service.GoodsService;
import com.example.demo.service.PayService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private PayService ps;

	@Autowired
	private GoodsService gs;
	
	@GetMapping("/listGoods")
	public String listGoods(Model model,HttpSession session) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		User user = (User)authentication.getPrincipal();
		
		String id = user.getUsername();
		
		session.setAttribute("id", id);
		model.addAttribute("list", gs.findAll());
		
		return "goods/listGoods";
	}
	@GetMapping("/insertGoods")
	public String insertGoods(Goods goods, Model model) {
		
		model.addAttribute("list",goods);
		 
		return "/goods/insertGoods";
		  
	}
	@PostMapping("/insertGoods")
	public String insertGoods(Goods goods,HttpServletRequest req) {
		MultipartFile uploadFile = goods.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		String path = req.getServletContext().getRealPath("images");
		
		if(uploadFile!=null && !uploadFile.equals("")) {
			goods.setFname(fname);
			try {
				byte[] fileData = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path + "/"+fname);
				fos.write(fileData);
				fos.close();
				
			}catch(Exception e) {
				System.out.println("파일 이미지 등록 오류 : " + e.getMessage());
			}
		}    
		
		gs.insert(goods);
		
		return "redirect:/goods/listGoods";
	}
	
	@GetMapping("detailGoods/{id}")
	public String detailGoods(@PathVariable Long id,Model model) {
		
		model.addAttribute("list",gs.findById(id));
		return "goods/detailGoods";  
	}
	   
	@GetMapping("/payment")
	@ResponseBody
	public String payment(Pay pay) {
		ps.insert(pay);
		return "OK";
		
	}

	
}
