package com.Hotel.dao.member;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.util.MybatisUtil;
import com.Hotel.vo.MemberVO;

public class MemberUpdateDaoImpl implements IMemberUpdateDao {
	private static MemberUpdateDaoImpl dao;
	private MemberUpdateDaoImpl() {

	}

	public static MemberUpdateDaoImpl getInstance() {
		if (dao == null)
			dao = new MemberUpdateDaoImpl();
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
	

	@Override
	public boolean updateMember(Map<String, Object> member) {
		
		SqlSession session = null;
		
        try {
        	session = MybatisUtil.getSqlSession();
            int result = session.update("mem.memberUpdate", member);
            session.commit();
            return result > 0;
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }	

}
