<%@page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>시설</title>
  <style>
       body {
          font-family: 'Noto Sans KR', sans-serif;
          background-color: #f5f5f5;
          margin: 0;
      }

      .container {
          max-width: 2500px;
          margin: 20px;
          background: white;
          padding: 40px;
          border-radius: 12px;
          box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
          textalign: center;
    	  min-height: calc(100vh - 50px); /* 최소 높이를 뷰포트 높이에서 header와 footer 높이를 뺀 값으로 설정 */
      }

      .title {
      	  max-width: 1200px;
          text-align: center;
          color: #333;
          font-size: 32px;
		  margin-left: 50px;
      }

      p.intro {
          text-align: center;
          color: #666;
          font-size: 18px;
          margin-bottom: 40px;
          max-width: 1000px;
		  margin-left: 150px;
          
      }

      .room-type {
          margin-top: 40px;
          display: flex;
          flex-wrap: wrap;
          
      }

      h2 {
       	  margin-left: 20px;
          margin-bottom: 30px;
          color: #333;
          font-size: 24px;
          margin-top: 30px;
          width: 100%;
      }

      .room {
          width: 30%;
          margin: 20px;
          text-align: center;
          border: 1px solid #ddd;
          border-radius: 12px;
          overflow: hidden;
          background-color: #fff;
          box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
          transition: transform 0.3s, box-shadow 0.3s;
      }

      .room:hover {
          transform: translateY(-5px);
          box-shadow: 0 8px 16px rgba(0, 0, 0, 0.15);
      }

      .room-image {
          width: 100%;
          height: 200px;
          object-fit: cover;
      }

      .room-info {
          padding: 20px;
      }

      .room-info h3 {
          color: #333;
          font-size: 20px;
          margin-bottom: 10px;
      }

      .room-info p {
          color: #666;
          font-size: 16px;
          margin-bottom: 15px;
      }

      button {
          margin: 10px 0;
          padding: 12px 24px;
          background-color: #007BFF;
          color: white;
          border: none;
          border-radius: 6px;
          font-size: 16px;
          cursor: pointer;
          transition: background-color 0.3s;
      }

      button:hover {
          background-color: #0056b3;
      }

      .view-all {
          margin-top: 30px;
          padding: 12px 24px;
          background-color: #28a745;
          color: white;
          border: none;
          border-radius: 6px;
          font-size: 16px;
          cursor: pointer;
          display: block;
          text-align: center;
          width: 200px;
          margin-left: auto;
          margin-right: auto;
          transition: background-color 0.3s;
      }

      .view-all:hover {
          background-color: #218838;
      }

     /* 슬라이드쇼 스타일 */
     .modal {
          display: none;
          position: fixed;
          z-index: 1000;
          left: 0;
          top: 0;
          width: 100%;
          height: 100%;
          overflow: auto;
          background-color: rgba(0, 0, 0, 0.8);
      }

      .modal-content {
          position: relative;
          background-color: #fefefe;
          margin: 1% auto;
          padding: 20px;
          border: 1px solid #888;
          width: 80%;
          max-width: 750px;
          border-radius: 10px;
      }

      .modal-image {
          width: 100%;
          height: auto;
          border-radius: 8px;
      }

      .close, .prev, .next {
          color: #aaa;
          font-size: 40px;
          font-weight: bold;
          cursor: pointer;
          position: absolute;
          top: 10px;
          right: 20px;
      }

      .close:hover,
      .close:focus,
      .prev:hover,
      .next:hover {
          color: black;
          text-decoration: none;
          cursor: pointer;
      }

      .prev, .next {
          top: 50%;
          transform: translateY(-50%);
          font-size: 60px;
          padding: 16px;
      }

      .prev {
          left: 20px;
      }

      .next {
          right: 20px;
      }

      .thumbnail-container {
          display: flex;
          justify-content: center;
          margin-top: 20px;
      }

      .thumbnail {
          width: 100px;
          height: 100px;
          margin: 0 10px;
          cursor: pointer;
          border-radius: 5px;
          opacity: 0.6;
      }

      .thumbnail:hover {
          opacity: 1;
      }

      .horizontal-divider {
    height: 1px; /* 선의 두께 */
    background-color: black; /* 선 색상 */
    margin: 20px 0; /* 위아래 간격 */
    width: 100%; /* 전체 너비 */
}

