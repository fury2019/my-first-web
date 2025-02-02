package com.Hotel.controller.reservation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.Hotel.service.reservation.IRoom_ServiceResService;
import com.Hotel.service.reservation.IRoom_reserService;
import com.Hotel.service.reservation.Room_ServiceResServiceImpl;
import com.Hotel.service.reservation.Room_reserServiceImpl;
import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Room_ReservationVO;


@WebServlet("/payresult")
public class payresult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoom_reserService reserService;
	private IRoom_ServiceResService serviceresService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payresult() {
        super();
        reserService = Room_reserServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String r_res_no = request.getParameter("r_res_no");
		 	
		 	 // r_res_no를 사용하여 예약 정보 조회
	        Room_ReservationVO reservation = reserService.selectRes(r_res_no);

	        // 예약 정보가 존재하는 경우
	        if (reservation != null) {
	            request.setAttribute("reservation", reservation);
	            // reservation4.jsp로 포워딩
	            request.getRequestDispatcher("/jsp/Reservation4.jsp").forward(request, response);
	        } else {
	            // 예약 정보가 존재하지 않을 경우 에러 처리
	            response.sendError(HttpServletResponse.SC_NOT_FOUND, "예약 정보를 찾을 수 없습니다.");
	        }
	    
	}

}
