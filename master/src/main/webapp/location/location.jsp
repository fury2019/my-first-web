<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title -->
    <title>Shinna Hotel - 위치 찾기</title>

    <!-- Favicon -->
    <link rel="icon" href="./img/core-img/favicon.png">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="../header.css">	
    <link rel="stylesheet" href="../style.css">
    <link href="js/map/google-map.js">
</head>

<body>
   <%@ include file="/header_footer/header.jsp" %>

    <!-- Breadcrumb Area Start -->
    <div class="breadcrumb-area bg-img bg-overlay jarallax" style="background-image: url(../image/deluxe.jpg);">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="breadcrumb-content text-center mt-100">
                        <h2 class="page-title">오시는 길</h2>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb justify-content-center">
                                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">오시는 길</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Area End -->

    <!-- Google Maps & Contact Info Area Start -->
    <section class="google-maps-contact-info">
        <div class="container-fluid">
            <div class="google-maps-contact-content">
                <div class="row">
                    <!-- Single Contact Info -->
                    <div class="col-6 col-lg-4">
                        <div class="single-contact-info">
                            <i class="fa fa-phone" aria-hidden="true" style="color: #f1ebd6;"></i>
                            <h4>Phone</h4>
                            <p>02)123-4567</p>
                        </div>
                    </div>
                    <!-- Single Contact Info -->
                    <div class="col-6 col-lg-4">
                        <div class="single-contact-info">
                            <i class="fa fa-map-marker" aria-hidden="true" style="color: #f1ebd6;"></i>
                            <h4>주소</h4>
                            <p>서울특별시 강남구 역삼동 736-7</p>
                        </div>
                    </div>
                   
                  
                    <!-- Single Contact Info -->
                    <div class="col-6 col-lg-4">
                        <div class="single-contact-info">
                            <i class="fa fa-envelope-o" aria-hidden="true" style="color: #f1ebd6;"></i>
                            <h4>문의하기</h4>
                            <p><a href="${pageContext.request.contextPath}/inquiry/inquiry.jsp">1:1문의하기</a></p>
                        </div>
                    </div>
                </div>

                <!-- Google Maps -->
                <div class="google-maps">
                   
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d791.333854027282!2d127.03505418816657!3d37.50000649873195!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca3f16462aff1%3A0xc4c79f9b20cf2718!2z7L2U66as7JWESVTslYTsubTrjbDrr7gg6rCV64Ko7KCQ!5e0!3m2!1sko!2skr!4v1667354976684!5m2!1sko!2skr" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                   
        </div>
            </div>
        </div>
    </section>

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
</body>

</html>