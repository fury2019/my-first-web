package com.shinnaHotel.user;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinnaHotel.DAO.UsersDAO;

import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class UserLoginOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		UsersDAO udao = new UsersDAO();
		
		List<String> user = new ArrayList();

		String u_id = req.getParameter("u_id");
		String u_password = req.getParameter("u_password");
		
		user.add(u_id);
		user.add(u_password);
		
		System.out.println(u_id);
		System.out.println(u_password);
	
		if(udao.login(u_id, u_password)) {
			// 로그인 성공
			HttpSession session = req.getSession();
            session.setAttribute("u_id", u_id);
			System.out.println("성공");
			forward.setRedirect(false);
			forward.setPath("/login/index.jsp");
			
		} else {
			// 로그인 실패
			System.out.println("실패");
			forward.setRedirect(false);
			forward.setPath("/login/login.jsp?flag=false");
		}
		
		return forward;
	}
	
}
