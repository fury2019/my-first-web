package com.Hotel.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Hotel.dao.admin.AdminMemDaoImpl;
import com.Hotel.vo.MemberVO;

@WebServlet("/viewAllMember")
public class ViewAllMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminMemDaoImpl dao = AdminMemDaoImpl.getInstance();
		
		List<MemberVO> memList = dao.getAllMembers();
		
		request.setAttribute("memList", memList);
        request.getRequestDispatcher("/jsp/MemList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
