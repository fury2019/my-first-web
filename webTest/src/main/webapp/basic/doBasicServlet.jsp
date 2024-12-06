<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
window.onload = function(){
	document.getElementById("getBtn").addEventListener("click",function(){
		location.href = "http://localhost/webTest/servletTest03.do";
	});
};
</script>

</head>
<body>
<h2>Servlet 요청 연습</h2>
<br><hr><br>

<h3>GET방식 요청1 == 링크 방식</h3>
<a href="http://localhost/webTest/servletTest03.do">Get방식 요청 1</a>
<br><hr>

<h3>GET방식 요청2 ==> form태그의 method속성을 생략하거나 'GET'으로 설정한 경우</h3>
<form action="http://localhost/webTest/servletTest03.do" method="get">
	<input type="submit" value="Get방식 요청2">
</form>
<br><hr>

<h3>GET방식 요청3 ==> JavaScript의 location.href 속성을 이용하는 경우</h3>
<form>
	<input type="button" value="Get방식 요청3" id="getBtn">
</form>
<br><hr><br>

<h3>POST방식 요청 ==> form태그의 method속성을 "POST"로 설정한 경우</h3>
<form action="http://localhost/webTest/servletTest03.do">
	<input type="submit" value="post방식 요청">
</form>
</body>
</html>