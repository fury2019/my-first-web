<%@page import="com.Hotel.vo.MemberVO"%> 
<%@page import="com.Hotel.vo.HotelVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %> <!-- 공통 header 포함 -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&display=swap" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>호텔 찾기</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/styles.css">
<style>
/* 기본 스타일 설정 */
/* body { */
/*     background-color: #FFF3C8;  */
/* } */
  @font-face {
    font-family: 'MinSans-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

.hotel-button {
    background-color: #0000;  /* 배경색을 #FFF3C8로 설정 */
    border: none;  /* 테두리 제거 */
    color: #333;  /* 버튼 텍스트 색상 */
    padding: 10px 20px;  /* 버튼의 여백 */
    font-size: 16px;  /* 글자 크기 */
    border-radius: 8px;  /* 버튼 모서리 둥글게 */
    cursor: pointer;  /* 마우스를 올리면 포인터로 바뀌게 */
    transition: background-color 0.3s ease;  /* 배경색 변화 효과 */
    font-family: 'MinSans-Regular', sans-serif;
}

/* .hotel-button:hover { */
/*     background-color: #E6D7A1;  /* 마우스를 올렸을 때 색상 */ 
/* } */


div.container {
    display: flex;
    flex-wrap: nowrap;
    justify-content: space-between;
    background-color: #FFF3C8;
    margin: 20px auto;
    width: 95%;
    max-width: 2000px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    font-family: 'MinSans-Regular', sans-serif;
}

.region-list {
    width: 22%; /* 너비를 줄여서 더 왼쪽으로 밀림 */
    background-color: #FFF3C8;
    padding: 15px;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    overflow-y: auto;
    max-height: 700px;
    margin-left: -10px; 
}

.region-list ul {
    list-style-type: none;
    padding: 0;
}

.region-list li {
    margin: 10px 0;
    padding: 10px 20px;
    background-color: #f4d19f; 
    border-radius: 8px;
    transition: background-color 0.3s ease;
    cursor: pointer;
}


.region-list li:hover {
    background-color: #ffca83;
}

.search-bar {
    margin-bottom: 20px;
}

.search-bar input[type="text"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 20px;
    font-size: 16px;
    margin-bottom: 10px;
}

.search-bar input[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #5A8DEE;
    color: white;
    border: none;
    border-radius: 20px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.search-bar input[type="submit"]:hover {
    background-color: #4173CC;
}

.details-container {
    width: 50%;
    background-color: #FFF3C8;
    border-radius: 8px;
    max-height: 700px;
    margin-right: -235px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    font-family: 'MinSans-Regular', sans-serif;
}

#hotel-details {
    margin-top: 20px;
    padding: 20px;
    text-align: left;
    width: 100%;
}

#details-content {
	background-color: FFF3C8;
    font-size: 16px;
    color: #333;
}

#details-image {
    flex: 1; /* 이미지가 공간을 적절히 차지하도록 설정 */
    max-width: 60%; /* 이미지 최대 너비 제한 */
    max-height 30%;
    border-radius: 8px;
    overflow: hidden;
}

#details-image img {
    max-width: 60%;
    height: 60%;
    margin-top: 10px;
    border-radius: 8px;
}

.details-content {
    display: flex;
    align-items: center; /* 수직 가운데 정렬 */
    justify-content: space-between; /* 이미지와 지도 사이에 여백을 생성 */
    gap: 20px;
    margin-top: 20px;
}

#map-container {
    flex: 2; /* 지도 컨테이너가 더 넓게 표시되도록 설정 */
    height: 500px; /* 높이 확장 */
    border-radius: 8px;
    overflow: hidden;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
    margin-left: 20px; /* 이미지와의 간격 조정 */
    margin-right: 100px;
    margin-top: 100px;
}

#map-iframe {
    width: 100%;
    height: 100%;
    border: none;
}


