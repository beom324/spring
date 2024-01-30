package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import lombok.Setter;

@Service
public class MemberService implements UserDetailsService {

	@Autowired
	private MemberDAO dao;
			
	public MemberService(MemberDAO dao) {		
		this.dao = dao;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo =  dao.findById(username);
		if(vo==null) {
			throw new UsernameNotFoundException(username);//유저가 없으면 강제로 예외 발생
		}
		UserDetails user = null; //UserDetails를 반환해주기 위해 
		user =User.builder().username(vo.getId()).password(vo.getPwd()).roles(vo.getRole()).build(); //유저 생성
		
		
		return user;

	}

}
