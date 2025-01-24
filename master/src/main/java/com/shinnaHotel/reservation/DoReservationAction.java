package com.shinnaHotel.reservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinnaHotel.DAO.ReservationDAO;
import com.shinnaHotel.DTO.ReservationDTO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class DoReservationAction implements Action{
	// 예약하기
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		
		ActionForward forward = new ActionForward();
		ReservationDAO rdao = new ReservationDAO();
		ReservationDTO rdto = new ReservationDTO();
		
		HttpSession session = req.getSession();		
		
			
		
			rdto.setU_id((String)session.getAttribute("u_id"));
			rdto.setRes_adults(Integer.parseInt( (String) session.getAttribute("adults")));
			rdto.setRes_kids(Integer.parseInt( (String) session.getAttribute("children")));
			rdto.setRes_checkin((String) session.getAttribute("checkin_date"));
			rdto.setRes_checkout((String) session.getAttribute("checkout_date"));
			rdto.setRes_rtype((String)req.getParameter("r_type"));
			rdto.setRes_price(Integer.parseInt(req.getParameter("r_price")));
			rdto.setR_id(Integer.parseInt(req.getParameter("r_id")));
			rdto.setDiffday(Integer.parseInt(req.getParameter("diffday")));
			
			System.out.println("get" + session.getAttribute("adults"));
			System.out.println("get" + session.getAttribute("children"));
		
		
		// 결제 후 예약 테이블 인서트
		if(rdao.insertReservation(rdto)) {
			forward.setRedirect(false);
			forward.setPath(req.getContextPath()+"/reservation/ReservationSelect.re");
			
		}
		

		return forward;
	}
	 
}
