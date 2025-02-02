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

@WebServlet("/faqUpdate")
public class FAQUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String faqNo = request.getParameter("faq_no");
		System.out.println("FAQ 번호: " + faqNo);

				
		IFAQService service = FAQServiceImpl.getInstance();
		FAQVO faqVo = service.getFAQ(faqNo);

		if (faqVo == null) {
	        request.setAttribute("errorMsg", "FAQ 정보를 불러올 수 없습니다.");
	    } else {
	        request.setAttribute("faqVo", faqVo);
	    }
		
//		request.setAttribute("faqVo", faqVo);
		request.getRequestDispatcher("/jsp/FAQUpdate.jsp")
		.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String faqNo = request.getParameter("faq_no");
		String faqTitle = request.getParameter("faq_title");
		String faqContent = request.getParameter("faq_content");
		
		FAQVO faqVo = new FAQVO();
		faqVo.setFaq_no(faqNo);
		faqVo.setFaq_title(faqTitle);
		faqVo.setFaq_content(faqContent);
		
		IFAQService service = FAQServiceImpl.getInstance();
		service.updateFAQ(faqVo);
		
		response.sendRedirect(request.getContextPath() + "/AdminPage.jsp?redirect=faqList");
    }

}
