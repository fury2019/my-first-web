package kr.or.ddit.basic.reqNresp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;


public class RedirectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	 	- redirect
	 		다른 페이지로 이동한다. (request객체와 Response객체를 공유하지 않는다.)
	 		
	 		응답시 브라우저에게 '이동할 URL'을 전송하여 브라우저가 자동으로 해당 URL로 
	 		새롭게 요청하는 방식이다.
	 		이 때 요청하는 전송방식은 GET방식으로 요청하기 때문에 URL의 길이에 제한이 있다.
	 		
	 */		
		
		// 앞의 문서와 뒤의 문서가 request객체와 Response객체를 공유하지 않기 때문에
		// Request객체의 setAttribute()메서드를 이용하여 데이터를 전달할 수 없다.
		System.out.println("redirectTest.do 문서입니다.");
		
		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("username");
		
		String userTel = "010-9999-8888";
		// request.setAttribute("tel", "010-9999-8888"); //전송 불가
		
		// redirect방식으로 이동하기
		// 		HttpServletResponse객체의 sendRedirect()메서드를 이용한다.
		//		sendRedirect()메서드에는 이동할 서블릿이나 JSP의 '전체 URL경로'를 지정해
		//		주저야 하고, URL경로에 한글이 포함될 경우에는 URLEncoder.encode()메서드를
		//		이용하여 인코딩해서 지정해 주어야 한다.
		
		//response.sendRedirect("/webTest/redirectTarget.do");
		
		// 다음 문서로 데이터를 보내려면 URL주소 뒤에 보낼 문서를 붙여서 보낼 수 있다.
		
		response.sendRedirect("/webTest/redirectTarget.do?name=" + 
		URLEncoder.encode(userName,"utf-8") + "%usertel=" + userTel);
		
		//response.sendRedirect("https://www.daum.net");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
