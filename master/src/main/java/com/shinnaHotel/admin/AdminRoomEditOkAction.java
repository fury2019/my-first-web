package com.shinnaHotel.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.AdminDAO;
import com.shinnaHotel.DTO.RoomDTO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class AdminRoomEditOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		AdminDAO adao = new AdminDAO();
		
		int r_id = Integer.parseInt( req.getParameter("r_id") );

		RoomDTO rdto = new RoomDTO();
		rdto.setR_id(r_id);
		rdto.setR_type(req.getParameter("r_type"));
		rdto.setR_capacity(Integer.parseInt( req.getParameter("r_capacity")));
		rdto.setR_price(Integer.parseInt( req.getParameter("r_price") ));
		rdto.setR_img(req.getParameter("r_img"));
		
		if(adao.updateRoom(rdto)) {
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/admin/AdminRoomView.ad?r_id=" + r_id);
		}
		return forward; 
		
	}


}
