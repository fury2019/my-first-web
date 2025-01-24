package com.Hotel.service.member;

import java.util.List;

import com.Hotel.dao.member.IMyPageDao;
import com.Hotel.dao.member.MyPageDaoImpl;
import com.Hotel.vo.MemberVO;

public class MyPageServiceImpl implements IMyPageService {
	
	private static MyPageServiceImpl service;
	private IMyPageDao dao;
	
	// 1.
	private MyPageServiceImpl() {
		dao = MyPageDaoImpl.getInstance();
	}
	
	public static MyPageServiceImpl getInstance() {
		if(service == null) service = new MyPageServiceImpl();
		
		return service;
	}

	@Override
	public MemberVO memberInfo(String mem_id) {
		return dao.getMemberInfo(mem_id);
	}

}
