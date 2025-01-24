package com.shinnaHotel.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.BoardDAO;
import com.shinnaHotel.DTO.CommentDTO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class AddCommentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		
		BoardDAO bdao = new BoardDAO();
		CommentDTO comment = new CommentDTO();
		
		int b_number = Integer.parseInt( req.getParameter("b_number") );
		
		comment.setB_number( b_number );
		
		comment.setC_comment( req.getParameter("c_comment") );
		
		if(bdao.addcomment( comment )) {
			forward.setRedirect(true);
			forward.setPath( req.getContextPath() + "/board/BoardView.bo?b_number=" + b_number );
		}
		
		
		
		return forward;
	}

}
