package com.Hotel.service.member;

import java.util.Map;

import com.Hotel.dao.member.IMemberUpdateDao;
import com.Hotel.dao.member.MemberUpdateDaoImpl;
import com.Hotel.vo.MemberVO;

public class MemberUpdateServiceImpl implements IMemberUpdateService {

	private static IMemberUpdateService service;
	private IMemberUpdateDao dao;
	
	// 1.
	public MemberUpdateServiceImpl() {
		dao = MemberUpdateDaoImpl.getInstance();
	}
	
	public static IMemberUpdateService getInstance() {
		if(service == null) service = new MemberUpdateServiceImpl();
		
		return service;
	}
	
	@Override
	public MemberVO memberInfo(String mem_id) {
		return dao.getMemberInfo(mem_id);
	}
	
	@Override
	public boolean updateMember(Map<String, Object> member) {
		return dao.updateMember(member);
	}

}
