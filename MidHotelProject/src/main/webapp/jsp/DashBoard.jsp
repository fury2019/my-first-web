<%@page import="com.Hotel.vo.Reservation_ServiceVO"%>
<%@page import="com.Hotel.vo.Room_ReservationVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.Hotel.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>최근 회원 및 예약 내역</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; background-color: #fdf5e6; }
        #content-area {
        	height: 950px;
        }
        
        h2 { color: #8b4513; text-align: center; }
        
        table { width: 80%; margin: 20px auto; border-collapse: collapse; background-color: #fff; }
        
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        
        th { background-color: #deb887; color: white; }
        
        .section { margin-top: 40px; }
    </style>
</head>
<body>
    <h2>신규 회원 목록</h2>
    <table>
        <thead>
            <tr>
                <th>회원 ID</th>
                <th>회원 이름</th>
                <th>가입 날짜</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<MemberVO> members = (List<MemberVO>) request.getAttribute("recentMembers");
                if (members != null && !members.isEmpty()) {
                    for (MemberVO member : members) {
            %>
            <tr>
                <td><%= member.getMem_id() %></td>
                <td><%= member.getMem_name() %></td>
                <td><%= member.getMem_create() %></td>
            </tr>
            <% 
                    }
                } else { 
            %>
            <tr><td colspan="3">최근 3일 이내 가입한 회원이 없습니다.</td></tr>
            <% } %>
        </tbody>
    </table>

<!--     <div class="section"> -->
<!--         <h2>신규 객실예약 내역</h2> -->
<!--         <table> -->
<!--             <thead> -->
<!--                 <tr> -->
<!--                     <th>예약 ID</th> -->
<!--                     <th>회원 ID</th> -->
<!--                     <th>객실 번호</th> -->
<!--                     <th>예약 날짜</th> -->
<!--                 </tr> -->
<!--             </thead> -->
<!--             <tbody> -->
<%--                 <% --%>
<!-- //                     List<Room_ReservationVO> reservations = (List<Room_ReservationVO>) request.getAttribute("recentReservations"); -->
<!-- //                     if (reservations != null && !reservations.isEmpty()) { -->
<!-- //                         for (Room_ReservationVO reservation : reservations) { -->
<%--                 %> --%>
<!--                 <tr> -->
<%--                     <td><%= reservation.getHotel_id() %></td> --%>
<%--                     <td><%= reservation.getMem_id() %></td> --%>
<%--                     <td><%= reservation.getRoom_no() %></td> --%>
<%--                     <td><%= reservation.getType_name() %></td> --%>
<!--                 </tr> -->
<%--                 <%  --%>
<!-- //                         } -->
<!-- //                     } else {  -->
<%--                 %> --%>
<!--                 <tr><td colspan="4">최근 3일 이내 객실 예약 내역이 없습니다.</td></tr> -->
<%--                 <% } %> --%>
<!--             </tbody> -->
<!--         </table> -->
<!--     </div> -->
</body>
</html>
