package com.example.demo.controller;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String insertGoods(Goods g,HttpServletRequest req) {
		String path = req.getServletContext().getRealPath("images");
		MultipartFile uploadFile = g.getUploadFile();
		g.setId(gs.getNextNo());
		if(uploadFile!=null&&!uploadFile.equals("")) {
			String fname = uploadFile.getOriginalFilename();
			g.setFname(fname);
			try {
				FileOutputStream fos = new FileOutputStream(path +"/"+fname);
				FileCopyUtils.copy(uploadFile.getBytes(), fos);
				fos.close();
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			
		}
		gs.save(g);
		
		return "ok";
	}

}
