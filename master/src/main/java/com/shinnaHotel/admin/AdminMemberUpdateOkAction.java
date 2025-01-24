package com.shinnaHotel.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.AdminDAO;
import com.shinnaHotel.DTO.UsersDTO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class AdminMemberUpdateOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		AdminDAO adao = new AdminDAO();
		UsersDTO udto = new UsersDTO();

		String u_id = req.getParameter("u_id");
		String u_name = req.getParameter("name" + u_id);
		String u_password = req.getParameter("password" + u_id);
		String u_phone = req.getParameter("phone" + u_id);
		String u_email = req.getParameter("email" + u_id);
		String u_status = req.getParameter("status" + u_id);

		
		udto.setU_name(u_name);
		udto.setU_id(u_id);
		udto.setU_password(u_password);
		udto.setU_email(u_email);
		udto.setU_phone(u_phone);
		udto.setU_status(u_status);

		System.out.println(u_id);
		System.out.println(u_name);
		System.out.println(u_password);
		System.out.println(u_phone);
		System.out.println(u_email);
		System.out.println(u_status);

		if (adao.updateMemberOk(udto)) {
			System.out.println("액션도착");
			forward.setRedirect(true);
			forward.setPath("/admin/AdminMemberList.ad");
		}

		return forward;
	}

}
