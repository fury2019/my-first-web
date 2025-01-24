package com.shinnaHotel.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinnaHotel.DAO.AdminDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class AdminReservationListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		AdminDAO adao = new AdminDAO();
		
		int totalCnt = adao.getReserveCnt();
		System.out.println("토탈카운트"+ totalCnt);

		HttpSession session = req.getSession();		
		String u_id = (String)session.getAttribute("u_id");
		System.out.println("uid"+u_id);

		req.setAttribute("adminReserveList", adao.getAdminReserveList(u_id));
		System.out.println(" adao.getAdminReserveList(u_id)"+  adao.getAdminReserveList(u_id));

		req.setAttribute("totalCnt", totalCnt);
		
		System.out.println("액션도착");
		forward.setRedirect(false);
		forward.setPath("/admin/ReservationList.jsp" );
		return forward;
		

	
	}
}
