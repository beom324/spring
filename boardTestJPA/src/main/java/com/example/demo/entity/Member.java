package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "member")
public class Member {

	@Id
	private String id;
	private String name;
	private String pwd;
	private String role;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)//이 이름으로 Board를 참조하겠다, 자식테이블을 즉시 읽어들여라. //Lazy는 필요할때 읽ㅇ어들여라
	private List<Board> boards;
}
