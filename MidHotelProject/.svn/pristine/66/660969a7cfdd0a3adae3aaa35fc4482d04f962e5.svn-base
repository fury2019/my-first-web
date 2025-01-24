<%@page import="com.Hotel.vo.CouponVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>내 쿠폰 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&display=swap" rel="stylesheet">
</head>
<style>
/* 동일한 스타일 */
body {
    margin: 0;
    font-family: 'Arial', sans-serif;
    background-color: #fff8dc;
    color: #333;
}

.coupon-container {
    max-width: 1000px;
    margin: 50px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.coupon-title {
    text-align: center;
    font-family: 'Playfair Display', serif;
    font-size: 32px;
    color: #8b4513;
    margin-bottom: 30px;
}

.coupon-list {
    display: flex;
    flex-direction: column;
    gap: 20px;
}

.coupon-card {
    background-color: #f5deb3;
    border: 1px solid #e3d5b8;
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.coupon-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}

.coupon-card h3 {
    margin: 0;
    font-size: 20px;
    color: #8b4513;
}

.coupon-card p {
    margin: 10px 0;
    font-size: 16px;
    color: #555;
}

.coupon-expiry {
    font-size: 14px;
    color: #a0522d;
    font-weight: bold;
    display: block;
    margin-top: 10px;
    text-align: right;
}

@media (max-width: 768px) {
    .coupon-card {
        padding: 15px;
    }
}
</style>
<body>
    <div class="coupon-container">
        <h1 class="coupon-title">내 쿠폰 목록</h1>
        <div class="coupon-list">
            <!-- 서버에서 전달된 쿠폰 리스트를 JSP로 출력 -->
            <%
                List<CouponVO> mycoupons = (List<CouponVO>) request.getAttribute("mycoupons");
                if (mycoupons != null && !mycoupons.isEmpty()) {
                    for (CouponVO coupon : mycoupons) {
            %>
                        <div class="coupon-card">
                            <h3><%= coupon.getCoupon_name() %></h3>
                            <p><%= coupon.getCoupon_comment() %></p>
                            <span class="coupon-expiry">할인율: <%= coupon.getCoupon_percent() %>%</span>
                        </div>
            <%
                    }
                } else {
            %>
                    <p style="text-align: center; font-size: 18px;">보유한 쿠폰이 없습니다.</p>
            <%
                }
            %>
        </div>
    </div>
    
    <%@include file="/jsp/include/footer.jsp" %>
</body>
</html>
