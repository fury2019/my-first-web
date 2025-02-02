package com.Hotel.dao.member;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.common.util.MybatisUtil;
import com.Hotel.vo.MemberVO;

public class JoinLoginDaoImpl implements IJoinLoginDao {
	private static JoinLoginDaoImpl dao;

	private JoinLoginDaoImpl() {

	}

	public static JoinLoginDaoImpl getInstance() {
		if (dao == null)
			dao = new JoinLoginDaoImpl();
		return dao;
	}

	// 회원가입
	public int joinMember(MemberVO memVO) {

		SqlSession session = null;

		int count = 0;

		try {
			session = MybatisUtil.getSqlSession();
			count = session.insert("mem.joinMember", memVO);
			if (count > 0)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
			session.close();
		}

		return count;

	}

	// 회원 로그인
	public MemberVO memberLogin(Map<String, String> map) {
		SqlSession session = null;
		MemberVO memId = null;

		try {
			session = MybatisUtil.getSqlSession();
			memId = session.selectOne("mem.memberLogin", map);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
			session.close();
		}
		
		return memId;
	}

	@Override
	public MemberVO loginCheck(String userId, String userPw) {
		SqlSession session = null;
		MemberVO memVo = null;
		try {
			session = MybatisUtil.getSqlSession();
			Map<String, String> params = new HashMap<>();
			params.put("id", userId);
			params.put("pw", userPw);
			memVo = session.selectOne("mem.loginCheck", params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return memVo;
	}
	
	public int loginJSCheck(String memId) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			Map<String, String> params = new HashMap<String, String>();
			params.put("userId", memId);
			cnt = session.selectOne("mem.checkLogin", params);
		} catch (Exception e) {
			if (session != null)
				session.close();
		}
		return cnt;
		
	}
}
