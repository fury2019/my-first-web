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
<title>정성한우 명품 2</title>
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
		    font-family: 'MinSans-Regular', sans-serif;
		    background-color: #f5f5f5;
		    margin: 0;
/* 		    padding: 20px; */
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
            text-decoration: none;
            color: #9A0101;
        }

.nav-links {
    display: flex;
    align-items: center;
}

.nav-links a {
    margin: 0 15px;
    font-size: 20px;
    color: #012b28;
    text-decoration: none;
}


.sub-nav {
    display: flex;
    justify-content: flex-start;
    padding: 10px 60px;
    background-color: #FFF3C8;
}

.dropdown {
    position: relative;
    margin-right: 20px;
}

.dropdown-menu {
    display: none; /* 기본적으로 숨김 */
    position: absolute;
    background-color: white;
    border: 1px solid #ddd;
    z-index: 1000; /* 드롭다운이 다른 요소 위에 오도록 설정 */
    min-width: 120px; /* 최소 너비 설정 */
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    border-radius: 8px; /* 모서리 둥글게 */
}

.dropdown:hover .dropdown-menu {
    display: block; /* 호버 시 드롭다운 표시 */
}

.dropdown a {
    display: block; /* 블록 형태로 설정 */
    padding: 10px 15px; /* 패딩 추가 */
    color: #9A0101; /* 글자 색상 */
    text-decoration: none;
}

.dropdown a:hover {
    background-color: #f0f0f0; /* 호버 시 배경색 변경 */
}

.container {
    max-width: 1200px;
    margin: auto;
    background: white;
    padding: 20px;
    border-radius: 12px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    margin-bottom: 40px; /* 푸터와의 간격 추가 */
}

.product-section {
    display: flex;
    flex-direction: column;
    gap: 40px;
}

.product-image {
    flex: 1;
    display: flex;
    justify-content: center;
    align-items: center;
}

.product-image img {
    max-width: 100%;
    height: auto;
}

.product-info {
    flex: 1;
    padding: 20px;
}

.product-info h1 {
    font-size: 28px;
    margin-bottom: 10px;
    color: #333;
    display: inline-block; /* 인라인 블록으로 변경 */
}

.heart-button {
    background: none;
    border: 1px solid #ccc; /* 테두리 추가 */
    border-radius: 5px; /* 테두리 둥글게 */
    cursor: pointer;
    font-size: 20px;
    color: #7d7d7d; /* 기본 색상 */
    margin-left: 10px; /* 하트와 제목 간격 */
    padding: 5px; /* 하트 버튼 패딩 */
}

.details {
    margin-bottom: 20px;
}

.details p {
    margin: 5px 0;
    font-size: 16px;
    color: #555;
}

.price {
    font-weight: bold;
    color: #d9534f; /* 가격 강조 색상 */
    font-size: 20px;
}

.quantity {
    margin: 20px 0;
}

.quantity label {
    margin-right: 10px;
    font-size: 16px;
}

.total {
    font-size: 18px;
    margin: 20px 0;
    font-weight: bold;
    color: #333;
}

.btn {
    padding: 12px 24px;
    background-color: #5cb85c;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    margin-right: 10px;
    transition: background-color 0.3s;
    font-size: 16px;
}

.btn:hover {
    background-color: #4cae4c;
}

