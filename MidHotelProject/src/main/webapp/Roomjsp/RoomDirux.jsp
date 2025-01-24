<%@ page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>디럭스 룸</title>
<link rel="stylesheet" href="../css/Room.css">
</head>
<body>

  
          <h2>디럭스</h2>
          <div class="room">
              <img src="../image/서울 디럭스 더블.jpg" alt="디럭스 더블" class="room-image">
              <div class="room-info">
                  <h3>디럭스 더블</h3>
                  <p>아늑하면서 효율적인 공간</p>
                  <p>객실크기: 43㎡</p>
                  <button onclick="openModal('myModal3', 1)">이미지 보기</button>
              </div>
          </div>
          <div class="room">
              <img src="../image/서울 디럭스 트윈.jpg" alt="디럭스 트윈" class="room-image">
              <div class="room-info">
                  <h3>디럭스 트윈</h3>
                  <p>아늑하면서 효율적인 공간</p>
                  <p>객실크기: 43㎡</p>
                  <button onclick="openModal('myModal4', 1)">이미지 보기</button>
              </div>
          </div>
          
          <div class="room">
              <img src="../image/서울 비즈니스 더블.jpg" alt="비즈니스 더블" class="room-image">
              <div class="room-info">
                  <h3>비즈니스 더블</h3>
                  <p>휴식이 필요한 비즈니스 고객을 위한 공간</p>
                  <p>객실크기: 53㎡</p>
                  <button onclick="openModal('myModal5', 1)">이미지 보기</button>
              </div>
          </div>
          <div class="room">
              <img src="../image/서울 비즈니스 트윈.jpg" alt="비즈니스 트윈" class="room-image">
              <div class="room-info">
                  <h3>비즈니스 트윈</h3>
                  <p>휴식이 필요한 비즈니스 고객을 위한 공간</p>
                  <p>객실크기: 53㎡</p>
                  <button onclick="openModal('myModal6', 1)">이미지 보기</button>
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
			'myModal1': ["../image/서울 스탠다드 더블.jpg", "../image/서울 스탠다드 욕실.jpg"],
			'myModal2': ["../image/서울 스탠다드 트윈.jpg", "../image/서울 스탠다드 욕실.jpg"],
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

		
	
</script>



</body>
</html>