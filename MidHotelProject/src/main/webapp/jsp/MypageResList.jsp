<%@page import="com.Hotel.vo.MemberVO"%>
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

<title>객실 예약 관리</title>
</head>
<body>
    <h1>객실 예약 관리</h1>

    <%-- <!-- 모든 예약 정보 보기 -->
    <form action="<%= request.getContextPath() %>/hotelRoomResList" method="get">
        <input type="hidden" name="action" value="viewRoomAll">
        <button type="submit">모든 객실 예약 정보 보기</button>
    </form> --%>


	
    <!-- 특정 회원의 예약 정보 보기 -->
    <form action="<%=request.getContextPath() %>/hotelRoomResList" method="get">
        <input type="hidden" name="action" value="viewByRoomMember">
        <input type="hidden" id="mem_id" name="mem_id" value="<%=log.getMem_id()%>">
        <button type="submit">내 객실 예약 정보 보기</button>
    </form>
    
    
    <h1>다이닝 예약 관리</h1>

    <%-- <!-- 모든 예약 정보 보기 -->
    <form action="<%= request.getContextPath() %>/facilitiesResList" method="get">
        <input type="hidden" name="action" value="viewAll">
        <button type="submit">모든 예약 정보 보기</button>
    </form> --%>


	
    <!-- 특정 회원의 예약 정보 보기 -->
    <form action="<%=request.getContextPath() %>/facilitiesResList" method="get">
        <input type="hidden" name="action" value="viewByMember">
        <input type="hidden" id="mem_id" name="mem_id" value="<%=log.getMem_id()%>">
        <button type="submit">내 다이닝예약 정보 보기</button>
    </form>
    
</body>
</html>
