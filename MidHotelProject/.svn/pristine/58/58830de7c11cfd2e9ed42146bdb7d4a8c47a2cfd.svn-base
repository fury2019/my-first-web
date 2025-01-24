package com.Hotel.controller.Coupon;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.Hotel.service.Coupon.CouponService;
import com.Hotel.vo.CouponVO;
import com.Hotel.vo.MemberVO;

@WebServlet("/memberCoupon")
public class MemberCoupon extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        MemberVO loggedInMember = (MemberVO) session.getAttribute("loginCode");

        if (loggedInMember == null) {
            response.sendRedirect(request.getContextPath() + "/jsp/Login.jsp");
            return;
        }

        CouponService couponService = new CouponService();
        List<CouponVO> couponList = couponService.getAvailableCoupons(loggedInMember.getMem_id());

        // 쿠폰 정보를 세션에 저장
        session.setAttribute("CouponList", couponList);

        request.getRequestDispatcher("/jsp/YourPaymentPage.jsp").forward(request, response);
    }
}

