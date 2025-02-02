<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Login - DDIT Hotel</title>
<!-- <link rel="icon" href="/image/LOGOHOTEL.ico" type="image/x-icon"> -->
<link rel="stylesheet" type="text/css" href="/css/styles.css">
<style>
.join {
text-decoration: none;
color: #9A0101;
}

</style>
</head>
<body id="login_body">
	<div class="login-container">
		<h1>로그인</h1>
		<hr id="hr">
		<form action="/Login" method="post">
			<h6 class="Lid">아이디</h6>
			<input class="idid" type="text" id="username" name="mem_id" placeholder="Id를 입력하세요." required> 
			<h6 class="Lid">비밀번호</h6>
			<input class="idid" type="password"  id="password" name="mem_pw" placeholder="Password를 입력하세요." required>
			<input id="sum" type="submit" value="Login">
			<a href="/jsp/Agreement.jsp" class="join">회원가입</a>
		</form>
		
	</div>
	
 </body>
 
		<script>

		<%
        if (request.getAttribute("errorMessage") != null) {
        %>
            alert("<%= request.getAttribute("errorMessage") %>");
		
		window.onload = function () {
		    // URL 파라미터에서 'redirect' 값을 가져옵니다.
		    const urlParams = new URLSearchParams(window.location.search);
		    const redirectUrl = urlParams.get('redirect'); // 원래 페이지의 URL

		    // 로그인 폼 제출 시 리다이렉트 처리
		    document.getElementById("loginForm").onsubmit = function () {
		        if (redirectUrl) {
		            window.location.href = decodeURIComponent(redirectUrl); // 원래 페이지로 이동
		        } else {
		            window.location.href = '/Main.jsp'; // 기본 페이지로 이동
		        }
		        return false; // 기본 폼 제출 방지
		    };
		};
		
		<%
		}
		%>
		</script>
	


 
<%@include file="/jsp/include/footer.jsp" %>
  </html>