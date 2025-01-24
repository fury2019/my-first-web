<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.Hotel.vo.CouponVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>쿠폰 회수</title>
    <style>
        /* 기존 스타일 유지 */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #fdf5e6;
            color: #333;
        }
        
        h2 {
            color: #8b4513; /* 고급 브라운 컬러 */
            font-family: 'Playfair Display', serif;
            font-weight: bold;
            text-align: center;
            margin-bottom: 50px;
            margin-top: 20px;
        }
        
        .container {
        	width: 100%;
		    display: flex;
		    flex-direction: column;
		    justify-content: space-between; /* 위-아래 요소를 공간에 맞게 배치 */
		    height: 750px; /* 컨텐츠 박스의 고정 높이 */
		    padding: 20px;
		    box-sizing: border-box; 
        }

        table {
            width: 100%;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            table-layout: fixed;
            flex: 1;
    		overflow-y: auto; /* 스크롤 가능 */
        }

        th, td {
            padding: 12px;
            border: 1px solid #e3d5b8;
            text-align: left;
            vertical-align: top;
            color: #8b4513;
            word-wrap: break-word;
        }

        th {
            background-color: #f5deb3;
            font-size: 16px;
            text-transform: uppercase;
            font-weight: bold;
        }

        td {
            font-size: 14px;
        }

        button {
            background-color: #cd5c5c;
            color: #fff;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #b22222;
        }

        .pagination {
            display: flex;
		    justify-content: center;
		    margin-top: 20px;
		    position: relative; /* 부모 요소에 맞게 위치 */
		    bottom: 0; /* 컨텐츠 박스의 하단에 위치 */
        }

        .pagination button {
            margin: 0 5px;
            padding: 10px 15px;
            background-color: #8b4513;
            color: #fff;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .pagination button:hover {
            background-color: #5a2d0c;
        }

        .pagination button.active {
            background-color: #5a2d0c;
            font-weight: bold;
        }
    </style>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function() {
    initializeCouponEvents(); // 쿠폰 페이징 이벤트 초기화

    // 쿠폰 삭제 이벤트
    $(document).on("click", ".delete-coupon", function(event) {
        event.preventDefault();

        let couponId = $(this).data("id");
        if (confirm("정말 회수하시겠습니까?")) {
            $.ajax({
                url: "<%=request.getContextPath()%>/deleteCoupon",
                method: 'post',
                data: { couponId: couponId },
                success: function(response) {
                    alert("쿠폰이 성공적으로 회수되었습니다.");
                    location.reload(); // 페이지 새로고침
                },
                error: function(xhr, status, error) {
                    alert("쿠폰 회수 중 오류가 발생했습니다.");
                }
            });
        }
    });
});

function initializeCouponEvents() {
    const itemsPerPage = 10; // 한 페이지당 표시할 쿠폰 수
    const couponItems = $("tbody tr"); // 쿠폰 리스트의 각 행
    const totalItems = couponItems.length;
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
        couponItems.hide(); // 모든 쿠폰 숨기기
        const start = (pageNumber - 1) * itemsPerPage;
        const end = start + itemsPerPage;
        couponItems.slice(start, end).show(); // 선택된 페이지의 쿠폰 항목만 표시

        // 활성화된 버튼 표시
        $(".page-btn").removeClass("active");
        $('.page-btn[data-page="' + pageNumber + '"]').addClass("active");
    }

    // 버튼 클릭 이벤트 바인딩
    $(".page-btn").off("click").on("click", function () {
        const pageNumber = $(this).data("page");
        showPage(pageNumber);
    });

    // 첫 번째 페이지 표시
    showPage(1);
}
</script>

<div class="container">
    <h2>쿠폰 리스트</h2>
    <table>
        <thead>
            <tr>
                <th>쿠폰 번호</th>
                <th>쿠폰 이름</th>
                <th>쿠폰 설명</th>
                <th>쿠폰 상태</th>
                <th>할인율</th>
                <th>회원 ID</th>
                <th>회수</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<CouponVO> couponList = (List<CouponVO>) request.getAttribute("couponList");
                if (couponList != null && !couponList.isEmpty()) {
                    for (CouponVO coupon : couponList) {
            %>
            <tr>
                <td><%= coupon.getCoupon_no() %></td>
                <td><%= coupon.getCoupon_name() %></td>
                <td><%= coupon.getCoupon_comment() %></td>
                <td><%= coupon.getCoupon_condition() %></td>
                <td><%= coupon.getCoupon_percent() %>%</td>
                <td><%= coupon.getMem_id() %></td>
                <td>
                    <button type="button" class="delete-coupon" data-id="<%= coupon.getCoupon_no() %>">회수</button>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="7" class="no-data">쿠폰 데이터가 없습니다.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <div id="pagination" class="pagination"></div>
</div>
</body>
</html>
