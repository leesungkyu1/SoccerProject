package com.soccer.www.springsecurity.securityvo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipalVO implements UserDetails {

	private ArrayList<MemberVo> memvo;
	
	public UserPrincipalVO(ArrayList<MemberVo> userAuthes) {
		this.memvo = userAuthes;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { //유저가 갖고있는 권한 목록
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for(int i=0; i<memvo.size(); i++) {
				authorities.add(new SimpleGrantedAuthority(memvo.get(i).getRole_name()));
			}
			return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
