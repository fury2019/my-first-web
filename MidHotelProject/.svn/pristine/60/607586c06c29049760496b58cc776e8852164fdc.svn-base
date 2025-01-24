<%@page import="com.Hotel.vo.FAQVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DDIT 호텔-FAQ</title>
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
                <h2>FAQ 수정 / 삭제</h2>
                
                <div class="faq-categories">
                    <button class="category-btn" data-category="all">전체</button>
                    <button class="category-btn" data-category="F_Room">객실 관련</button>
                    <button class="category-btn" data-category="F_Fac">편의 시설</button>
                    <button class="category-btn" data-category="F_Shop">E-SHOP관련</button>
                    <button class="category-btn" data-category="F_Other">기  타</button>
                </div>
                
                <hr class="line">

                <div class="faq-list" id="faqList">
                    <%
                        List<FAQVO> faqList = (List<FAQVO>) request.getAttribute("faqList");
                        if (faqList != null) {
                            for (FAQVO faq : faqList) {
                    %>
                    <div class="faq-item" data-id="<%=faq.getFaq_no()%>">
                        <div class="faq-title" onclick="toggleContent(this)">
                            <%=faq.getFaq_title()%>
                        </div>
                        <div class="faq-content">
                            <p><%=faq.getFaq_content()%></p>
                            <div class="faq-actions">
                                <button class="edit-btn" onclick="editFAQ('<%=faq.getFaq_no()%>')">수정</button>
                                <button class="delete-btn" onclick="deleteFAQ('<%=faq.getFaq_no()%>')">삭제</button>
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
            const url = category === "all" ? "/faqUpdateList" : "<%=request.getContextPath()%>/faqUpdateClassList?category=" + category;

            // Ajax 요청
            $.ajax({
                url: url,
                type: "GET",
                success: function (response) {
                    $("#content-area").html(response);
                },
                error: function () {
                    console.error("FAQ 데이터를 가져오는데 실패했습니다.");
                },
            });
        });
    });

    function editFAQ(faqId) {
        const contentArea = $("#content-area"); // 관리 페이지의 메인 컨텐츠 영역

        // AJAX를 사용하여 수정 페이지 로드
        $.ajax({
            url: "/faqUpdate", // 서블릿 URL
            method: "GET", // GET 방식으로 faq_no 전달
            data: { faq_no: faqId }, // 요청 파라미터
            success: function (response) {
                contentArea.html(response); // 응답 내용을 컨텐츠 영역에 삽입
            },
            error: function (xhr) {
                console.error("FAQ 수정 페이지 로드 중 오류:", xhr.statusText);
                alert("FAQ 수정 페이지를 로드할 수 없습니다.");
            },
        });
    }

    function deleteFAQ(faqId) {
        if (confirm("이 FAQ를 삭제하시겠습니까?")) {
            // AJAX를 사용하여 /faqDelete 서블릿으로 삭제 요청 전송
            $.ajax({
                url: '/faqDelete',
                method: 'POST', // FAQ 삭제는 POST 방식으로 처리
                contentType: 'application/x-www-form-urlencoded',
                data: { faq_no: faqId }, // 서버로 전송할 데이터
                success: function(response) {
                    if (response.trim() === "success") {
                        alert("FAQ가 성공적으로 삭제되었습니다.");
                        loadContent("/faqList");
                        // 컨텐츠 박스에 FAQ 목록 로드
                    } else {
                        alert("FAQ 삭제 중 오류가 발생했습니다.");
                    }
                },
                error: function(error) {
                    alert("FAQ 삭제 요청 중 서버 오류가 발생했습니다.");
                }
            });
        }
    }
    </script>
</body>

</html>
