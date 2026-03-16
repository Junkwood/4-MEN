package com.aio.mes.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	//암호화
	@Bean
	public PasswordEncoder passwordEncoder(){
		// return new BCryptPasswordEncoder(); // 기존 코드 주석 처리
		return org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance();
	}
	    //인증 및 인가 설정
		@Bean
		SecurityFilterChain fiterChain(HttpSecurity http) throws Exception{
			http.authorizeHttpRequests()

					// 정적 리소스 및 로그인 페이지는 누구나 접근 가능
					.antMatchers("/account/login","/css/**","/images/**", "/js/**").permitAll()

					// [수정] 한글("관리", "설비" 등) -> DB코드("DM1", "DM6" 등)로 변경
					// DM1: 관리자, DM2: 영업, DM3: 생산, DM4: 품질, DM5: 자재, DM6: 설비
					.antMatchers("/admin/**").hasAuthority("DM1")           // 관리자만
					.antMatchers("/facility/**").hasAnyAuthority("DM1","DM6") // 관리자 + 설비팀
					.antMatchers("/business/**").hasAnyAuthority("DM1","DM2") // 관리자 + 영업팀
					.antMatchers("/prod/**").hasAnyAuthority("DM1","DM3")     // 관리자 + 생산팀
					.antMatchers("/mat/**").hasAnyAuthority("DM1","DM5")      // 관리자 + 자재팀
					.antMatchers("/test/**").hasAnyAuthority("DM1","DM4")     // 관리자 + 품질팀

					.anyRequest().authenticated()
					.and()
					.formLogin()
					.loginPage("/account/login")
					.usernameParameter("username") // 혹시 모르니 명시
					.passwordParameter("password")
					.permitAll()
					.defaultSuccessUrl("/")
					.and()
					.logout()
					.logoutSuccessUrl("/account/login")
					.permitAll()
					.and()
					.headers()
					.frameOptions().sameOrigin(); // H2나 iframe 사용시 필요

			return http.build();
		}
	
}
