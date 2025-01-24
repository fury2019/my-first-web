<%@ page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>스탠다드 룸</title>
<link rel="stylesheet" href="../css/Room.css">
</head>
<body>

  <div class="container">
      <h3 class="title">세계적인 디자이너 피터 리미디오스가 담당한 DDIT호텔 객실은 모던하면서도 품격있는 라이프스타일 공간입니다.</h3>
      <p class="intro">시대를 아우르는 모던함(Timeless Modern)을 모토로, 시간이 흐를수록 더욱 빛나는 절제된 디자인을 선보입니다.</p>

      <div class="room-type">
          <h2>스탠다드</h2>
          <div class="room">
              <img src="../image/서울 스탠다드 더블.jpg" alt="서울 스탠다드 더블" class="room-image">
              <div class="room-info">
                  <h3>스탠다드 더블</h3>
                  <p>아늑하면서 효율적인 공간</p>
                  <p>객실크기: 36㎡</p>
                  <button onclick="openModal('myModal1', 1)">이미지 보기</button>
              </div>
          </div>
          <div class="room">
              <img src="../image/서울 스탠다드 트윈.jpg" alt="서울 스탠다드 트윈" class="room-image">
              <div class="room-info">
                  <h3>스탠다드 트윈</h3>
                  <p>아늑하면서 효율적인 공간</p>
                  <p>객실크기: 36㎡</p>
                  <button onclick="openModal('myModal2', 1)">이미지 보기</button>
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


<script>
var slideIndex = {
		'myModal1': 1,
		'myModal2': 1
	
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