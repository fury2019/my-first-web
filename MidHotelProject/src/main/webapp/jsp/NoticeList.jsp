<%@page import="com.Hotel.vo.NoticeVO"%>
<%@page import="com.Hotel.vo.FAQVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DDIT 호텔 - 공지사항</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/FAQ.css">
</head>

<body>
    <div class="layout">
        <div class="content">
            <div class="faq-info">
                <h2>공지사항 목록</h2>

                <!-- 상단 메뉴 버튼 -->
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
                            	String noticeDate = notice.getNotice_date();
                            	String simpDate = noticeDate.split(" ")[0];
                    %>
                    <div class="faq-item">
                        <div class="faq-title" onclick="toggleContent(this)">
                            <span class="faq-title2"><%= notice.getNotice_title() %></span>
    						<span class="faq-date">공지 날짜 : <%= simpDate %></span>
                        </div>
                        <div class="faq-content">
                            <%=notice.getNotice_content()%>
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
    <script type="text/javascript">
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
            const url = category === "all" ? "/noticeList" : "<%=request.getContextPath()%>/noticeClassList?category=" + category;

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
    
    </script>
</body>

</html>
