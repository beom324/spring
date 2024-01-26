package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BoardVO;
import com.example.demo.vo.EmpVO;
import com.example.demo.vo.GoodsVO;
import com.example.demo.vo.MemberVO;

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
	public static int deleteGoods(int no) {
		int re = 0;
		SqlSession session = factory.openSession();
		re= session.delete("goods.deleteGoods",no);
		session.commit();
		session.close();
		return re;		
	}
	
	public static List<BoardVO> listBoard(HashMap<String, Object> map){

		SqlSession session = factory.openSession();
		List<BoardVO> list = session.selectList("board.findAll",map);
		session.close();
		return list;
		
	}
	public static BoardVO findByIdBoard(int no) {
		BoardVO vo = null;
		SqlSession session = factory.openSession();
		vo = session.selectOne("board.findById",no);
		session.close();
		return vo;						
	}
	public static int insertBoard(BoardVO vo) {
		int re = 0;
		SqlSession session = factory.openSession();
		re=session.insert("board.insertBoard",vo);
		session.commit();
		session.close();
		return re;
	}
	public static int nextBoardNo() {
		int re=0;
		SqlSession session = factory.openSession();
		re = session.selectOne("board.nextNo");
		session.close();
		return re;
	}

	public static void updateStep(int b_ref, int b_step) {
		SqlSession session = factory.openSession(true);
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("b_ref", b_ref);
		map.put("b_step", b_step);
		session.update("board.updateStep",map);
		session.close();
		
	}
	public static int getTotalRecord() {
		int re=0;
		SqlSession session = factory.openSession();
		re =session.selectOne("board.getTotalRecord");
		session.close();
		return re;
	}
	public static int join(MemberVO vo) {
		int re=0;
		SqlSession session = factory.openSession();
		re = session.insert("member.join",vo);
		session.commit();
		session.close();
		return re;
	}
	
	public static List<EmpVO> findEmpAll() {
		List<EmpVO> list = null;
		
		SqlSession session = factory.openSession();
		list = session.selectList("emp.findAll");
		session.close();
		return list;
	}
	

}
