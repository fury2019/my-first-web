package com.Hotel.controller.CustomerInquiry;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Hotel.service.CustomerInquiry.CustomerServiceImpl;
import com.Hotel.service.CustomerInquiry.ICustomerService;
import com.Hotel.vo.HotelVO;

@WebServlet("/customerList.do")
public class CustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICustomerService service = CustomerServiceImpl.getInstance();
		
		List<HotelVO> hotelList = service.getAllHotel();
		
		request.setAttribute("hotelList", hotelList);
		
		request.getRequestDispatcher("/CustomerInquiry.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
