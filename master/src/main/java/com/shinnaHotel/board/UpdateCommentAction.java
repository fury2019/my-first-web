package com.shinnaHotel.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.BoardDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class UpdateCommentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		BoardDAO bdao = new BoardDAO();
		
		int c_number = Integer.parseInt( req.getParameter("c_number") );
		String  c_comment = req.getParameter( "comment" + c_number );
		String b_number = req.getParameter("b_number");
		
		if(bdao.updatecomment(c_number, c_comment)) {
			forward.setRedirect(true);
			forward.setPath("/board/BoardView.bo?b_number=" + b_number);
		} 
		
		
		return forward;
	}

}
