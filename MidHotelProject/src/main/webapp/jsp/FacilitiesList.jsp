<%@page import="com.Hotel.vo.hotel_fac_catVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>편의 시설 정보</title>
</head>
<body>

	<!-- 검색 결과 테이블 추가 -->
	<%
	List<hotel_fac_catVO> diningsearchList = (List<hotel_fac_catVO>) request.getAttribute("diningList");

	if (diningsearchList != null && !diningsearchList.isEmpty()) {
	%>
	<h3>검색 결과</h3>
	<table>
		<thead>
			<tr>
				<th>다이닝 시설명</th>
				<th>최대 인원수</th>
				<th>시설 상태</th>
				<th>시설 주소</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (hotel_fac_catVO dining : diningsearchList) {
			%>
			<tr>
				<td><%=dining.getFac_name()%></td>
				<td><%=dining.getFac_max_mem()%></td>
				<td><%=dining.getFac_status()%></td>
				<td><%=dining.getFac_addr()%></td>
				<td><%=dining.getFac_tel()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	} else {
	%>
	<p>검색된 다이닝 정보가 없습니다.</p>
	<%
	}
	%>
</body>
</html>