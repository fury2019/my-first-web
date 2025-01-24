package com.Hotel.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Hotel.service.admin.CouponDeleteServiceImpl;
import com.Hotel.vo.CouponVO;

@WebServlet("/couponAllView")
public class CouponAllView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CouponDeleteServiceImpl service = new CouponDeleteServiceImpl();
		List<CouponVO> couponList = service.viewAllCoupon();
		
		request.setAttribute("couponList", couponList);
		
		request.getRequestDispatcher("/jsp/CouponAllView.jsp").forward(request, response);
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
