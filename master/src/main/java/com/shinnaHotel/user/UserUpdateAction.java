package com.shinnaHotel.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.UsersDAO;
import com.shinnaHotel.DTO.UsersDTO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class UserUpdateAction implements Action{
	
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		UsersDAO udao = new UsersDAO();
		
		String u_id = req.getParameter("u_id");
		
		String u_name = req.getParameter("u_name");
		String u_password = req.getParameter("u_password");
		String u_phone = req.getParameter("u_phone");
		String u_email = req.getParameter("u_email");

		UsersDTO udto = new UsersDTO();
		
		udto.setU_id(u_id);
		udto.setU_name(u_name);
		udto.setU_password(u_password);
		udto.setU_phone(u_phone);
		udto.setU_email(u_email);
		
		forward.setRedirect(false);
		
		if(udao.userUpdate(udto)) {
			forward.setPath(req.getContextPath()+"/user/userInfo.us");
		}
		
		
		return forward;
	}

}
