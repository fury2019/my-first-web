package kr.or.ddit.basic.cookie;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       
       // userid, userpass, chkid 파라미터를 구한다.
       String userId = request.getParameter("userid");
       String userPass = request.getParameter("userpass");
       String chkId = request.getParameter("chkid");   // 체크박스는 체크된 데이터만 전송된다.
       
       // 쿠키 객체 생성 ==> 클라이언트가 보내온 userid를 쿠키값으로 하는 쿠키 객체 생성
       Cookie loginCookie = new Cookie("USERID", userId);
       
       // 체크박스의 체크 여부 확인
       if(chkId==null) {   // 체크박스가 체크되지 않았을 때
          // 쿠키 삭제
          loginCookie.setMaxAge(0);
          response.addCookie(loginCookie); // 쿠키 저장
       }else {
          response.addCookie(loginCookie); //쿠키 저장
       }
       
       // 로그인 성공 여부 확인
       if("test".equals(userId) && "1234".equals(userPass)) {   // 로그인 성공
          response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieMain.jsp");
       }else { // 로그인 실패
          response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieLogin.jsp");
      }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
