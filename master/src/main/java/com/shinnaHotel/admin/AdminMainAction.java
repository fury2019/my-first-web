package com.shinnaHotel.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.AdminDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class AdminMainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		AdminDAO adao = new AdminDAO();
		
		String u_id = (String)req.getAttribute("u_id");		

		// 월별 예약 수
		int ReCnt9 = adao.ReCnt9();
		int ReCnt10 = adao.ReCnt10();
		int ReCnt11 = adao.ReCnt11();
		int ReCnt12 = adao.ReCnt12();
		
		// 월별 매출액
		Integer ReSales9 = adao.ReSales9();
        Integer ReSales10 = adao.ReSales10();
        Integer ReSales11 = adao.ReSales11();
        Integer ReSales12 = adao.ReSales12();

		// 회원 내역
		req.setAttribute("adminList", adao.getAdminList());
		// 에약 내역
		req.setAttribute("adminReserveList", adao.getAdminReserveList(u_id));

		// 월별 예약 수		
		req.setAttribute("ReCnt9", ReCnt9);
		req.setAttribute("ReCnt10", ReCnt10);
		req.setAttribute("ReCnt11", ReCnt11);
		req.setAttribute("ReCnt12", ReCnt12);

		// 월별 매출액
		req.setAttribute("ReSales9", ReSales9);
		req.setAttribute("ReSales10", ReSales10);
		req.setAttribute("ReSales11", ReSales11);
		req.setAttribute("ReSales12", ReSales12);

		
		
		System.out.println("액션도착");
		forward.setRedirect(false);
		forward.setPath("/admin/admin.jsp" );
		return forward;
	}

}
