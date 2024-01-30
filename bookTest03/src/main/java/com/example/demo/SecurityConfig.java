package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatchers;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean //객체 제공자입니다.
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //메소드이름이 xml의 id
												//<bean id="filetchain" class ="SecurityFilterChain"> 같은의미
		http.authorizeHttpRequests()
		.requestMatchers("/","/all/**","/join").permitAll() //인증과 관련 없이 아무나 사용할 수 있어요(permitAll())
		.requestMatchers("/admin/**").hasRole("admin")//admin role 필요
		.anyRequest().authenticated();//나머지는 인증만 필요해요
		
		http.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/listBook");
		
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.invalidateHttpSession(true).logoutSuccessUrl("/login");
		
		http.httpBasic();
	
		return http.build(); //http의 build메소드가 SecurityFilterChain을 만들어줌
		
		
	}
}
