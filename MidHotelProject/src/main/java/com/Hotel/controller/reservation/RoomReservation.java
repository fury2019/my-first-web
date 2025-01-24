package com.Hotel.controller.reservation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/roomReservation")
public class RoomReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 폼 데이터 읽기
        String hotelId = request.getParameter("hotelId");
        String hotelName = request.getParameter("hotelName");
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");
        int adultCount = Integer.parseInt(request.getParameter("adultCount"));
        int childCount = Integer.parseInt(request.getParameter("childCount"));
        int kidsCount = Integer.parseInt(request.getParameter("kidsCount"));
        String roomType = request.getParameter("roomType");
        String bedType = request.getParameter("bedType");
        String price = request.getParameter("price");

        // 예약 처리 로직 추가
        // 예약 정보를 데이터베이스에 저장하거나 비즈니스 로직 수행

        // 결과를 새로운 페이지로 전달
        request.setAttribute("hotelName", hotelName);
        request.setAttribute("checkInDate", checkInDate);
        request.setAttribute("checkOutDate", checkOutDate);
        request.setAttribute("roomType", roomType);
        request.setAttribute("bedType", bedType);
        request.setAttribute("price", price);

        // JSP로 포워딩
        request.getRequestDispatcher("/jsp/Reservation3.jsp").forward(request, response);
	}

}
