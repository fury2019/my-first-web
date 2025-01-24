package com.Hotel.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Hotel.dao.admin.AdminMemDaoImpl;
import com.Hotel.service.admin.AdminMemServiceImpl;
import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Room_ReservationVO;

@WebServlet("/dashBoard")
public class DashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AdminMemDaoImpl dao = AdminMemDaoImpl.getInstance();
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        // 최근 회원 정보와 예약 내역 조회
	        List<MemberVO> recentMembers = dao.getRecentMembers();
//	        List<Room_ReservationVO> recentReservations = dao.getRecentReservations();
	        
	        // JSP로 데이터 전달
	        request.setAttribute("recentMembers", recentMembers);
//	        request.setAttribute("recentReservations", recentReservations);
	        
	        request.getRequestDispatcher("/jsp/DashBoard.jsp").forward(request, response);
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
