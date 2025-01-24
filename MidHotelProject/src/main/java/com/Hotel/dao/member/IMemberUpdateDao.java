package com.Hotel.dao.member;

import java.util.Map;

import com.Hotel.vo.MemberVO;

public interface IMemberUpdateDao {
	
	public MemberVO getMemberInfo(String mem_id);
	
	public boolean updateMember(Map<String, Object> member);
	 
}
