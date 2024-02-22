package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.DeptDAO;
import com.example.demo.entity.Dept;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptService {
	
	private final DeptDAO dao;
	
	public List<Dept> listAll(){
		return dao.findAll();
	}
	

}
