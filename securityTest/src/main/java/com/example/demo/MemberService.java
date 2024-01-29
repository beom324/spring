package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import lombok.Setter;

@Service //자동스캔, 생성
@Setter
public class MemberService implements UserDetailsService {

	
	@Autowired
	private MemberDAO dao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//유저네임에 해당하는 회원에 대한 정보를 db로 부터 갖고온다.
		//없으면 예외를 발생시켜줌.
		MemberVO vo = dao.findById(username);
		if(vo==null) {
			throw new UsernameNotFoundException(username);//VO가 NULL이면 강제로 예외를 발생시킨다.
		}
		
		UserDetails details = null;
		UserBuilder builder = User.builder();
		builder.username(vo.getId()); //매개변수로 받은 username과 같다.
		builder.password(vo.getPwd());
		builder.roles(vo.getRole());
		details=builder.build();
		return details;
		
		
		
	}

}
