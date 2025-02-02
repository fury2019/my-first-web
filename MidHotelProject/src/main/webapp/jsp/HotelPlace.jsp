<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Hotel.vo.Hotel_PlaceVO" %>
<!DOCTYPE html>
<html>
<head>
    <title>호텔 장소 목록</title>
</head>
<body>
    <h1>호텔 장소 목록</h1>
    
    <table border="1">
        <thead>
            <tr>
                <th>호텔 ID</th>
                <th>호텔 이름</th>
                <th>위치</th>
                <th>설명</th>
            </tr>
        </thead>
        <tbody>
            <%
                // 서블릿에서 전달된 HPlace 리스트를 가져옵니다.
                List<Hotel_PlaceVO> hPlaceList = (List<Hotel_PlaceVO>) request.getAttribute("HPlace");
                
                // 리스트가 null이 아니고 비어있지 않은 경우에만 반복합니다.
                if (hPlaceList != null && !hPlaceList.isEmpty()) {
                    for (Hotel_PlaceVO hotelPlace : hPlaceList) {
            %>
                        <tr>
                            <td><%= hotelPlace.getPlace_id() %></td>
                            <td><%= hotelPlace.getPlace_name() %></td>
                            <td><%= hotelPlace.getPlace_tel() %></td>
                            <td><%= hotelPlace.getPlace_addr() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="4">등록된 호텔 장소가 없습니다.</td>
                </tr>
            <%
                }
            %>
        </tbody>
        
    </table>
</body>
</html>
