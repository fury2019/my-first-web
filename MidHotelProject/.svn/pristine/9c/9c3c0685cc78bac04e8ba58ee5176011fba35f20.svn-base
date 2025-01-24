package com.Hotel.service.member;

import java.util.Map;

import com.Hotel.vo.MemberVO;

public interface IJoinLoginService {
	
	
	//회원 가입
	public int joinMember(MemberVO memVO);
	
	//로그인
	public MemberVO memberLogin(Map<String, String> map);
	
	//아이디 패스워드 중복 체크
	public MemberVO loginCheck(String memId, String memPw);
	
	//jsp 아이디 중복 체크 
	public int loginJSCheck(String memId);
}
