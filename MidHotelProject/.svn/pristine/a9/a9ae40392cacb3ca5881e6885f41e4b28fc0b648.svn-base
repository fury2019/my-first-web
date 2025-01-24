package com.Hotel.controller.FAQ;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.Hotel.service.FAQ.FAQServiceImpl;
import com.Hotel.service.FAQ.IFAQService;
import com.Hotel.vo.FAQVO;

@WebServlet("/faqDelete")
public class FAQDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

        String faqNos = request.getParameter("faq_no");
        IFAQService service = FAQServiceImpl.getInstance();

        if (faqNos != null) {
        	service.deleteFAQ(faqNos);
            response.getWriter().write("success");
            
        } else {
            response.getWriter().write("failure");
        }
	}
}
