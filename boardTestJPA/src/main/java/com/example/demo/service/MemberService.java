package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.entity.Member;

@Service
public class MemberService implements UserDetailsService {

	private MemberDAO dao;

	public MemberService(MemberDAO dao) {
		super();
		this.dao = dao;
	}
	
	public List<Member> findAll(){
		return dao.findAll();
	}
	
	public void delete(String id) {
		dao.deleteById(id);
	}
	public Member findById(String id) {
		return dao.getOne(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = null;
		try {
			Optional<Member> op = dao.findById(username);
			Member member = null;
			if(op.isPresent()) {
				member=op.get();
			}		
			if (member == null) {
				throw new UsernameNotFoundException(username);
			}
			user = User.builder().username(username).password(member.getPwd()).roles(member.getRole()).build();
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}
		return user;
	}

}
