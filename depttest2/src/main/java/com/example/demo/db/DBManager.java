package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptVO;

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
	
	public static List<DeptVO> findAll(){ //ArrayList의 부모인 List를 반환
		List<DeptVO> list = null;
		//Mybatis설정파일의 sql을 요청하기 위하여 SqlSession을 얻어옵니다.
		SqlSession session =  factory.openSession();//sql세션을 통해 sql을 요청할 수 있다.
		list = session.selectList("dept.findAll");
		session.close();//닫아준다.
		return list;
	}	
	public static int insertDept(DeptVO vo) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.insert("dept.insert",vo);
		//데이터베이스에 변동이 있는 sql(insert,update,delete)인 경우에는 반드시 commit을 해야 반영이 됩니다.
		session.commit();
		session.close();
		return re;
	}
}
