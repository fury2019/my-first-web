package kr.or.ddit.basic.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

// Session 정보를 읽어오는 서블릿
@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
   private static final long serialVersionUID = 1L;

   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset='utf-8");
      PrintWriter out = response.getWriter();
      
      // 저장된 Session 정보 읽어오는 과정 
      HttpSession session = request.getSession();
      
      out.println("<html>");
      out.println("<head><meta charset='utf-8'><title>Session 읽기</title></head>");
      out.println("<body>");
      
      out.println("<h3>세션 데이터 1개씩 확인하기</h3>");
      // Session객체의 getAttribute()메서드를 이용하여 Session값을 읽어온다.
      // 형식) Session객체.getAttribute("key값");
      //      'key값' ==> setAttribute()메서드로 세션값을 저장할 때 사용한 'key값'
      String sessionValue = (String)session.getAttribute("testSession");
      if(sessionValue==null) {
         out.println("<h4>key값이 'testSession'인 세션정보는 없습니다.</h4>");
      }else {
         out.println("<h4>testSession의 세션값 : " + sessionValue + "</h4>");
      }
      
      out.println("<br><hr><br>");
      
      out.println("<h3>전체 세션 정보 읽어오기</h3>");
      out.println("<ol>");
      
      // 세션에 저장된 전체 세션이름(key값) 가져오기
      Enumeration<String> sessionNames = session.getAttributeNames();
      
      int cnt = 0;
      while(sessionNames.hasMoreElements()) {
         cnt++;
         String key = sessionNames.nextElement();
         out.println("<li>" + key + " : " + session.getAttribute(key) + "</li>");
      }
      
      if(cnt==0) {
         out.println("<h4>세션 정보가 하나도 없습니다...</h4>");
      }
      
      out.println("</ol>");
      
      out.println("<br><hr><br>");
      
      // 세션 ID ==> 세션을 구분하기 위한 고유한 값 
      out.println("세션 ID : " + session.getId() + "<br>");
      
      // 생성시간 ==> 1970년 1월 1일부터 경과한 시간으로 표시한다. (밀리세컨드 단위)
      out.println("세션 생성 시간 : " + session.getCreationTime() + "<br>");
      
      // 최근 세션에 접근한 시간 ==> 1970년 1월 1일부터 경과한 시간으로 표시한다. (밀리세컨드 단위)
      out.println("세션 최근 접근 시간 : " + session.getLastAccessedTime() + "<br>");
      
      // 세션 유효시간 ==> ( 초 단위)
      out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
      
      out.println("<br><hr><br>");
      
      out.println("<a href='" + request.getContextPath()
                  + "/basic/session/sessionTest.jsp'>시작문서로 이동</a>");
      
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
