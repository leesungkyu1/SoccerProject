package com.soccer.www.springsecurity.securitycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/login/loginPage.do")
	public String loginPage() {
		
		return "login/loginPage";
	}
	
	@RequestMapping(value = "/login/accessDenied.do")
	public String accessDeniedPage() {
		
		return "login/accessDenied";
	}

}
