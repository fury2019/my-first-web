package com.Hotel.service.member;

import java.util.Map;

import com.Hotel.dao.member.IJoinLoginDao;
import com.Hotel.dao.member.JoinLoginDaoImpl;
import com.Hotel.vo.MemberVO;

public class JoinLoginServiceImpl implements IJoinLoginService {
	private static JoinLoginServiceImpl service;

	private IJoinLoginDao dao;

	private JoinLoginServiceImpl() {
		dao = JoinLoginDaoImpl.getInstance();
	}

	public static JoinLoginServiceImpl getInstance() {
		if (service == null)
			service = new JoinLoginServiceImpl();

		return service;
	}	
	
	/**
	 * 회원가입
	 */
	@Override
	public int joinMember(MemberVO memVO) {
		return dao.joinMember(memVO);
	}

	/**
	 * 로그인
	 */
	@Override
	public MemberVO memberLogin(Map<String, String> map) {
		return dao.memberLogin(map);
	}
	
	/**
	 * 로그인 중복 체크
	 */
	@Override
	public MemberVO loginCheck(String userId, String userPw) {
		return dao.loginCheck(userId, userPw);
	}
	
	/**
	 * 로그인 중복 체크 카운트
	 */
	public int loginJSCheck(String memId) {
		return dao.loginJSCheck(memId);	
	}

}
