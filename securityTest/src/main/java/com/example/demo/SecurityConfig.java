package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		.mvcMatchers("","/join","/all/**","/error").permitAll() //아무나 다 사용할 수 있어요
		.mvcMatchers("/admin/**").hasRole("admin")//admin 이라는 role 이 있어야 서비스 할 수 있다.
		.anyRequest().authenticated(); //나머지는 로그인만 하면 사용할 수 있어.
		
		
		http.formLogin().loginPage("/login").permitAll()//사용자가 만든 loginform 을 통한 로그인설정
		.defaultSuccessUrl("/listBook");//로그인 성공시 /listBook으로 이동
		
		
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //어떤url 입력 시 로그아웃 할 것인가.
		.invalidateHttpSession(true)//자동으로 세션파괴하겠다
		.logoutSuccessUrl("/login");//로그아웃 성공시 이동 할 url
		
		http.httpBasic();//그 나머지는 http기본을 따릅니다.
		
	
	}
	
}
