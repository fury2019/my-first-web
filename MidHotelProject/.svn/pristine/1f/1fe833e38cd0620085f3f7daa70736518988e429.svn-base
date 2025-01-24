package com.Hotel.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.Hotel.dao.member.MemberUpdateDaoImpl;
import com.Hotel.dao.member.MyPageDaoImpl;
import com.Hotel.service.member.IMemberUpdateService;
import com.Hotel.service.member.IMyPageService;
import com.Hotel.service.member.MemberUpdateServiceImpl;
import com.Hotel.vo.MemberVO;

@WebServlet("/memberUpdatePw")
public class MemberUpdatePw extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberUpdateServiceImpl memUpdate = new MemberUpdateServiceImpl();	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        request.getRequestDispatcher("/jsp/include/PWTest.jsp").forward(request, response);
       
        
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		// 세션에서 저장된 비밀번호 가져오기
	    HttpSession session2 = request.getSession();
	    MemberVO memVo2 = (MemberVO) session2.getAttribute("loginCode");

	    // 세션 비밀번호 확인
	    String memPw = memVo2 != null ? memVo2.getMem_pw() : null;

	    // 사용자가 입력한 비밀번호 가져오기
	    String inPw = request.getParameter("password");
	    
	    String result = "{ \"result\" : \"fail\" }";
	    if(memPw.equals(inPw)) {
	    	result = "{ \"result\" : \"ok\" }";
	    }
	    response.getWriter().write(result);
	    response.flushBuffer();

    }
	
	
	


}
