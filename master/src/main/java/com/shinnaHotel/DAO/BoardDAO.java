package com.shinnaHotel.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.shinnaHotel.DTO.BoardDTO;
import com.shinnaHotel.DTO.CommentDTO;
import com.shinnaHotel.mybatis.SqlMapConfig;

public class BoardDAO {
	
	

	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlSession;
	
	public BoardDAO() {
		sqlSession = factory.openSession(true);
	}
	// 리턴타입
		public List<BoardDTO> getBoardList(int startRow, int endRow) {
	    	// 파라미터값을 해쉬맵에 넣어준다.
			HashMap<String, Integer> datas = new HashMap<>();
			datas.put("startRow", startRow);
			datas.put("endRow", endRow);
			List<BoardDTO> boardList = sqlSession.selectList("Board.getBoardList", datas);
			
			return boardList;
		}

		public int getBoardCnt() {
			return sqlSession.selectOne("Board.getBoardCnt");
		}
		
		public BoardDTO getDetail(int b_number) {
			return (BoardDTO)sqlSession.selectOne("Board.getDetail",b_number);
		}

		public void updateReadCount(int b_number) {
			sqlSession.update("Board.updateReadCount", b_number);
		}
		
		public boolean insertBoard(BoardDTO board) {
			boolean result = false;
			
			if(sqlSession.insert("Board.insertBoard", board) == 1) {
				result = true;
			}
			
			return result;
		}

		public int getSeq() {
			return sqlSession.selectOne("Board.getSeq");
		}

		public boolean addcomment(CommentDTO comment) {
			boolean result = false;
			
			if(sqlSession.insert("Board.addcomment", comment) == 1) {
				result = true;
			}
			
			return result;
		}

		public List<CommentDTO> getcomment(int b_number) {
			List<CommentDTO> list = sqlSession.selectList("Board.getcomment",b_number);
			return list;
		}

		public boolean updatecomment(int c_number, String c_comment) {
			boolean result = false;
			HashMap<String, Object> datas = new HashMap<>();
			datas.put("c_number", c_number);
			datas.put("c_comment", c_comment);
			
			if(sqlSession.update("Board.updatecomment",datas) != 0) {
				result = true;
			}
			
			return result;
		}

		public boolean deletecomment(int c_number) {
			boolean result = false;
			
			if(sqlSession.delete("Board.deletecomment", c_number) == 1) {
				result = true;
			}
			
			return result;
		}
		
}
