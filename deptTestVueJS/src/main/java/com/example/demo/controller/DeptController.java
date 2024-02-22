package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Dept;
import com.example.demo.service.DeptService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class DeptController {
	
	private final DeptService ds;
	
	
	@GetMapping("/listDept")
	public List<Dept> listDept() {
		
		return ds.listAll(); 
	}
	@PostMapping("/insertDept")
	public String insertDept(Dept d,HttpServletRequest req) {
		
		String path = req.getServletContext().getRealPath("images");
		
		MultipartFile uploadFile = d.getUploadFile();

		
		if(uploadFile!=null && !uploadFile.equals("")) {
			String fname = uploadFile.getOriginalFilename();
			d.setFname(fname);
			
			try {
				byte[] fileData = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(fileData);
				fos.close();
				
			} catch (IOException e) {

			}
			ds.save(d);

			
		}
		
		
		
		
		return "ok";		
	}

}
