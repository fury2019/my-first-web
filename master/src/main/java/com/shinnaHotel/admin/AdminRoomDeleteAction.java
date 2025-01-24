package com.shinnaHotel.admin;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;

import com.shinnaHotel.DAO.AdminDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class AdminRoomDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		AdminDAO adao = new AdminDAO();

		int r_id = Integer.parseInt(req.getParameter("r_id"));

		try {
			if (adao.deleteRoom(r_id)) {
//			삭제 성공시 객실 정보 페이지 이동

				forward.setRedirect(true);
				forward.setPath(req.getContextPath() + "/admin/AdminRoomList.ad");
			}
		} catch (PersistenceException e) {
//			삭제 실패시 상세보기 페이지 이동

			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/admin/AdminRoomView.ad?r_id=" + r_id);
			e.printStackTrace();
		}

		return forward;
	}

}
