package com.Hotel.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.Hotel.dao.member.MyPageDaoImpl;
import com.Hotel.service.member.IJoinLoginService;
import com.Hotel.service.member.JoinLoginServiceImpl;
import com.Hotel.vo.MemberVO;

@WebServlet("/myPage")
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	
		   // 세션에서 로그인 정보 가져오기
        HttpSession session = request.getSession();
        MemberVO loggedInMember = (MemberVO) session.getAttribute("loginCode");

        if (loggedInMember != null) {
            // 세션에서 mem_id 가져오기
            String userId = loggedInMember.getMem_id();

            // DAO를 통해 memberInfo 쿼리 호출
            MyPageDaoImpl dao = MyPageDaoImpl.getInstance();
            MemberVO memberInfo = dao.getMemberInfo(userId);
            
            // 조회 결과를 request에 설정하여 JSP에 전달
            request.setAttribute("memberInfo", memberInfo);
            request.getRequestDispatcher("/jsp/MemberInfo.jsp").forward(request, response);
        } else {
            // 세션 정보가 없으면 로그인 페이지로 리다이렉트
            response.sendRedirect(request.getContextPath() + "/jsp/Login.jsp");
        }
		
	}
	
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}


}
