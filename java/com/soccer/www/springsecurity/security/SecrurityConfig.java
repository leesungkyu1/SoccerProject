package com.soccer.www.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.soccer.www.springsecurity.securityservice.MemberServiceImpl;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity //@Configuration 클래스에 @EnableWebSecurity 어노테이션을 추가하여 Spring Security 설정할 클래스라고 정의
					//설정은 WebSecurityConfigurerAdapter 클래스를 상속받아 메서드를 구현하는 것이 일반적인 방법
@AllArgsConstructor
public class SecrurityConfig extends WebSecurityConfigurerAdapter { //WebSecurityConfigurer 인스턴스를 편리하게 생성하기 위한 클래스
	private MemberServiceImpl memberservice;
	
	@Bean
	public PasswordEncoder passwordEncoder() { //BCryptPasswordEncoder는 Spring Security에서 제공하는 비밀번호 암호화 객체
												//Service에서 비밀번호를 암호화할 수 있도록 Bean으로 등록
		return new BCryptPasswordEncoder();
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {  //configure() method를 오버라이딩하여, Security 설정
		
		// static 디렉터리의 하위 파일 목록은 인증 무시(= 항상 통과)
		web.ignoring().antMatchers("/css/**", "js/**", "img/**", "/lib/**"); //해당 경로의 파일들은 Spring Security가 무시할 수 있도록 설정
																			// 이 파일들은 무조건 통과, 파일 기준은 resources/static 디렉터리
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { //HttpSecurity를 통해 HTTP요청에 대한 웹 기반 보안을 구성할 수 있음
		http
			.cors().and() //CorsFilter 필터를 활성화 시키는 작업
			.csrf().disable() //세션을 사용하지 않고 JWT 토큰을 활용하여 진행하고 REST API를 만드는 작업 csrf사용 disable
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests() //HttpServletRequest에 따라 접근(access)을 제한
			//페이지 권한 설정
			.antMatchers("/admin/**").hasRole("ADMIN") //admin으로 시작하는 경로는 ADMIN을 가진사람들만 접근
			.antMatchers("/user/myinfo").hasRole("MEMBER") //user/myinfo는 MEMBER등급을 가진사람들만 접근
			.antMatchers("/main.do").permitAll() // 모든 경로에 대해 권한없이 접근  
			//.anyRequest().authenticated() 모든 요청에 대해, 인증된 사용자만 접근하도록 설정.
		.and() //로그인 설정
			.formLogin() //로그인 정보는 기본적으로 HttpSession
			.loginPage("/login/loginPage") // login 경로로 접근하면 springSecurity에서 제공하는 로그인 form 사용, 기본제공되는 form 말고, 커스텀 로그인폼은 loginPage() 메서드를 사용
										//이 때 커스텀 로그인 form의 action 경로와 loginPage() 파라미터 경로가 일치해야 인증할 수 있음
			.usernameParameter("userid")
			.passwordParameter("userpw")
			.defaultSuccessUrl("/") //로그인이 성공했을때 이동되는 페이지
			.permitAll()
			//name=username인 input을 기본으로 인식하는데, usernameParameter() 메서드를 통해 파라미터명을 변경
		.and() //로그아웃 설정
			.logout() //기본적으로 "/logout"에 접근하면 HTTP 세션을 제거
			.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")) //로그아웃의 기본 URL(/logout) 이 아닌 다른 URL로 재정의
			.invalidateHttpSession(true) //HTTP 세션을 초기화하는 작업
		.and() // 403 예외처리 핸들링
			.exceptionHandling().accessDeniedPage("/user/denied"); //예외가 발생했을 때 exceptionHandling() 메서드로 핸들링
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{ //Spring Security에서 모든 인증은 AuthenticationManager를 통해 이루어지며 
																				//AuthenticationManager를 생성하기 위해서는 AuthenticationManagerBuilder를 사용
		auth.userDetailsService(memberservice).passwordEncoder(passwordEncoder()); //증을 위해서는 UserDetailService를 통해서 필요한 정보들을 가져
		
	}

}
