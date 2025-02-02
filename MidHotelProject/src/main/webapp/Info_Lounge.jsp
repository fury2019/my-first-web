<%@ page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>DDIT 호텔 - 라운지</title>
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
      <h3 class="title">고객의 취향에 따라 즐기는 라이프스타일 공간</h3>
      <p class="intro">정세계적인 인테리어 디자이너 피터 리미디오스가 디자인 한 더 라이브러리는 고객의 라이프스타일과 취향에 따라 다양하게 이용하실 수 있는 컴템포러리 라운지&바입니다.</p>

      <div class="room-type">
          <h2>라운지</h2>
          
          <div class="room">
              <img src="../Facilities_image/라운지_더이그제큐티브라운지_서울.png" alt="라연" class="room-image">
              <div class="room-info">
                  <h3>더 이그제큐티브 라운지</h3>
                  <p>세계 어느 곳에서도 찾을 수 없는 최고 수준의 더 이그제큐티브 라운지</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal1', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          
          <div class="room">
              <img src="../Facilities_image/바_더디스틸러스라이브러리_서울.png" alt="콘티넨탈" class="room-image">
              <div class="room-info">
                  <h3>더 디스틸러스 라이브러리</h3>
                  <p>진귀한 고숙성 위스키 경험</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal2', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          
          <div class="room">
              <img src="../Facilities_image/바_더라이브러리_서울.png" alt="아리아께" class="room-image">
              <div class="room-info">
                  <h3>더 라이브러리</h3>
                  <p>신개념의 고품격 사교 공간 라운지&바</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal3', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          
     

	<div class="horizontal-divider"></div>


  
<!-- 슬라이드쇼 모달 1 -->
<div id="myModal1" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal1')">&times;</span>
        <div style="display: flex; align-items: flex-start; gap: 20px;">
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/라운지_더이그제큐티브라운지_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p>더 이그제큐티브 라운지는 고급스러운 펜트하우스의 응접실을 콘셉트로 구현한 투숙객 전용 비즈니스 공간입니다.</p>
        		<p>23층 최상층에 위치해 남산의 사계절 풍광과 도시의 전경이 그릠처럼 펼쳐지는 더 이그제큐티브 라운지에서</p>
				<p>특별한 다이닝 경험을 체험해보시기 바랍니다.<br></p>
			
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
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/바_더디스틸러스라이브러리_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p>더 디스틸러스 라이브러리 </p>
        		<p>윌리엄 그랜트앤선즈코리아와 협업하여 오픈한 더 디스틸러스 라이브러리는 특별한 위스키 컬렉션과 글렌피딕, 발베니 고숙성 제품을 만나볼 수 있는 곳입니다.</p>
				<p><br>Open / Close 11:00 ~ 24:00
				<br>
				예약 및 문의Tel) 02-2230-3388
				</p>
			
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
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/바_더라이브러리_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p>고객의 취향에 따라 즐기는 라이프스타일 공간</p>
        		<p>세계적인 인테리어 디자이너 피터 리미디오스가 디자인 한 더 라이브러리는 고객의</p>
				<p>라이프스타일과 취향에 따라 다양하게 이용하실 수 있는 컨템포러리 라운지&바입니다.<br></p>
				<p>Open / Close                </p>
				<p>Lounge & Bar : 10:00 ~ 24:00</p>
				<p>                            </p>
				<p>A La Carte  11:00 ~ 17:00   </p>
				<p>                            </p>
				<p>Bar Plates 17:00 ~ 23:00    </p>
				<p>                            </p>
				<p>Royal Tea  12:00 ~ 20:00    </p>
				<p>                            </p>
				<p>예약 및 문의Tel) 02-2230-3389  </p>
				<p>                            </p>
				<p></p>
				<p></p>
				<p></p>
				<p></p>
				<p></p>
			
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
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/팔선_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p></p>
        		<p></p>
				<p><br></p>
			
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