package com.Hotel.controller.facilities;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.Hotel.service.facilities.Fac_reserServiceImpl;
import com.Hotel.service.facilities.IFac_reserService;
import com.Hotel.vo.Facilities_ReservationVO;
import com.Hotel.vo.MemberVO;

	@WebServlet("/facilitiesResList")
	public class FacilitiesResList extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	   private IFac_reserService facservice;
	
	   public FacilitiesResList() {
	      super();
	      facservice = Fac_reserServiceImpl.getInstance();
	   }
	
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
		   
		   HttpSession session = request.getSession();
			MemberVO loggedInMember = (MemberVO) session.getAttribute("loginCode");      
			String mem_id = loggedInMember.getMem_id();
			String grade = loggedInMember.getGrade_no();
			
	      if ("Admin".equals(grade)) {
	         // 모든 예약 정보 조회
	         List<Facilities_ReservationVO> reservations = facservice.selectAllFacRes();
	         request.setAttribute("reservationAlls", reservations);
	         request.getRequestDispatcher("/jsp/AllReservations.jsp").forward(request, response);
	         
	      } else {
	    	  
	         // 특정 회원의 예약 정보 조회
	         List<Facilities_ReservationVO> reservations = facservice.selectFacRes(mem_id);
	         request.setAttribute("reservationMembers", reservations);
	         request.getRequestDispatcher("/jsp/MemberReservations.jsp").forward(request, response);
	      }
	
	   }
	   
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	      String action = request.getParameter("action");
	
	        if ("delete".equals(action)) {
	            // 예약 정보 삭제
	            String fResNo = request.getParameter("f_res_no");
	            
	            int result = facservice.deleteFacRes(fResNo);
	            
	            
	            // 응답 헤더 설정
	            response.setContentType("text/html; charset=UTF-8");
	            response.setCharacterEncoding("UTF-8");
	
	            if (result > 0) {
	            response.getWriter().write(
	                  "<script>alert('예약이 취소되었습니다.'); location.href='/MyPage.jsp';</script>");
	         } else {
	            response.getWriter().write("<script>alert('예약 취소가 실패하였습니다.'); history.back();</script>");
	         }
	        }
	    }
	}
	

