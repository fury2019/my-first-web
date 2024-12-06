package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 	이 예제는 애노테이션(@WebServlet)을 이용해서 Servlet을 설정하여
 	처리하는 예제이다.
 	애노테이션(@WebServlet)은 서블릿 버전 3.0이상에서 사용할 수 있다.
 */

/*
 	@WebServlet 애노테이션의 속성들
 	1. name : 서블릿 이름을 설정한다. (기본값 : 빈문자열(""))
 	2. urlPatterns : 서블릿의 URL패턴의 목록을 설정한다.( 기본값 : 빈배열(  {}  ))
 		예) urlPatterns="/url1" 또는 urlPatterns={"/url1"}
 					==> 패턴이 1개인 경우
 		예) urlPatterns={"/url1", "/url2", ...}
 					==> 패턴이 2개 이상인 경우
 	3. value : urlPatterns속성과 동일한 기능을 한다.
 	4. description : 주석(설명글)을 설정한다.
 	
 */

@WebServlet(
	name="servletTest02", urlPatterns = {"/servletTest02.do"},
	description = "애노테이션을 이용한 서블릿 설정 연습"
)
public class SetvletTest02 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");  // 응답 문서의 인코딩 방식 지정
		response.setContentType("text/html; charset=utf-8");  // 응답 문서의 ContentType 지정
		
		// 처리한 결과를 응답으로 보내기 위해서 PrintWriter객체를 생성한다.
		//		==> HttpServletRespnse객체를 통해서 구할 수 있다.
		PrintWriter out = response.getWriter();
	
		// 처리한 내용을 출력한다.
		// 방법2) print()메서드 또는 println()메서드, printf()메서드 등을 이용하기
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>두번째 Servlet예제</title></head>");
		out.println("<body>");
		
		out.println("<h3 style='text-align:center; color:blue;'>안녕하세요. 두번째 Servlet예제입니다.</h3>");
		out.println("<h3>이 예제는 애노테이션을 이용한 서블릿 예지입니다.</h3>");
		out.println("</body></html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
