<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>고객 센터</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/AdminPage.css">
    
    <script type="text/javascript">
        window.onload = function() {
            const redirectTo = new URLSearchParams(window.location.search).get('redirect');

            if (redirectTo) {
                // 리다이렉트가 있는 경우 해당 페이지를 로드
                if (redirectTo === "faqList") {
                    loadContent('/faqList');
                } else if (redirectTo === "customerInquiry") {
                    loadContent('/CustomerInquiry.jsp');
                }

                // URL에서 리다이렉트 정보 제거 (히스토리 업데이트)
                const url = new URL(window.location.href);
                url.searchParams.delete('redirect');
                window.history.replaceState({}, document.title, url.pathname);
            } else {
                // 리다이렉트 정보가 없는 경우 기본 콘텐츠 로드
                loadContent('/customerList.do');
            }
        };

        function loadContent(url) {
            const contextPath = "<%=request.getContextPath()%>";
            const fullUrl = contextPath + url;

            const contentArea = $("#content-area");

            $.ajax({
                url: fullUrl,
                type: "GET",
                success: function (response) {
                    contentArea.html(response);
                },
                error: function (xhr) {
                    console.error("Error loading content:", xhr.statusText);
                    contentArea.html("<p>콘텐츠를 불러오지 못했습니다.</p>");
                }
            });
        }
    </script>
</head>
<body>
    <div class="layout">
        <!-- 사이드바 및 콘텐츠 -->
        <div class="content">
            <!-- 사이드바 -->
            <div class="sidebar" id="menu">
                <ul>
                    <li>
						<a href="#" onclick="loadContent('<%=request.getContextPath()%>/customerList.do')">고객 문의</a>
                    </li>
                    <li>
                        <a href="#" onclick="loadContent('<%=request.getContextPath()%>/faqList')">FAQ</a>
                    </li>
                    <li>
                        <a href="#" onclick="loadContent('<%=request.getContextPath()%>/noticeList')">공지사항</a>
                    </li>
                </ul>
            </div>

            <!-- 메인 콘텐츠 -->
            <div class="main-content">
                <div id="content-area">
                    <h1>고객 센터</h1>
                    <p>로딩 중...</p>
                </div>
            </div>
        </div>
    </div>

    <%@include file="/jsp/include/footer.jsp" %>
</body>
</html>
