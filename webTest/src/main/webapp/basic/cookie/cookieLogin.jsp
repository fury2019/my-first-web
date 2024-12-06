<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!--==>'cookieLoginServlet.do' 로그인 서블릿에서 하는 일 
'id 기억하기' 체크박스를 체크한 후 'Login'버튼을 클릭하면 입력했던 'ID'값을 쿠키에 저장하고
체크박스가 해제된 상태로 'Login'버튼을 클릭하면 해당 쿠키가 삭제되게 처리한다.

ID가 'test'이고, PassWord가 '1234'이면 로그인 성공으로 처리하여 'cookieMain.jsp'로 이동하고
로그인이 실패하면 'cookieLogin.jsp'로 이동한다.

-------------------------------------------------------------------
==> cookieLogin.jsp에서 하는 일 
서블릿에서 저장한 쿠키가 있으면 해당 쿠키값(ID값)을 가져와 'id 입력요소'에 출력하고
체크박스도 체크된 상태가 되게 한다.   -->
<!DOCTYPE html>

<html>
  <head>
    <meta charset="UTF-8" />
    <title>로그인 화면</title>
<%
   // 쿠키이름이 'USERID'와 한 쌍인 '쿠키값'을 가져온다.
   
   String cookieUserId = "";   // 쿠키값이 저장될 변수
   String cookieCheck = "";   // 체크박스의 체크 여부를 나타낼 변수
   
   Cookie[] cookieArr = request.getCookies();
   if(cookieArr!=null){
      for(Cookie cookie : cookieArr){
         if("USERID".equals(cookie.getName())){   // 쿠키이름이 'USERID'인 쿠키 찾기
            cookieUserId = cookie.getValue();
            cookieCheck = "checked";
         }
      }
   }
   
   
%>    
    
  </head>
  <body>
    
  <form action="<%=request.getContextPath()%>/cookieLoginServlet.do" method="post">
    <table style="margin: 0 auto;">
      <tr>
        <td>ID : </td>
        <td><input type="text" name="userid" placeholder="ID를 입력하세요." value="<%=cookieUserId%>"></td>
      </tr>
      <tr>
        <td>PASS : </td>
        <td><input type="password" name="username" placeholder="Password를 입력하세요."></td>
      </tr>
      <tr>
        <td colspan="2"> <input type="checkbox" name="chkid" value="check" <%=cookieCheck %>>ID 기억하기</td>
      </tr>
      <tr>
        <td colspan="2" style="text-align: center;"> <input type="submit" value="Login"></td>
      </tr>

    </table>
    </form>
  
  </body>



</html>