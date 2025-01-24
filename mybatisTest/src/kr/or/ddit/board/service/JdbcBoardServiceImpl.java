package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.IJdbcBoardDao;
import kr.or.ddit.board.dao.JdbcBoardDaoImpl;
import kr.or.ddit.vo.JdbcBoardVO;

public class JdbcBoardServiceImpl implements IJdbcBoardService {
   //1번
   private static IJdbcBoardDao dao;
   
   private static JdbcBoardServiceImpl service;
   
   public JdbcBoardServiceImpl() {
      dao = JdbcBoardDaoImpl.getInstance();
   }
   
   public static JdbcBoardServiceImpl getInstance() {
      if(service == null) service = new JdbcBoardServiceImpl();
      
      return service;
   }
   
   @Override
   public int insertBoard(JdbcBoardVO boardVo) {
      return dao.insertBoard(boardVo);
   }

   @Override
   public int deleteBoard(int boardNo) {
      return dao.deleteBoard(boardNo);
   }

   @Override
   public int updateBoard(JdbcBoardVO boardVo) {
      return dao.updateBoard(boardVo);
   }

   @Override
   public List<JdbcBoardVO> getAllBoard() {
      return dao.getAllBoard();
   }

   @Override
   public JdbcBoardVO getBoard(int boardNo) {
      //조회수 증가 
      int cnt = dao.setCountIncrement(boardNo);
      
      //조회수 증가 기능이 실패한다는 것은 해당 게시글 번호에 맞는 게시글이 
      //존재하지 않는다는 의미
      if(cnt == 0) {
         return null;
      }
      
      return dao.getBoard(boardNo);
   }

   @Override
   public List<JdbcBoardVO> getSearchBoard(String title) {
      return dao.getSearchBoard(title);
   }

   @Override
   public int setCountIncrement(int boardNo) {
      return dao.setCountIncrement(boardNo);
   }

}
