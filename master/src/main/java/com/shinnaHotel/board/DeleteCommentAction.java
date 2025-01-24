package com.shinnaHotel.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.BoardDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class DeleteCommentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		BoardDAO dbao = new BoardDAO();
		
		int c_number = Integer.parseInt( req.getParameter("c_number") );
		String b_number = req.getParameter("b_number");
		
		if(dbao.deletecomment(c_number)) {
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/board/BoardView.bo?b_number=" + b_number);
		}
		
		
		return forward;
	}

}
