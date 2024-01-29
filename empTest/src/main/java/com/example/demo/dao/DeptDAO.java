package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.DeptVO;

@Repository
public class DeptDAO {

	public static List<DeptVO> findAll(){
		return DBManager.listDept();
	}
}
