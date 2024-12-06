package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountDel.do")
public class CookieCountDel extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        
        Cookie[] cookieArr = request.getCookies();

        out.println("<html>");
        out.println("<head><meta charset='utf-8'><title>카운트 초기화</title></head>");
        out.println("<body>");
        
        if (cookieArr != null) { // cookieArr이 null이 아닌 경우에만 실행
            for (Cookie cookie : cookieArr) {
                if ("count".equals(cookie.getName())) { // 'count'라는 쿠키이름 찾기
                    cookie.setMaxAge(0); // 찾은 쿠키의 유지시간을 0으로 설정하여 삭제하기
                    response.addCookie(cookie);
                }
            }
            out.println("<h3>count가 초기화 되었습니다.</h3>");
        } else {
            out.println("<h3>저장된 쿠키가 없습니다.</h3>");
        }
        
        out.println("<br><br><br>");
        out.println("<a href='" + request.getContextPath() + "/basic/cookie/cookieTest02.jsp'>시작문서로 이동하기</a>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
