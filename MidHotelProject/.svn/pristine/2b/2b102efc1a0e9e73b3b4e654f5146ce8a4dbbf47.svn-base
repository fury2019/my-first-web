<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@include file="/jsp/include/top.jsp" %>

<!DOCTYPE html>
<html>
<head>

    <title>시설 예약 관리</title>
</head>
<body>
    <h1>시설 예약 관리</h1>

    <!-- 모든 예약 정보 보기 -->
    <form action="<%= request.getContextPath() %>/facilitiesResList" method="get">
        <input type="hidden" name="action" value="viewAll">
        <button type="submit">모든 예약 정보 보기</button>
    </form>


	
    <!-- 특정 회원의 예약 정보 보기 -->
    <form action="<%=request.getContextPath() %>/facilitiesResList" method="get">
        <input type="hidden" name="action" value="viewByMember">
        <input type="hidden" id="mem_id" name="mem_id" value="<%=loggedInMember.getMem_id()%>">
        <button type="submit">내 예약 정보 보기</button>
    </form>
</body>
</html>
