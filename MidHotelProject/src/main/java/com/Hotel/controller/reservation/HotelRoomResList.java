package com.Hotel.controller.reservation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.Hotel.service.reservation.IRoom_ServiceResService;
import com.Hotel.service.reservation.IRoom_reserService;
import com.Hotel.service.reservation.Room_ServiceResServiceImpl;
import com.Hotel.service.reservation.Room_reserServiceImpl;
import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Room_ReservationVO;

	@WebServlet("/hotelRoomResList")
	public class HotelRoomResList extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	   private IRoom_reserService reserService;
	   private IRoom_ServiceResService serviceresService;
	
	   public HotelRoomResList() {
	      super();
	      reserService = Room_reserServiceImpl.getInstance();
	      serviceresService = Room_ServiceResServiceImpl.getInstance();
	   }
	
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
		   
		    HttpSession session = request.getSession();
		    MemberVO loggedInMember = (MemberVO) session.getAttribute("loginCode");
		    String mem_id = loggedInMember.getMem_id();
		    String grade = loggedInMember.getGrade_no();

		    try {
		        if ("Admin".equals(grade)) {
		            // 모든 객실 예약 정보 조회
		            List<Room_ReservationVO> reservations = reserService.selectAllRes();
		            request.setAttribute("reservationRoomAlls", reservations);
		            request.getRequestDispatcher("/jsp/AllRoomReservations.jsp").forward(request, response);
		        } else {
		        	

		        	// 특정 회원의 객실 예약 정보 조회
		            List<Room_ReservationVO> reservations = reserService.selectgetRes(mem_id);
		            request.setAttribute("reservationRoomMembers", reservations);
		            request.getRequestDispatcher("/jsp/RoomMemberReservations.jsp").forward(request, response);
		        }
		    } catch (Exception e) {
		        // 예외 처리 및 오류 메시지 출력
		        response.setContentType("text/html; charset=UTF-8");
		        response.getWriter().write("<script>alert('서버 오류가 발생했습니다. 관리자에게 문의하세요.'); history.back();</script>");
		    }
	
	   }
	
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	      String action = request.getParameter("action");
	
	      if ("Roomdelete".equals(action)) {
	         String fResNo = request.getParameter("r_res_no");
	         System.out.println(fResNo);
	         int result1 = serviceresService.deleteService(fResNo);
	         
	         int result = reserService.deleteRes(fResNo);
	         
	         if(result1 > 0) {
	        	 if (result > 0) {
	 	            response.getWriter().write(
	 	                  "<script>alert('예약이 취소되었습니다.'); location.href='/MyPage.jsp';</script>");
	 	         } else {
	 	            response.getWriter().write("<script>alert('예약 취소가 실패하였습니다.'); history.back();</script>");
	 	         }
	         } else {
	        	 response.getWriter().write("<script>alert('예약 취소가 실패하였습니다.'); history.back();</script>");
	         }
	
	        
	
	         response.setContentType("text/html; charset=UTF-8");
	         response.setCharacterEncoding("UTF-8");
	
	    
	      }
	
	   }
	}
