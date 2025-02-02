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
<title>동양란 태양금</title>
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
.detail-item img {
    width: 500%; /* 원하는 크기로 조정 */
    max-width: 1000px; /* 최대 너비 설정 */
    height: auto;
    border-radius: 5px;
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
         <img src="../../image/동양란 태양금.jpg" alt="동양란 태양금">
          </div>
        <div class="product-info">
            <h1>동양란 태양금</h1>
            <div class="details">
                <p>판매가 : <span class="price" id="unit-price">200,000원</span></p>
                <p>구성 : 태양금</p>
                <p>배송비 : 서울 & 경기지역 무료, 경기 외곽지역 및 지방 별도 비용 (이용안내 참조)</p>
            </div>
            <div class="quantity">
                                <label for="quantity">수량:</label>
                                <input type="number" id="quantity" name="goods_amt" value="1" min="1" onchange="updateTotal()">
                            </div>
                            <div class="total"> 총 금액: <span class="total-price" id="total-price">200,000원</span> </div>
                            <input type="hidden" name="goods_id" value="Fl011"> <!-- 상품 ID 추가 -->
                            <input type="hidden" name="goods_name" value="동양란 태양금"> <!-- 상품 이름 추가 -->
                            <input type="hidden" name="goods_price" value="200000"> <!-- 가격 추가 -->
                            <input type="hidden" name="mem_id" value="${sessionScope.userId}"> <!-- 사용자 ID 추가 -->
                            <button type="submit" class="btn">장바구니</button>
                        </div>
                    </div>
                </form>

    <!-- 상품 상세 정보 추가 -->
    <div class="product-details">
        <h2>상품 상세</h2>
        <br>
        <h3>동양란 태양금</h3>
        <br>
        <p>꽃 구성 | 태양금</p>
        <p>화기 규격 | 10cm(w) x 10cm(d) x 15cm(h)</p>
        <br>
        <p>태양금은 가장자리에 아름다운 황금색 무늬가 있어 고운 자태와 멋스러움을 드러냅니다.</p>
        <p>성질이 튼튼하여 가꾸기에도 좋은 품종으로 추천합니다.</p>
        <br>
        <div class="detail-item">
        <img src="../../image/동양 태양금.JPG" alt="동양란 태양금">
         <div class="product-details">
        <h2>※관리방법</h2>
        <br>
        <p>- 난을 건강하고 아름다운 상태로 유지하기 위해서는 난의 종류를 이해하고 적절하게 관리해야 합니다.</p>
        <p>- 10-15일에 한번 듬뿍 물을 주는 것이 좋습니다.</p>
        <p>- 난은 밝은 곳에서 자라야 하지만, 직접적으로 햇빛에 노출되지 않도록 주의해야 하며 바람이 많이 불거나 건조한 곳은 피해야 합니다.</p>
        <p>- 난은 온도와 습도가 중요하며 일반적으로 20~25도의 온도에 40~60%의 습도를 권장합니다.</p>
        <p>- 관수</p>
        <p>난은 수분이 필요하지만, 과습은 피해야 합니다.</p>
        <p>물을 충분히 스며들 정도로 관수하고, 다음 관수시기는 흙이 마르도록 방치합니다.</p>
        <p>계절별로 여름에는 해가 젖을 때, 겨울에는 한밤에, 그 외 계절에는 아침, 저녁이 좋습니다.</p>
        <p>- 비료 주기</p>
        <p>유기질 비료는 물을 줄 때 넣기 때문에 안전합니다.</p>
        <p>무기질 액비는 물과 섞어 농도를, 고형비료는 정량(무게)을 지키는 것이 중요합니다.</p>
        <p>비료는 봄과 여름에는 2주간, 가을과 겨울에는 한 달에 한 번 주는 것이 좋습니다.</p>
         <p>- 가지치기</p>
        <p>난은 꽃이 필 염두에 두고 가지치기 하는 것이 좋으며 새로운 꽃이 피일 때까지는 꽃대를 그대로 두는 것을 권장합니다.</p>
        <p>- 상품 이미지는 연출된 컷으로 실제와 다를 수 있습니다.</p>
        <br>
    </div>
</div>
</div>

<script>
    const unitPrice = 200000; // 단가
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