package com.shinnaHotel.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shinnaHotel.DAO.AdminDAO;
import com.shinnaHotel.DAO.FilesDAO;
import com.shinnaHotel.DTO.RoomDTO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class AdminRoomAddOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		AdminDAO adao = new AdminDAO();
		RoomDTO rdto = new RoomDTO();
		FilesDAO fdao = new FilesDAO();
		
		
		MultipartRequest multi = null;
		
		String savaFolder = "C:\\Users\\user\\Desktop\\이클립스\\master\\src\\main\\webapp\\upload";
		int fileSize = 1024 * 1024 * 5; // 5M
		
		try {
			// req, 경로, 파일의 크기, 인코딩방식, 정책
			multi = new MultipartRequest(req, savaFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		rdto.setR_type(multi.getParameter("r_type"));
		rdto.setR_capacity(Integer.parseInt( multi.getParameter("r_capacity")));
		rdto.setR_price(Integer.parseInt( multi.getParameter("r_price") ));
		rdto.setR_img(multi.getParameter("imgName"));
		
		
		adao.insertRoom(rdto);
		fdao.insertFile(multi, adao.getSeq());

	
		forward.setRedirect(true);
		forward.setPath(req.getContextPath() + "/admin/AdminRoomList.ad" );
		

		return forward;
	}

}
