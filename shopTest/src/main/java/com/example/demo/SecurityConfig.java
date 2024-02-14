package   com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder encoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}   
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.requestMatchers("/", "/member/login", "/member/join").permitAll()
		.requestMatchers("/admin/**","goods/insertGoods").hasRole("admin")
		.anyRequest().authenticated();   
		
		http.formLogin().loginPage("/member/login").permitAll()
		.defaultSuccessUrl("/goods/listGoods"); 
		
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/member/login");
		
		http.httpBasic();
		
		return http.build();
	}
}
















