<%@ page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>DDIT 호텔 - 다이닝</title>
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
      <h3 class="title">참 미식으로의 초대</h3>
      <p class="intro">정통을 뛰어넘는 하이엔드 스타일의 다이닝, 라운지에서 맛보는 스위트 트리스, 눈을 행복하게 하는 감각적인 패스트리까지</p>

      <div class="room-type">
          <h2>레스토랑</h2>
          
          <div class="room">
              <img src="../Facilities_image/라연_서울.png" alt="라연" class="room-image">
              <div class="room-info">
                  <h3>라연</h3>
                  <p>전통화 품격의 한식 레스토랑</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal1', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          
          <div class="room">
              <img src="../Facilities_image/콘티넨탈_서울.png" alt="콘티넨탈" class="room-image">
              <div class="room-info">
                  <h3>콘티넨탈</h3>
                  <p>정통 프렌치 정찬과 와인</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal2', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          
          <div class="room">
              <img src="../Facilities_image/아리아께_서울.png" alt="아리아께" class="room-image">
              <div class="room-info">
                  <h3>아리아께</h3>
                  <p>오감 만족의 정통 일식당</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal3', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          
          <div class="room">
              <img src="../Facilities_image/팔선_서울.webp" alt="팔선" class="room-image">
              <div class="room-info">
                  <h3>팔선</h3>
                  <p>중식 명가의 품격</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal4', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          
          <div class="room">
              <img src="../Facilities_image/더파크뷰_서울.png" alt="파크뷰" class="room-image">
              <div class="room-info">
                  <h3>더 파크뷰</h3>
                  <p>올 데이 다이닝 자연을 닮은 레스토랑</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal5', 1)">이미지 & 안내사항</button>
              </div>
          </div>

	<div class="horizontal-divider"></div>

		<h2>베이커리</h2>
          <div class="room">
              <img src="../Facilities_image/부티크_서울.png" alt="부티크" class="room-image">
              <div class="room-info">
                  <h3>패스트리 부티크</h3>
                  <p>품격있는 명품 쥬얼리 부티크를 연상시키는 디스플레이와 전문 파티셰의 손길에서 태어난 정성이 담긴 명품 패스트리와 베이커리를 만나보실 수 있습니다.</p>
                  <p></p>
				  <p></p>
                  <button onclick="openModal('myModal6', 1)">이미지 & 안내사항</button>
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
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/라연_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p>전통의 맛을 세심하고 세련되게 표현한 한식당, 蘿宴</p>
        		<p>禮와 格을 갖추어 정성으로 차려낸 라연만의 한식 정찬을 선보입니다. </p>
				<p><br>Open / Close Lunch : 12:00 ~ 14:30 (Last Order : 13:00)<br>
						Dinner : 17:30 ~ 21:30 (Last Order : 19:30)<br><br>
						예약 및 문의Tel) 02-2230-3367
				</p>
			
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
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/콘티넨탈_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p>우아한 실내장식과 부드러운 조명, 전문적이고 세심한 직원 서비스 또한 소중한 사람과의 특별한 만남을 더욱 빛나게 합니다.</p>
        		<p>콘티넨탈은 서울의 전경과 함께 프렌치 정찬을 즐길 수 있는 프렌치 레스토랑입니다.</p>
				<p><br>Open / Close :12:00 ~ 14:30 (Last Order : 13:00)	<br>
				       Dinner :  17:30 ~ 21:30 (Last Order : 19:30)<br><br>
				       예약 및 문의Tel) 02-2230-3369
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
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/아리아께_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p>五感을 만족시키는 정통 일식당 아리아께</p>
        		<p>모던함이 느껴지는 현대적 감각의 레스토랑으로 청정해의 해산물과</p>
				<p><br>직접 엄선한 최고급 식재료로 정통 일식의 진수를 선보입니다.</p>
				<p>Open / Close Lunch : 12:00 ~ 14:30 (Last Order : 13:30)<br>
				   Dinner : 17:30 ~ 21:30 (Last Order : 20:30)<br><br>
					※ 스시카운터 Last order는 Lunch 13:00, Dinner 19:00까지 가능합니다.<br>

				   예약 및 문의Tel) 02-2230-3356
</p>
			
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
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/팔선_서울.webp" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<h4>동양적 감성과 현대미의 공존</h4>
        		<p>동양적인 감성과 현대적인 느낌이 고급스럽게 어우러진 실내 인테리어는</p>
				<p>중국의 상류층 저택 다이닝룸을 방문한 것과 같은 편안하고 품격 있는 분위기를 연출하여<br></p>
				<p>들어서는 입구부터 고객의 마음을 사로잡습니다.<br><br></p>
				
				<h4>정통 중식의 진수</h4>
				<p>팔선의 깊은 전통과 꾸준한 명성은 중국 본토 최고의 맛을 그대로 전해드립니다.</p>
				<p>북경과 광둥 지역 출신의 조리사가 직접 선보이는 정통 중식 요리는 그 맛과 정성으로</p>
				<p>다양한 취향을 가진 고객의 눈과 입을 만족시켜 드립니다.<br><br></p>
				
				<p>Open / Close</p>
				<p>Lunch : 12:00 ~ 14:30 (Last Order : 13:30)</p>

				<p> Dinner : 17:30 ~ 21:30 (Last Order : 20:30)</p>
				<p>예약 및 문의Tel) 02-2230-3366</p>
			
 	       </div>
        </div>
        <span class="prev" onclick="plusSlides(-1, 'myModal4')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal4')">&#10095;</span>
    </div>
</div>

<!-- 슬라이드쇼 모달 5 -->
<div id="myModal5" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal5')">&times;</span>
        <div style="display: flex; align-items: flex-start; gap: 20px;">
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/더파크뷰_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p>원목과 대리석의 자연 친화적 인테리어와 남산의 놈음이 어우러진 올 데이 다이닝 공간입니다.</p>
        		<p>라이브 키친에서 신선한 식재료로 즉석에서 조리한 음식을 맛볼 수 있습니다.</p>
				<p><br>Open / Close :12:00 ~ 14:30 (Last Order : 13:00)	<br>
				       Dinner :  17:30 ~ 21:30 (Last Order : 19:30)<br><br>
				       예약 및 문의Tel) 02-2230-3374
				</p>
			
 	       </div>
        </div>
        <span class="prev" onclick="plusSlides(-1, 'myModal5')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal5')">&#10095;</span>
    </div>
</div>

<!-- 슬라이드쇼 모달 6 -->
<div id="myModal6" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('myModal6')">&times;</span>
        <div style="display: flex; align-items: flex-start; gap: 20px;">
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/부티크_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p>운영시간 07:00 ~ 22:00</p>
        		<p>* 홈페이지 상품 이미지는 패스트리 부티크에서 실제 판매하는 상품과 상이할 수 있습니다.</p>
				<p>* 패스트리 부티크의 케이크 레터링 서비스가 2022년 12월 1일자로 중단됨을 안내드립니다.<br></p>
			
 	       </div>
        </div>
        <span class="prev" onclick="plusSlides(-1, 'myModal6')">&#10094;</span>
        <span class="next" onclick="plusSlides(1, 'myModal6')">&#10095;</span>
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