package com.shinnaHotel.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinnaHotel.DAO.ReservationDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class ReservationSelectAction implements Action{
	// 예약된 내역 조회
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		ReservationDAO rdao = new ReservationDAO();
		
		HttpSession session = req.getSession();		
		String u_id = (String)session.getAttribute("u_id");
		
		req.setAttribute("reservationlist", rdao.selectReservation(u_id));

		forward.setRedirect(false);
		forward.setPath("reservationlist.jsp");
		
		return forward;
	}
	 
}
