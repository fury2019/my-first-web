package com.shinnaHotel.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.AdminDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class AdminRoomEditAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest  req, HttpServletResponse  resp) {
		ActionForward forward = new ActionForward();
		AdminDAO adao = new AdminDAO();
		
		int r_id = Integer.parseInt( req.getParameter("r_id") );
		req.setAttribute("room", adao.getDetail(r_id));
		req.setAttribute("file", adao.getfileName(r_id));
		
		forward.setRedirect(false);
		forward.setPath("/admin/room_edit.jsp");
		
		return forward;
	}

}
