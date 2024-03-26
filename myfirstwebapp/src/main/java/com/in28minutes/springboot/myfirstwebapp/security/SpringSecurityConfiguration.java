package com.in28minutes.springboot.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(UserDetails...users)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		UserDetails userDetails1 = createNewUser("in28Minutes", "dummy");
		UserDetails userDetails2 = createNewUser("ranga", "dummydummy");
		
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder().username(username)
												.passwordEncoder(passwordEncoder)
												.password(password)
												.roles("USER", "ADMIN")
												.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 설정을 하지 않으면 어떤 URL이든 Login 페이지로 redirection됨
	// 기본값  1. 모든 URL 보호
	//       2. 승인되지 않은 요청에 대해선 로그인 양식 표시 
	
	// H2 콘솔에 액세스하려면 CSRF(사이트 간 요청 위조) 비활성화
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(
//				auth -> auth.anyRequest().authenticated());
//		http.formLogin(withDefaults());
//		
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
//		return http.build();
		http.authorizeHttpRequests(
				authorize -> authorize.anyRequest().authenticated()).formLogin(withDefaults())
																	.csrf(csrf->csrf.disable())
																	.headers(headers-> headers.frameOptions(options->options.disable()));
		return http.build();
	}
}
