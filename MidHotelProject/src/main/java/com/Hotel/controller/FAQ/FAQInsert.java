package com.Hotel.controller.FAQ;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.Hotel.service.FAQ.FAQServiceImpl;
import com.Hotel.service.FAQ.IFAQService;
import com.Hotel.vo.FAQVO;

@WebServlet("/faqInsert")
public class FAQInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	    FAQVO faqVo = new FAQVO();
	    faqVo.setFaq_title(request.getParameter("faq_title"));
        faqVo.setFaq_content(request.getParameter("faq_content"));
        faqVo.setClass_id(request.getParameter("class_id"));

	    IFAQService service = FAQServiceImpl.getInstance();
	    int result = service.insertFAQ(faqVo);

	    response.setContentType("text/html; charset=UTF-8");
        if (result > 0) {
            // JavaScript를 사용해 알림 출력 후 리다이렉트
            response.getWriter().println("<script>");
            response.getWriter().println("alert('새글 등록이 성공적으로 완료되었습니다.');");
            response.getWriter().println("location.href='" + request.getContextPath() + "/AdminPage.jsp?redirect=faqList';");
            response.getWriter().println("</script>");
        } else {
            response.getWriter().println("<script>");
            response.getWriter().println("alert('새글 등록에 실패하였습니다.');");
            response.getWriter().println("location.href='" + request.getContextPath() + "/AdminPage.jsp';");
            response.getWriter().println("</script>");
        }
	
	}

}
