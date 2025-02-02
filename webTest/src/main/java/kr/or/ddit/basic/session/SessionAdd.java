package kr.or.ddit.basic.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


// Session 정보를 저장하는 서블릿
@WebServlet("/sessionAdd.do")
public class SessionAdd extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
      
      // Session에 데이터 저장하는 과정
      
      // 1. session객체를 생성하거나 현재 세션 가져오기
      // 형식) Request객체.getSession();   또는 Request객체.getSession(true);
      //         ==> 현재 세션이 존재하면 현재 세션을 반환하고, 존재하지 않으면 새로운 세션을 생성한다.
      //   형식) Request객체.getSession(false);
      //         ==> 현재 세션이 존재하면 현재 세션을 반환하고, 존재하지 않으면 null을 반환한다.
      
      HttpSession session = request.getSession();
      
      // 2. Session값 저장
      // 형식) Session객체.setAttribute("key값", session값);
      //         ==> 'key값'은 문자열, 'session값'은 모든 데이터를 사용할 수 있다.
      session.setAttribute("testSession", "연습용 세션값 입니다...");
      session.setAttribute("userName", "송경호");
      session.setAttribute("age", 27);
      
      
      out.println("<html>");
      out.println("<head><meta charset='utf-8'><title>Session 저장</title></head>");
      
      out.println("<h3>Session 데이터가 저장되었습니다...</h3>");
      
      out.println("<br><hr><br>");
      
      out.println("<a href='" + request.getContextPath()
                        + "/basic/session/sessionTest.jsp'>시작문서로 이동</a>");
      
      
      
      out.println("<body>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
