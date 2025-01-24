<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@include file="/jsp/include/top.jsp" %>

<!DOCTYPE html>
<html>
<head>

<title>객실 예약 관리</title>
</head>
<body>
    <h1>객실 예약 관리</h1>

    <!-- 모든 예약 정보 보기 -->
    <form action="<%= request.getContextPath() %>/hotelRoomResList" method="get">
        <input type="hidden" name="action" value="viewRoomAll">
        <button type="submit">모든 객실 예약 정보 보기</button>
    </form>


	
    <!-- 특정 회원의 예약 정보 보기 -->
    <form action="<%=request.getContextPath() %>/hotelRoomResList" method="get">
        <input type="hidden" name="action" value="viewByRoomMember">
        <input type="hidden" id="mem_id" name="mem_id" value="<%=loggedInMember.getMem_id()%>">
        <button type="submit">내 객실 예약 정보 보기</button>
    </form>
    
    
</body>
</html>
