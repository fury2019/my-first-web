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
    <title>침구</title>
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
            background-color: #FFF3C8;
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
            text-decoration: none;
            color: #9A0101;
        }

        .sub-nav {
            display: flex;
            justify-content: flex-start;
            padding: 10px 60px;
            background-color: #FFF3C8;
        }

        .sub-nav .dropdown {
            position: relative;
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

        .category-header {
            margin: 20px 0;
            text-align: center; /* 중앙 정렬 */
        }

        .category-title {
            font-size: 24px;
            font-weight: bold;
            margin-top: 10px; /* 위쪽 여백 추가 */
        }

        .category-description {
            margin-bottom: 20px;
        }

        .product {
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 15px;
            text-align: center;
            margin: 10px; /* 카드 간의 여백 */
        }
        
		 .product a {
        	text-decoration: none; /* 링크의 밑줄 제거 */
        	color: inherit; /* 부모 요소의 색상 상속 */
    	}
		
        .product img {
            max-width: 100%; /* 이미지 크기 조정 */
            height: auto; /* 비율 유지 */
            border-radius: 5px;
        }

        .product-name {
            font-weight: bold;
            margin-top: 10px;
        }

        .product-price {
            color: #b12704; /* 가격 색상 */
            font-size: 18px;
            margin-top: 5px;
        }
    </style>
</head>

<body>
<div class="header">
        <a href="/Main.jsp">
            <img src="../image/호텔 아이콘.png" alt="DDIT HOTEL Logo" width="50px" class="main">
        </a>
        <a href="../E-Shop.jsp" style="text-decoration: none; color: inherit;">
            <h1>&nbsp;&nbsp;&nbsp;THE E-SHOP</h1>
        </a>
         <div class="nav-links">
            <% if (loggedInMember != null) { %>
                <a href="/Logout">로그아웃</a>
            <% } else { %>
                <a href="jsp/Login.jsp">로그인</a>
                <a href="jsp/join.jsp">회원가입</a>
            <% } %>
            <a href="../ServiceCenter.jsp">고객 문의</a>
        </div>
    </div>

     <!-- 서브 네비게이션 왼쪽으로 정렬 및 배경색 변경 -->
    <div class="sub-nav">
        <div class="dropdown">
            <a href="#">식품</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="../Meat.jsp">육류</a>
                <a class="dropdown-item" href="../Fruit.jsp">과일</a>
                <a class="dropdown-item" href="../Seafood.jsp">수산</a>
                <a class="dropdown-item" href="Tea.jsp">차</a>
            </div>
        </div>
        <div class="dropdown">
            <a href="#">주류</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="Wine.jsp">와인</a>
            </div>
        </div>
        <div class="dropdown">
            <a href="#">플라워</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="CenterPiece.jsp">센터피스</a>
                <a class="dropdown-item" href="FlowerBasket.jsp">꽃바구니</a>
                <a class="dropdown-item" href="OrientalOrchids.jsp">동양란</a>
                <a class="dropdown-item" href="WesternOrchid.jsp">서양란</a>
            </div>
        </div>
        <div class="dropdown">
            <a href="#">라이프스타일</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="Bedding.jsp">침구</a>
                <a class="dropdown-item" href="Linen.jsp">린넨</a>
                <a class="dropdown-item" href="Living.jsp">리빙</a>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="category-header">
            <img src="../image/e-shop2.jpg" alt="침구" style="width: 100%; height: auto; border-radius: 5px;">
            <h2 class="category-title">침구 (3)</h2>
        </div>
    
        <div class="row justify-content-center"> <!-- 중앙 정렬 -->
            <div class="col-md-3 product" style="margin: 0 55px 30px;"> <!-- 아래쪽 여백 추가 -->
            	<a href="../jsp/Bedding_E-SHOP/1.jsp">
                <img src="../image/베딩 세트_S.jpg" alt="베딩 세트_S">
                <div class="product-name">베딩 세트_S</div>
                <div class="product-price">1,200,000원</div>
                </a>
            </div>
            <div class="col-md-3 product" style="margin: 0 55px 30px;"> <!-- 아래쪽 여백 추가 -->
            	<a href="../jsp/Bedding_E-SHOP/2.jsp">
                <img src="../image/베딩 세트_Q.jpg" alt="베딩 세트_Q">
                <div class="product-name">베딩 세트_Q</div>
                <div class="product-price">1,400,000원</div>
                </a>
            </div>
            <div class="col-md-3 product" style="margin: 0 55px 30px;"> <!-- 아래쪽 여백 추가 -->
            	<a href="../jsp/Bedding_E-SHOP/3.jsp">
                <img src="../image/베딩 세트_K.jpg" alt="베딩 세트_K">
                <div class="product-name">베딩 세트_K</div>
                <div class="product-price">1,600,000원</div>
                </a>
            </div>
        </div>
    </div>
    
  <%@include file="/jsp/include/footer.jsp" %>

</body>

</html>
    