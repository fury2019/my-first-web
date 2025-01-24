package com.Hotel.controller.FAQ;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Hotel.service.FAQ.FAQServiceImpl;
import com.Hotel.service.FAQ.IFAQService;
import com.Hotel.vo.FAQVO;

@WebServlet("/faqClassList")
public class FaqClassList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String class_id = request.getParameter("category");

        IFAQService service = FAQServiceImpl.getInstance();

        // 카테고리에 따라 필터링
        List<FAQVO> faqList;
        if ("all".equals(class_id)) {
            faqList = service.getAllFAQ(); // 전체 목록
        } else {
            faqList = service.getClassFAQ(class_id); // 특정 카테고리 목록
        }

        request.setAttribute("faqList", faqList);

        // FAQList.jsp로 전달
        request.getRequestDispatcher("/jsp/FAQList.jsp").forward(request, response);
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
