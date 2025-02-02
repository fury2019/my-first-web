<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The DDIT Hotels</title>
    <style>
      @font-face {
    font-family: 'MinSans-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
    
        body {
            font-family: 'MinSans-Regular', sans-serif;
            margin: 0;
            padding: 0;
            color: #333;
        }
        
         /* 서울 호텔 헤더와 풋터 */
        #header-seoul, #footer-seoul {
            background-color: #800020;
            color: #fff;
        }
        
        /* 제주 호텔 헤더와 풋터 */
        #header-jeju, #footer-jeju {
            background-color: #800020; /* 녹색 계열 */
            color: #fff;
        }
        
        /* 스테이 호텔 헤더와 풋터 */
        #header-stay, #footer-stay {
            background-color:   #800020 
            ; /* 주황 계열 */
            color: #fff;
        }
        
        header {
		    display: flex;
		    justify-content: space-between;
		    align-items: center;
		    background-color: #800020;
		    color: #fff;
		    padding: 10px 20px;
		    position: relative;
		    
		    
		}
		.logo {
		    font-size: 36px;  /* Increase the font size to your desired value */
		    font-weight: bold; /* Optional: Make the text bold for more emphasis */
		    color: #fff;  /* Ensure the text is white, matching the rest of the header */
		}
		
        .logo-container {
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .logo-button {
            background: none;
            border: none;
            color: #fff;
            font-size: 18px;
            cursor: pointer;
        }
        
        nav {
		    display: inline-block;  /* inline-block을 사용하여 블록 요소처럼 취급하면서 오른쪽으로 정렬되도록 */
		}

        nav .dropdown {
		    position: relative;
		    display: inline-block;
		}
		
		nav .dropdown-content {
		    display: none;
		    position: absolute;
		    background-color: #fff;
		    min-width: 150px;
		    box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
		    z-index: 1;
		}
		
		nav .dropdown-content a {
		    color: #333;
		    padding: 10px;
		    text-decoration: none;
		    display: block;
		}
		
		nav .dropdown:hover .dropdown-content {
		    display: block;
		}
		
		nav .dropdown-content a:hover {
		    background-color: #f1f1f1;
		}
		
		nav a {
		    color: #fff;
		    text-decoration: none;
		    font-size: 15px;
		    margin-right : 30px;
		}
        nav .dropdown {
            position: relative;
            display: inline-block;
        }
        nav .dropdown-content {
            display: none;
            position: absolute;
            background-color: #fff;
            min-width: 150px;
            box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
            z-index: 1;
        }
        nav .dropdown-content a {
            color: #333;
            padding: 10px;
            text-decoration: none;
            display: block;
            
        }
        nav .dropdown:hover .dropdown-content {
            display: block;
        }
		.main-banner {
		    position: relative;
		    height: 550px;
		    width: 90%;  /* 배너 너비 설정 */
		    background-size: cover;
		    background-position: center;
		    margin: 0 auto;  /* 왼쪽과 오른쪽 마진을 자동으로 설정하여 수평 중앙 정렬 */
		}
        .main-banner img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }
        .main-banner .overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.4);
            color: #fff;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
        }
        .reservation {
            background: #f8f8f8;
            padding: 20px;
            display: flex;
            justify-content: center;
            gap: 15px;
        }
        .reservation input, .reservation select {
            padding: 10px;
            font-size: 14px;
        }
        .reservation button {
            padding: 10px 20px;
            background-color: #000;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        .section {
            padding: 20px;
        }
        .room-details {
            text-align: center;
            margin: 20px 0;
        }
        .room-details img {
            max-width: 100%;
            height: auto;
            border: 1px solid #ddd;
        }
        .footer {
            background-color: #800020;
            color: #fff;
            padding: 20px;
            text-align: center;
        }
        
        #banner-seoul {
    		background-color: #1e90ff;
		}

		#banner-jeju {
		    background-color: #ff7f50;
		}
		
		#banner-stay {
		    background-color: #32cd32;
		}
		
        .popup {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.8);
            justify-content: center;
            align-items: center;
            z-index: 1000;
        }
        .popup img {
            max-width: 80%;
            max-height: 80%;
            border: 5px solid white;
            border-radius: 10px;
        }
        .popup .close-btn {
            position: absolute;
            top: 20px;
            right: 20px;
            background: none;
            border: none;
            color: white;
            font-size: 24px;
            cursor: pointer;
        }
        .view-button {
            position: absolute;
            bottom: 20px;
            right: 20px;
            background-color: #000;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }
		
		#scrollToTop {
			display: none;
			position: fixed;
			bottom: 20px;
			right: 20px;
			width: 50px;
			height: 50px;
			background-color: #000;
			color: #fff;
			border: none;
			border-radius: 50%;
			text-align: center;
			line-height: 50px;
			font-size: 20px;
			cursor: pointer;
			z-index: 1000;
        }
        #scrollToTop:hover {
            background-color: #444;
        }
        
		.content-area{
			margin-left:100px
		}
		
	
				
		
    </style>
