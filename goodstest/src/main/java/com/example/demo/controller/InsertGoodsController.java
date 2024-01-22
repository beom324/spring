package com.example.demo.controller;

import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/insertGoods")
@Slf4j
public class InsertGoodsController {
	
	
	private static GoodsDAO dao;
	
	
	
	public InsertGoodsController(GoodsDAO dao) {
		this.dao = dao;
	}
	@RequestMapping(method = RequestMethod.GET)
	public void form(Model model) {
		model.addAttribute("no",dao.nextNo());
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(GoodsVO vo, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("redirect:/listGoods");
		String path = req.getServletContext().getRealPath("images");//파일의 실 경로를 알아옴
		String fname = null; //업로드한 파일 정보를 알아오기 위한 변수 선언
		int re = -1;
		MultipartFile uploadFile = vo.getUploadFile();
		
		/* uploadFile null체크로는 파일이 있는지 없는지 검사할 수 없다.
		if(uploadFile !=null) {
			System.out.println("업로드 파일이 있습니다");
		}else {
			System.out.println("업로드 파일이 없습니다");
		}
		 */
		fname = uploadFile.getOriginalFilename();//업로드한 파일의 이름을 가져옴
		if(fname!=null && !fname.equals("")) {//업로드한 파일이 있으면
			try {
				byte[] data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
				vo.setFname(fname); 
				
			}catch(Exception e) {
				System.out.println("파일 업로드 오류 : " + e.getMessage());
			}
		}else {
			
		}	
		re = dao.insertGoods(vo);
		if(re!=1) {
			mav.setViewName("error");
		}
		
		
		return mav;
	}
}
