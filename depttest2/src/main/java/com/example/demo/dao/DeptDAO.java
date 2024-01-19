package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.DeptVO;

@Repository
public class DeptDAO {

	public DeptVO findById(int dno) {
		return DBManager.findById(dno);
	}
	
	public List<DeptVO> findAll(){
		return DBManager.findAll();
	}
	
	public int insertDept(DeptVO vo) {
		return DBManager.insertDept(vo);
	}
	
	public int updateDept(DeptVO vo) {
		return DBManager.updateDept(vo);
	}
	public int deleteDept(int dno) {
		return DBManager.deleteDept(dno);
	}
}
