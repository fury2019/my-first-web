package com.Hotel.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate(); // 세션 제거를 통해 로그아웃 처리 ....
		
		//forward() 는 직전 요청을 가지고 페이지로 이동되며, url정보도 직전기록을 유지함
//		request.getRequestDispatcher("/").forward(request, response); // root는 web-app위치를 가리킴 >> index.jsp를 자동연결 
	
		//redirect() 는 재요청하기때문에 직전 요청이 사라지고, 때문에 url정보도 갱신됨
		response.sendRedirect("/Main.jsp");
	}

}
