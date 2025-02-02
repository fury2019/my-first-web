package com.Hotel.controller.reservation;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.Hotel.service.reservation.IRoom_PayService;
import com.Hotel.service.reservation.Room_PayServiceImpl;
import com.Hotel.vo.MemberVO;


@WebServlet("/RoomPayment")
public class RoomPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoom_PayService payService;
	
	public RoomPayment() {
		super();
		payService = Room_PayServiceImpl.getInstance();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션에서 사용자 ID 가져오기
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginCode");
		String userId = (loginUser != null) ? loginUser.getMem_id() : null;
	
		if(userId == null) {
			response.sendRedirect("/jsp/Login.jsp");
			return;
		}
//		String r_res_no = 
		int p_use_point = Integer.parseInt(request.getParameter("p_Use_Point")); 
		String coupon_no = request.getParameter("couponNo"); 
		int p_earn_point = Integer.parseInt(request.getParameter("p_Earn_Point")); 
		int p_tot_price = Integer.parseInt(request.getParameter("p_Tot_Price")); 
		int p_price = Integer.parseInt(request.getParameter("pPrice")); 
		String p_date = request.getParameter("pDate");
	} // 결제 정보를 파라미터로 받기 
}


