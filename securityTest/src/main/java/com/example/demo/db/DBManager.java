package com.example.demo.db;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	public static int insertMember(MemberVO vo) {
		int re=0;
		SqlSession session = factory.openSession();
		re = session.insert("member.insert",vo);
		session.commit();
		session.close();
		
		
		
		return re;
		
	}
	
	public static MemberVO findById(String id) {
		MemberVO vo = new MemberVO();
		SqlSession session = factory.openSession();
		vo=session.selectOne("member.findById",id);
		session.close();
		return vo;
	}

}
