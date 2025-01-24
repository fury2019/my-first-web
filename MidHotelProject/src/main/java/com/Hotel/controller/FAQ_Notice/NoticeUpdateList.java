package com.Hotel.controller.FAQ_Notice;

import java.io.IOException;
import java.util.List;

import com.Hotel.service.FAQ.FAQServiceImpl;
import com.Hotel.service.FAQ.IFAQService;
import com.Hotel.service.FAQ.INoticeService;
import com.Hotel.service.FAQ.NoticeServiceImpl;
import com.Hotel.vo.FAQVO;
import com.Hotel.vo.NoticeVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/noticeUpdateList")
public class NoticeUpdateList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		INoticeService service = NoticeServiceImpl.getInstance();
		
		List<NoticeVO> noticeList = service.getAllNotice();
		
		request.setAttribute("noticeList", noticeList);
	
		request.getRequestDispatcher("/jsp/NoticeUpdateList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
