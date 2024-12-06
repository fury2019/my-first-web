<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	JSP문서에서 세션은 'session'이라는 이름으로 저장되어 있다.
 --%>
 <%
 	String name = (String)session.getAttribute("userName");
 	int age = (int)session.getAttribute("age");
 %>
 
 <h3>읽어온 session값</h3>
 
 userName : <%=name %><br><br>
 
 age : <%=age %>
 
 
</body>
</html>