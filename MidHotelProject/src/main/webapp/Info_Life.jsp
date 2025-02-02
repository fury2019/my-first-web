<%@ page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>DDIT 호텔 - 라이프 스타일</title>
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
          margin-right: 100px;
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
      <h3 class="title">라이프 스타일</h3>
      <p class="intro">품격이 다른 편안함으로 서울ddit호텔은 당신의 휴식을 책임집니다.</p>

      <div class="room-type">
          <h2>백화점&산책로</h2>
          
          <div class="room">
              <img src="../Facilities_image/백화점_서울.webp" alt="백화점" class="room-image">
              <div class="room-info">
                  <h3>백화점</h3>
                  <p>서울 ddit호텔에서 럭셔리 브랜드들의 최신 트렌드를 가장 가까이에서 만나보실 수 있습니다.</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal1', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          
          <div class="room">
              <img src="../Facilities_image/산책로_서울.png" alt="콘티넨탈" class="room-image">
              <div class="room-info">
                  <h3>산책로</h3>
                  <p>서울ddit호텔만의 고풍스러운 성곽길</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal2', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          
          
  
<!-- 슬라이드쇼 모달 1 -->
<div id="myModal1" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal1')">&times;</span>
        <div style="display: flex; align-items: flex-start; gap: 20px;">
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/백화점_서울.webp" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p>ddit 명품 아케이드는 서울신라호텔만의 라이프 스타일이 살아 숨쉬는 공간입니다. 고객 모두에게 만족을 드릴 최고급 쇼핑 공간으로서</p>
        		<p>엄선된 20여개의 최고급 브랜드만 입점되어 있습니다.</p>
				<p>프라이빗한 구조의 매장 구성으로 럭셔리 브랜드들의 최신 트렌드를 가장 가까이에서 만나보실 수 있습니다.<br><br>운영시간 10:00 ~ 19:00(월 ~ 금), 11:00 ~ 19:00(토,일,공휴일)</p>
			
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
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/산책로_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<h4>서울 ddit호텔만의 고풍스러운 성곽길</h4>
        		<p>아름다운 경관과 맑은 공기가 가득한 여유롭고 평온한 휴식 장소로서, 4만㎡의 녹지대를 따라 조성된 산책길을 따라 굽이굽이 펼쳐지는 서울성곽길을 걸어가 보면 옛 숨결도 느끼실 수 있습니다.</p>
				<p><br>운영시간 06:00 ~ 22:00</p>
			
 	       </div>
        </div>
        <span class="prev" onclick="plusSlides(-1, 'myModal2')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal2')">&#10095;</span>
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