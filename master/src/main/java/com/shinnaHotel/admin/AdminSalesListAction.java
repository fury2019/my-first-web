package com.shinnaHotel.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.AdminDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class AdminSalesListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		AdminDAO adao = new AdminDAO();
		
		int totalCnt = adao.getSalesCnt();
		
		req.setAttribute("salesList", adao.getSalesList());
		req.setAttribute("totalCnt", totalCnt);

		System.out.println("액션도착");
		forward.setRedirect(false);
		forward.setPath("/admin/sales.jsp" );
		return forward;
	}

}
