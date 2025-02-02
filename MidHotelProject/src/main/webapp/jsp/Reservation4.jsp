<%@page import="com.Hotel.vo.Hotel_room_resVO"%>
<%@page import="com.Hotel.vo.Room_ServiceVO"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.Hotel.vo.HotelVO"%>
<%@page import="com.Hotel.vo.MemberVO"%>
<%@ page import="java.util.List"%>
<%@ page import="com.Hotel.vo.Room_ReservationVO"%>
<%@ page import="com.Hotel.service.reservation.IRoom_reserService"%>
<%@ page import="com.Hotel.service.reservation.Room_reserServiceImpl"%>
<%@ page session="true" %>

<%@include file="/jsp/include/top.jsp" %>

<%@include file="/jsp/include/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%
MemberVO log = (MemberVO) session.getAttribute("loginCode");
if (log == null) {
	System.out.println("로그인 정보가 없습니다. 로그인이 필요합니다.");
} else {
	System.out.println("로그인 성공: " + log);
}
%>
<meta charset="UTF-8">
<title>DDIT 호텔 - 예약완료</title>
<link rel="stylesheet" type="text/css" href="/css/RESView.css">
<style>
.header1 { 
	text-align: center;
}

.header1 img {
    text-align: center; 
    margin-bottom: 20px;
}


</style>
</head>
  <body>
  <br>
  	 <div class="header1">
		<img src="/image/예약4.png" alt="예약단계4">
    </div>
  

<%
	
	Room_ReservationVO reservations = (Room_ReservationVO) request.getAttribute("reservation");
%>

<h1>결제 완료</h1>
<div>

	<%
	
	if (reservations != null ) {
		String rooms = reservations.getRoom_no();
		String room[] = rooms.split("_");
		String room_no = room[room.length - 1];
		String indate = reservations.getR_res_chkindate();
		String outdate = reservations.getR_res_chkoutdate();
		String sdate = indate.split(" ")[0];
		String edate = outdate.split(" ")[0];
	%>
    <table border="1">
		<thead>
			<tr>
				<th>예약 번호</th>
				<th>예약자 성함</th>
				<th>호텔 이름</th>
				<th>객실 번호</th>
				<th>객실 타입</th>
				<th>체크인 날짜</th>
				<th>체크아웃 날짜</th>
				<th>객실 가격</th>
				<th>성인 인원</th>
				<th>어린이 인원</th>
				<th>유아 인원</th>
			</tr>
		</thead>
		<tbody>
		<tr>
				<td><%=reservations.getR_res_no()%></td>
				<td><%=log.getMem_name()%></td>
				<td class="hotel-name"><%=reservations.getHotel_name()%></td>
				<td class="room-no"><%=room_no%>호</td>
				<td><%=reservations.getType_name()%></td>
				<td><%=sdate%></td>
				<td><%=edate%></td>
				<td><%=reservations.getR_res_price()%>원</td>
				<td><%=reservations.getR_res_adult()%>명</td>
				<td><%=reservations.getR_res_child()%>명</td>
				<td><%=reservations.getR_res_kids()%>명</td>
			</tr>
			<%
			}
			 else {
			%>
			<tr>
				<td colspan="12">예약 정보가 없습니다.</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</div>


  
  
<%@include file="/jsp/include/footer.jsp"%>
</body>
</html>

