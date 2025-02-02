package com.Hotel.controller.facilities;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.Hotel.service.facilities.Fac_reserServiceImpl;
import com.Hotel.service.facilities.IFac_reserService;
import com.Hotel.vo.hotel_fac_catVO;



@WebServlet("/FacResServlet")
public class FacResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IFac_reserService facResService;

	public FacResServlet() {
		super();
		facResService = Fac_reserServiceImpl.getInstance(); 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String hotelId = request.getParameter("hotel_id");
		String room = request.getParameter("type");
		
		System.out.println("FacResServlet.. get room =" + room);
		request.setAttribute("type", room);
		
		List<hotel_fac_catVO> allDining = facResService.gethotelDining(hotelId);
		request.setAttribute("dining", allDining);
		//jsp로 포워딩
		request.getRequestDispatcher("/jsp/FacilitiesReservation.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 호텔 id를 파라미터로 받아 검색
        String hotelId = request.getParameter("hotel_id");
        String room = request.getParameter("type");
		
		System.out.println("FacResServlet.. post room =" + room);
		request.setAttribute("type", room);

        List<hotel_fac_catVO> hotels = facResService.gethotelDining(hotelId);
        
        
        // 검색된 결과를 JSP로 전달
        request.setAttribute("searchedHotels", hotels);

        // JSP로 포워딩
        request.getRequestDispatcher("/jsp/FacilitiesReservation.jsp").forward(request, response);
		
		
	}

}
