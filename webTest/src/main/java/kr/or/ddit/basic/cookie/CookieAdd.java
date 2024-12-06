package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieAdd.do")
public class CookieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		// Cookie 저장하는 작업
		
		// 1. Cookie객체를 생성한다. ==> '쿠키이름'과 '쿠키값'은 문자열로 지정한다.
		// 형식) Cookie cookie변수 = new Cookie("쿠키이름", "쿠키값");
		//	==> '쿠키값'으로 한글을 사용할 경우에는 URLEncoder.encode()메서드로
		//		인코딩한 후 저장한다.
		//	==> 하나의 쿠키는 4kb(4096byte)까지 저장 가능하고
		//	==> 하나의 도메인 당 20개 (총 300개)까지 저장 가능하다.
		
		Cookie nameCookie = new Cookie("name", URLEncoder.encode("홍길동","utf-8") );
		Cookie ageCookie = new Cookie("age", "20");
		//Cookie ageCookie2 = new Cookie("age", 20 + "");
		//Cookie ageCookie3 = new Cookie("age", String.valueOf(20));
		
		Cookie genderCookie = new Cookie("gender", "Male");
		
		// 2. 쿠키 속성 설정
		/*
		 cookie변수.setPath("적용경로"); ==> 지정한 경로와 그 하위 경로에서만 사용 가능하다.
		 							  ==> 생략하면 쿠키를 설정할 당시의 경로가 설정된다.
		 cookie변수.setMaxAge(유지시간); ==> 쿠키가 사용할 수 있는 유지시간 설정 (단위:초)
		 							  ==> -1 : 브라우저가 종료될 때까지 유지 (기본값)
		 							  ==> 0 : 해당 쿠키가 즉시 삭제된다.
		 cookie변수.setDomain("적용도메인명") 
		 ==> 예) '.ddit.or.kr' ==> www.ddit.or.kr, mail.ddit.or.kr 에서도 사용 가능하다.
		
		 cookie변수.setSecure(보안여부); ==> (true:보안적용, false:보안미적용(기본값))
		
		 */
		
		// 3. Response객체를 이용하여 쿠키를 웹브라우저로 보내면 웹브라우저가 이 쿠키를 
		// 	  받아서 저장한다.
		// 형식) Response객체.addCookie( 1번에서 만든 Cookie객체);
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(genderCookie);
		
		//---------------------------------------------------------
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title><Cookie 저장</title></head>");
		out.println("<body>");
		out.println("<h3>Cookie 데이터가 저장되었습니다. </h3><br><br>");
		out.println("<a href ='" + request.getContextPath()
								 + "/basic/cookie/cookieTest01.jsp'> 시작문서로 이동하기 </a>");
		out.println("</body></html>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
