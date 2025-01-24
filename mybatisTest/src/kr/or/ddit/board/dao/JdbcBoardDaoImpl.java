package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.JdbcBoardVO;

public class JdbcBoardDaoImpl implements IJdbcBoardDao {
	//1
	private static JdbcBoardDaoImpl dao;
	
	//2
	private JdbcBoardDaoImpl()  {  }
	
	//3
	public static JdbcBoardDaoImpl getInstance() {
		if(dao==null) dao = new JdbcBoardDaoImpl();
		
		return dao;
	}
	
	

	@Override
	public int insertBoard(JdbcBoardVO boardVo) {
		int cnt = 0; 		// 반환값 저장 변수
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.insert("board.insertBoard", boardVo);
			
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int cnt = 0; 		// 반환값 저장 변수
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.delete("board.deleteBoard", boardNo);
			
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(JdbcBoardVO boardVo) {
		int cnt = 0; 		// 반환값 저장 변수
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("board.updateBoard", boardVo);
			
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<JdbcBoardVO> getAllBoard() {
		List<JdbcBoardVO>boardList = null;  //반환값 저장될 변수
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			boardList = session.selectList("board.getAllBoard");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return boardList;
	}
	 
	@Override
	public JdbcBoardVO getBoard(int boardNo) {
		JdbcBoardVO boardVo = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			boardVo = session.selectOne("board.getBoard", boardNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return boardVo;
	}
		
	@Override
	public List<JdbcBoardVO> getSearchBoard(String title) {
		List<JdbcBoardVO>boardList = null;  //반환값 저장될 변수
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			boardList = session.selectList("board.getSearchBoard", title);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return boardList;
	}

	@Override
	public int setCountIncrement(int boardNo) {
		int cnt = 0; 		// 반환값 저장 변수
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("board.setCountIncrement", boardNo);
			
			if(cnt>0) session.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

}
