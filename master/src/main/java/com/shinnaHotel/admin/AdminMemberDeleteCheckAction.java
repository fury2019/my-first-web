package com.shinnaHotel.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinnaHotel.DAO.AdminDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class AdminMemberDeleteCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		AdminDAO adao = new AdminDAO();
		
		String u_id = req.getParameter("u_id");
		System.out.println(u_id);
		forward.setRedirect(false);
		
		HttpSession adminsession = req.getSession();
		adminsession.setAttribute("uid", u_id);
				
		
		String exist = "";
		if (adao.withdrawSelect(u_id)) {
		exist = "true";
		forward.setPath("../admin/deleteMem.jsp");
		req.setAttribute("exist", exist);
		} else {
			exist = "false";
			forward.setPath("../admin/deleteMem.jsp");
			req.setAttribute("exist", exist);
		}
		System.out.println(exist);
	
		
		
		
		
		return forward;

	}
}
