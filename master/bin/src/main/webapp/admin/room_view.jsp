
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>My JSP Page</title>
	<!-- Twitter Bootstrap3 & jQuery -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
		<div class="container">
		<h1 class='page-header'>객실 상세 보기</h1>
		
		<!-- 조회결과를 출력하기 위한 표 시작 -->
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th class="info text-center" width="130">객실 아이디</th>
					<td>${room.r_id }</td>
				</tr>
				<tr>
					<th class="info text-center">객실 종류</th>
					<td>${room.r_type }</td>
				</tr>
				<tr>
					<th class="info text-center">수용 인원</th>
					<td>${room.r_capacity }</td>
				</tr>
				<tr>
					<th class="info text-center">가격</th>
					<td>${room.r_price }</td>
				</tr>
				<tr>
					<th class="info text-center">이미지경로</th>
					<td>/upload/${file }</td>	
				</tr>
				<tr>
					<th class="info text-center">이미지</th>

					<td><img alt="" src="/upload/${file }"> </td>
				</tr>
			</tbody>
		</table>
		<!--// 조회결과를 출력하기 위한 표 끝  -->

		<!-- 버튼 시작 -->
		<div class="text-center">
			<a href="${pageContext.request.contextPath}/admin/AdminRoomList.ad" >목록</a>
			<a href="${pageContext.request.contextPath}/admin/AdminRoomAdd.ad?r_id=${room.r_id }">추가</a>
			<a href="${pageContext.request.contextPath}/admin/AdminRoomEdit.ad?r_id=${room.r_id }" >수정</a>
			<a href="${pageContext.request.contextPath}/admin/AdminRoomDelete.ad?r_id=${room.r_id }">삭제</a>
		</div>
		<!--// 버튼 끝 -->
	</div>
</body>
</html>