</head>

<body>
     <header id="header-seoul">
        <div class="logo-container">
            <button class="logo-button" onclick="rotateBanner(-1)">&lt;</button>
            <div class="logo">THE DDIT SEOUL HOTEL</div>
            <button class="logo-button" onclick="rotateBanner(1)">&gt;</button>
        </div>
        <nav>
        
            <div class="dropdown">
                <a href="#" onclick="loadContent('Info_Aqua.jsp')">야외 수영장</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('Info_Room.jsp')">객실</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('Info_Dining.jsp')">다이닝</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('Info_Fitness.jsp')">피트니스</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('Info_Life.jsp')">라이프 스타일</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('Info_Lounge.jsp')">라운지 & 바</a>
            </div>
            
        </nav>
    </header>

    <!-- Other headers -->
    <header id="header-jeju" style="display: none;">
        <div class="logo-container">
            <button class="logo-button" onclick="rotateBanner(-1)">&lt;</button>
            <div class="logo">THE DDIT JEJU HOTEL</div>
            <button class="logo-button" onclick="rotateBanner(1)">&gt;</button>
        </div>
        <nav>
        
            <div class="dropdown">
                <a href="#" onclick="loadContent('.jsp')">야외 수영장</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('.jsp')">객실</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('.jsp')">다이닝</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('.jsp')">피트니스</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('.jsp')">라이프 스타일</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('.jsp')">라운지 & 바</a>
            </div>
            
        </nav>
    </header>

    <header id="header-stay" style="display: none;">
        <div class="logo-container">
            <button class="logo-button" onclick="rotateBanner(-1)">&lt;</button>
            <div class="logo">THE DDIT HOTEL 스테이</div>
            <button class="logo-button" onclick="rotateBanner(1)">&gt;</button>
        </div>
        <nav>
        
            <div class="dropdown">
                <a href="#" onclick="loadContent('.jsp')">야외 수영장</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('.jsp')">객실</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('.jsp')">다이닝</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('.jsp')">피트니스</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('.jsp')">라이프 스타일</a>
            </div>

            <div class="dropdown">
                <a href="#" onclick="loadContent('.jsp')">라운지 & 바</a>
            </div>
            
        </nav>
    </header>
    
    
    <!-- Main Banners -->
    <div class="main-banner" id="banner-seoul">
        <img src="/image/h01.webp" alt="The DDIT Seoul" onclick="openPopup('/image/h01.webp')">
        <div class="overlay">
            <h1>Welcome to The DDIT Seoul</h1>
            <p>서울의 중심에서 아름다운 경관과 함께 문화적인 매력을 만끽하며 잊지 못할 순간을 만들어 보세요.</p>
        </div>
    </div>

    <div class="main-banner" id="banner-jeju" style="display: none;">
        <img src="/image/h09.webp" alt="The DDIT Jeju" onclick="openPopup('/image/h09.webp')">
        <div class="overlay">
            <h1>Welcome to The DDIT Jeju</h1>
            <p>제주도에서의 편안한 시간은 자연 속에서 느끼는 여유로움과 함께 더욱 특별한 경험이 될 것입니다.</p>
        </div>
    </div>

    <div class="main-banner" id="banner-stay" style="display: none;">
        <img src="/image/h05.webp" alt="DDIT Stay" onclick="openPopup('/image/h05.webp')">
        <div class="overlay">
            <h1>Welcome to DDIT Stay</h1>
            <p>자유롭고 즐거운 여행 시간을 보낼 수 있도록 최고의 서비스를 제공해드리겠습니다.</p>
        </div>
    </div>

    <!-- Content Area -->
    <div class="content-area" style="padding: 20px;">
        <!-- Default content or placeholder -->
        <h2>Welcome to The DDIT Hotels</h2>
        <p>Choose a service to learn more about our offerings.</p>
    </div>

    <!-- 서울 호텔 풋터 -->
    <footer class="footer" id="footer-seoul">
        <p>&copy; 2024 The DDIT Hotels. All rights reserved.</p>
        <p>Contact: +82-042-222-8202  |  Email: info@ddit.com</p>
        <p>대표이사: 김형음</p>
    </footer>
    
    <!-- 제주 호텔 풋터 -->
    <footer class="footer" id="footer-jeju" style="display: none;">
        <p>&copy; 2024 The DDIT Hotels. All rights reserved.</p>
        <p>Contact: +82-042-222-8202  |  Email: info@ddit.com</p>
        <p>대표이사: 김형음</p>
    </footer>
    
    <!-- 스테이 호텔 풋터 -->
    <footer class="footer" id="footer-stay" style="display: none;">
        <p>&copy; 2024 The DDIT Hotels. All rights reserved.</p>
        <p>Contact: +82-042-222-8202  |  Email: info@ddit.com</p>
        <p>대표이사: 김형음</p>
    </footer>

    <!-- JavaScript -->
    <script>
        const headerIds = ["header-seoul", "header-jeju", "header-stay"];
        const bannerIds = ["banner-seoul", "banner-jeju", "banner-stay"];
        const footerIds = ["footer-seoul", "footer-jeju", "footer-stay"];
        let currentBannerIndex = 0;

        function showBannerAndHeader(index) {
            bannerIds.forEach((id, idx) => {
                document.getElementById(id).style.display = idx === index ? "block" : "none";
            });
            headerIds.forEach((id, idx) => {
                document.getElementById(id).style.display = idx === index ? "block" : "none";
            });
            footerIds.forEach((id, idx) => {
                document.getElementById(id).style.display = idx === index ? "block" : "none";
            });
        }

        function rotateBanner(direction) {
            currentBannerIndex = (currentBannerIndex + direction + bannerIds.length) % bannerIds.length;
            showBannerAndHeader(currentBannerIndex);
        }

        function loadContent(page) {
            const contentArea = document.querySelector('.content-area');
            const xhr = new XMLHttpRequest();
            xhr.open('GET', page, true);
            xhr.onload = function () {
                if (xhr.status === 200) {
                    contentArea.innerHTML = xhr.responseText;
                } else {
                    contentArea.innerHTML = '<p>Error loading content. Please try again later.</p>';
                }
            };
            xhr.onerror = function () {
                contentArea.innerHTML = '<p>Error loading content. Please check your connection.</p>';
            };
            xhr.send();
        }
        
    	
    	function scrollToTop() {
    	    window.scrollTo({
    	        top: 0,
    	        behavior: 'smooth'
    	    });
    	}
    	
    	// 스크롤 이벤트로 버튼 표시/숨김 처리
    	window.addEventListener('scroll', function () {
    	    const scrollToTopButton = document.getElementById('scrollToTop');
    	    if (window.scrollY > 300) {
    	        scrollToTopButton.style.display = 'block';
    	    } else {
    	        scrollToTopButton.style.display = 'none';
    	    }
    	});

        // Initialize the first banner and header
        showBannerAndHeader(0);
        
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