.sidebar {
    background-color: #f2e6d3;
    padding: 20px;
    border-radius: 8px;
    height: 90%;
    width: 14%;
    float: left;
    margin: auto;
    position: sticky;
    top: 20px;
    left: 20px;
    overflow-y: auto;
    max-height: calc(100vh - 40px);
}

.sidebar h4 {
    margin: 0;
    padding-bottom: 20px;
    border-bottom: 2px solid #5b3e26;
    color: #5b3e26;
    font-size: 24px; /* 제목 크기 */
    font-weight: bold; /* 제목 굵기 */
}

.menu-item {
    text-decoration: none;
    color: #333;
    display: block;
    background-color: #d0b69e;
    padding: 10px;
    border-radius: 4px;
    margin-top: 10px;
    font-size: 18px; /* 메뉴 항목 크기 */
    font-weight: bold; /* 메뉴 항목 굵기 */
    position: relative; /* 화살표를 위한 위치 설정 */
}

.menu-item:hover {
    background-color: #c1a48b; /* 호버 색상 */
}

.submenu {
    padding-left: 10px;
}

.submenu-item {
    text-decoration: none;
    color: #333;
    display: flex; /* 플렉스 박스로 변경 */
    justify-content: space-between; /* 양쪽 끝으로 배치 */
    align-items: center; /* 수직 정렬 */
    background-color: #e8d9c5;
    padding: 8px;
    border-radius: 4px;
    margin-top: 5px;
    font-size: 16px; /* 서브메뉴 항목 크기 */
}

.submenu-item:hover {
    background-color: #d0b69e; /* 서브메뉴 호버 색상 */
    
}

.submenu-item.active {
    background-color: #c1a48b; /* 선택된 서브메뉴 색상 */
    font-weight: bold; /* 선택된 항목 굵기 */
        content: " >"; /* 화살표 추가 */
    
}

.submenu-item::after {
    font-size: 15px; /* 화살표 크기 */
    color: #999; /* 화살표 색상 */
    margin-left: auto; /* 화살표와 텍스트 간격 */
    font-weight: bold; /* 화살표 굵게 */
}
  </style>
</head>
<body>
<div class="sidebar">
	<h4>서울 DDIT 호텔</h4>
	
    <div class="sub-menu">
		<a href="SeoulDDITRoominformation.jsp" class="menu-item">객실정보</a>
		<div class="submenu">
			<a href="SeoulRoom_Stand.jsp" class="submenu-item" onclick="setActive(this)">스탠다드</a>
           	<a href="SeoulRoom_Deluxe.jsp" class="submenu-item" onclick="setActive(this)">디럭스</a>
           	<a href="SeoulRoom_Suite .jsp" class="submenu-item" onclick="setActive(this)">스위트</a>
		</div>
	</div>
	
    <div class="sub-menu">
		<a href="SeoulDDITilitiac_esInformation.jsp" class="menu-item">편의시설</a>
		<div class="submenu">
           	<a href="SeoulFac_Outpool.jsp" class="submenu-item" onclick="setActive(this)">야외 수영장</a>
           	<a href="SeoulFac_Gym.jsp" class="submenu-item" onclick="setActive(this)">실내 체육관</a>
           	<a href="SeoulFac_Spa.jsp" class="submenu-item" onclick="setActive(this)">스파</a>
        </div>
	</div>
	
    <div class="sub-menu">
	    <a href="SeoulDDITDining.jsp" class="menu-item">다이닝</a>
    	<div class="submenu">
           	<a href="SeoulDining_Restaurant.jsp" class="submenu-item" onclick="setActive(this)">레스토랑</a>
           	<a href="SeoulDining_LoungeBar.jsp" class="submenu-item" onclick="setActive(this)">라운지 & 바</a>
           	<a href="SeoulDining_Bakery.jsp" class="submenu-item" onclick="setActive(this)">베이커리</a>
        </div>
	</div>
	