</style>
</head>
<body>
    <div class="container">
        <div class="region-list">
            <!-- 호텔 주소 검색 폼 -->
            <form class="search-bar" action="/hotelfindServlet" method="post">
                <input type="text" name="hotel_addr" id="hotel_addr" placeholder="호텔 주소 검색" required />
                <input type="submit" value="검색">
            </form>
            
            <% 
            // 지역별 호텔 목록 생성
            List<String> regions = (List<String>) request.getAttribute("regions");
            List<HotelVO> hotels = (List<HotelVO>) request.getAttribute("hotels");
            List<HotelVO> searchedHotels = (List<HotelVO>) request.getAttribute("searchedHotels");
            Map<String, List<HotelVO>> regionHotelMap = new LinkedHashMap<>();
            if (regions != null && hotels != null) {
                for (String region : regions) {
                    regionHotelMap.put(region, hotels.stream()
                        .filter(h -> h.getHotel_addr().startsWith(region))
                        .toList());
                }
            }
            // 지역별로 호텔 이름을 나누어 보여줌
            if (!regionHotelMap.isEmpty()) {
                for (Map.Entry<String, List<HotelVO>> entry : regionHotelMap.entrySet()) {
                    String region = entry.getKey();
                    List<HotelVO> regionHotels = entry.getValue();
            %>
            <div class="region-container">
                <h3><%= region %></h3>
                <ul>
                    <% 
                    if (regionHotels != null && !regionHotels.isEmpty()) {
                        for (HotelVO hotel : regionHotels) { 
                    %>
                    <li>
                        <button class="hotel-button" data-hotel-name="<%= hotel.getHotel_name() %>">
                            <%= hotel.getHotel_name() %> <!-- 호텔 이름을 버튼으로 표시 -->
                        </button>
                    </li>
                    <% 
                        }
                    } 
                    %>
                </ul>
            </div>
            <% 
                }
            } 
            %>
            
            <% if (searchedHotels != null && !searchedHotels.isEmpty()) { %>
            <!-- 검색된 호텔 리스트 표시 -->
            <div class="region-container">
                <h3>검색 결과</h3>
                <ul>
                    <% 
                    for (HotelVO hotel : searchedHotels) { 
                    %>
                    <li>
                        <button type="button" class="hotel-button" data-hotel-name="<%= hotel.getHotel_name() %>">
                            <%= hotel.getHotel_name() %>
                        </button>
                    </li>
                    <% 
                    } 
                    %>
                </ul>
            </div>
            <% } else if (request.getAttribute("searchedHotels") != null) { %>
            <!-- 검색 결과가 없을 경우 -->
            <div class="region-container">
                <h3>검색 결과</h3>
                <p style="text-align: center; color: #777;">검색된 호텔이 없습니다.</p>
            </div>
            <% } %>
        </div>

        <div class="details-container">
            <div id="hotel-details">
                <h3>호텔 세부 정보</h3>
                <div id="details-content">호텔 정보를 선택하세요.</div>
                <div class="details-content">
	                <div id="details-image"></div>
		        </div>
            </div>
        </div>
	                <div id="map-container" >
			            <iframe id="map-iframe" src="" style="width: 100%; height: 100%; border: none;"></iframe>
			        </div>
    </div>

    <script>
        // 호텔 목록 버튼 클릭 시
        $(".region-list li").click(function() {
    const hotelName = $(this).text().trim(); // 클릭된 li의 텍스트(호텔 이름) 가져오기

    // JSON 파일에서 호텔 이미지 URL 가져오기
    $.getJSON("/resources/data/hotelImage.json", function(data) {
        const imageUrl = data[hotelName] || ""; // 호텔 이미지 URL 확인

        // 서버에서 호텔 세부 정보 가져오기
        $.ajax({
            url: "/hotelDetailsServlet", // 호텔 세부 정보를 가져오는 Servlet 호출
            method: "get",
            data: { hotel_name: hotelName },
            dataType: "json",
            success: function(response) {
                if (response) {
                    // 세부 정보 표시
                    var detailsHtml = 
                        "<p><strong>호텔 이름:</strong> " + 
                        "<a href='../api/mapApi/" + response.hotelName.replaceAll(' ', '_') + ".html' target='_blank'>" +
                        response.hotelName + 
                        "</a></p>" +
                        "<p><strong>호텔 주소:</strong> " + response.hotelAddr + "</p>" +
                        "<p><strong>호텔 전화번호:</strong> " + response.hotelTel + "</p>";
                    $("#details-content").html(detailsHtml);

                    // 이미지가 있을 경우 표시
                    if (imageUrl) {
                        var imageHtml = '<img src="' + imageUrl + '" alt="' + hotelName + '" width="500" height="450">';
                        $("#details-image").html(imageHtml);
                    } else {
                        $("#details-image").html("<p>이미지를 찾을 수 없습니다.</p>");
                    }

                    // 지도 URL 설정 및 표시
                    const mapUrl = "../api/mapApi/" + hotelName.replaceAll(' ', '_') + ".html";
                    $("#map-iframe").attr("src", mapUrl);
                    $("#map-container").show();
                } else {
                    $("#details-content").html("<p>호텔 정보를 불러올 수 없습니다.</p>");
                }
            },
            error: function() {
                alert("호텔 정보를 불러오지 못했습니다.");
            }
        });
    });
});

    </script>
    <%@include file="/jsp/include/footer.jsp" %> <!-- 공통 footer 포함 -->
</body>
</html> 
