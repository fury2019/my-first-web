package com.Hotel.controller.reservation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.Hotel.service.hotel.HotelFindServiceImpl;
import com.Hotel.service.hotel.IHotelFindService;
import com.Hotel.vo.HotelVO;


@WebServlet("/roomResultServlet")
public class RoomResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IHotelFindService hotelFindService;   
   
	
	
    public RoomResultServlet() {
        super();
        hotelFindService = HotelFindServiceImpl.getInstance();
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> allRegions = hotelFindService.LocalSearch();
		List<HotelVO> allHotelNames = hotelFindService.getAllHotelNames();
		String room = request.getParameter("type");
		
		HttpSession session = request.getSession();
		session.setAttribute("regions", allRegions);
		session.setAttribute("hotels", allHotelNames);
		System.out.println("RoomResultServlet.. get room =" + room);
		request.setAttribute("type", room);
		
		//jsp로 포워딩
		if(room.equals("room")) {
			request.getRequestDispatcher("/jsp/Reservation.jsp").forward(request, response);
		} 
		else if(room.equals("fac")) {
			request.getRequestDispatcher("/jsp/FacilitiesReservation.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 호텔 주소를 파라미터로 받아 검색
        String hotel_addr = request.getParameter("hotel_addr");
        
        List<HotelVO> hotels = hotelFindService.searchHotelAddr(hotel_addr);
        String room = request.getParameter("type");

        System.out.println("RoomResultServlet.. post room =" + room);
		request.setAttribute("type", room);
        // 검색된 결과를 JSP로 전달
        request.setAttribute("searchedHotels", hotels);

        if(room.equals("room")) {
			request.getRequestDispatcher("/jsp/Reservation.jsp").forward(request, response);
		} 
		else if(room.equals("fac")) {
			request.getRequestDispatcher("/jsp/FacilitiesReservation.jsp").forward(request, response);
		}
	}

}
