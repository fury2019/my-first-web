package kr.or.ddit.basic.reqNresp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/forwardTarget.do")
public class ForwadTarget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 파라미터값을 공유해서 사용할 수 있다.
		String userName = request.getParameter("username");
		
		// 이전 문서에서 setAttribute()메서드로 설정한 데이터 가져오기 
		String tel = (String)request.getAttribute("tel");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>forward 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>Forward 방식 처리 결과</h3><hr>");
		
		out.println("<table border='1'>");
		
		out.println("<tr><td>이 름</td>");
		out.println("<td>" + userName + "</td></tr>");
		
		out.println("<tr><td>전 화</td>");
		out.println("<td>"+ tel +"</td></tr>");
		
		out.println("</table>");
		
		out.println("</body></html>");
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
