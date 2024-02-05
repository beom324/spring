package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatchers;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	
	
	@Bean
	public PasswordEncoder encoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.requestMatchers("/","/member/login").permitAll()
		.requestMatchers("/admin/**").hasRole("admin")		
		.anyRequest().authenticated();//나머지는 로그인을 하면 사용할 수 있습니다.
		
		http.formLogin().loginPage("/member/login").permitAll().defaultSuccessUrl("/board/listBoard");
		
		
		
		
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.invalidateHttpSession(true).logoutSuccessUrl("/member/login");
		
		http.httpBasic(); //나머지는 기본을 따른다
		
		return http.build(); //HttpSecurity의 build메소드가 SecurityFilterChain을 만들어줌
		
		
	}
	

}
