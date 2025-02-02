<%@ page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>DDIT 호텔 - 야외 수영장</title>
  <style>

       
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

       .intro {
          text-align: center;
          color: #666;
          font-size: 18px;
          margin-bottom: 40px;
      }

     div .room-type {
          margin-top: 40px;
          display: flex;
          flex-wrap: wrap;
          text-align: center;
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
          text-align: center;
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
      <h3 class="title">격이 다른 아웃도어 라이프스타일 경험을 제공하는 어번 아일랜드</h3>
      <p class="intro">어번 아일랜드는 '도심 속 휴식의 섬' 컨셉의 야외 수영장입니다.</p>

      <div class="room-type">
          <h2>야외 수영장</h2>
          <div class="room">
              <img src="../Facilities_image/어번아일랜드_서울.png" alt="어번아일랜드" class="room-image">
              <div class="room-info">
                  <h3>어번 아일랜드</h3>
                  <p>문의 전화 02-2230-2209~1</p>
                  <p>어번 아일랜드가 동계 시설 정비를 위해 휴장합니다.</p>
				  <p>- 25년 2월 중 운영 기간 공지 예정 -</p>
                  <button onclick="openModal('myModal1', 1)">이미지 & 안내사항</button>
              </div>
          </div>
          <div class="room">
              <img src="../Facilities_image/카바나_서울.png" alt="카바나" class="room-image">
              <div class="room-info">
                  <h3>카바나</h3>
                  <p>문의 전화 02-2230-2209~1</p>
                  <p>어번 아일랜드가 동계 시설 정비를 위해 휴장합니다.</p>
				  <p>- 25년 2월 중 운영 기간 공지 예정 -</p>
                  <button onclick="openModal('myModal2', 1)">이미지 & 안내사항</button>
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
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/어번아일랜드_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p>어번 아일랜드(Urban Island)는 다양한 야외 공간에서 특별한 경험을 제공하는 장소입니다.</p>
        		<p>서울 신사동에 위치하며, 테라스, 루프탑, 카페 등에서 다양한 라이프스타일을 즐길 수 있습니다.</p>
				<p><br></p>
				<p>■ 운영 방침 ■</p>
				<p>방문 시 사전 예약이 필요하며, 전화(02-2230-3528-9)로 문의 가능합니다.</p>
				<p>신장 140cm 미만의 고객은 보호자의 동반이 필요합니다.</p>
				<p>음식 반입이 금지되며, 특정 물품에 대한 제한이 있습니다.</p>
				<p>상업적 목적으로 이용할 수 없습니다.</p>
				<p>안전과 관련하여 고객의 안전을 위해 여러 규정이 있으며, 위반 시 이용이 제한될 수 있습니다. </p>
				<p>또한, 특정 서비스는 제공되지 않으니 미리 확인해야 합니다.</p>
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
	        <img class="modal-image" id="modalImage1" src="../Facilities_image/카바나_서울.png" alt="슬라이드쇼 이미지">
    	    <div class="modal-description">
				<p><br></p>
        		<p id="modalDescription1"></p>
        		<p></p>
        		<p>프라이빗하고 여유로운 휴식과 함께 낭만적인 시간을 만들어드립니다.</p>
				<p><br></p>
				<p>어번 아일랜드에서 더욱 여유로운 시간을 즐길 수 있는 다양한 스타일의 카바나를 제안합니다.</p>
				<p>소중한 사람들과 함께하는 여유로운 휴식 그리고 낭만적인 순간을 경험해 보십시오</p>
				
				<p></p>
				<p></p>
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