package com.Hotel.dao.member;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.util.MybatisUtil;
import com.Hotel.vo.MemberVO;

public class MemberDeleteDaoImpl implements IMemberDeleteDao {
	
	private static MemberDeleteDaoImpl dao;
	public MemberDeleteDaoImpl() {

	}

	public static MemberDeleteDaoImpl getInstance() {
		if (dao == null)
			dao = new MemberDeleteDaoImpl();
		return dao;
	}

	@Override
	public boolean memberDelete(String mem_id) {
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			
			int result = session.update("mem.memberDelete", mem_id);
            session.commit();
            return result > 0;
			
			
		} catch (Exception e) {
			 session.rollback();
	         e.printStackTrace();
	         return false;		
	    }finally {
            session.close();
        }
		
	}
	

}
