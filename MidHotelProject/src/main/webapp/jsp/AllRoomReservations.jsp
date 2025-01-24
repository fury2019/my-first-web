<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Hotel.vo.Room_ReservationVO" %>
<!DOCTYPE html>
<html>
<head>
    <title>객실 예약 정보</title>
    <link rel="stylesheet" type="text/css" href="/css/RESView.css">
</head>
<body>
	<div class="layout">
	    <div class="content">
	        <div class="faq-info">
	            <h1>객실 예약 리스트</h1>
	        
	            <table border="1" id="reservationTable">
	                <thead>
	                    <tr>
	                        <th>예약 번호</th>
	                        <th>회원 ID</th>
	                        <th>호텔 이름</th>
	                        <th>객실 번호</th>
	                        <th>체크인 날짜</th>
	                        <th>체크아웃 날짜</th>
	                        <th>객실 가격</th>
	                        <th>성인 인원</th>
	                        <th>어린이 인원 </th>
	                        <th>유아 인원</th>
	                        <th>삭제</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <%
	                        // 서블릿에서 전달된 예약 리스트 가져오기
	                        List<Room_ReservationVO> reservations = (List<Room_ReservationVO>) request.getAttribute("reservationRoomAlls");
	        
	                        if (reservations != null && !reservations.isEmpty()) {
	                            for (int i = 0; i < reservations.size(); i++) {
	                                Room_ReservationVO reservation = reservations.get(i);
	                                String rooms = reservation.getRoom_no();
	                                String room[] = rooms.split("_");
	                                String room_no = room[room.length - 1];
	                                String indate = reservation.getR_res_chkindate();
	                                String outdate = reservation.getR_res_chkoutdate();
	                                String sdate = indate.split(" ")[0];
	                                String edate = outdate.split(" ")[0];
	                    %>
	                    <tr class="reservation-item">
	                        <td><%= reservation.getR_res_no() %></td>
	                        <td><%= reservation.getMem_id() %></td>
	                        <td><%= reservation.getHotel_name() %></td>
	                        <td><%= room_no %>호</td>
	                        <td><%= sdate %></td>
	                        <td><%= edate %></td>
	                        <td><%= reservation.getR_res_price() %>원</td>
	                        <td><%= reservation.getR_res_adult() %>명</td>
	                        <td><%= reservation.getR_res_child() %>명</td>   
	                        <td><%= reservation.getR_res_kids() %>명</td>
	                        <td>
	                            <form action="<%= request.getContextPath() %>/hotelRoomResList" method="post">
	                                <input type="hidden" name="action" value="Roomdelete">
	                                <input type="hidden" name="f_res_no" value="<%= reservation.getR_res_no() %>">
	                                <button type="submit">삭제</button>
	                            </form>
	                        </td>
	                    </tr>
	                    <%
	                            }
	                        } else {
	                    %>
	                    <tr>
	                        <td colspan="11">예약 정보가 없습니다.</td>
	                    </tr>
	                    <% } %>
	                </tbody>
	            </table>
	        </div>
	    </div>
	</div>
	
	<!-- 페이지네이션 -->
	<div id="pagination" class="pagination"></div>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
	<script type="text/javascript">
	function initializePagination() {
	    const itemsPerPage = 10; // 한 페이지당 표시할 예약 정보 수
	    const reservationItems = $(".reservation-item");
	    const totalItems = reservationItems.length;
	    const totalPages = Math.ceil(totalItems / itemsPerPage);
	
	    // 기존 버튼 초기화
	    $("#pagination").empty();
	
	    // 페이지 버튼 생성
	    for (let i = 1; i <= totalPages; i++) {
	        $("#pagination").append(
	            '<button class="page-btn btn btn-outline-primary mx-1" data-page="' + i + '">' + i + '</button>'
	        );
	    }
	
	    // 특정 페이지 보여주는 함수
	    function showPage(pageNumber) {
	        reservationItems.hide(); // 모든 예약 숨기기
	        const start = (pageNumber - 1) * itemsPerPage;
	        const end = start + itemsPerPage;
	        reservationItems.slice(start, end).show(); // 선택된 페이지의 예약 항목만 표시
	
	        // 활성화된 버튼 표시
	        $(".page-btn").removeClass("active");
	        $('.page-btn[data-page="' + pageNumber + '"]').addClass("active");
	    }
	
	    // 버튼 클릭 이벤트 바인딩
	    $(".page-btn").off("click").on("click", function () {
	        const pageNumber = $(this).data("page");
	        showPage(pageNumber); // 선택한 페이지 표시
	    });
	
	    // 첫 번째 페이지 표시
	    showPage(1);
	}
	
	$(document).ready(function () {
	    initializePagination(); // 페이지네이션 초기화
	});
</script>
</body>
</html>
