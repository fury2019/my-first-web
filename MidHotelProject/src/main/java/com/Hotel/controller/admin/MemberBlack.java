package com.Hotel.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Hotel.dao.admin.AdminMemDaoImpl;
import com.Hotel.service.admin.AdminMemServiceImpl;
import com.Hotel.vo.MemberVO;

@WebServlet("/memberBlack")
public class MemberBlack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 회원 목록 조회
		AdminMemDaoImpl dao = AdminMemDaoImpl.getInstance();
		List<MemberVO> memList = dao.getAllMembers();
        
        // JSP로 데이터 전달
        request.setAttribute("memList", memList);
        request.getRequestDispatcher("/jsp/MemberBlack.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
	    String action = request.getParameter("action"); // 어떤 동작인지 구분

	    AdminMemDaoImpl dao = AdminMemDaoImpl.getInstance();
	    boolean isUpdated = false;

	    if ("blacklist".equals(action)) {
	        isUpdated = dao.memberBlack(mem_id); // 블랙리스트 처리
	    } else if ("revert".equals(action)) {
	        isUpdated = dao.memberRevert(mem_id); // 일반 상태로 되돌리기
	    }
	    
//	    response.setContentType("text/html; charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
	    
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");

	    if (isUpdated) {
	        response.getWriter().write("{\"status\": \"success\"}");
	    } else {
	        response.getWriter().write("{\"status\": \"failure\"}");
	    }
	    }
	}


