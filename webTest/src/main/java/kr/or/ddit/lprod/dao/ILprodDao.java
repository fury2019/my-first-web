package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.vo.LprodVO;

public interface ILprodDao {
	/**
	 * Lprod테이블의 전체 데이터를 가져오는 메서드
	 * 
	 * @return LPROD테이블의 전체 데이터를 담고 있는 List객체
	 */
	public List<LprodVO> getLprodAll();
	
}
