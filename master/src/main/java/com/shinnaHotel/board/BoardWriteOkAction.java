package com.shinnaHotel.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.BoardDAO;
import com.shinnaHotel.DTO.BoardDTO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class BoardWriteOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		BoardDAO bdao = new BoardDAO();
		
		String b_writer = req.getParameter("b_writer");
		String b_title = req.getParameter("b_title");
		String b_content = req.getParameter("b_content");
		
		
		BoardDTO board = new BoardDTO();
		board.setB_writer(b_writer);
		board.setB_title(b_title);
		board.setB_content(b_content);
		
		
		forward.setRedirect(true);
		if(bdao.insertBoard(board)) {
			// 성공시
			int b_number = bdao.getSeq();
			forward.setPath(req.getContextPath() + "/board/BoardView.bo?b_number=" + b_number);
		} else {
			// 실패시
			forward.setPath(req.getContextPath() + "/board/BoardWrite.bo" );
		}
		
		
		return forward;
	}

}
