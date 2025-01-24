package com.shinnaHotel.reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.shinnaHotel.DAO.ReservationDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class RoomSearchAction implements Action{
	// 예약가능한 룸 조회
	
	
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ReservationDAO rdao = new ReservationDAO();
		ActionForward forward = new ActionForward();
		
		
		Map<String, Object> param = new HashMap<>();
		String checkin_date = req.getParameter("checkin_date");
		String checkout_date = req.getParameter("checkout_date");
		
		
		param.put("checkin_date", checkin_date);
		param.put("checkout_date", checkout_date);
		param.put("room", req.getParameter("room"));
		param.put("adults", req.getParameter("adults"));
		param.put("children", req.getParameter("children"));

		String  str = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		long diffday = 0;
		try {
			Date checkin = sdf.parse(checkin_date);
			Date checkout = sdf.parse(checkout_date);
			
			diffday = (checkout .getTime() - checkin.getTime()) / (24*60*60*1000);
		
		} catch (ParseException e) {
			System.err.println("ReservationRoomServlet - doGet() err : " + e.getMessage());
		}
		
		req.setAttribute("diffday", diffday);
		req.setAttribute("RoomList", rdao.searchRoom(param));
		
		HttpSession session = req.getSession();
		
		
		session.setAttribute("checkin_date", req.getParameter("checkin_date"));
		session.setAttribute("checkout_date", req.getParameter("checkout_date"));
		session.setAttribute("room", req.getParameter("room"));
		session.setAttribute("adults", (req.getParameter("adults")));
		session.setAttribute("children", (req.getParameter("children")));
		System.out.println(req.getParameter("adults"));
		System.out.println(req.getParameter("children"));
		
		forward.setRedirect(false);
		forward.setPath("reservation.jsp");
		
		return forward;
	}
	 
}
