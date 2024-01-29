package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVO;

@SpringBootApplication
public class SecurityTestApplication {

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder()	;
	}
	
	public static void main(String[] args) {
//		MemberVO vo = new MemberVO();
//		vo.setId("tiger");
//		vo.setPwd(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("tiger"));
//		vo.setName("관리자");
//		vo.setRole("admin");
//		DBManager.insertMember(vo);
//		System.out.println("관리자 계정 생성함.");
		SpringApplication.run(SecurityTestApplication.class, args);
	}

}
