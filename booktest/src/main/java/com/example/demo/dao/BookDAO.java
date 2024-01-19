package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.vo.BookVO;

@Repository
public class BookDAO {

	public ArrayList<BookVO> findAll(){
		String sql = "select * from book";
		ArrayList<BookVO> list = new ArrayList<>();
		
		try {
				
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##madang","madang");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BookVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("도서목록 출력오류 : " + e.getMessage());
		}
		return list;
	}
}