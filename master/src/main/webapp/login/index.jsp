<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date today = new Date();
SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
String now = simpledateformat.format(today);

Calendar cal = Calendar.getInstance();
String format = "yyyy-mm-dd";
cal.add(cal.DATE, +1);
String tomorrow = simpledateformat.format(cal.getTime());

%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title -->
    <title>Shinna Hotel</title>

    <!-- Favicon -->
    <link rel="icon" href="../image/headicon.png">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../header.css">
</head>

<body>
    <%@ include file="/header_footer/header.jsp" %>

    <!-- Welcome Area Start -->
    <section class="welcome-area">
        <div class="welcome-slides owl-carousel">
            <!-- Single Welcome Slide -->
            <div class="single-welcome-slide bg-img bg-overlay" style="background-image: url(../image/grand.jpg);" src="../image/grand.jpg">
                <!-- Welcome Content -->
                <div class="welcome-content h-100">
                    <div class="container h-100">
                        <div class="row h-100 align-items-center">
                            <!-- Welcome Text -->
                            <div class="col-12">
                                <div class="welcome-text text-center">
                                    <h6 data-animation="fadeInLeft" data-delay="200ms">SHINNA HOTEL</h6>
                                    <h2 data-animation="fadeInLeft" data-delay="500ms">신나호텔에 오신 것을 환영합니다.</h2>
                                    <a href="${pageContext.request.contextPath}/reservation/reservation.jsp" class="btn roberto-btn btn-2" style="border: 2px solid #f1e3c4;" data-animation="fadeInLeft" data-delay="800ms">예약하기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Single Welcome Slide -->
            <div class="single-welcome-slide bg-img bg-overlay" style="background-image: url(../image/deluxe.jpg);" src="../image/deluxe.jpg">
                <!-- Welcome Content -->
                <div class="welcome-content h-100">
                    <div class="container h-100">
                        <div class="row h-100 align-items-center">
                            <!-- Welcome Text -->
                            <div class="col-12">
                                <div class="welcome-text text-center">
                                    <h6 data-animation="fadeInUp" data-delay="200ms">SHINNA HOTEL</h6>
                                    <h2 data-animation="fadeInUp" data-delay="500ms">신나호텔에 오신 것을 환영합니다.</h2>
                                    <a href="${pageContext.request.contextPath}/reservation/reservation.jsp" class="btn roberto-btn btn-2" style="border: 2px solid #f1e3c4;" data-animation="fadeInUp" data-delay="800ms">예약하기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Single Welcome Slide -->
            <div class="single-welcome-slide bg-img bg-overlay" style="background-image: url(../image/standard.jpg);" data-img-url="../image/standard.jpg">
                <!-- Welcome Content -->
                <div class="welcome-content h-100">
                    <div class="container h-100">
                        <div class="row h-100 align-items-center">
                            <!-- Welcome Text -->
                            <div class="col-12">
                                <div class="welcome-text text-center">
                                    <h6 data-animation="fadeInUp" data-delay="200ms">SHINNA HOTEL</h6>
                                    <h2 data-animation="fadeInUp" data-delay="500ms">신나호텔에 오신 것을 환영합니다.</h2>
                                    <a href="${pageContext.request.contextPath}/reservation/reservation.jsp" class="btn roberto-btn btn-2" style="border: 2px solid #f1e3c4;" data-animation="fadeInUp" data-delay="800ms">예약하기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Welcome Area End -->

    <!-- About Us Area Start -->
    <section class="roberto-about-area section-padding-100-0">
        <!-- Hotel Search Form Area -->
        <div class="hotel-search-form-area">
            <div class="container-fluid">
                <div class="hotel-search-form">
                    <form name="searchForm" action="${pageContext.request.contextPath }/reservation/RoomSearch.re" method="post">
                        <p>날짜, 인원 선택</p>
                        <div class="row justify-content-between align-items-end">
                            <div class="col-6 col-md-2 col-lg-3">
                                <label for="checkIn">체크인</label>
                                <input type="date" class="form-control" id="checkIn" name="checkin_date" min='<%=now%>'>
                            </div>
                            <div class="col-6 col-md-2 col-lg-3">
                                <label for="checkOut">체크아웃</label>
                                <input type="date" class="form-control" id="checkOut" name="checkout_date" min='<%=tomorrow%>'>
                            </div>
                            <div class="col-4 col-md-1">
                                <label for="room">객실</label>
                                <select name="room" id="room" class="form-control">
                                    <option value="01">01</option>
                                    <option value="02">02</option>
                                    <option value="03">03</option>
                                </select>
                            </div>
                            <div class="col-4 col-md-1">
                                <label for="adults">성인</label>
                                <select name="adults" id="adults" class="form-control">
                                    <option value="01">01</option>
                                    <option value="02">02</option>
                                    <option value="03">03</option>
                                </select>
                            </div>
                            <div class="col-4 col-md-2 col-lg-1">
                                <label for="children">어린이</label>
                                <select name="children" id="children" class="form-control">
                                    <option value="01">01</option>
                                    <option value="02">02</option>
                                    <option value="03">03</option>
                                </select>
                            </div>
                            <div class="col-12 col-md-3">
                                <button type="submit" class="form-control btn roberto-btn w-100" style="background-color: #f1e3c4;color: #524b42;" onclick="return search()">검색</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

           <!-- Blog Area Start -->
    <section class="roberto-blog-area section-padding-100-0">
        <div class="container">
            <div class="row">
                <!-- Section Heading -->
                <div class="col-12">
                    <div class="section-heading text-center wow fadeInUp" data-wow-delay="100ms">
                        <h6 style="color: #524b42;">Shinna</h6>
                        <h2 style="color: #524b42;">Production &amp; package</h2>
                    </div>
                </div>
            </div>

            <div class="row">
                <!-- Single Post Area -->
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single-post-area mb-100 wow fadeInUp" data-wow-delay="300ms">
                        <a href="#" class="post-thumbnail"><img src="../image/R0000001ONZJ_KR.jpg" alt=""></a>
                        <!-- Post Meta -->
                        <div class="post-meta">                            
                            <a href="#" class="post-catagory">Event</a>
                        </div>
                        <!-- Post Title -->
                        <a href="#" class="post-title">Artist of the Day</a>
                        <p>객실 1실 1박, 소마 드로잉카페 2인 이용권 1매</p>                        
                        <p>2022.09.28 ~ 2022.12.31</p>
                    </div>
                </div>

                <!-- Single Post Area -->
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single-post-area mb-100 wow fadeInUp" data-wow-delay="500ms">
                        <a href="#" class="post-thumbnail"><img src="../image/R0000001PC6L_KR.jpg" alt=""></a>
                        <!-- Post Meta -->
                        <div class="post-meta">                       
                            <a href="#" class="post-catagory">Event</a>
                        </div>
                        <!-- Post Title -->
                        <a href="#" class="post-title">신나스테이에서 한 달 살기</a>
                        <p>객실 14박~30박, 쿠폰북 1권, HDMI 케이블 대여</p>
                        <p>2022.07/01 ~ 2022.12.31</p>                        
                    </div>
                </div>

                <!-- Single Post Area -->
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single-post-area mb-100 wow fadeInUp" data-wow-delay="700ms">
                        <a href="#" class="post-thumbnail"><img src="../image/R0000001OYLY_KR.jpg" alt=""></a>
                        <!-- Post Meta -->
                        <div class="post-meta">                            
                            <a href="#" class="post-catagory">Event</a>
                        </div>
                        <!-- Post Title -->
                        <a href="#" class="post-title">Shinna Culture Stay(뚝섬미술관)</a>
                        <p>객실 1박, 조식 2인 뚝섬미술관 '로그아웃' 전시 초대권 1매</p>
                        <p>2022.05.23 ~ 2022.12.31</p>
                   
                    </div>
                </div>

            </div>
        </div>
    </section>
    <!-- Blog Area End -->

        <div class="container mt-100">
            <div class="row align-items-center">
                <div class="col-12 col-lg-6">
                    <!-- Section Heading -->
                    <div class="section-heading wow fadeInUp" data-wow-delay="100ms">
                        <h6 style="color: #524b42;">신나리워즈</h6>
                        <hr>
                        <h2>Welcome to <br>Shinna Hotel</h2>
                    </div>
                    <div class="about-us-content mb-100">
                        <h5 class="wow fadeInUp" data-wow-delay="300ms" style="color: #524b42;">호텔설명</h5>
                        <p class="wow fadeInUp" data-wow-delay="400ms">Manager: <span style="color: #524b42;">Shinna manager</span></p>
                        
                    </div>
                </div>

                <div class="col-12 col-lg-6">
                    <div class="about-us-thumbnail mb-100 wow fadeInUp" data-wow-delay="700ms">
                        <div class="row no-gutters">
                            <div class="col-6">
                                <div class="single-thumb">
                                    <img src="/image/그랜드1.jpg" alt="">
                                </div>
                                <div class="single-thumb">
                                    <img src="/image/디럭스1.jpg" alt="">
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="single-thumb">
                                    <img src="/image/스탠다드1.jpg" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- About Us Area End -->

  



    

  
 

    <!-- Call To Action Area Start -->
