package com.Hotel.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.Hotel.service.admin.CouponInsertServiceImpl;
import com.Hotel.vo.CouponVO;

@WebServlet("/insertCoupon")
public class InsertCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CouponVO coupon = new CouponVO();
		coupon.setCoupon_name(request.getParameter("coupon_name"));
		coupon.setCoupon_comment(request.getParameter("coupon_comment"));
		coupon.setCoupon_percent(request.getParameter("coupon_percent"));
		coupon.setMem_id(request.getParameter("mem_id"));

		// 서비스 호출
		CouponInsertServiceImpl service = CouponInsertServiceImpl.getInstance();
		int result = service.insertCoupon(coupon);
		
		response.setContentType("text/html; charset=UTF-8");
		if (result > 0) {
            // JavaScript를 사용해 알림 출력 후 리다이렉트
            response.getWriter().println("<script>");
            response.getWriter().println("alert('쿠폰 발송이 성공적으로 완료되었습니다.');");
            response.getWriter().println("location.href='" + request.getContextPath() + "/AdminPage.jsp?redirect=couponInsert';");
            response.getWriter().println("</script>");
        } else {
            response.getWriter().println("<script>");
            response.getWriter().println("alert('쿠폰 발송에 실패하였습니다.');");
            response.getWriter().println("location.href='" + request.getContextPath() + "/AdminPage.jsp';");
            response.getWriter().println("</script>");
        }
	}

}
