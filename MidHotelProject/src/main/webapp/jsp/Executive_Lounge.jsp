<%@ page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>더 이그제큐티브 라운지</title>
<link rel="stylesheet" href="../css/Room.css">
</head>
<body>

  <div class="container">
      <h3 class="title"></h3>
      <p class="intro"></p>

      <div class="room-type">
          <h2>더 이그제큐티브 라운지</h2>
          <div class="room">
              <img src="../Facilities_image/라운지_더이그제큐티브라운지_서울.png" alt="이그제큐티브 라운지" class="room-image">
              <div class="room-info">
                  <h3>더 이그제큐티브 라운지</h3>
                  
                  <button onclick="openModal('myModal1', 1)">이미지 보기</button>
              </div>
          </div>
         
          
          
          <!-- 슬라이드쇼 모달 1 -->
<div id="myModal1" class="modal">
    <div class="modal-content">
     <span class="close" onclick="closeModal('myModal1')">&times;</span>
      <img class="modal-image" id="modalImage1" src="../Facilities_image/라운지_더이그제큐티브라운지_서울.png" alt="슬라이드쇼 이미지">
       <span class="prev" onclick="plusSlides(-1, 'myModal1')">&#10094;</span>
       <span class="next" onclick="plusSlides(1, 'myModal1')">&#10095;</span>
        <div class="thumbnail-container">
         	<img class="thumbnail" src="../Facilities_image/라운지_더이그제큐티브라운지_서울.png" onclick="currentSlide(1, 'myModal1')">
        </div>
    </div>
</div>




<script>
var slideIndex = {
		'myModal1': 1
	
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
			'myModal1': ["../Facilities_image/라운지_더이그제큐티브라운지_서울.png"]
			
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