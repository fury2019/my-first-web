package com.shinnaHotel.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinnaHotel.DAO.UsersDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class UserWithdrawOkAction implements Action{
	
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		UsersDAO udao = new UsersDAO();
		
		HttpSession session = req.getSession();
		String u_id = (String)session.getAttribute("u_id");
		
		System.out.println("회원탈퇴확인 세션 id : " + u_id);
		
		forward.setRedirect(true);
		
		if(udao.withdrawOkupdate(u_id)){
			session.invalidate();
			forward.setPath("../login/index.jsp");
		}
		
		
		return forward;
	}

}
