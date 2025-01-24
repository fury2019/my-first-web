package kr.or.ddit.book.dao;

import java.util.List;

import kr.or.ddit.vo.BookVO;


/*
 * DAO 객체 - 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성해서
 * 			Service에게 전달하는 역할을 수행하는 객체
 * 
 * 		- 이 클래스의 메서드 하나가 DB와 관련된 작업 1개를 수행하도록 작성
 */
public interface IBookDao {
	/**
	 * 매개변수로 받은 BookVO 자료를 DB에 insert하는 메서드
	 * 
	 * @param bookVo insert할 자료가 저장된 BookVO객체
	 * @return 작성 성공 : 1, 작업 실패 : 0
	 */
	public int bookInsert(BookVO bookVo);
	
	/**
	 * 매개변수로 받은 BookVO 자료를 이용하여 DB에 update하는 메서드
	 * 
	 * @param bookVo update할 자료가 저장된 BookVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int bookUpdate(BookVO bookVo);
	
	/**
	 * 도서 번호를 매개변수로 받아 해당 자료를 delete하는 메서드
	 * 
	 * @param bookId 삭제할 도서 번호
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int bookDelete(String bookId);
	
	/**
	 * 매개변수로 받은 데이터가 제목에 포함되어 있는 
	 * 도서 정보를 반환하는 메서드
	 * 
	 * @param bookTitle 검색할 도서 제목
	 * @return 검색된 결과가 저장된 List객체
	 */
	public List<BookVO> bookSearch(String bookId);
	
	/**
	 * 전체 도서 정보를 가져와 List에 저장하여 반환하는 메서드
	 * 
	 * @return BookVO객체가 저장된 List객체
	 */
	public List<BookVO> bookDisplayAll();
	
	/**
	 * 도서 번호를 매개변수로 받아서 해당 도서 번호의 개수를
	 * 반환하는 메서드
	 * 
	 * @param bookId 검색할 도서 번호
	 * @return 검색된 도서번호의 개수
	 */
	public int getBookIdCount(String bookId);
	
	
	
	
	
	
	
	
}
