package com.Hotel.controller.Coupon;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.Hotel.dao.Coupon.CouponDaoImpl;
import com.Hotel.dao.Coupon.ICouponDao;
import com.Hotel.dao.member.MyPageDaoImpl;
import com.Hotel.vo.CouponVO;
import com.Hotel.vo.MemberVO;

@WebServlet("/myCoupon")
public class MyCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        MemberVO loggedInMember = (MemberVO) session.getAttribute("loginCode");
        
        if (loggedInMember != null) {
            // 세션에서 mem_id 가져오기
            String mem_id = loggedInMember.getMem_id();

            // DAO를 통해 memberInfo 쿼리 호출
            ICouponDao dao = CouponDaoImpl.getInstance();
            List<CouponVO> mycoupons = dao.myCoupon(mem_id);
            
            request.setAttribute("mycoupons", mycoupons);
            request.getRequestDispatcher("/jsp/Coupons.jsp").forward(request, response);
        } else {
			response.sendRedirect(request.getContextPath() + "/Mypage.jsp");
		}
		
	}
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


}
