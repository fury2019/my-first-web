package com.Hotel.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.Hotel.dao.member.MyPageDaoImpl;

import com.Hotel.service.member.IJoinLoginService;
import com.Hotel.service.member.IMyPageService;
import com.Hotel.service.member.JoinLoginServiceImpl;
import com.Hotel.service.member.MyPageServiceImpl;
import com.Hotel.vo.MemberVO;

@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Main() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 로그인 정보
        String memId = request.getParameter("memId");
        String memPw = request.getParameter("memPw");

        // 서비스 객체 필요
        IJoinLoginService service = JoinLoginServiceImpl.getInstance();

        // 로그인 확인 로직
        MemberVO memberUser = service.loginCheck(memId, memPw);

        
        if (memberUser != null) {
            // 로그인 성공 시 세션에 사용자 정보 저장
            request.getSession().setAttribute("loginMember", memberUser);
            
            // Main.jsp로 리다이렉트
            response.sendRedirect(request.getContextPath() + "/Main.jsp");
        } else {
            // 로그인 실패 시 로그인 페이지로 다시 돌아감
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=1");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doPost로 처리하도록 함
        doPost(request, response);
    }
}
