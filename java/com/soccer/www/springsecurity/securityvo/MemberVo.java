package com.soccer.www.springsecurity.securityvo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MemberVo implements UserDetails{

	private static final long serialVersionUID = 1L;
	
		private int idx;
		private String id;
		private String pass;
		private String name;
		private int role_no;
		private String role_name;
		
		
		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public int getRole_no() {
			return role_no;
		}
		public void setRole_no(int role_no) {
			this.role_no = role_no;
		}
		public String getRole_name() {
			return role_name;
		}
		public void setRole_name(String role_name) {
			this.role_name = role_name;
		}
		
		//계정이 가진 권한 목록
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			ArrayList<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
			if(role_no ==1) {
				authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}else if(role_no ==2) {
				authList.add(new SimpleGrantedAuthority("ROLE_USER"));
			}
			return authList;
		}
		
		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return pass;
		}
		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return id;
		}
		//계정 만료 여부
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		//계정 잠김 여부
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
		
		
		@Override
		public String toString() {
			return "MemberVo [idx=" + idx + ", id=" + id + ", pass=" + pass + ", name=" + name + ", role_no=" + role_no + ", role_name=" + role_name + "]";
		}
		
	
}
