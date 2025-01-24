package com.Hotel.controller.facilities;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Hotel.service.facilities.Fac_reserServiceImpl;
import com.Hotel.service.facilities.IFac_reserService;
import com.Hotel.vo.hotel_fac_catVO;


//다이닝 검색 서블릿
@WebServlet("/facilitiesList")
public class FacilitiesList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static IFac_reserService service;
	
	public FacilitiesList() {
		service = Fac_reserServiceImpl.getInstance();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotelId = request.getParameter("hotel_id");
		String diningName = request.getParameter("dining_name");
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hotelId", hotelId);
		params.put("diningName", diningName);
		
		List<hotel_fac_catVO> diningList = service.getSearchDining(hotelId,diningName);
		
		request.setAttribute("diningList", diningList);
		
		request.getRequestDispatcher("/jsp/FacilitiesReservation.jsp").forward(request, response);
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
