package com.shinnaHotel.reservation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.action.ActionForward;

@WebServlet("*.re")
public class ReservationFrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doprocess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doprocess(req, resp);
	}
	
	protected void doprocess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String requestURI = req.getRequestURI();
		ActionForward forward = null;
		
		
		
		switch(requestURI) {
		
			// 검색 버튼 클릭 시 예약 가능한 룸리스트 출력요청
			case  "/reservation/RoomSearch.re" :
				forward = new RoomSearchAction().execute(req, resp);
				break;
			// 예약버튼 클릭 시 	insert 요청
			case "/reservation/DoReservation.re" :
				forward = new DoReservationAction().execute(req, resp);
				break;
			// 예약 취소하기 시 취소테이블 insert, 예약테이블 delete
			case "/reservation/ReservationCancel.re" :
				forward = new ReservationCancelAction().execute(req, resp);
				break;
			// 예약내역 리스트 조회요청
			case "/reservation/ReservationSelect.re" :
				forward = new ReservationSelectAction().execute(req, resp);
				break;
			// 객실정보 - 전체객실 리스트 조회
			case "/reservation/RoomUpdate.re" :
				forward = new RoomUpdateAction().execute(req, resp);
				break;
			
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				// 리다이렉트 전송방식
				resp.sendRedirect(forward.getPath());
			}else {
				// forward 전송방식
				RequestDispatcher disp = req.getRequestDispatcher(forward.getPath());
				disp.forward(req, resp);
			}
	}
	
}
}