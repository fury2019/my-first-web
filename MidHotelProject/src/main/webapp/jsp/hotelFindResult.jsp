<%@page import="com.Hotel.vo.HotelVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호텔 찾기 결과</title>
</head>
<body>
	<h2>호텔 검색 결과</h2>
	
	<%
		List<HotelVO> hotels = (List<HotelVO>) request.getAttribute("hotels");
		if (hotels != null && !hotels.isEmpty()) {
	%>
	<table border="1">
		<tr>
			<th>호텔 ID</th>
			<th>호텔 이름</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>등급</th>
		</tr>
		<%
			for (HotelVO hotel : hotels) {
		%>
		<tr>
<%-- 			<td><%=hotel.getHotel_id()%></td> --%>
			<td><%=hotel.getHotel_name()%></td>
<%-- 			<td><%=hotel.getHotel_addr()%></td> --%>
<%-- 			<td><%=hotel.getHotel_tel()%></td> --%>
<%-- 			<td><%=hotel.getHotel_grade()%></td> --%>
		</tr>
		<%
			}
		%>
	</table>
	<%
		} else {
	%>
	<p>등록된 호텔이 없습니다.</p>
	<%
		}
	%>

</body>
</html>