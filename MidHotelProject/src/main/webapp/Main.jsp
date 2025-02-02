<%@ page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/jsp/include/top.jsp" %>

<%@include file="/jsp/include/header.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>DDIT 호텔 - DDIT HOTEL</title>
<!--     <link rel="icon" href="/image/LOGOHOTEL.ico" type="image/x-icon"> -->
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&display=swap" rel="stylesheet"> <!-- 폰트 추가 -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body> 

<!-- 슬라이드 쇼 (Carousel) 추가 -->
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

  <div class="body">
    <h3>DDIT HOTEL</h3>
    <h5>DDIT HOTEL은 도심 속의 편안한 오아시스입니다.<br> 현대적인 디자인과 따뜻한 환대가 어우러진 이곳은 비즈니스 여행객과 관광객 모두에게 최적의 선택입니다.</h5>
  </div>

<%@include file="/jsp/include/footer.jsp" %>

</body>
</html>
