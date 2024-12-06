package kr.or.ddit.basic.reqNresp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirctTarget.do")
public class RedirectTarget extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		/*
		
		   앞 문서의 Request객체를 공유하지 않기 때문에 사용불가
		
		// 파라미터 받기
		String userName = request.getParameter("username");

		// setAttribute()로 저장한 데이터 받기
		String tel = (String) request.getAttribute("tel");
		*/
		
		// 앞의 문서에서 Query String으로 보내온 데이터를 getParameter()메서드를
		// 이용해서 받아서 처리한다.
		
		String userName = request.getParameter("name");
		String userTel = request.getParameter("usertel");
		
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>forward 연습</title></head>");
		out.println("<body>");

		out.println("<h3>redirect 방식 처리 결과</h3><hr>");

		out.println("<table border='1'>");

		out.println("<tr><td>이 름</td>");
		out.println("<td>" + userName + "</td></tr>");

		out.println("<tr><td>전 화</td>");
		out.println("<td>" + userTel + "</td></tr>");

		out.println("</table>");

		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