</div>

  <div class="container">
      <h3 class="title">품격이 다른 편암함으로 서울 DDIT 호텔은 여러분의 휴식을 책임집니다.</h3>
      <p class="intro">넓은 야외 테라스와 아름다운 남산 조망이 가능한 옥상 정원(Rooftop Garden)에서 자연과 더불어 휴식은 물론 다양한 문화 프로그램과 개인별 취미를 즐기실 수 있습니다.</p>

      <div class="room-type">
          <h2>야외 수영장</h2>
          <div class="room">
              <img src="../Facilities_image/어번아일랜드_서울.png" alt="서울 야외수영장" class="room-image">
              <div class="room-info">
                  <h5>어번 아일랜드</h5>
                  <p>탁 트인 전망과 편안한 휴식을 취할 수 있는 완벽한 장소를 경험하실 수 있습니다.</p>
                  <p>인원제한 : 30명</p>
                  <button onclick="openModal('myModal1', 1)">이미지 보기</button>
              </div>
          </div>
          <div class="room">
              <img src="../Facilities_image/카바나_서울.png" alt="서울 카바나" class="room-image">
              <div class="room-info">
                  <h5>카바나</h5>
                  <p>프라이빗하고 여유로운 휴식과 함께 낭만적인 시간을 만들어 드립니다.</p>
                  <p>인원제한 : 4명</p>
                  <button onclick="openModal('myModal2', 1)">이미지 보기</button>
               
              </div>
          </div>

          <div class="horizontal-divider"></div>

          <h2>피트니스</h2>
          <div class="room">
              <img src="../image/서울 디럭스 더블.jpg" alt="디럭스 더블" class="room-image">
              <div class="room-info">
                  <h3>실내 수영장</h3>
                  <p>아늑하면서 효율적인 공간</p>
                  <p>객실크기: 43㎡</p>
                  <button onclick="openModal('myModal3', 1)">이미지 보기</button>
                  <button>예약하기</button>
              </div>
          </div>
          <div class="room">
              <img src="../image/서울 디럭스 트윈.jpg" alt="디럭스 트윈" class="room-image">
              <div class="room-info">
                  <h3>실내 체육관</h3>
                  <p>아늑하면서 효율적인 공간</p>
                  <p>객실크기: 43㎡</p>
                  <button onclick="openModal('myModal4', 1)">이미지 보기</button>
                  <button>예약하기</button>
              </div>
          </div>
          <div class="room">
              <img src="../image/서울 비즈니스 더블.jpg" alt="비즈니스 더블" class="room-image">
              <div class="room-info">
                  <h3>실내 골프장</h3>
                  <p>휴식이 필요한 비즈니스 고객을 위한 공간</p>
                  <p>객실크기: 53㎡</p>
                  <button onclick="openModal('myModal5', 1)">이미지 보기</button>
                  <button>예약하기</button>
              </div>
          </div>
          <div class="room">
              <img src="../image/서울 비즈니스 트윈.jpg" alt="비즈니스 트윈" class="room-image">
              <div class="room-info">
                  <h3>실내 사우나</h3>
                  <p>휴식이 필요한 비즈니스 고객을 위한 공간</p>
                  <p>객실크기: 53㎡</p>
                  <button onclick="openModal('myModal6', 1)">이미지 보기</button>
                  <button>예약하기</button>
              </div>
          </div>

          <div class="horizontal-divider"></div>

          <h2>스위트</h2>
          <div class="room">
              <img src="../image/서울 스위트.jpg" alt="서울 스위트" class="room-image">
              <div class="room-info">
                  <h3>스위트</h3>
                  <p>아늑하고 모던한 공간</p>
                  <p>객실크기: 66㎡</p>
                  <button onclick="openModal('myModal7', 1)">이미지 보기</button>
                  <button>예약하기</button>
              </div>
          </div>
          <div class="room">
              <img src="../image/서울 프리미어 스위트.jpg" alt="서울 프리미어 스위트" class="room-image">
              <div class="room-info">
                  <h3>프리미어 스위트</h3>
                  <p>비즈니스와 휴식을 동시에 취할 수 있는 공간</p>
                  <p>객실크기:84㎡</p>
                  <button onclick="openModal('myModal8', 1)">이미지 보기</button>
                  <button>예약하기</button>
              </div>
          </div>
      </div>
  </div>
  
<!-- 슬라이드쇼 모달 1 -->
<div id="myModal1" class="modal">
    <div class="modal-content">
     <span class="close" onclick="closeModal('myModal1')">&times;</span>
      <img class="modal-image" id="modalImage1" src="../image/서울 스탠다드 더블.jpg" alt="슬라이드쇼 이미지">
       <span class="prev" onclick="plusSlides(-1, 'myModal1')">&#10094;</span>
       <span class="next" onclick="plusSlides(1, 'myModal1')">&#10095;</span>
        <div class="thumbnail-container">
         	<img class="thumbnail" src="../image/서울 스탠다드 더블.jpg" onclick="currentSlide(1, 'myModal1')">
           	<img class="thumbnail" src="../image/서울 스탠다드 욕실.jpg" onclick="currentSlide(2, 'myModal1')">
        </div>
    </div>