<!--     <section class="roberto-cta-area"> -->
<!--         <div class="container"> -->
<!--             <div class="cta-content bg-img bg-overlay jarallax" style="background-image: url(img/bg-img/1.jpg);"> -->
<!--                 <div class="row align-items-center"> -->
<!--                     <div class="col-12 col-md-7"> -->
<!--                         <div class="cta-text mb-50"> -->
<!--                             <h2>Contact us now!</h2> -->
<!--                             <h6>Contact (+12) 345-678-9999 to book directly or for advice</h6> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     <div class="col-12 col-md-5 text-right"> -->
<!--                         <a href="#" class="btn roberto-btn mb-50">Contact Now</a> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
<!--     </section> -->
    <!-- Call To Action Area End -->

    <!-- Partner Area Start -->
<!--     <div class="partner-area"> -->
<!--         <div class="container"> -->
<!--             <div class="row"> -->
<!--                 <div class="col-12"> -->
<!--                     <div class="partner-logo-content d-flex align-items-center justify-content-between wow fadeInUp" data-wow-delay="300ms"> -->
<!--                         <a href="#" class="partner-logo"><img src="img/core-img/p1.png" alt=""></a> -->
<!--                         <a href="#" class="partner-logo"><img src="img/core-img/p2.png" alt=""></a> -->
<!--                         <a href="#" class="partner-logo"><img src="img/core-img/p3.png" alt=""></a> -->
<!--                         <a href="#" class="partner-logo"><img src="img/core-img/p4.png" alt=""></a> -->
<!--                         <a href="#" class="partner-logo"><img src="img/core-img/p5.png" alt=""></a> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
<!--     </div> -->
    <!-- Partner Area End -->

    <%@ include file="/header_footer/footer.jsp" %>

    <!-- **** All JS Files ***** -->
    <!-- jQuery 2.2.4 -->
    <script src="../js/jquery.min.js"></script>
    <!-- Popper -->
    <script src="../js/popper.min.js"></script>
    <!-- Bootstrap -->
    <script src="../js/bootstrap.min.js"></script>
    <!-- All Plugins -->
    <script src="../js/roberto.bundle.js"></script>
    <!-- Active -->
    <script src="../js/default-assets/active.js"></script>

	<script type="text/javascript" src="../reservation/reservation.js"></script>
</body>

</html>