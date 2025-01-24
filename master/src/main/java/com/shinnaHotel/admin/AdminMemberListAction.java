package com.shinnaHotel.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.AdminDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class AdminMemberListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		AdminDAO adao = new AdminDAO();
		
		int totalCnt = adao.getMemCnt();
		
		req.setAttribute("adminList", adao.getAdminList());
		req.setAttribute("totalCnt", totalCnt);
		req.setAttribute("adminExitList", adao.getAdminExitList());
		
		System.out.println("액션도착");
		forward.setRedirect(false);
		forward.setPath("../admin/AllMember.jsp" );
		return forward;
	}

}
