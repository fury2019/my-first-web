package com.Hotel.controller.Goods_Payment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/paymentComplete")
public class Goods_PaymentComplete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String impUid = request.getParameter("imp_uid");
        String merchantUid = request.getParameter("merchant_uid");

        // IAMPORT API를 호출하여 결제 정보를 확인하는 로직
        // 필요한 경우 데이터베이스에 결제 정보를 저장

        // JSON 형식으로 응답 반환
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("{\"success\": true}"); // 또는 실패 시 false 반환
        out.flush();
    }
}

