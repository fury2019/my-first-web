package com.Hotel.controller.FAQ_Notice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Hotel.service.FAQ.INoticeService;
import com.Hotel.service.FAQ.NoticeServiceImpl;
import com.Hotel.vo.NoticeVO;

@WebServlet("/noticeList")
public class NoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		INoticeService service = NoticeServiceImpl.getInstance();
	
		List<NoticeVO> noticeList = service.getAllNotice();
		
		request.setAttribute("noticeList", noticeList);
		
		request.getRequestDispatcher("/jsp/NoticeList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
