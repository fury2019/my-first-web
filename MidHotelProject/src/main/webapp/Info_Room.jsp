<%@ page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>DDIT 호텔 - 객실 정보</title>
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
      }


      .title {
      	  max-width: 1000px;
          text-align: center;
          color: #333;
          font-size: 32px;
          margin-bottom: 10px;
		  margin-left: 100px;
          
      }

      p.intro {
          text-align: center;
          color: #666;
          font-size: 18px;
          margin-bottom: 40px;
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
		  margin-right: 20px;
          margin-left: 20px;
          margin-bottom: 20px;
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
          margin: 15% auto;
          padding: 20px;
          border: 1px solid #888;
          width: 80%;
          max-width: 800px;
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


  </style>
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

          <div class="horizontal-divider"></div>

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

          <div class="horizontal-divider"></div>

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