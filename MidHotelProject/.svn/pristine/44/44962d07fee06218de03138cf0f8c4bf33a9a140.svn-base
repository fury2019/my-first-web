<%@page import="com.Hotel.vo.MemberVO"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.Hotel.vo.Room_ReservationVO"%>
<%
MemberVO log = (MemberVO) session.getAttribute("loginCode");
if (log == null) {
	System.out.println("로그인 정보가 없습니다. 로그인이 필요합니다.");
} else {
	System.out.println("로그인 성공: " + log);
}
%>
<!DOCTYPE html>
<html>
<head>
<title>객실 회원 예약 정보</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/RESView.css">
<body>
	<h1><%=log.getMem_name()%>님의 객실 예약 리스트
	</h1>

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
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<%
			// 서블릿에서 전달된 예약 리스트 가져오기
			List<Room_ReservationVO> reservations = (List<Room_ReservationVO>) request.getAttribute("reservationRoomMembers");

			if (reservations != null && !reservations.isEmpty()) {
				for (Room_ReservationVO reservation : reservations) {
					String rooms = reservation.getRoom_no();
					String room[] = rooms.split("_");
					String room_no = room[room.length - 1];
					String indate = reservation.getR_res_chkindate();
					String outdate = reservation.getR_res_chkoutdate();
					String sdate = indate.split(" ")[0];
					String edate = outdate.split(" ")[0];
			%>
			<tr>
				<td><%=reservation.getR_res_no()%></td>
				<td><%=log.getMem_name()%></td>
				<td class="hotel-name"><%=reservation.getHotel_name()%></td>
				<td class="room-no"><%=room_no%>호</td>

				<td><%=reservation.getType_name()%></td>
				<td><%=sdate%></td>
				<td><%=edate%></td>
				<td><%=reservation.getR_res_price()%>원</td>
				<td><%=reservation.getR_res_adult()%>명</td>
				<td><%=reservation.getR_res_child()%>명</td>
				<td><%=reservation.getR_res_kids()%>명</td>
				<td>
					<form action="<%=request.getContextPath()%>/hotelRoomResList"
						method="post">
						<input type="hidden" name="action" value="Roomdelete"> <input
							type="hidden" name="r_res_no"
							value="<%=reservation.getR_res_no()%>">
						<button type="submit">삭제</button>
					</form>
				</td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="12">예약 정보가 없습니다.</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<br>
</body>
</html>
