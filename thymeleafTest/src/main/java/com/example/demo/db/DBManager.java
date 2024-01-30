package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.vo.BookVO;
import com.example.demo.vo.MemberVO;

public class DBManager {

	private static SqlSessionFactory factory;
	
	static {
		try {

			String resource = "com/example/demo/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("DBManager 오류 : " + e.getMessage());
		}

	}
	
	
	public static List<BookVO> list(){
		SqlSession session = factory.openSession();
		List<BookVO> list = session.selectList("book.findAll");
		session.close();
		return list;
	}
}
