package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Goods;
import com.example.demo.service.GoodsService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GoodsController {
	
	private final GoodsService gs;
	
	@GetMapping("/listGoods")
	public List<Goods> listGoods(){
		return gs.listGoods();
	}
	
	
	@PostMapping("/insertGoods")
	public String insertGoods(Goods g, MultipartFile uploadFile, HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("images");
		System.out.println("path:"+path);
		String fname = "";
		try {
			if(uploadFile != null) {
				fname = uploadFile.getOriginalFilename();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				FileCopyUtils.copy(uploadFile.getBytes(), fos);
				fos.close();
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		g.setFname(fname);
		System.out.println("fname:"+fname);
		gs.save(g);		
		return "OK";
	}
	
	@PostMapping("/updateGoods")
	public String updateGoods(Goods g, MultipartFile uploadFile, HttpServletRequest request) {
		String oldFname = g.getFname();		
		String path = request.getServletContext().getRealPath("images");
		System.out.println("path:"+path);
		String fname = "";
		try {
			if(uploadFile != null) {
				fname = uploadFile.getOriginalFilename();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				FileCopyUtils.copy(uploadFile.getBytes(), fos);
				fos.close();
				g.setFname(fname);
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		
		
		System.out.println("fname:"+fname);
		gs.updateGoods(g);		
		if(fname != null && !fname.equals("") && 
				oldFname != null && !oldFname.equals("")) {
			File file = new File(path +"/" + oldFname);
			file.delete();
		}
		
		return "OK";
	}
}

