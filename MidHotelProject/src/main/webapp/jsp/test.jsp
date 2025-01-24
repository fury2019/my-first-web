<!DOCTYPE html>
<html lang="en">

<head>
    <title>Bootstrap 5 Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .header {
            background-color: #012b28;
            color: #333;
            text-align: center;
            padding: 0px 0;
            font-family: 'Arial', sans-serif;
            position: relative;
        }

        .header img {
            max-width: 100%;
            height: auto;
            margin-left: 10px;
            margin-right: 70px;
        }

        .header .links {
            position: absolute;
            width: 100%;
            display: flex;
            justify-content: space-between;
            padding: 0 60px;
            bottom: 20px;
        }

        .header a {
            font-size: 20px;
            color: #ebb42c;
            text-decoration: none;
            height: 60px;
        }

        .body {
            display: flex;
            /* Flexbox 사용 */
            flex-direction: column;
            /* 세로 방향으로 정렬 */
            align-items: center;
            /* 가로 방향 가운데 정렬 */
            text-align: center;
            /* 텍스트 가운데 정렬 */
            padding: 20px 0;
            /* 상하 패딩 */
        }

        .body img {
            margin-bottom: 20px;
            /* 이미지 아래에 간격 추가 */
        }

        .body h2 {
            font-family: 'Helvetica', sans-serif;
            margin: 15px 0;
        }

        .body h5 {
            font-family: 'Tahoma', sans-serif;
        }

        .modal-content {
            padding: 20px;
        }

        .modal-title {
            color: #012b28;
            /* 모달 제목 색상 변경 */
        }

        .btn-primary {
            background-color: #012b28;
            /* 버튼 배경색 변경 */
            border-color: #012b28;
            /* 버튼 테두리 색상 변경 */
        }

        .btn-primary:hover {
            background-color: #0a3d3e;
            /* 호버 시 색상 변경 */
            border-color: #0a3d3e;
            /* 호버 시 테두리 색상 변경 */
        }

        .footer {
            background-color: #012b28;
            color: #fff;
            text-align: center;
            padding: 20px 0;
        }

        .carousel-inner img {
            max-height: 750px;
            object-fit: contain;
        }
    </style>
</head>

<body>

    <div class="header">
        <a href="http://127.0.0.1:5500/%EC%A4%91%ED%94%84%20%ED%85%8C%EC%8A%A4%ED%8A%B8/%EB%A9%94%EC%9D%B8%ED%8E%98%EC%9D%B4%EC%A7%80.html">
            <img src="image/아이콘.png" alt="DDIT HOTEL Logo" width="200px">
        </a>

        <!-- 상단 링크 -->
        <div class="links"
            style="display: flex; justify-content: flex-end; padding: 10px 60px; position: absolute; top: 10px;">
            <a href="../html/login.html" style="font-size: 12px; margin-right: 20px;">로그인</a>
            <a href="http://127.0.0.1:5500/%EC%A4%91%ED%94%84%20%ED%85%8C%EC%8A%A4%ED%8A%B8/%EA%B3%A0%EA%B0%9D%EB%AC%B8%EC%9D%98.html#" style="font-size: 14px;">고객 문의</a>
        </div>

        <!-- 하단 링크 -->
        <div class="links"
            style="display: flex; justify-content: space-around; padding: 10px 60px; position: absolute; bottom: 20px; width: calc(100% - 120px);">
            <a href="#" data-bs-toggle="modal" data-bs-target="#reservationModal">예약</a>
            <a href="#">객실정보</a>
            <a href="#" style="margin-left: 150px;">호텔 근처 명소</a> <!-- 오른쪽으로 더 띄움 -->
            <a href="http://127.0.0.1:5500/%EC%A4%91%ED%94%84%20%ED%85%8C%EC%8A%A4%ED%8A%B8/E-SHOP.html">E-SHOP</a>
        </div>
    </div>

    <!-- 슬라이드 쇼 (Carousel) -->
    <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="image/1.jpg" class="d-block w-100" alt="호텔 이미지 1">
            </div>
            <div class="carousel-item">
                <img src="image/2.jpg" class="d-block w-100" alt="호텔 이미지 2">
            </div>
            <div class="carousel-item">
                <img src="image/3.jpg" class="d-block w-100" alt="호텔 이미지 3">
            </div>
            <div class="carousel-item">
                <img src="image/4.jpg" class="d-block w-100" alt="호텔 이미지 4">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <!-- 모달 -->
    <div class="modal fade" id="reservationModal" tabindex="-1" aria-labelledby="reservationModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="reservationModalLabel">예약하기</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <h6>국내</h6>
                    <div class="d-flex flex-wrap mb-3">
                        <button class="btn btn-outline-secondary me-2 mb-2">서울 DDIT 호텔</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 광화문</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 마포</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 서대문</button>
                    </div>

                    <h6>서울 강남</h6>
                    <div class="d-flex flex-wrap mb-3">
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 역삼</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 서초</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 구로</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 삼성</button>
                    </div>

                    <h6>전국</h6>
                    <div class="d-flex flex-wrap">
                        <button class="btn btn-outline-secondary me-2 mb-2">제주 DDIT 호텔</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 동탄</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 천안</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 전주</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 울산</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 여수</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 서부산</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 해운대</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 제주</button>
                        <button class="btn btn-outline-secondary me-2 mb-2">DDIT스테이 플러스 이호테우</button>
                    </div>
                </div>

                <div class="mt-4">
                    <h6>체크인</h6>
                    <input type="date" class="form-control mb-2" required>
                    <h6>체크아웃</h6>
                    <input type="date" class="form-control mb-2" required>
                    <h6>인원</h6>
                    <div class="row">
                        <div class="col">
                            <label for="adult" class="form-label">성인</label>
                            <input type="number" class="form-control" id="adult" value="1" min="1" required>
                        </div>
                        <div class="col">
                            <label for="child" class="form-label">어린이</label>
                            <input type="number" class="form-control" id="child" value="0" min="0">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                <button type="button" class="btn btn-primary">검색하기</button>
            </div>
        </div>
    </div>
    </div>

    <div class="body">
        <h3>DDIT HOTEL</h3>
        <h5>DDIT HOTEL은 도심 속의 편안한 오아시스입니다.<br> 현대적인 디자인과 따뜻한 환대가 어우러진 이곳은 비즈니스 여행객과 관광객 모두에게 최적의 선택입니다.</h5>
    </div>

    <div class="footer">
        <div class="footer-logo">
            <img src="image/아이콘.png" alt="호텔 로고" width="200px">
        </div>
        <div class="footer-info">
            <p>㈜DDIT호텔 34908, 대전 중구 계룡로 846 / +82-042-222-8202</p>
            <p>대표이사: 김형응</p>
        </div>
        <div class="footer-links">
            <a href="#">개인정보처리방침</a>
            <a href="#">사이트 이용약관</a>
            <a href="#">약관 및 정책</a>
            <a href="#">쿠키 설정</a>
        </div>
    </div>

</body>

</html>