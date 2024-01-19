package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.vo.DeptVO;

@Repository
public class DeptDAO {		
	
	public ArrayList<DeptVO> findAll(){
		ArrayList<DeptVO> list = new ArrayList<>();
		String sql = "select * from dept";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##madang","madang");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}	
	
	public int insertDept(DeptVO vo) {
		int re=-1;
		String sql ="insert into dept values(?,?,?)";
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##madang","madang");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,vo.getDno());
			pstmt.setString(2, vo.getDname());
			pstmt.setString(3, vo.getDloc());
			re= pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		return re;
	}
	
	public DeptVO findByDno(int dno) {
		DeptVO vo = new DeptVO();
		String sql = "select * from dept where dno = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##madang","madang");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setDno(dno);
				vo.setDname(rs.getString(2));
				vo.setDloc(rs.getString(3));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return vo;
	}
	
	public int updateDept(DeptVO vo) {
		int re = -1;
		String sql = "update dept set dname =? , dloc=? where dno = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##madang","madang");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getDname());
			pstmt.setString(2, vo.getDloc());
			pstmt.setInt(3, vo.getDno());
			re=pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public int deleteDept(int dno) {
		int re = -1;
		String sql ="delete dept where dno = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##madang","madang");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			
			re=pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	
}