input[type="number"] {
    width: 60px;
    padding: 5px;
    font-size: 16px;
    margin-left: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

.product-details {
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.product-details h2 {
    font-size: 24px;
    color: #333;
    margin-bottom: 15px;
}

.product-details h3 {
    font-size: 20px;
    margin-bottom: 10px;
}

.detail-item {
    margin-bottom: 20px;
}

.detail-item h4 {
    font-size: 18px;
    margin: 10px 0;
    color: #9A0101;
}

.detail-item img {
    width: 100%; /* 원하는 크기로 조정 */
    max-width: 400px; /* 최대 너비 설정 */
    height: auto;
    border-radius: 5px;
}

.detail-item p {
    margin-top: 5px;
    color: #555;
}
        </style>
    </head>
    <body>
        <div class="header">
           <a href="/Main.jsp">
               <img src="../../image/호텔 아이콘.png" alt="DDIT HOTEL Logo" width="50px" class="main">
           </a>
           <a href="../../E-Shop.jsp" style="text-decoration: none; color: inherit;">
               <h1>&nbsp;&nbsp;&nbsp;THE E-SHOP</h1>
           </a>
           <div class="nav-links">
               <% if (loggedInMember !=null) { %>
                   <a href="CenterPiece_E-SHOP/1">로그아웃</a>
                   <% } else { %>
                       <a href="../../jsp/Login.jsp">로그인</a>
                       <a href="../../jsp/join.jsp">회원가입</a>
                       <% } %>
                           <a href="#">고객 문의</a>
           </div>
       </div>

        <!-- 서브 네비게이션 왼쪽으로 정렬 및 배경색 변경 -->
        <div class="sub-nav">
            <div class="dropdown">
                <a href="#">식품</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="../../Meat.jsp">육류</a>
                    <a class="dropdown-item" href="../../Fruit.jsp">과일</a>
                    <a class="dropdown-item" href="../../Seafood.jsp">수산</a>
                    <a class="dropdown-item" href="../Tea.jsp">차</a>
                </div>
            </div>
            <div class="dropdown">
                <a href="#">주류</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="../Wine.jsp">와인</a>
                </div>
            </div>
            <div class="dropdown">
                <a href="#">플라워</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="../CenterPiece.jsp">센터피스</a>
                    <a class="dropdown-item" href="../FlowerBasket.jsp">꽃바구니</a>
                    <a class="dropdown-item" href="../OrientalOrchids.jsp">동양란</a>
                    <a class="dropdown-item" href="../WesternOrchid.jsp">서양란</a>
                </div>
            </div>
            <div class="dropdown">
                <a href="#">라이프스타일</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="../Bedding.jsp">침구</a>
                    <a class="dropdown-item" href="../Linen.jsp">린넨</a>
                    <a class="dropdown-item" href="../Living.jsp">리빙</a>
                </div>
            </div>
        </div>

       <form action="${pageContext.request.contextPath}/goods_CartInsert" method="post">
                    <div class="product-section">
                        <div class="product-image">
         <img src="../../image/정성한우 명품 2.jpg" alt="정성한우 명품 2">
          </div>
        <div class="product-info">
            <h1>정성한우 명품 2</h1>
            <div class="details">
                <p>판매가 : <span class="price" id="unit-price">650,000원</span></p>
                <p>구성 : 1+등급 구이용 등심 250g x 2팩, 채끝 250g x 2팩, 갈비살 250g x 2팩, 차돌박이 250g x 2팩 총 8팩 2kg</p>
                <p>원산지 : 국내산 한우 100%</p>
                <p>배송비 : 서울 & 경기지역 무료, 경기 외곽지역 및 지방 별도 비용 (이용안내 참조)</p>
            </div>
            <div class="quantity">
                                <label for="quantity">수량:</label>
                                <input type="number" id="quantity" name="goods_amt" value="1" min="1" onchange="updateTotal()">
                            </div>
                            <div class="total"> 총 금액: <span class="total-price" id="total-price">650,000원</span> </div>
                            <input type="hidden" name="goods_id" value="Fo005"> <!-- 상품 ID 추가 -->
                            <input type="hidden" name="goods_name" value="정성한우 명품 2"> <!-- 상품 이름 추가 -->
                            <input type="hidden" name="goods_price" value="650000"> <!-- 가격 추가 -->
                            <input type="hidden" name="mem_id" value="${sessionScope.userId}"> <!-- 사용자 ID 추가 -->
                            <button type="submit" class="btn">장바구니</button>
                        </div>
                    </div>
                </form>

    <!-- 상품 상세 정보 추가 -->
    <div class="product-details">
        <h2>상품 상세</h2>
        <h3>정성한우 명품 2 구성품</h3>
        <p>구이용 등심 250g, 채끝 250g, 갈비살 250g, 차돌박이 250g x 각 2팩 총 2kg(250g씩 스킨포장)</p>
        <div class="detail-item"> <h4>구이용 등심</h4> <img src="../../image/정성한우 일품 구이용 등심.jpg" alt="구이용 등심">
         <p>한우 부위 중 가장 선호도가 높은 등심은 육질이 부드럽고 육즙이 풍부하여</p>
        <p>고소함과 감칠맛이 뛰어난 부위입니다. 가정에서 구이용으로 즐기기</p>
        <p>알맞은 두께로 손질해 손쉽게 조리하여 드실 수 있도록 보내드립니다.</p>
    </div>
    <div class="detail-item">
        <h4>채끝</h4> <img src="../../image/채끝.JPG" alt="채끝">
        <p>소를 몰 때 휘두르는 채찍의 끝이 닿는 부분이라 하여 이름 붙여진 채끝은</p>
        <p>고깃결이 곱고 부드러우며 마블링이 골고루 퍼져 있어</p>
        <p>적당히 구우면 풍부한 육즙과 마블링의 향미를 즐길 수 있습니다.</p>
    </div>
    <div class="detail-item">
        <h4>갈비살</h4> <img src="../../image/갈비살.jpg" alt="갈비살">
        <p>갈비살은 갈비뼈에 사이사이에 있는 살코기를 분리하여 그 모양이 손가락처럼</p>
        <p>길고 두툼하며, 쫄깃한 식감과 고소한 육향이 일품인 부위입니다.</p>
        <p>구이용으로 드시기 쉽게 한 점씩 정성스럽게 손질하여 담았습니다.</p>
    </div>
     <div class="detail-item">
         <h4>차돌박이</h4> <img src="../../image/정성한우 일품 차돌박이.jpg" alt="차돌박이">
        <p>근내지방이 섞여 있어 고소하고 얇게 썰어 구이용으로 부드러운 식감과</p>
        <p>풍부한 풍미를 느낄 수 있습니다.짙은 적색을 띠며 고기의 결이</p>
        <p>거친 편에 속하지만 구울때 나오는 지방의 향미는 식욕을 돋우어 주며</p>
        <p>쫀득하면서도 꼬들꼬들한 식감이 일품인 부위입니다.</p>
    </div>
</div>
</div>
<script>
    const unitPrice = 650000; // 단가
    const quantityInput = document.getElementById('quantity');
    const totalPriceElement = document.getElementById('total-price');

    function updateTotal() {
        const quantity = parseInt(quantityInput.value);
        const totalPrice = unitPrice * quantity;
        totalPriceElement.textContent = totalPrice.toLocaleString() + '원';
    }

    function toggleHeart() {
        const heartButton = document.getElementById('heart-button');
        const isHearted = heartButton.style.color === 'red';
        heartButton.style.color = isHearted ? '#7d7d7d' : 'red'; // 하트 색상 변경
    }
</script>
</body>

</html>