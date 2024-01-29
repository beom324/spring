package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.vo.DeptVO;
import com.example.demo.vo.EmpVO;


public class DBManager {
	private static SqlSessionFactory factory;
	
	static { //호출하지 않아도 application이 가동되면서 자동으로 동작되는 영역
		try {
			String resource = "com/example/demo/db/sqlMapConfig.xml";//mybatis설정파일이 있는 경로
			InputStream inputStream = Resources.getResourceAsStream(resource); //읽어옴
			factory =
			  new SqlSessionFactoryBuilder().build(inputStream); //sql세션을 만들어줌
		}catch(Exception e) {
			System.out.println("DB Manager 오류 : " + e.getMessage());
		}
	}
	

	public static List<DeptVO> listDept(){
		List<DeptVO> list = null;
		SqlSession session = factory.openSession();
		list=session.selectList("dept.findAll");
		
		session.close();
		
		return list;
	}
	

}