</div>

<!-- 슬라이드쇼 모달 2 -->
<div id="myModal2" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal2')">&times;</span>
        <img class="modal-image" id="modalImage2" src="../image/서울 스탠다드 트윈.jpg" alt="슬라이드쇼 이미지">
        <span class="prev" onclick="plusSlides(-1, 'myModal2')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal2')">&#10095;</span>
        <div class="thumbnail-container">
            <img class="thumbnail" src="../image/서울 스탠다드 트윈.jpg" onclick="currentSlide(1, 'myModal2')">
            <img class="thumbnail" src="../image/서울 스탠다드 욕실.jpg" onclick="currentSlide(2, 'myModal2')">
        </div>
    </div>
</div>

<!-- 슬라이드쇼 모달 3 -->
<div id="myModal3" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal3')">&times;</span>
        <img class="modal-image" id="modalImage3" src="../image/디럭스 더블.jpg" alt="슬라이드쇼 이미지">
        <span class="prev" onclick="plusSlides(-1, 'myModal3')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal3')">&#10095;</span>
        <div class="thumbnail-container">
            <img class="thumbnail" src="../image/서울 디럭스 더블.jpg" onclick="currentSlide(1, 'myModal3')">
            <img class="thumbnail" src="../image/서울 디럭스 거실.jpg" onclick="currentSlide(2, 'myModal3')">
            <img class="thumbnail" src="../image/서울 디럭스 욕실.jpg" onclick="currentSlide(3, 'myModal3')">
        </div>
    </div>
</div>

<!-- 슬라이드쇼 모달 4 -->
<div id="myModal4" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal4')">&times;</span>
        <img class="modal-image" id="modalImage4" src="../image/디럭스 트윈.jpg" alt="슬라이드쇼 이미지">
        <span class="prev" onclick="plusSlides(-1, 'myModal4')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal4')">&#10095;</span>
        <div class="thumbnail-container">
            <img class="thumbnail" src="../image/서울 디럭스 트윈.jpg" onclick="currentSlide(1, 'myModal4')">
            <img class="thumbnail" src="../image/서울 디럭스 거실.jpg" onclick="currentSlide(2, 'myModal4')">
            <img class="thumbnail" src="../image/서울 디럭스 욕실.jpg" onclick="currentSlide(3, 'myModal4')">
        </div>
    </div>
</div>

<!-- 슬라이드쇼 모달 5 -->
<div id="myModal5" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal5')">&times;</span>
        <img class="modal-image" id="modalImage5" src="../image/비즈니스 더블.jpg" alt="슬라이드쇼 이미지">
        <span class="prev" onclick="plusSlides(-1, 'myModal5')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal5')">&#10095;</span>
        <div class="thumbnail-container">
            <img class="thumbnail" src="../image/서울 비즈니스 더블.jpg" onclick="currentSlide(1, 'myModal5')">
            <img class="thumbnail" src="../image/서울 디럭스 거실.jpg" onclick="currentSlide(2, 'myModal5')">
            <img class="thumbnail" src="../image/서울 디럭스 거실.jpg" onclick="currentSlide(3, 'myModal5')">
        </div>
    </div>
</div>

<!-- 슬라이드쇼 모달 6 -->
<div id="myModal6" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal6')">&times;</span>
        <img class="modal-image" id="modalImage6" src="../image/비즈니스 트윈.jpg" alt="슬라이드쇼 이미지">
        <span class="prev" onclick="plusSlides(-1, 'myModal6')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal6')">&#10095;</span>
        <div class="thumbnail-container">
            <img class="thumbnail" src="../image/서울 비즈니스 트윈.jpg" onclick="currentSlide(1, 'myModal6')">
            <img class="thumbnail" src="../image/서울 디럭스 거실.jpg" onclick="currentSlide(2, 'myModal6')">
            <img class="thumbnail" src="../image/서울 디럭스 욕실.jpg" onclick="currentSlide(3, 'myModal6')">
        </div>
    </div>
</div>

