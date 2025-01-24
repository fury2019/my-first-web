package com.Hotel.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.Hotel.dao.admin.CouponDeleteDaoImpl;
import com.Hotel.service.admin.CouponDeleteServiceImpl;

@WebServlet("/deleteCoupon")
public class DeleteCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CouponDeleteDaoImpl dao = CouponDeleteDaoImpl.getInstance();
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");

	        try {
	            int couponId = Integer.parseInt(request.getParameter("couponId"));
	            boolean isDeleted = dao.deleteCoupon(couponId);

	            if (isDeleted) {
	                response.getWriter().write("{\"status\": \"success\", \"message\": \"쿠폰이 삭제되었습니다.\"}");
	            } else {
	                response.getWriter().write("{\"status\": \"error\", \"message\": \"쿠폰 삭제 실패.\"}");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().write("{\"status\": \"error\", \"message\": \"서버 오류 발생.\"}");
	        }
	    
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
