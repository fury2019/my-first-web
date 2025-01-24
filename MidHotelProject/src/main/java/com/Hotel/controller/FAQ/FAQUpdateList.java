package com.Hotel.controller.FAQ;

import java.io.IOException;
import java.util.List;

import com.Hotel.service.FAQ.FAQServiceImpl;
import com.Hotel.service.FAQ.IFAQService;
import com.Hotel.vo.FAQVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/faqUpdateList")
public class FAQUpdateList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IFAQService service = FAQServiceImpl.getInstance();
		
		List<FAQVO> faqList = service.getAllFAQ();
		
		request.setAttribute("faqList", faqList);
	
		request.getRequestDispatcher("/jsp/FAQUpdateList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
