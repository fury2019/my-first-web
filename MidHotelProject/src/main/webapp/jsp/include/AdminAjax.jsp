<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
    
    <script type="text/javascript">
    let chkMenu = null;

    $(function() {
        // 메뉴 클릭 시 클릭된 메뉴 ID 저장 및 하위 메뉴 토글
        $(document).on("click", "#menu a", function(event) {
            chkMenu = $(this).attr("id");
            if (chkMenu === 'coupons') {
                $('#coupon-submenu').toggle();
            }
        });
    });
    
    $(document).ready(function() {
        $(document).on("click", "#res", function(event) {
            $("#res-submenu").toggle(); // 하위 메뉴 표시/숨김
        });
    });
    
    $(function() {
        // 회원 관리 클릭 시 하위 메뉴 토글
        $(document).on("click", "#users", function() {
            $('#user-submenu').toggle();
        });
    });
    
    $(document).ready(function() {
        // FAQ 관리 클릭 시 하위 메뉴 토글
        $(document).on("click", "#faq", function(event) {
            $("#faq-submenu").toggle(); // 하위 메뉴 표시/숨김
        });
    });
    
    $(document).ready(function() {
        // FAQ 관리 클릭 시 하위 메뉴 토글
        $(document).on("click", "#notice", function(event) {
            $("#notice-submenu").toggle(); // 하위 메뉴 표시/숨김
        });
    });
    

    // 쿠폰 회수 버튼 이벤트 바인딩
    function bindDeleteCouponEvent() {
        console.log("bindDeleteCouponEvent 호출됨"); // 디버깅용 로그
        $(document).off("click", ".delete-coupon").on("click", ".delete-coupon", function(event) {
            event.preventDefault();

            const couponId = $(this).data("id");
            console.log("회수할 쿠폰 ID:", couponId);

            if (confirm("정말 회수하시겠습니까?")) {
                $.ajax({
                    url: "<%= request.getContextPath() %>/deleteCoupon",
                    method: "POST",
                    data: { couponId: couponId },
                    success: function(response) {
                        alert("쿠폰이 성공적으로 회수되었습니다.");
                        loadContent("<%= request.getContextPath() %>/couponAllView");
                    },
                    error: function(xhr) {
                        console.error("AJAX 에러:", xhr.statusText);
                        alert("쿠폰 회수 중 오류가 발생했습니다.");
                    }
                });
            }
        });
    }

    $(document).on("click", ".blacklist-btn", function() {
        const memId = $(this).data("id"); // 클릭된 버튼의 data-id 가져오기

        if (confirm("해당 회원을 블랙리스트로 변경하시겠습니까?")) {
        	$.ajax({
        	    url: "<%= request.getContextPath() %>/memberBlack",
        	    type: "POST",
        	    data: { mem_id: memId, action: "blacklist" },
        	    success: function(response) {
        	        console.log("서버 응답:", response);
        	        
        	        if (response.status === "success") { 
        	            alert("회원 상태가 블랙리스트로 변경되었습니다.");
        	            loadContent('/memberBlack'); 
        	        } else {
        	            alert("상태 변경에 실패했습니다.");
        	        }
        	    },
        	    error: function(xhr, status, error) {
        	        console.error("AJAX 에러:", error);
        	        console.log("Response Text:", xhr.responseText);
        	        alert("상태 변경 중 오류가 발생했습니다. 오류: " + error);
        	    },
        	    dataType: "json" 
        	});
        }
    });
    
    $(document).on("click", ".revert-btn", function() {
        const memId = $(this).data("id");

        if (confirm("해당 회원을 일반 상태로 변경하시겠습니까?")) {
            $.ajax({
                url: "<%= request.getContextPath() %>/memberBlack",
                type: "POST",
                data: { mem_id: memId, action: "revert" },
                success: function(response) {
                    console.log("서버 응답:", response);

                    if (response.status === "success") {
                        alert("회원 상태가 일반으로 변경되었습니다.");
                        loadContent('/memberBlack'); // 컨텐츠 새로고침
                    } else {
                        alert("상태 변경에 실패했습니다.");
                    }
                },
                error: function(xhr, status, error) {
                    console.error("AJAX 에러:", error);
                    alert("상태 변경 중 오류가 발생했습니다.");
                },
                dataType: "json"
            });
        }
    });
    
    window.onload = function() {
        const redirectTo = new URLSearchParams(window.location.search).get('redirect');

        if (redirectTo) {
            // 리다이렉트가 있는 경우 해당 페이지를 로드
            if (redirectTo === "faqList") {
                loadContent('/faqList');
            } else if (redirectTo === "couponInsert") {
                loadContent('/couponAllView');
            } else if (redirectTo === "noticeList") {
                loadContent('/noticeList');
            }

            // URL에서 리다이렉트 정보 제거 (히스토리 업데이트)
            const url = new URL(window.location.href);
            url.searchParams.delete('redirect');
            window.history.replaceState({}, document.title, url.pathname);
        } else {
            // 리다이렉트 정보가 없는 경우 대시보드 로드
            loadContent('/dashBoard');
        }
    };
    
    
    function loadContent(page) {
        const contentArea = $("#content-area");

        // 기존 이벤트 핸들러를 확실히 제거 (중복 방지)
        $(document).off("submit", "#btnInsert");

        $.ajax({
            url: page,
            type: "GET",
            success: function(response) {
                contentArea.html(response);

                // FAQInsert 페이지 이벤트 바인딩 처리
                if (page === "/jsp/FAQInsert.jsp") {
                    bindFAQInsertEvent();
                }
                
                if (page === "/jsp/NoticeInsert.jsp") {
                    bindFAQInsertEvent();
                }

                // FAQ 리스트 이벤트 바인딩 처리
                if (page === "/faqList") {
                    bindFAQEvents();
                }

                // 쿠폰 삭제 이벤트 바인딩 처리
                if (page === "<%= request.getContextPath() %>/couponAllView") {
                    bindDeleteCouponEvent();
                }
            },
            error: function(xhr) {
                console.error("Error loading content:", xhr.statusText);
                contentArea.html("<p>콘텐츠를 불러오지 못했습니다.</p>");
            }
        });
    }
    
        


</script>
</body>
</html>
</head>
<body>
