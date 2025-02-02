<%@ page import="com.Hotel.vo.HotelVO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %>    

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>호텔 선택</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Custom CSS to control image size -->
    <style>
        .card-img-top {
            object-fit: cover; /* Maintain aspect ratio and fill the space */
            height: 200px; /* Set fixed height for images */
        }
    </style>
</head>

<body>
    <div class="container my-5">
        <h2 class="text-center mb-4">호텔 선택</h2>

        <%
        List<HotelVO> hotelList = (List<HotelVO>) request.getAttribute("hotelList");
        %>
        <%
        if (hotelList != null && !hotelList.isEmpty()) {
        %>
        <div class="row">
            <%
            for (HotelVO hotel : hotelList) {
            %>
            <div class="col-md-4 mb-4">
                <div class="card" data-bs-toggle="modal" data-bs-target="#hotelModal<%= hotel.getHotel_id() %>">
                    <!-- 이미지 추가 -->
                    <%
                    // 이미지 파일명을 hotel_id와 연결
                    String imagePath = "image/" + hotel.getHotel_id() + ".webp";
        
                    %>
                    <img src="<%= request.getContextPath() %>/<%= imagePath %>" class="card-img-top" alt="Hotel Image">
                    <div class="card-body">
                        <h5 class="card-title"><%= hotel.getHotel_name() %></h5>
                        <p class="card-text">
                            전화번호: <%= hotel.getHotel_tel() %>
                        </p>
                    </div>
                </div>
            </div>

            <!-- Modal for each hotel -->
            <div class="modal fade" id="hotelModal<%= hotel.getHotel_id() %>" tabindex="-1" aria-labelledby="hotelModalLabel<%= hotel.getHotel_id() %>" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="hotelModalLabel<%= hotel.getHotel_id() %>"><%= hotel.getHotel_name() %></h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <!-- 이미지 추가 -->
                            <img src="<%= request.getContextPath() %>/<%= imagePath %>" class="img-fluid" alt="Hotel Image">
                            <p><strong>호텔 이름:</strong> <%= hotel.getHotel_name() %></p>
                            <p><strong>전화번호:</strong> <%= hotel.getHotel_tel() %></p>
                            <%-- Handle missing getHotel_address() method safely --%>
                            <%
                            if (hotel.getHotel_addr() != null) {
                            %>
                            <p><strong>주소:</strong> <%= hotel.getHotel_addr() %></p>
                            <%
                            } else {
                            %>
                            <p><strong>주소:</strong> Not available</p>
                            <%
                            }
                            %>
                        </div>
                        <div class="modal-footer">
                            <form action="<%= request.getContextPath() %>/HotelNearbySpots" method="get">
                                <input type="hidden" name="hotelId" value="<%= hotel.getHotel_id() %>">
                                <button type="submit" class="btn btn-success">근처 명소 보기</button>
                            </form>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                        </div>
                    </div>
                </div>
            </div>
            <%
            }
            %>
        </div>
        <%
        } else {
        %>
        <p class="text-center">No hotels available.</p>
        <%
        }
        %>
    </div>
    
    <%@include file="/jsp/include/footer.jsp" %>
    
</body>

</html>
