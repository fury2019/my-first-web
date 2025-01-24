package com.Hotel.controller.FAQ_Notice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Hotel.service.FAQ.FAQServiceImpl;
import com.Hotel.service.FAQ.IFAQService;
import com.Hotel.service.FAQ.INoticeService;
import com.Hotel.service.FAQ.NoticeServiceImpl;
import com.Hotel.vo.FAQVO;
import com.Hotel.vo.NoticeVO;

@WebServlet("/noticeClassList")
public class NoticeClassList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String class_id = request.getParameter("category");

        INoticeService service = NoticeServiceImpl.getInstance();

        // 카테고리에 따라 필터링
        List<NoticeVO> noticeList;
        if ("all".equals(class_id)) {
        	noticeList = service.getAllNotice(); // 전체 목록
        } else {
        	noticeList = service.getClassNotice(class_id); // 특정 카테고리 목록
        }

        request.setAttribute("noticeList", noticeList);

        // FAQList.jsp로 전달
        request.getRequestDispatcher("/jsp/NoticeList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
