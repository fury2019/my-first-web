package com.Hotel.controller.HotelNearbySpots;

import java.io.IOException;
import java.util.List;

import com.Hotel.service.HotelNearbySpots.HotelNearbySpotsService;
import com.Hotel.service.HotelNearbySpots.IHotelNearbySpotsService;
import com.Hotel.vo.HotelVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HotelList")
public class HotelList extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		IHotelNearbySpotsService service = HotelNearbySpotsService.getInstance();
    		
    		List<HotelVO> hotelList = service.getAllHotels();
    		
    		request.setAttribute("hotelList", hotelList);
    	
    		request.getRequestDispatcher("/jsp/hotelList.jsp").forward(request, response);
    		
    	}

    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		doGet(request, response);
    	}

    }
