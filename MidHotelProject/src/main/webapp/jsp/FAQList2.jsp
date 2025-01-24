<%@page import="com.Hotel.vo.FAQVO"%>
<%@page import="com.Hotel.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
       pageEncoding="UTF-8"%>
       
<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %>      
           
       
<!DOCTYPE html>
<html lang="ko">

<head>
   <meta charset="UTF-8"/>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>DDIT 호텔 - FAQ</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <link rel="stylesheet" type="text/css" href="/css/FAQ2.css">
   
</head>     
<body>
    <div class="layout">
        <div class="content">
        	<div class="sidebar">
               <ul>
                     <li><a href="<%=request.getContextPath() %>/customerList.do">고객문의</a></li>
                     <li><a href="/faqList2">FAQ</a></li>
                </ul>
            </div>
            
            <div class="faq-info">
                <h2>FAQ 목록</h2>

                <!-- 상단 메뉴 버튼 -->
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
                    <div class="faq-item">
                        <div class="faq-title" onclick="toggleContent(this)">
                            <%=faq.getFaq_title()%>
                        </div>
                        <div class="faq-content">
                            <%=faq.getFaq_content()%>
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
            const url = category === "all" ? "/faqList" : "<%=request.getContextPath()%>/faqClassList2?category=" + category;

            // Ajax 요청
            $.ajax({
                url: url,
                type: "GET",
                success: function (response) {
                	$("#faqList").html(response);
                },
                error: function () {
                    console.error("FAQ 데이터를 가져오는데 실패했습니다.");
                },
            });
        });
    });

    </script>
</body>
</html>
<%@include file="/jsp/include/footer.jsp" %>