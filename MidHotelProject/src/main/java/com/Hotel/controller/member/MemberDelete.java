package com.Hotel.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.Hotel.vo.MemberVO;

import com.Hotel.dao.member.MemberDeleteDaoImpl;
import com.Hotel.vo.MemberVO;
//
@WebServlet("/memberDelete")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 세션에서 ID 가져오기 (로그인 사용자)
		HttpSession session = request.getSession();
		MemberVO loggedInMember = (MemberVO) session.getAttribute("loginCode");      
		String mem_id = loggedInMember.getMem_id();
		MemberDeleteDaoImpl dao = new MemberDeleteDaoImpl();
		boolean isDeleted = dao.memberDelete(mem_id);
		
		 if (isDeleted) {
	            session.invalidate();
	            response.sendRedirect("/jsp/MemberDelete.jsp");
	        } else {
	            response.sendRedirect("/jsp/MemberDelete.jsp?error=invalidPassword");
	        }
	}

}
