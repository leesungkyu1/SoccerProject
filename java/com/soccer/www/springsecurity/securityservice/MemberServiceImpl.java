package com.soccer.www.springsecurity.securityservice;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.soccer.www.springsecurity.securitydao.SecurityDao;
import com.soccer.www.springsecurity.securityvo.MemberVo;


@Service
public class MemberServiceImpl implements UserDetailsService{

	@Autowired(required=false)
	private SecurityDao secdao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVo user = secdao.getUserById(username);
		
		System.out.println(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}


}
