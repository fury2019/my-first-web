<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/AdminPage.css">
  
    <%@include file="/jsp/include/AdminAjax.jsp" %>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script type="text/javascript">
   

    
    function loadContent(url) {
        const contentArea = $("#content-area");

        $.ajax({
            url: url,
            type: "GET",
            success: function (response) {
                contentArea.html(response);

                // FAQ 리스트 페이지일 경우 이벤트 초기화
                if (url.includes('/faqList')) {
                    initializeFAQEvents();
                }
            },
            error: function (xhr) {
                console.error("Error loading content:", xhr.statusText);
                contentArea.html("<p>콘텐츠를 불러오지 못했습니다.</p>");
            }
        });
    }
    
    </script>
    
  <style>
  	  @font-face {
    		font-family: 'MinSans-Regular';
    		src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
    		font-weight: normal;
    		font-style: normal;
	}
	 .layout {
	 	font-family: 'MinSans-Regular', sans-serif;
	 }
  	 .main-content {
  	 	font-family: 'MinSans-Regular', sans-serif;
  	 }
  
  </style>  



</head>
<body>
    <div class="layout">
        <!-- 사이드바 및 콘텐츠 -->
        <div class="content">
            <!-- 사이드바 -->
			<div class="sidebar" id="menu">
			    <ul>
			        <li><a href="#" onclick="loadContent('/dashBoard')" id="dashboard">대시보드</a></li>
			        <li>
			            <a href="#" id="users">회원 관리</a>
			            <ul id="user-submenu" style="display: none;">
			                <li><a href="#" onclick="loadContent('/viewAllMember')">회원 목록</a></li>
			                <li><a href="#" onclick="loadContent('/memberBlack')">블랙리스트 관리</a></li>
			            </ul>
			        </li>
			        <li>
		              	<a href="#" id="res">예약관리</a>
			              	<ul id="res-submenu" style="display: none;">
						    	<li><a href="#" onclick="loadContent('/hotelRoomResList')""> 객실</a></li>
						    	<li><a href="#" onclick="loadContent('/facilitiesResList')"> 다이닝</a></li>
						    </ul>
					  </li>
			        <li>
					    <a href="#" id="faq">FAQ 관리</a>
					    <ul id="faq-submenu" style="display: none;">
					        <li><a href="#" onclick="loadContent('/faqList')">FAQ 목록</a></li>
					        <li><a href="#" id="addBtn" onclick="loadContent('/jsp/FAQInsert.jsp')">새글등록</a></li>
					        <li><a href="#" id="updateBtn" onclick="loadContent('/faqUpdateList')">수정 / 삭제</a></li>
					    </ul>
					</li>
					
			        <li>
					    <a href="#" id="notice">공지사항 관리</a>
					    <ul id="notice-submenu" style="display: none;">
					        <li><a href="#" onclick="loadContent('/noticeList')">공지사항목록</a></li>
					        <li><a href="#" id="addBtn" onclick="loadContent('/jsp/NoticeInsert.jsp')">새글등록</a></li>
					        <li><a href="#" id="updateBtn" onclick="loadContent('/noticeUpdateList')">수정 / 삭제</a></li>
					    </ul>
					</li>
			        <li>
			            <a href="#" id="coupons">쿠폰 관리</a>
			            <ul id="coupon-submenu" style="display: none;">
			                <li><a href="#" onclick="loadContent('/jsp/CouponInsert.jsp')">쿠폰 발송</a></li>
			                <li><a href="#" onclick="loadContent('/couponAllView')">쿠폰 회수</a></li>
			            </ul>
			        </li>
			    </ul>
			</div>

            <!-- 메인 콘텐츠 -->
            <div class="main-content">
                <div id="content-area">
                    <h1>관리자 페이지</h1>
                    <p>로딩 중...</p>
                </div>
            </div>
        </div>
    </div>

    <%@include file="/jsp/include/footer.jsp" %>
</body>
</html>
