<%@page import="com.Hotel.vo.NoticeVO"%>
<%@page import="com.Hotel.vo.FAQVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DDIT 호텔-공지사항</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/FAQ.css">
    <style>
	    .faq-content {
	        display: none;
	        margin-top: 10px;
	        padding: 10px;
	        background-color: #fff7e6; /* 밝은 크림색으로 조정 */
	        border-left: 3px solid #f5deb3;
	        border-radius: 5px;
	        color: #5a2d0c; /* FAQ 제목과 동일한 색상 */
	    }
	
	    .faq-content.expanded {
	        display: block;
	    }
	
	    .faq-actions {
	        margin-top: 10px;
	        display: flex;
	        gap: 10px; /* 버튼 간격 조정 */
	        justify-content: start; /* 버튼 정렬 왼쪽 */
	    }
	
	    .faq-actions button {
	        padding: 8px 15px;
	        background-color: #8b4513; /* 메인 테마 색상과 맞춤 */
	        color: #fff;
	        border: none;
	        border-radius: 5px;
	        cursor: pointer;
	        font-size: 14px;
	        transition: background-color 0.3s, transform 0.2s;
	    }
	
	    .faq-actions button:hover {
	        background-color: #5a2d0c; /* 테마 색상으로 강조 */
	        transform: scale(1.05); /* 호버 시 크기 약간 증가 */
	    }
	
	    .faq-actions .delete-btn {
	        background-color: #cd5c5c; /* 붉은색 조정 */
	    }
	
	    .faq-actions .delete-btn:hover {
	        background-color: #b22222; /* 호버 시 더 어두운 붉은색 */
	    }
	    
	    
	</style>
</head>

<body>
    <div class="layout">
        <div class="content">
            <div class="faq-info">
                <h2>공지사항 수정 / 삭제</h2>
                
                <div class="faq-categories">
                    <button class="category-btn" data-category="all">전체</button>
                    <button class="category-btn" data-category="N_Hotel">호텔 운영 관련</button>
                    <button class="category-btn" data-category="N_Event">이벤트</button>
                    <button class="category-btn" data-category="N_Policy">고객 안전 및 정책</button>
                    <button class="category-btn" data-category="N_Other">기  타</button>
                </div>
                
                <hr class="line">

                <div class="faq-list" id="faqList">
                    <%
                        List<NoticeVO> noticeList = (List<NoticeVO>) request.getAttribute("noticeList");
                        if (noticeList != null) {
                            for (NoticeVO notice : noticeList) {
                    %>
                    <div class="faq-item" data-id="<%=notice.getNotice_no()%>">
                        <div class="faq-title" onclick="toggleContent(this)">
                            <%=notice.getNotice_title()%>
                        </div>
                        <div class="faq-content">
                            <p><%=notice.getNotice_content()%></p>
                            <div class="faq-actions">
                                <button class="edit-btn" onclick="editFAQ('<%=notice.getNotice_no()%>')">수정</button>
                                <button class="delete-btn" onclick="deleteFAQ('<%=notice.getNotice_no()%>')">삭제</button>
                            </div>
                        </div>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>

                <div id="pagination" class="pagination"></div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
    <script>
    function initializeFAQEvents() {
        const itemsPerPage = 10; // 한 페이지당 표시할 FAQ 수
        const faqItems = $(".faq-item");
        const totalItems = faqItems.length;
        const totalPages = Math.ceil(totalItems / itemsPerPage);

        // 기존 버튼 초기화
        $("#pagination").empty();

        // 페이지 버튼 생성
        for (let i = 1; i <= totalPages; i++) {
            $("#pagination").append(
                '<button class="page-btn" data-page="' + i + '">' + i + '</button>'
            );
        }

        // 특정 페이지 보여주는 함수
        function showPage(pageNumber) {
            faqItems.hide(); // 모든 FAQ 숨기기
            const start = (pageNumber - 1) * itemsPerPage;
            const end = start + itemsPerPage;
            faqItems.slice(start, end).show(); // 선택된 페이지의 FAQ 항목만 표시

            // 활성화된 버튼 표시
            $(".page-btn").removeClass("active");
            $('.page-btn[data-page="' + pageNumber + '"]').addClass("active");
        }

        // 버튼 클릭 이벤트 바인딩
        $(".page-btn").off("click").on("click", function () {
            const pageNumber = $(this).data("page");
            showPage(pageNumber); // 선택한 페이지 표시
        });

        // 첫 번째 페이지 표시
        showPage(1);
    }

    $(document).ready(function () {
        initializeFAQEvents(); // FAQ 이벤트 초기화
    });

    function toggleContent(element) {
        $(element).next(".faq-content").toggleClass("expanded");
    }
    
    $(document).ready(function () {
        $(".category-btn").on("click", function () {
            const category = $(this).data("category");
            const url = category === "all" ? "/noticeUpdateList" : "<%=request.getContextPath()%>/noticeUpdateClassList?category=" + category;

            // Ajax 요청
            $.ajax({
                url: url,
                type: "GET",
                success: function (response) {
                    $("#content-area").html(response);
                },
                error: function () {
                    console.error("공지사항 데이터를 가져오는데 실패했습니다.");
                },
            });
        });
    });

    function editFAQ(noticeId) {
        const contentArea = $("#content-area"); // 관리 페이지의 메인 컨텐츠 영역

        // AJAX를 사용하여 수정 페이지 로드
        $.ajax({
            url: "/noticeUpdate", // 서블릿 URL
            method: "GET", // GET 방식으로 faq_no 전달
            data: { notice_no: noticeId }, // 요청 파라미터
            success: function (response) {
                contentArea.html(response); // 응답 내용을 컨텐츠 영역에 삽입
            },
            error: function (xhr) {
                console.error("공지사항 수정 페이지 로드 중 오류:", xhr.statusText);
                alert("공지사항 수정 페이지를 로드할 수 없습니다.");
            },
        });
    }

    function deleteFAQ(noticeId) {
        if (confirm("이 공지사항을 삭제하시겠습니까?")) {
            // AJAX를 사용하여 /faqDelete 서블릿으로 삭제 요청 전송
            $.ajax({
                url: '/noticeDelete',
                method: 'POST', // FAQ 삭제는 POST 방식으로 처리
                contentType: 'application/x-www-form-urlencoded',
                data: { notice_no: noticeId }, // 서버로 전송할 데이터
                success: function(response) {
                    if (response.trim() === "success") {
                        alert("공지사항이 성공적으로 삭제되었습니다.");
                        loadContent("/noticeList");
                        // 컨텐츠 박스에 FAQ 목록 로드
                    } else {
                        alert("공지사항 삭제 중 오류가 발생했습니다.");
                    }
                },
                error: function(error) {
                    alert("공지사항 삭제 요청 중 서버 오류가 발생했습니다.");
                }
            });
        }
    }
    </script>
</body>

</html>
