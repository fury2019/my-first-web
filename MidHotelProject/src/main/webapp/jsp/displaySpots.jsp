<%@page import="com.Hotel.vo.Place_LikeVO"%>
<%@ page import="com.Hotel.vo.Hotel_PlaceVO"%>
<%@ page import="com.Hotel.vo.MemberVO" %>
<%@ page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %>    

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>근처 명소</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/HotelPlace.css">
    
    <!-- Custom CSS -->
    <style>
        .card-img-top {
            object-fit: cover;
            height: 200px;
        }
        .modal-img {
            width: 100%;
            max-height: 500px;
            object-fit: contain;
        }
        
    </style>
</head>

<body>
    <div class="container my-5">
        <h2 class="text-center mb-4">근처 명소</h2>
        <%
            List<Hotel_PlaceVO> spots = (List<Hotel_PlaceVO>) request.getAttribute("spots");
            MemberVO loginMember = (MemberVO) session.getAttribute("loginCode");
        %>

        <% if (spots != null && !spots.isEmpty()) { %>
        <div class="row">
            <% for (Hotel_PlaceVO spot : spots) { %>
            <div class="col-md-4 mb-4">
                <div class="card" data-bs-toggle="modal" data-bs-target="#spotModal<%= spot.getPlace_id() %>">
                    <% String imagePath = "place_image/" + spot.getPlace_id() + ".webp"; %>
                    <img src="<%= request.getContextPath() %>/<%= imagePath %>" class="card-img-top" alt="Spot Image">
                    <div class="card-body">
                        <h5 class="card-title"><%= spot.getPlace_name() %></h5>
                        <p class="card-text">
                            <strong>전화:</strong> <%= spot.getPlace_tel() %><br>
                            <strong>주소:</strong> <%= spot.getPlace_addr() %>
                        </p>
                    </div>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="spotModal<%= spot.getPlace_id() %>" tabindex="-1" aria-labelledby="spotModalLabel<%= spot.getPlace_id() %>" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="spotModalLabel<%= spot.getPlace_id() %>"><%= spot.getPlace_name() %></h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <img src="<%= request.getContextPath() %>/<%= imagePath %>" class="modal-img" alt="Spot Image">
                            <p><strong>전화:</strong> <%= spot.getPlace_tel() %></p>
                            <p><strong>주소:</strong> <%= spot.getPlace_addr() %></p>
                            <p><strong>카테고리:</strong> <%= spot.getPlace_cat_id() %></p>
                            <p><strong>좋아요 수:</strong> <%= spot.getPlaceLikeVo().size() %></p>

                            <% 
                            boolean isLiked = false;
                            if (loginMember != null) {
                                for (Place_LikeVO likeVo : spot.getPlaceLikeVo()) {
                                    if (loginMember.getMem_id().equals(likeVo.getMem_id())) {
                                        isLiked = true;
                                        break;
                                    }
                                }
                            }
                            if (loginMember != null && !isLiked) { 
                            %>
                            <form action="HotelNearbySpots" method="get">
                                <input type="hidden" name="hotelId" value="<%= spot.getHotel_id() %>" />
                                <input type="hidden" name="placeId" value="<%= spot.getPlace_id() %>" />
                                <input type="hidden" name="action" value="like" />
                                <button type="submit" class="btn btn-primary">좋아요</button>
                            </form>
                            <% } else if (loginMember != null && isLiked) { %>
                            <form action="HotelNearbySpots" method="get">
                                <input type="hidden" name="hotelId" value="<%= spot.getHotel_id() %>" />
                                <input type="hidden" name="placeId" value="<%= spot.getPlace_id() %>" />
                                <input type="hidden" name="action" value="unlike" />
                                <button type="submit" class="btn btn-danger">좋아요 취소</button>
                            </form>
                            <% } else if (loginMember == null) { %>
                            <p class="text-muted">좋아요는 로그인이 필요합니다.</p>
                            <% } %>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                        </div>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
        <% } else { %>
        <p class="text-center">이 호텔 근처에는 명소가 없습니다.</p>
        <% } %>
    </div>

    <%@include file="/jsp/include/footer.jsp" %>
</body>

</html>
