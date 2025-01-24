package com.shinnaHotel.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.UsersDAO;
import com.shinnaHotel.DTO.UsersDTO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class UserJoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		UsersDAO udao = new UsersDAO();
		
		String u_name = req.getParameter("u_name");
		String u_id = req.getParameter("u_id");
		String u_password = req.getParameter("u_password");
		String u_phone = req.getParameter("u_phone");
		String u_email = req.getParameter("u_email");
		
		UsersDTO userdto = new UsersDTO();
		userdto.setU_name(u_name);
		userdto.setU_id(u_id);
		userdto.setU_password(u_password);
		userdto.setU_phone(u_phone);
		userdto.setU_email(u_email);
		
		// 가입 성공 여부
		forward.setRedirect(true);
		
		if(udao.insertUsers(userdto)) {
			// 성공시

			forward.setPath("/login/login.jsp");
		} else {
			// 실패시
			forward.setPath("/join/join.jsp");
		}
		
		return forward;
	}
}		


