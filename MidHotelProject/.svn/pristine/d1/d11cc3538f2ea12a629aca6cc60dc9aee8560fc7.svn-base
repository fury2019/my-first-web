<%@page import="com.Hotel.vo.MemberVO"%>
<%@page import="com.Hotel.vo.Facilities_ReservationVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%MemberVO log = (MemberVO)session.getAttribute("loginCode");
if (log == null) {
    System.out.println("로그인 정보가 없습니다. 로그인이 필요합니다.");
} else {
    System.out.println("로그인 성공: " + log);
} 

%>

<!DOCTYPE html>
<html>
<head>
    <title>다이닝 회원 예약 정보</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/RESView.css">
<body>
    <h1><%= log.getMem_name() %>님의 다이닝 예약 정보</h1>
    <table border="1">
        <thead>
            <tr>
                <th>예약 번호</th>
                <th>호텔 이름</th>
                <th>시설 이름</th>
                <th>예약자 성함</th>
                <th>예약 인원</th>
                <th>예약 시간</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
        <% 
            List<Facilities_ReservationVO> reservations = (List<Facilities_ReservationVO>) request.getAttribute("reservationMembers");
            if (reservations != null) {
                for (Facilities_ReservationVO reservation : reservations) {
        %>
            <tr>
                <td><%= reservation.getF_res_no() %></td>
                <td><%= reservation.getHotel_name() %></td>
                <td><%= reservation.getFac_name() %></td>
                <td><%= log.getMem_name() %></td>
                <td><%= reservation.getF_res_mem() %></td>
                <td><%= reservation.getF_fes_time() %></td>
                <td>
                    <form action="<%= request.getContextPath() %>/facilitiesResList" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="f_res_no" value="<%= reservation.getF_res_no() %>">
                        <button type="submit">삭제</button>
                    </form>
                </td>
            </tr>
        <% 
                }
            } else {
        %>
            <tr>
                <td colspan="6">예약 정보가 없습니다.</td>
            </tr>
        <% } %>
        </tbody>
    </table>
    <br>
</body>
</html>
