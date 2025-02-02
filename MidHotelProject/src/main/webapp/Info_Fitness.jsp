<%@ page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>DDIT 호텔 - 피트니스</title>
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
	    margin: 50px auto; /* 수평 중앙 정렬 */
	    padding: 20px;
	    border: 1px solid #888;
	    width: 80%; /* 너비를 늘림 */
	    max-width: 1600px; /* 최대 너비 */
	    border-radius: 10px;
	    display: flex; /* Flexbox 적용 */
	    flex-direction: row; /* 기본적으로 이미지 왼쪽, 설명 오른쪽 */
	    align-items: center; /* 이미지와 텍스트 수직 정렬 */
	    gap: 20px; /* 이미지와 설명 간 간격 */
	}
	
	.modal-image {
	    width: 700px; /* 이미지가 차지할 공간 */
	    height: 700px;
	    max-width: 700px; /* 최대 너비 제한 */
	    height: auto;
	    border-radius: 8px;
	}
	
	.modal-description {
	    flex: 1; /* 텍스트 영역이 이미지에 맞춰 늘어나도록 */
	    font-size: 18px;
	    color: #333;
	    margin: 0; /* 여백 제거 */
	    text-align: left; /* 텍스트 왼쪽 정렬 */
	    white-space: normal; /* 텍스트 자동 줄 바꿈 */
	    
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
	.image-description {
	    margin-top: 15px;
	    font-size: 16px;
	    text-align: center;
	    color: #555;
	}

  </style>
</head>
<body>

  <div class="container">
      <h3 class="title">피트니스</h3>
      <p class="intro">정통을 뛰어넘는 하이엔드 스타일의 다이닝, 라운지에서 맛보는 스위트 트리스, 눈을 행복하게 하는 감각적인 패스트리까지</p>

      <div class="room-type">
          <h2>피트니스</h2>
          
          <div class="room">
              <img src="../Facilities_image/실내수영장_서울.webp" alt="라연" class="room-image">
              <div class="room-info">
                  <h3>실내 수영장</h3>
                  <p>'자연과 하나되는 Relaxation 공간'<p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal1', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          
          <div class="room">
              <img src="../Facilities_image/헬스장_서울.png" alt="콘티넨탈" class="room-image">
              <div class="room-info">
                  <h3>실내 체육관</h3>
                  <p>체계적인 체력 관리를 위한 기능별 공간과 최상의 휴식을 위한 공간으로 조성되어 운동과 휴식을 조화롭게 즐기실 수 있는 실내 체육관입니다.</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal2', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          
          <div class="room">
              <img src="../Facilities_image/골프장_서울.png" alt="아리아께" class="room-image">
              <div class="room-info">
                  <h3>실내 골프장</h3>
                  <p>골프 경기력 향상을 위한 다양한 디지털 장비를 마련해 드라이비, 퍼팅, 자세교정, 클럽 피팅 등 One-stop Solution을 제공합니다.</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal3', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          
          <div class="room">
              <img src="../Facilities_image/사우나_서울.webp" alt="팔선" class="room-image">
              <div class="room-info">
                  <h3>실내 사우나</h3>
                  <p>고급스러운 시설과 서비스로 여유로운 휴식을 즐기실 수 있습니다.</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal4', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          
          <div class="horizontal-divider"></div>
      </div>
  </div>
  
<!-- 슬라이드쇼 모달 1 -->
<div id="myModal1" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal1')">&times;</span>
        <div style="display: flex; align-items: flex-start; gap: 20px;">
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/실내수영장_서울.webp" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p>길이 25m, 너비 6m의 풀로 이루어져 있으며, 건식 사우나와 실내 및 야외 자쿠지를 갖추고 있습니다.</p>
        		<p>회원과 투숙객을 위해 별도의 락커룸을 제공합니다.</p>
				<p>운영시간 06:00 ~ 22:00 <br>정기휴일 매월 세 번째 수요일<br></p>
			
 	       </div>
        </div>
        <span class="prev" onclick="plusSlides(-1, 'myModal1')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal1')">&#10095;</span>
    </div>
</div>

<!-- 슬라이드쇼 모달 2 -->
<div id="myModal2" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal2')">&times;</span>
        <div style="display: flex; align-items: flex-start; gap: 20px;">
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/헬스장_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p>운영시간 05:30 ~ 22:30 <br>정기휴일 매월 세 번째 수요일<br><br></p>
        		<p>* 체육관은 만 16세 이상 고객에 한해 입장 가능합니다.</p>
				<p>* 고객 여러분의 안전을 위하여 음주 후 체육관, 사우나, 실내 수영장 등의 피트니스 시설 이용은 제한될 수 있습니다.</p>
				<p>* 실내 체육관 입장 시 반드시 운동복과 실내용 운동화를 착용해 주시기 바랍니다.</p>

			
 	       </div>
        </div>
        <span class="prev" onclick="plusSlides(-1, 'myModal2')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal2')">&#10095;</span>
    </div>
</div>

<!-- 슬라이드쇼 모달 3 -->
<div id="myModal3" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal3')">&times;</span>
        <div style="display: flex; align-items: flex-start; gap: 20px;">
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/골프장_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p></p>
        		<p>국내 최초로 드라이빙 레인지 전 타석에 골프샷 분석시스템인 트랙맨(Track Man)을 설치해 더욱 과학적인 골프 연습을 경험하실 수 있습니다.</p>
        		<p>문의전화 02-2230-3521</p>
        		<p>위치 서울신라호텔 3층 피트니스</p>
				<p>실내 골프장은 만 13세 이상 고객에 한해 입장 가능합니다.</p>
				<p>고객 여러분의 안전을 위하여 음주 후 체육관, 사우나, 실내 수영장 등의 피트니스 시설 이용은 제한될 수 있습니다.</p>
			
 	       </div>
        </div>
        <span class="prev" onclick="plusSlides(-1, 'myModal3')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal3')">&#10095;</span>
    </div>
</div>

<!-- 슬라이드쇼 모달 4 -->
<div id="myModal4" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal4')">&times;</span>
        <div style="display: flex; align-items: flex-start; gap: 20px;">
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/사우나_서울.webp" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p>운영시간 05:30 ~ 22:30 <br>정기휴일 매월 세 번째 수요일<br><br></p>
        		<p>* 사우나는 만 13세 이상 고객에 한해 입장 가능합니다.</p>
				<p>* 고객 여러분의 안전을 위하여 음주 후 체육관, 사우나, 실내 수영장등의 시설 이용은 제한될 수 있습니다.<br></p>
				<p>* 건강상 문제나 피부질환, 문신 등의 이유로 피트니스 시설 이용이 제한될 수 있습니다.</p>
 	       </div>
        </div>
        <span class="prev" onclick="plusSlides(-1, 'myModal4')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal4')">&#10095;</span>
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



</script>


</body>
</html>