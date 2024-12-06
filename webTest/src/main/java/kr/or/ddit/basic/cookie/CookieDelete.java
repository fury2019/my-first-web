package kr.or.ddit.basic.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 쿠키 정보를 삭제하는 서블릿
@WebServlet("/cookieDelete.do")
public class CookieDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		// 쿠키 정보 삭제하기
		// - 쿠키 정보의 삭제는 쿠키의 유지시간을 0으로 설정하는 방법을 사용한다.
		// - 쿠킹의 유지시간은 쿠키를 저장하는 addCookie()메서드를 호출하기 전에 해당 쿠키의
		// setMaxAge()메서드를 사용한다.
		// 형식) 쿠키객체변수.setMaxAge(0);

		// 예제) 쿠키이름이 'gender'인 쿠키 삭제하기

		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>쿠키 삭제하기</title></head>");
		out.println("<body>");

		// 1. 전체 쿠키 정보 가져오기
		Cookie[] cookieArr = request.getCookies();
		if (cookieArr == null || cookieArr.length == 0) {
			out.println("<h3>저장된 Cookie 정보가 하나도 없습니다.</h3>");
		} else {
			out.println("<h3>저장된 Cookie 정보 삭제하기</h3>");

			// 2. 삭제할 쿠키를 찾는다.
			for (Cookie cookie : cookieArr) {
				String name = cookie.getName(); // '쿠키이름'구하기

				// 쿠키이름을 이용하여 삭제할 쿠키를 찾는다.
				if ("gender".equals(name)) {
					// 3. 찾은 쿠키의 유지시간을 0으로 설정해서 다시 저장한다.
					cookie.setMaxAge(0);
					response.addCookie(cookie);

				}
			} // for문 끝.
		} // else문 끝.
		
		out.println("<br><br>");
		out.println("<a href='" + request.getContextPath() + "/basic/cookie/cookieTest01.jsp'>시작문서로 이동하기</a>");
		
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