<!-- 슬라이드쇼 모달 7 -->
<div id="myModal7" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal7')">&times;</span>
        <img class="modal-image" id="modalImage7" src="../image/서울 스위트.png" alt="슬라이드쇼 이미지">
        <span class="prev" onclick="plusSlides(-1, 'myModal7')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal7')">&#10095;</span>
        <div class="thumbnail-container">
            <img class="thumbnail" src="../image/서울 스위트.jpg" onclick="currentSlide(1, 'myModal7')">
            <img class="thumbnail" src="../image/서울 스위트 거실.jpg" onclick="currentSlide(2, 'myModal7')">
            <img class="thumbnail" src="../image/서울 스위트 욕실.jpg" onclick="currentSlide(3, 'myModal7')">
        </div>
    </div>
</div>

<!-- 슬라이드쇼 모달 8 -->
<div id="myModal8" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal8')">&times;</span>
        <img class="modal-image" id="modalImage8" src="../image/서울 프리미어 스위트.png" alt="슬라이드쇼 이미지">
        <span class="prev" onclick="plusSlides(-1, 'myModal8')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal8')">&#10095;</span>
        <div class="thumbnail-container">
            <img class="thumbnail" src="../image/서울 프리미어 스위트.jpg" onclick="currentSlide(1, 'myModal8')">
            <img class="thumbnail" src="../image/서울 프리미어 스위트 거실.jpg" onclick="currentSlide(2, 'myModal8')">
            <img class="thumbnail" src="../image/서울 프리미어 스위트 욕실.jpg" onclick="currentSlide(3, 'myModal8')">
        </div>
    </div>
</div>

<script>
var slideIndex = {
		'myModal1': 1,
		'myModal2': 1,
		'myModal3': 1,
		'myModal4': 1,
		'myModal5': 1,
		'myModal6': 1,
		'myModal7': 1,
		'myModal8': 1
	};

function openModal(modalId, slideIndex) {
		document.getElementById(modalId).style.display = "block";
		showSlides(slideIndex, modalId);
	}

function closeModal(modalId) {
		document.getElementById(modalId).style.display = "none";
	}

function currentSlide(n, modalId) {
		slideIndex[modalId] = n;
		showSlides(n, modalId);
	}

function plusSlides(n, modalId) {
		slideIndex[modalId] += n;
		showSlides(slideIndex[modalId], modalId);
	}

function showSlides(n, modalId) {
	var images = {
			'myModal1': ["../Facilities_image/어번아일랜드_서울.png", "../Facilities_image/어번아일랜드_서울.png"],
			'myModal2': ["../Facilities_image/카바나_서울.png", "../Facilities_image/카바나_서울.png"],
			'myModal3': ["../image/서울 디럭스 더블.jpg", "../image/서울 디럭스 거실.jpg", "../image/서울 디럭스 욕실.jpg"],
			'myModal4': ["../image/서울 디럭스 트윈.jpg", "../image/서울 디럭스 거실.jpg", "../image/서울 디럭스 욕실.jpg"],
			'myModal5': ["../image/서울 비즈니스 더블.jpg", "../image/서울 디럭스 거실.jpg", "../image/서울 디럭스 욕실.jpg"],
			'myModal6': ["../image/서울 비즈니스 트윈.jpg", "../image/서울 디럭스 거실.jpg", "../image/서울 디럭스 욕실.jpg"],
			'myModal7': ["../image/서울 스위트.jpg", "../image/서울 스위트 거실.jpg", "../image/서울 스위트 욕실.jpg"],
			'myModal8': ["../image/서울 프리미어 스위트.jpg", "../image/서울 프리미어 스위트 거실.jpg", "../image/서울 프리미어 스위트 욕실.jpg"]
	};
	
	if (n > images[modalId].length) {
		slideIndex[modalId] = 1;
	}
	if (n < 1) {
		slideIndex[modalId] = images[modalId].length;
	}
	
	document.getElementById("modalImage" + modalId.slice(-1)).src = images[modalId][slideIndex[modalId] - 1]; 
	}
	
		
	function setActive(element) {
	    // 모든 서브메뉴 항목에서 active 클래스 제거
	    const items = document.querySelectorAll('.submenu-item');
	    items.forEach(item => {
	        item.classList.remove('active');
	    });
	    
	    // 클릭한 항목에 active 클래스 추가
	    element.classList.add('active');
	    
}
</script>

</body>
</html>