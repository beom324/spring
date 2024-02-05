package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Board;

import jakarta.transaction.Transactional;

public interface BoardDAO extends JpaRepository<Board,Integer> {

	@Modifying
	@Transactional
	@Query(value="insert into board b(b.no,b.title,b.writer,b.pwd,b.content,b.regdate,b.hit,b.fname,b.b_ref,b.b_level,b.b_step) values(:#{#b.no},:#{#b.title},:#{#b.writer},:#{#b.pwd},:#{#b.content},sysdate,0,:#{#b.fname},:#{#b.b_ref},:#{#b.b_level},:#{#b.b_step})",nativeQuery = true)
	public void insert(Board b);
	
	@Query(value = "select nvl(max(no),0)+1 from board", nativeQuery = true)
	public int getNextNo();
	@Modifying
	@Transactional
	@Query(value ="update board set hit = hit+1 where no=?1",nativeQuery = true)
	public void incHit(int no);

	@Modifying
	@Transactional
	@Query(value="update Board b set b.b_step = b.b_step+1 where b.b_ref=?1 and b.b_step> ?2", nativeQuery = true)
	public void updateStep(int b_ref,int b_step);
	
	@Query(value ="select * from board order by b_ref desc, b_step" , nativeQuery = true)
	public Page<Board> findAllby(Pageable pageble);
	
	
	
	
	
	
}
