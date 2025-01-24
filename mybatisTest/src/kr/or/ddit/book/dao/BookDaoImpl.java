package kr.or.ddit.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.BookVO;

public class BookDaoImpl implements IBookDao {
	// 싱글톤
	// 1번
	private static BookDaoImpl dao;

	// 2번
	private BookDaoImpl() {
	}

	// 3번
	public static BookDaoImpl getInstance() {
		if (dao == null)
			dao = new BookDaoImpl();

		return dao;
	}

	@Override
	public int bookInsert(BookVO bookVo) {
		int cnt = 0; // 반환값이 저장될 변수

		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();

			cnt = session.insert("book.bookInsert", bookVo);

			if (cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int bookUpdate(BookVO bookVo) {
		int cnt = 0;

		SqlSession session = null;

		try {
			session = MybatisUtil.getSqlSession();

			cnt = session.update("book.bookUpdate", bookVo);

			if (cnt > 0)
				session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int bookDelete(String bookId) {
		int cnt = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.delete("book.bookDelete", bookId);

			if (cnt > 0)
				session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	/*
	 * @Override public List<BookVO> bookSearch(String bookTitle) { List<BookVO>
	 * bookList = null; // 반환값이 저장될 변수 Connection conn = null; PreparedStatement
	 * pstmt = null; ResultSet rs = null;
	 * 
	 * 
	 */
	@Override
	public List<BookVO> bookDisplayAll() {
		List<BookVO> bookList = null; // 반환값이 저장될 변수

		SqlSession session = null;

		try {

			session = MybatisUtil.getSqlSession();

			bookList = session.selectList("book.bookDisplayAll");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return bookList;
	}

	@Override
	public int getBookIdCount(String bookId) {
		int count = 0;

		SqlSession session = null;

		try {
			session = MybatisUtil.getSqlSession();

			count = session.selectOne("book.getBookIdCount", bookId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return count;
	}

	@Override
	public List<BookVO> bookSearch(String bookTitle) {
		List<BookVO> bookList = null;

		SqlSession session = null;

		try {
			session = MybatisUtil.getSqlSession();

			bookList = session.selectList("book.bookSearch", bookTitle);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return bookList;
	}

}
