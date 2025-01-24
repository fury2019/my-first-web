package com.Hotel.controller.FAQ_Notice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.Hotel.service.FAQ.FAQServiceImpl;
import com.Hotel.service.FAQ.IFAQService;
import com.Hotel.service.FAQ.INoticeService;
import com.Hotel.service.FAQ.NoticeServiceImpl;
import com.Hotel.vo.FAQVO;
import com.Hotel.vo.NoticeVO;

@WebServlet("/noticeUpdate")
public class NoticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String noticeNo = request.getParameter("notice_no");
		System.out.println("notice 번호: " + noticeNo);

				
		INoticeService service = NoticeServiceImpl.getInstance();
		NoticeVO NoticeVo = service.getNotice(noticeNo);

		if (NoticeVo == null) {
	        request.setAttribute("errorMsg", "공지사항 정보를 불러올 수 없습니다.");
	    } else {
	        request.setAttribute("noticeVo", NoticeVo);
	    }
		
//		request.setAttribute("faqVo", faqVo);
		request.getRequestDispatcher("/jsp/NoticeUpdate.jsp")
		.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String noticeNo = request.getParameter("notice_no");
		String noticeTitle = request.getParameter("notice_title");
		String noticeContent = request.getParameter("notice_content");
		
		NoticeVO noticeVo = new NoticeVO();
		noticeVo.setNotice_no(noticeNo);
		noticeVo.setNotice_title(noticeTitle);
		noticeVo.setNotice_content(noticeContent);
		
		INoticeService service = NoticeServiceImpl.getInstance();
		service.updateNotice(noticeVo);
		
		response.sendRedirect(request.getContextPath() + "/AdminPage.jsp?redirect=noticeList");
    }

}
