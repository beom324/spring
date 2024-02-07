package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
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
//		Optional<Member> op = dao.findById(id);
//		Member member = null;
//		if(op.isPresent()) {
//			member =op.get();
//		}
//		return member;
		return dao.findById(id).get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = null;
//		Member kim = new Member();
//		kim.setId("kim");
//		kim.setName("kimname");
//		kim.setPwd(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("kim"));
//		kim.setRole("user");
//		dao.save(kim);
//		
//		Member hong = new Member();
//		hong.setId("hong");
//		hong.setName("hongname");
//		hong.setPwd(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("hong"));
//		hong.setRole("admin");
//		dao.save(hong);
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
