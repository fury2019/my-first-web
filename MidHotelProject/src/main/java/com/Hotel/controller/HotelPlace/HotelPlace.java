package com.Hotel.controller.HotelPlace;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Hotel.service.HotelPlace.HotelPlaceServiceImpl;
import com.Hotel.service.HotelPlace.IHotelPlaceService;
import com.Hotel.vo.Hotel_PlaceVO;


@WebServlet("/HotelPlace")
public class HotelPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
//    HotelPlaceServiceImpl service = HotelPlaceServiceImpl.getInstance();
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IHotelPlaceService service = HotelPlaceServiceImpl.getInstance();
		
		List<Hotel_PlaceVO> HPlace = service.getAllPlace();
		
		request.setAttribute("HPlace", HPlace); 
		request.getRequestDispatcher("/jsp/HotelPlace.jsp").forward(request, response);
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
