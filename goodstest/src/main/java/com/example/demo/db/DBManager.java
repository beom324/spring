package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.GoodsVO;

import lombok.extern.slf4j.Slf4j;

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

	public static List<GoodsVO> findAll() {
		List<GoodsVO> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("goods.findAll");
		session.close();
		return list;

	}
	public static int nextNo() {
		int re = 0;
		SqlSession session = factory.openSession();
		re = session.selectOne("goods.nextNo");
		session.close();
		return re;
	}
	public static int insertGoods(GoodsVO vo) {
		int re = 0;
		SqlSession session = factory.openSession();
		re= session.insert("goods.insertGoods",vo);
		session.commit();
		session.close();
		
		return re;
	}
	public static GoodsVO findById(int no) {
		GoodsVO vo = new GoodsVO();
		SqlSession session = factory.openSession();
		vo = session.selectOne("goods.findById",no);
		session.close();
		return vo;
	}
	public static int updateGoods(GoodsVO vo) {
		int re = 0;
		SqlSession session =factory.openSession();
		re = session.update("goods.updateGoods",vo);
		session.commit();
		session.close();
		return re;
	}

}
