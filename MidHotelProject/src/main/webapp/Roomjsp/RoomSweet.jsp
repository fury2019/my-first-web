<%@ page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>스위트 룸</title>
<link rel="stylesheet" href="../css/Room.css">
</head>
<body>

  
         <h2>스위트</h2>
          <div class="room">
              <img src="../image/서울 스위트.jpg" alt="서울 스위트" class="room-image">
              <div class="room-info">
                  <h3>스위트</h3>
                  <p>아늑하고 모던한 공간</p>
                  <p>객실크기: 66㎡</p>
                  <button onclick="openModal('myModal7', 1)">이미지 보기</button>
              </div>
          </div>
          <div class="room">
              <img src="../image/서울 프리미어 스위트.jpg" alt="서울 프리미어 스위트" class="room-image">
              <div class="room-info">
                  <h3>프리미어 스위트</h3>
                  <p>비즈니스와 휴식을 동시에 취할 수 있는 공간</p>
                  <p>객실크기:84㎡</p>
                  <button onclick="openModal('myModal8', 1)">이미지 보기</button>
              </div>
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