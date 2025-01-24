package com.shinnaHotel.reservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinnaHotel.DAO.ReservationDAO;
import com.shinnaHotel.DTO.ResCancelDTO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class ReservationCancelAction implements Action{
	// 예약 취소하기
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		
		ReservationDAO rdao = new ReservationDAO();
		ResCancelDTO rcdto = new ResCancelDTO();
		
		int res_number = Integer.parseInt(req.getParameter("res_number"));
		
		HttpSession session = req.getSession();	
		System.out.println(res_number);
		System.out.println((String)session.getAttribute("u_id"));
		System.out.println(req.getParameter("res_checkin"));
		System.out.println(req.getParameter("res_checkout"));
		System.out.println(req.getParameter("res_rtype"));
		System.out.println(Integer.parseInt(req.getParameter("res_price")));
		
		
			rcdto.setU_id((String)session.getAttribute("u_id"));
			rcdto.setRes_number(res_number);
			rcdto.setRes_checkin(req.getParameter("res_checkin"));
			rcdto.setRes_checkout(req.getParameter("res_checkout"));
			rcdto.setRes_rtype(req.getParameter("res_rtype"));
			rcdto.setRes_price(Integer.parseInt(req.getParameter("res_price")));
	
			
		// 예약 취소테이블 insert
		if(rdao.insertResCancel(rcdto)) {
			// 예약테이블 delete
			rdao.updateReservation(res_number);
			forward.setRedirect(false);
			forward.setPath(req.getContextPath()+"/reservation/ReservationSelect.re");
		}
		
		return forward;
	}
	 
}
