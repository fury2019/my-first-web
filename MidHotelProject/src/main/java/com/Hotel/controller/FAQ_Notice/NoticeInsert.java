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

@WebServlet("/noticeInsert")
public class NoticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	    NoticeVO noticeVo = new NoticeVO();
	    noticeVo.setNotice_title(request.getParameter("notice_title"));
	    noticeVo.setNotice_content(request.getParameter("notice_content"));
	    noticeVo.setClass_id(request.getParameter("class_id"));

	    INoticeService service = NoticeServiceImpl.getInstance();
	    int result = service.insertNotice(noticeVo);

	    response.setContentType("text/html; charset=UTF-8");
        if (result > 0) {
            // JavaScript를 사용해 알림 출력 후 리다이렉트
            response.getWriter().println("<script>");
            response.getWriter().println("alert('새글 등록이 성공적으로 완료되었습니다.');");
            response.getWriter().println("location.href='" + request.getContextPath() + "/AdminPage.jsp?redirect=noticeList';");
            response.getWriter().println("</script>");
        } else {
            response.getWriter().println("<script>");
            response.getWriter().println("alert('새글 등록에 실패하였습니다.');");
            response.getWriter().println("location.href='" + request.getContextPath() + "/AdminPage.jsp';");
            response.getWriter().println("</script>");
        }
	
	}

}
