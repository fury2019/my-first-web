package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/cookieCount.do")
public class CookieCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 쿠키이름 ==> count
		
		// 쿠키이름이 'count'인 쿠키가 있는지 검사
		Cookie[] cookieArr = request.getCookies();
		
		// 쿠키값이 저장될 변수 선언
		int num = 0;
		
		if(cookieArr!=null) {
			for(Cookie cookie : cookieArr) {
				
				// 'count'쿠키가 있는지 검사
				if("count".equals(cookie.getName())) {
					
					// 'count'쿠키가 있으면 '쿠키값'을 가져와 정수형으로 변환하여 저장한다.
					String value = cookie.getValue();
					num = Integer.parseInt(value);
				}
			}
		}
		
		num++;	//count값 증가
		
		// 증가된 count값이 저장된 Coookie객체 생성
		Cookie countCookie = new Cookie("count", String.valueOf(num));
		
		// 쿠키 저장
		response.addCookie(countCookie);
		
	
		out.println("<html>"); 
		out.println("<head><meta charset='utf-8'><title>Cokie count</title></head>"); 
		out.println("<body>"); 
		
		out.println("<h3>어서오세요, 당신은 " + num + "번째 방문입니다.</h3>");
		out.println("<br><br><br>");
		
		out.println("<a href ='" + request.getContextPath()
		 			+ "/cookieCount.do'> 카운트 증가하기 </a>");
		
		out.println("<br>");
		
		out.println("<a href ='" + request.getContextPath()
		 + "/basic/cookie/cookieTest02.jsp'> 시작문서로 이동하기 </a>");
		
		out.println("</body>"); 
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
