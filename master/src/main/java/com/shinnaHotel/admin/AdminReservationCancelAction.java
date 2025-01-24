package com.shinnaHotel.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shinnaHotel.DAO.AdminDAO;
import com.shinnaHotel.DTO.ResCancelDTO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class AdminReservationCancelAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		AdminDAO adao = new AdminDAO();
		ResCancelDTO rcdto = new ResCancelDTO();

		int res_number = Integer.parseInt(req.getParameter("res_number"));


		System.out.println(res_number);
		
		System.out.println(req.getParameter("u_id"));
		System.out.println(req.getParameter("res_checkin"));
		System.out.println(req.getParameter("res_checkout"));
		System.out.println(req.getParameter("res_rtype"));
		System.out.println(Integer.parseInt(req.getParameter("res_price")));


		rcdto.setRes_number(res_number);	
		rcdto.setU_id(req.getParameter("u_id"));
		rcdto.setRes_checkin(req.getParameter("res_checkin"));
		rcdto.setRes_checkout(req.getParameter("res_checkout"));
		rcdto.setRes_rtype(req.getParameter("res_rtype"));
		rcdto.setRes_price(Integer.parseInt(req.getParameter("res_price")));

		// 예약 취소테이블 insert
		if (adao.insertResCancel(rcdto)) {
			// 예약테이블 delete
			adao.updateReservation(res_number);
			forward.setRedirect(false);
			forward.setPath(req.getContextPath() + "/admin/AdminReservationList.ad");
		}

		return forward;
	}

}
