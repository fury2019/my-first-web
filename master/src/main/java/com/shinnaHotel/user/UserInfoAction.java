package com.shinnaHotel.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinnaHotel.DAO.UsersDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class UserInfoAction implements Action{

	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		UsersDAO udao = new UsersDAO();
		
		HttpSession session = req.getSession();
		String u_id = (String)session.getAttribute("u_id");
		
		
		System.out.println("로그인세션id : " + u_id);
		
		req.setAttribute("userInfo", udao.getInfo(u_id));
		
		forward.setRedirect(false);
		forward.setPath("../login/myinfo.jsp");
		
		return forward;
	}
}
