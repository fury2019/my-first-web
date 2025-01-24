package com.Hotel.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.Hotel.service.member.JoinLoginServiceImpl;
import com.Hotel.service.member.MyPageServiceImpl;
import com.Hotel.vo.MemberVO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//requestDispatcher객체 - jsp 또는 servlet위치에 요청을 전달하며 페이지의 이동을 제공하는..
//		request.getRequestDispatcher("../Main.jsp").forward(request, response);
//		response.getWriter().print(1);
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String userId = request.getParameter("mem_id");
	    String userPw = request.getParameter("mem_pw");
	    
	    Map<String, String> map = new HashMap<>();
	    map.put("mem_id", userId);
	    map.put("mem_pw", userPw);

	    JoinLoginServiceImpl service = JoinLoginServiceImpl.getInstance();
	    MemberVO logginMember = service.memberLogin(map); // 로그인 시도
	    
	    HttpSession session = request.getSession();

	    if (logginMember != null) {
	        // 로그인 성공: Black 상태 확인
	        if ("Black".equals(logginMember.getGrade_no())) {
	            // Black 상태일 경우 알림 띄우고 로그인 불가 처리
	            session.setAttribute("loginCode", null);
	            response.setContentType("text/html; charset=UTF-8");
	            response.getWriter().write(
	                "<script>" +
	                "alert('해당 계정은 블랙리스트 처리되어 로그인이 불가합니다.');" +
	                "window.location.href = '../../jsp/Login.jsp';" +
	                "</script>"
	            );
	        } else {
	            // 정상 로그인 처리
	            session.setAttribute("loginCode", logginMember);
	            request.getRequestDispatcher("/Main.jsp").forward(request, response);
	        }
	    } else {
	        // 로그인 실패 처리
	    	response.setContentType("text/html; charset=UTF-8");
	        response.getWriter().write(
	                "<script>" +
	                "alert('아이디 또는 비밀번호가 일치하지 않습니다.');" +
	                "window.location.href = '../../jsp/Login.jsp';" +
	                "</script>"
	            );
	        session.setAttribute("loginCode", null);
	    }
	}

}
