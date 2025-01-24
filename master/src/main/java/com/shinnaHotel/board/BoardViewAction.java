package com.shinnaHotel.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.BoardDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class BoardViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		BoardDAO bdao = new BoardDAO();
		
		int b_number = Integer.parseInt(req.getParameter("b_number"));
		
		//조회수를 update
		bdao.updateReadCount(b_number);
		
		req.setAttribute("board", bdao.getDetail(b_number));
		// 댓글조회 로직 추가
		req.setAttribute("commentlist", bdao.getcomment(b_number));
		

		forward.setRedirect(false);
		forward.setPath("/inquiry/inquiryview.jsp" );
		
		return forward;
	}

}
