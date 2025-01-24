package com.Hotel.dao.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.util.MybatisUtil;
import com.Hotel.vo.MemberVO;

public class MyPageDaoImpl implements IMyPageDao {
	
	private  static MyPageDaoImpl dao;
	
	private MyPageDaoImpl() {}
	
	public static MyPageDaoImpl getInstance() {
		if (dao == null) {
			dao = new MyPageDaoImpl();
		}
		return dao;	
	}

	@Override
	public MemberVO getMemberInfo(String mem_id) {
		
			SqlSession session = null;
			MemberVO memInfo = null;
			try {
				
				session = MybatisUtil.getSqlSession();
				memInfo = session.selectOne("mem.memberInfo",mem_id);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return memInfo;
		}
	}


