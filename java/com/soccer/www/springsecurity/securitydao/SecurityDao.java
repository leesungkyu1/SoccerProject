package com.soccer.www.springsecurity.securitydao;


import org.springframework.stereotype.Repository;


import com.soccer.www.springsecurity.securityvo.MemberVo;

@Repository("secDAO")
public interface SecurityDao {

		//유저 정보
	MemberVo getUserById(String username);
	
//	//유저 저장
//	int userSave(MemberVo vo);
//	
//	//유저 권한 저장
//	int userRoleSave(@Param("userNo") int userNo, @Param("roleNo") int roleNo);
//	
//	//유저 FK번호 알아내기
//	int findUserNo(@Param("id") String id);
//	
//	//권한 FK번호 알아내기
//	int findRoleNo(@Param("roleName") String roleName);
}
