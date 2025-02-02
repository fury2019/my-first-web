<%@ page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // 세션에서 로그인 정보를 가져오기
    MemberVO loggedInMember = (MemberVO) session.getAttribute("loginCode");
%>    

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Shop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;700&display=swap" rel="stylesheet">
    <style>
    @font-face {
      font-family: 'MinSans-Regular';
      src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
      font-weight: normal;
      font-style: normal;
    } 
       
    body {
        background-color: #f5f5f5;
        font-family: 'MinSans-Regular', sans-serif;
    }

        .header {
            background-color: #fdf1c7;
            padding: 20px 60px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 1px solid #ddd;
        }

        .header h1 {
            margin: 0;
            font-size: 3em;
            font-weight: bold;
            color: #9A0101;
            letter-spacing: 1px;
        }

        .header .nav-links {
            display: flex;
            align-items: center;
            margin-left: auto;
        }

        .header .nav-links a {
            margin: 0 15px;
            font-size: 20px;
            color: #012b28;
            text-decoration: none;
        }

        .header .nav-links a:hover {
            text-decoration: underline;
        }
		.nav-links { 
			font-family: 'MinSans-Regular', sans-serif;
		}
		
        .sub-nav {
            display: flex;
            justify-content: flex-start;
            padding: 10px 60px;
            background-color: #FFF3C8;
            font-family: 'MinSans-Regular', sans-serif;
        }

        .sub-nav .dropdown {
            position: relative;
            font-family: 'MinSans-Regular', sans-serif;
        }

        .sub-nav .dropdown-menu {
            display: none; /* 기본적으로 숨김 */
            position: absolute;
            background-color: white;
            border: 1px solid #ddd;
            z-index: 1000; /* 드롭다운이 다른 요소 위에 오도록 설정 */
        }

        .sub-nav .dropdown:hover .dropdown-menu {
            display: block; /* 호버 시 드롭다운 표시 */
        }

        .sub-nav a {
            margin: 0 15px;
            font-size: 20px;
            color: #9A0101;
            text-decoration: none;
        }

        .sub-nav a:hover {
            text-decoration: underline;
        }

        .banner {
            background-image: url('image/banner.jpg');
            background-size: cover;
            background-position: center;
            height: 300px;
            display: flex;
            align-items: center;
            justify-content: center;
            color:  whitesmoke;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
            flex-direction: column;
        }

        .banner h2 {
            font-size: 2.5em;
            margin-bottom: 10px;
        }

        .banner h4 {
            display: block;
            text-align: center;
        }

        .category-links {
            display: flex;
            justify-content: center;
            padding: 20px 0;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .category-links a {
            margin: 0 15px;
            font-size: 16px;
            color: #012b28;
            text-decoration: none;
        }

        .category-links a:hover {
            text-decoration: underline;
        }

        .carousel-inner img {
            max-height: 750px;
            object-fit: contain;
        }
        .main {
           text-align: left;
        }
    </style>
</head>

<body>
    <div class="header">
        <a href="/Main.jsp">
            <img src="/image/호텔 아이콘.png" alt="DDIT HOTEL Logo" width="50px" class="main">
        </a>
        <a href="../E-Shop.jsp" style="text-decoration: none; color: inherit;">
            <h1>&nbsp;&nbsp;&nbsp;THE E-SHOP</h1>
        </a>
         <div class="nav-links">
            <% if (loggedInMember != null) { %>
                <a href="/Logout">로그아웃</a>
                <a href="/Goods_CartList.jsp">장바구니</a>
            <% } else { %>
                <a href="jsp/Login.jsp">로그인</a>
                <a href="jsp/join.jsp">회원가입</a>
            <% } %>
            <a href="/ServiceCenter.jsp">고객 문의</a>
        </div>
    </div>

    <!-- 서브 네비게이션 왼쪽으로 정렬 및 배경색 변경 -->
    <div class="sub-nav">
        <div class="dropdown">
            <a href="#">식품</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="./Meat.jsp">육류</a>
                <a class="dropdown-item" href="./Fruit.jsp">과일</a>
                <a class="dropdown-item" href="./Seafood.jsp">수산</a>
                <a class="dropdown-item" href="../jsp/Tea.jsp">차</a>
            </div>
        </div>
        <div class="dropdown">
            <a href="#">주류</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="../jsp/Wine.jsp">와인</a>
            </div>
        </div>
        <div class="dropdown">
            <a href="#">플라워</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="../jsp/CenterPiece.jsp">센터피스</a>
                <a class="dropdown-item" href="../jsp/FlowerBasket.jsp">꽃바구니</a>
                <a class="dropdown-item" href="../jsp/OrientalOrchids.jsp">동양란</a>
                <a class="dropdown-item" href="../jsp/WesternOrchid.jsp">서양란</a>
            </div>
        </div>
        <div class="dropdown">
            <a href="#">라이프스타일</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="../jsp/Bedding.jsp">침구</a>
                <a class="dropdown-item" href="../jsp/Linen.jsp">린넨</a>
                <a class="dropdown-item" href="../jsp/Living.jsp">리빙</a>
            </div>
        </div>
    </div>

    <!-- 슬라이드 쇼 (Carousel) -->
    <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="image/e-shop1.jpg" class="d-block w-100" alt="e-shop 이미지 1">
            </div>
            <div class="carousel-item">
                <img src="image/e-shop2.jpg" class="d-block w-100" alt="e-shop 이미지 2">
            </div>
            <div class="carousel-item">
                <img src="image/e-shop3.jpg" class="d-block w-100" alt="e-shop 이미지 3">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <div class="banner">
        <h2>DDIT PREMIUM GIFT</h2>
        <h4>진심이 전해지는 순간까지 더없이 엄격한 눈으로 골라 구석구석 살피고 들여다봅니다.</h4>
    </div>

<%@include file="/jsp/include/footer.jsp" %>

</body>
</html>