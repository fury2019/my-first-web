package kr.or.ddit.login.dao;

import kr.or.ddit.vo.MemberVO;

public interface IMemberDao {
	/**
	 *회원 ID와 패스워드가 저장된 MemberVO객체를 인수값으로 받아서
	 *해당 회원을 검색하여 반환하는 메서드
	 *
	 * @param memVo 검색된 회원 정보가 저장된 MemberVO객체 (검색된 데이터가 없으면 null)
	 * @return
	 */
	public MemberVO getLoginMember(MemberVO memVo);
}
