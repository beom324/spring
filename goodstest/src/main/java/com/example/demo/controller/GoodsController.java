package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GoodsController {

	private static GoodsDAO dao;

	
	public GoodsController(GoodsDAO dao) {
		this.dao = dao;
		// TODO Auto-generated constructor stub
	}


	@GetMapping("/listGoods")
	public String listGoods(Model model) {
		model.addAttribute("list",dao.findAll());
		return "listGoods";
	}
	@GetMapping("/detailGoods")
	public String detailGoods(Model model,int no) {
		model.addAttribute("list",dao.findById(no));
		return "detailGoods";
	}
	@GetMapping("/updateGoods")
	public String updateGoods(Model model, int no) {
		model.addAttribute("list",dao.findById(no));
		return "updateGoods";
	}
	@PostMapping("updateGoods")
	public String updateGoods(GoodsVO vo,HttpServletRequest req) {
		int re=0;
		String oldFname = vo.getFname();//기존 사진이름
		String path = req.getServletContext().getRealPath("images");//images의 실 경로를 알아옴
		String fname=null;
		MultipartFile uploadFile = vo.getUploadFile();
		fname = uploadFile.getOriginalFilename();
		if(fname!=null && !fname.equals("")) {//사진도 수정합니까??
			try {//사진 복사를 위한 예외처리
				byte []data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				vo.setFname(fname);
			}catch(Exception e) {
				
			}
		}
		re= dao.updateGoods(vo);
		if(re==1&&fname!=null&&!fname.equals("")) {//수정에 성공했고 사진도 수정했다면
			File file = new File(path +"/"+oldFname);//기존파일의경로
			file.delete();//삭제
		}


		return "redirect:/listGoods";
	}
}
