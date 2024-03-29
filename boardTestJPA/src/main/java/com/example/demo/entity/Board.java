package com.example.demo.entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name="board")
@Data
public class Board {
	@Id
	private int no;
	private String title;

	@ManyToOne
	@JoinColumn(name = "id",insertable = true, updatable = true)
	private Member member; //Member 의 mappedby변수명과 일치해야한다.
	
//	private String writer;
	
	private String pwd;
	private String content;
	private String regdate;
	private int hit;
	
	@Transient//파일업로드를 위한 속성이므로 테이블에서 제외
	private MultipartFile uploadFile;
	private String fname;
	private int b_ref;
	private int b_level;
	private int b_step;
}
