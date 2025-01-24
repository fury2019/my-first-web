<%@page import="com.Hotel.vo.MemberVO"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.Hotel.vo.HotelVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&display=swap" rel="stylesheet"> <!-- 폰트 추가 -->
<link rel="icon" type="image/x-icon" href="/image/logo.png">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
  @font-face {
    font-family: 'MinSans-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

.top{
		background-color: #FFF3C8; /* 전체 배경색 설정 */
		top: 10px; /* 상단에서의 거리 */
    	right: 10px; /* 오른쪽에서의 거리 */
		padding: 10px;
		justify-content: end;
		z-index: 1000; /* 다른 요소 위에 표시되도록 설정 */
		text-align: right;
		font-family: 'Minsans-Regular', sans-serif;
	}
	
.top a {
	margin: 0 15px;
	text-decoration: none;
	color: #333;
}
.top a:hover {
	text-decoration: none;
	color: #9A0101; /* 링크 호버 색상 */
}
</style>


<div class="top">
	<a href="/hotelfindServlet">호텔찾기</a>|
	<a href="/jsp/Membership.jsp">멤버십</a>|
	<%
    MemberVO loggedInMember = (MemberVO) session.getAttribute("loginCode");
	
    if(loggedInMember != null){
%>
	<a href="/myCoupon">쿠폰</a>|
	<a href="<%=request.getContextPath()%>/Logout">로그아웃</a>
<%
    } else{
%>
	<a href="/jsp/Login.jsp">쿠폰</a>|
	<a href="/jsp/Login.jsp">로그인</a>|
	<a href="/jsp/Agreement.jsp">회원가입</a>
	
<%
    }
%>

</div>
