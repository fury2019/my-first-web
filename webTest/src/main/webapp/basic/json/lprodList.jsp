<%@page import="kr.or.ddit.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
	// Servlet에서 setAttribute()메서드로 저장한 데이터를 받아온다.
	
	List<LprodVO> lprodList = (List<LprodVO>)request.getAttribute("lprodList");
	
%>
<body>
<h3>LPROD 자료 목록 (동기방식)</h3>

<table border="1">
<tr>
	<th>LPROD_ID</th><th>LPROD_GU</th><th>LPROD_NM</th>
</tr>
<%
	for(LprodVO lvo : lprodList){
%>
<tr>
	<td><%=lvo.getLprod_id() %></td>
	<td><%=lvo.getLprod_gu() %></td>
	<td><%=lvo.getLprod_nm() %></td>

</tr>

<%
	}
%>
</table>

</body>
</html>