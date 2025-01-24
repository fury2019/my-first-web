package com.Hotel.service.member;

import java.util.Map;

import com.Hotel.dao.member.IMemberDeleteDao;
import com.Hotel.dao.member.MemberDeleteDaoImpl;

public class MemberDeleteServiceImpl implements IMemberDeleteService {

	private static IMemberDeleteService service;
	private IMemberDeleteDao dao;
	
	// 1.
	public MemberDeleteServiceImpl() {
		dao = MemberDeleteDaoImpl.getInstance();
	}
	
	public static IMemberDeleteService getInstance() {
		if(service == null) service = new MemberDeleteServiceImpl();
		
		return service;
	}
	
	
	@Override
	public boolean memberDelete(String mem_id) {
		return dao.memberDelete(mem_id);
	}

}
