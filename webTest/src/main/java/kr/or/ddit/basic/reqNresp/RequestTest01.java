package kr.or.ddit.basic.reqNresp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식으로 전달되는 문자 인코딩 방식 설정하기
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트가 보내온 데이터 받기
		// 1) HttpServletRequest객체의 getParameter()메서드 이용
		//	  형식) Request객체.getParameter("파라미터명")
		//			==> 지정한 '파라미터명'에 설정된 '값'을 가져온다.
		//			==> 가져온 '값'의 자료형은 'String'이다.
		//			==> 지정한 '파라미터 명'이 없으면 null을 반환한다.
		//	 ==> '파라미터명'은 보통  <form>태그 안에서 구성된 입력 요소의 
		//		 'name'속성에 설정된 '속성값'을 말한다.
		
		String userName = request.getParameter("username");
		String job = request.getParameter("job");
		
		// 2) HttpServletRequest객체의 getParameterValues()메서드 이용하기
		//		==> '파라미터명'이 같은 것이 여러 개일 경우에 사용한다.
		//	형식) Request객체.getParameterValues("파라미터명");
		//		==> 가져오는 '값'의 자료형은 'String[]'이다.
		//		==> 지정한 '파라미터 명'이 없으면 null을 반환한다.
		String[] hobbies = request.getParameterValues("hobby");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title><Request객체 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>Request 테스트 결과</h3>");
		out.println("<table border ='1'>");
		
		out.println("<tr><td>이 름</td>");
		out.println("<td>" + userName + "</td></tr>");
		
		out.println("<tr><td>직 업</td>");
		out.println("<td>" + job + "</td></tr>");
		
		out.println("<tr><td>취 미</td>");
		out.println("<td>");
		
		if (hobbies!=null) {
			// 향상된  for문 이용
			for(String h : hobbies) {
				out.println(h + "<br>");
			}
			
			// 일반 for문 이용
			for(int i=0; i<hobbies.length; i++) {
				out.println(hobbies[i] + "<br>");
			}
		}
		out.println("</td></tr>");
		out.println("</table>");
		
		out.println("<br><hr><br>");
		
		out.println("<h3>HttpServletRequest의 제공 메서드들</h3>");
		out.println("<ol>");
		out.println("<li>클라이언트 IP주소 : " + request.getRemoteAddr() + "</li>");
		out.println("<li>요청할 때 전송 방식 : " + request.getMethod() + "</li>");
		out.println("<li>ContextPath : " + request.getContextPath() + "</li>");
		out.println("<li>프로토콜 : " + request.getProtocol() + "</li>");
		out.println("<li>URL 정보 : " + request.getRequestURL() + "</li>");
		out.println("<li>URI 정보 : " + request.getRequestURI() + "</li>");
		
		out.println("</ol>");
		
		
		out.println("</body></html>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
