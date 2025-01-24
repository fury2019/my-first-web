package com.shinnaHotel.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.ReservationDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class RoomUpdateAction implements Action{
	// 객실정보 - 전체객실 리스트 조회

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		
		ReservationDAO rdao = new ReservationDAO();
		
		req.setAttribute("RoomList", rdao.getAllRoomList());
		forward.setRedirect(false);
		forward.setPath(req.getContextPath()+"/room/room_all.jsp");
		
		
		return forward;
	}
}
