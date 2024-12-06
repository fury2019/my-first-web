package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieRead.do")
public class CookieRead extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        
        PrintWriter out = response.getWriter();
        
        Cookie[] cookieArr = request.getCookies();
        
        out.println("<html>");
        out.println("<head><meta charset=utf-8><title>Cookie 정보 읽기</title></head>");
        out.println("<body>");
        
        if(cookieArr==null || cookieArr.length==0) {
            out.println("<h3>저장된 쿠키가 하나도 없습니다.</h3>");
        }else {
            for(Cookie cookie : cookieArr) {
                String name = cookie.getName();     
                String value = cookie.getValue();   
                value = URLDecoder.decode(value, "utf-8");
                
                out.println("쿠키이름 : " + name + "<br>"); 
                out.println("쿠키값 : " + value + "<hr>"); // 쿠키값 제대로 출력
            }
        }
        
        out.println("<br><br>");
        out.println("<a href='" + request.getContextPath() + "/basic/cookie/cookieTest01.jsp'>시작문서로 이동하기</a>");
        out.println("</body></html>");
        
    }   
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}       
