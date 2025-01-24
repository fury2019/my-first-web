package com.shinnaHotel.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinnaHotel.DAO.UsersDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class UserWithdraw implements Action{
	
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		UsersDAO udao = new UsersDAO();
		
		HttpSession session = req.getSession();
		String u_id = (String)session.getAttribute("u_id");

		System.out.println("회원탈퇴 세션 id :" +u_id);
		forward.setRedirect(true);
		
		String exist = "";
		System.out.println("예약내역조회결과값 : " + exist);
		if (udao.withdrawSelect(u_id)) {
		exist = "true";
		forward.setPath("../login/withdraw.jsp");
		session.setAttribute("exist", exist);
		} else {
			exist = "false";
			forward.setPath("../login/withdraw.jsp");
			session.setAttribute("exist", exist);
		}
		System.out.println("초기화된 세션값 : " + exist);
		return forward;
	}

}
