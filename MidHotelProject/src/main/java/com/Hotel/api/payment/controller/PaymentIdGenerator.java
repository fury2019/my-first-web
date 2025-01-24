package com.Hotel.api.payment.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

import com.Hotel.vo.MemberVO;

@WebServlet("/generatePaymentId")
public class PaymentIdGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paymentId = "TC0ONETIME-" + UUID.randomUUID().toString();
		MemberVO memvo = new MemberVO();
		
		memvo.getMem_id();
		memvo.getMem_tel();
		memvo.getMem_name();
		
		
//		String customerId = 		// 고객 id(로그인한 사용자 정보)
		

		response.setContentType("application/json");
		response.getWriter().write("{\"paymentId\": \"" + paymentId + "\"}");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
