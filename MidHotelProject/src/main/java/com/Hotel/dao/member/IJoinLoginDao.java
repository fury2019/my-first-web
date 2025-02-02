package com.Hotel.dao.member;

import java.util.Map;

import com.Hotel.vo.MemberVO;

public interface IJoinLoginDao {
	
	//회원가입 
	public int joinMember(MemberVO memVO);
	
	//로그인 
	public MemberVO memberLogin(Map<String, String> map);
	
	
	public MemberVO loginCheck(String memId, String memPw);
	
	
	public int loginJSCheck(String memId);
}
