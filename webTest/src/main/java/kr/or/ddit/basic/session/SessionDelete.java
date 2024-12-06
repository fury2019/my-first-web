package kr.or.ddit.basic.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SessionDelete
 */
@WebServlet("/sessionDelete.do")
public class SessionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// Session 정보 삭제하기
		// 1. Session객체를 생성하거나 현재 세션 가져오기
		HttpSession session = request.getSession();

		// 2. 개별적인 세션값 삭제하기 ==> remmoneAttribute()메서드를 사요한다.
		// ==> 세션 자체는 삭제되지 않고 개별적인 세션값만 삭제된다.
		// 형식)Session객체.removeAttribute("삭제할key값");
		
		//session.removeAttribute("testSession");
		
		// 3. 세션 자체를 삭제하기 ==>invalidate
		session.removeAttribute("testSession");

		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>Session 읽기</title></head>");
		out.println("<body>");

		out.println("<h3>삭제하기</h3>");

		out.println("<a href='" + request.getContextPath() + "/basic/session/sessionTest.jsp'>시작문서로 이동</a>");

		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
