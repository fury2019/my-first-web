<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>



<style>
  @font-face {
    font-family: 'MinSans-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

.header {
	background-color: #FFF3C8;
	/* 배경색 변경 */
	color: #333;
	text-align: center;
	padding: 0px 0;
	/* 상하 패딩 */
	font-family: 'MinSans-Regular', sans-serif;
	/* 기본 폰트 */
	position: relative;
	/* 자식 요소의 절대 위치 설정을 위한 기준 */
}

.header img {
	max-width: 100%;
	/* 이미지가 부모 요소의 너비를 넘지 않도록 설정 */
	height: auto;
	/* 비율 유지 */
	margin-left: 10px;
	/* 왼쪽으로 이동 (원하는 값으로 조정 가능) */
	margin-right: 70px;
	/* 오른쪽으로 이동 (원하는 값으로 조정 가능) */
}

.header .links {
	position: absolute;
	/* 절대 위치 사용 */
	width: 100%;
	/* 전체 폭 사용 */
	display: flex;
	/* 플렉스 박스 사용 */
	justify-content: space-between;
	/* 좌우 공간 분배 */
	padding: 0 60px;
	/* 좌우 패딩 */
	bottom: 20px;
	/* 아래쪽 위치 조정 */
}

.header a {
	font-size: 20px;
	/* 링크 크기 */
	color: #9A0101;
	/* 링크 색상 */
	text-decoration: none;
	/* 밑줄 제거 */
	height: 60px;
}

.sub-nav .dropdown:hover .dropdown-menu {
	display: block; /* 호버 시 드롭다운 표시 */
}

.dropdown-menu {
	 display: none; /* 기본적으로 숨김 */
	 position: absolute;
	 background-color: white;
	 border: 1px solid #ddd;
	 z-index: 1000;
}

.dropdown-item {
    color: #333; /* 드롭다운 메뉴 텍스트 색상 변경 */
    padding: 10px 20px;
    text-decoration: none;
    display: block;
}

.dropdown-item:hover {
    background-color: #f1f1f1;
}

        .modal {
            display: none; /* 기본적으로 숨김 */
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }

        .modal-info {
            background: #f8f8f8;
            margin: 10% auto;
            padding: 20px;
            border: none;
            width: 500px;
            border-radius: 8px; /* 모서리 둥글게 */
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        
        .modal-info h2 {
        	font-size: 20px;
			font-weight: 600;
			margin-bottom: 20px;
			color: #333;
        }


        /* 닫기 버튼 스타일 */
		.close {
		  float: right;
		  font-size: 24px;
		  font-weight: bold;
		  cursor: pointer;
		  color: #666;
		}
		
		.close:hover,
		.close:focus {
		  color: #000;
		  text-decoration: none;
		  cursor: pointer;
		}
        
		/* 버튼 스타일 */
		.modal-option button {
		   width: 200px;
		   padding: 30px 10px; /* 크기 조절 */
		   border: 1px solid lightgray; /* 테두리 색상 */
		   border-radius: 8px;
		   cursor: pointer;
		   background: #fff;
		   text-align: center;
		   transition: all 0.3s ease;
		}
		
		.modal-option button:hover {
		  border-color: #B09F7A;
		}
		
		.modal-option button p {
		  margin: 10px 0 0 0;
		  font-size: 16px;
		  color: lightgray;
		}
		
		.modal-option button p:hover {
			color: #B09F7A;
		}
		
		.modal-option .icon {
		  font-size: 30px;
		  color: #B09F7A;
		}
		
		.modal-option .icon:hover {
			color: #B09F7A;
		}
		
		/* 선택된 버튼 스타일 */
		.modal-option button.selected {
		  border: 2px solid #B09F7A; /* 테두리 강조 */
		  background-color: #F9F6F1; /* 배경색 강조 */
		}
		



.header .links .dropdown-toggle::after {
    display: none; /* ▼ 표시 제거 */
}

.header .links .dropdown-toggle {
    font-size: 18px;
    color: #333;
    text-decoration: none;
    margin: 0 20px;
}

.header .links .dropdown-toggle:hover {
    color: #9A0101; /* 마우스 오버 시 색상 변경 */
}

#openModal:hover {
	color: #9A0101;
}
</style>
	
<div class="header">
  <a href="/Main.jsp">
            <img src="../image/호텔이미지new2.png" alt="DDIT HOTEL Logo" width="180px"></a>
  <div class="links">
  <div class="sub-nav">
  	<a id="openModal">예약</a>
  	 <div id="modal" class="modal">
        <div class="modal-info">
            <span class="close">&times;</span> <!-- 모달 닫기 버튼 -->
        	<h2>예약</h2>
            	<div class="modal-option">
                <button type="button" class="modal-room">
              		<span class="icon">🛏️</span>
              		<p>객실 예약</p>
           		</button>
            	<button type="button" class="modal-dining">
              		<span class="icon">🍴</span>
              		<p>다이닝 예약</p>
                </button>
            	</div>
            </div>
        </div>
    </div>
  
  <script>
        const modal = document.getElementById("modal");
        const btn = document.getElementById("openModal");
        const span = document.getElementsByClassName("close")[0];
        const roomButton = document.querySelector(".modal-room");
        const diningButton = document.querySelector(".modal-dining")
        
        
        btn.onclick = function() {
            modal.style.display = "block";
//             document.getElementById("room").focus(); // 포커스를 객실 선택으로 이동
        }

        span.onclick = function() {
            modal.style.display = "none";
        }

        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
     	// 객실 버튼 클릭 시 Reservation.jsp로 이동
        roomButton.onclick = function() {
            window.location.href = "/roomResultServlet?type=room";
        }

 		// 편의시설 버튼 클릭 시 FacilitiesReservation.jsp로 이동
 		diningButton.onclick = function() {
			window.location.href = "/roomResultServlet?type=fac";
 		}
	</script>
  
  
  
  <!-- 드롭다운 메뉴로 변경 -->
   <div class="sub-nav">
   	<div class="dropdown">
	<a href="/HotelInformation.jsp" class="nav-link dropdown-toggle" aria-expanded="false" onclick="location.href='/HotelInformation.jsp'; return false;">호텔정보</a>
   </div>
  </div>
  
  <a href="/E-Shop.jsp">E-SHOP</a>
  <a href="/HotelList?hotelId=?">호텔 근처 명소</a>
  <a href="/ServiceCenter.jsp">고객 센터</a>
  
  <%@include file="/jsp/include/MyPage.jsp" %>
  </div>
</div>






