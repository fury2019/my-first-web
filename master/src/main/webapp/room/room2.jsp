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
<title>Shinna Hotel - 객실정보</title>
    <!-- Favicon -->
    <link rel="icon" href="../image/headicon.png">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../header.css">
    <link rel="stylesheet" href="./room.css">
</head>
<body>

 <%@ include file="/header_footer/header.jsp" %>
 
  <!-- Breadcrumb Area Start -->
    <div class="breadcrumb-area bg-img bg-overlay jarallax" style="background-image: url(../image/R0000001PC6L_KR.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcrumb-content text-center">
                        <h2 class="page-title">객실 정보</h2>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb justify-content-center">
                                <li class="breadcrumb-item"><a href="../index.jsp">Home</a></li>
                                <li class="breadcrumb-item active" aria-current><a href="./room_all.jsp">객실정보</a></li>
                                <li class="breadcrumb-item active" aria-current="page"><a href="room2.jsp">디럭스<a></li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Area End -->
<!-- Blog Area Start -->
    <div class="roberto-news-area section-padding-100-0">
        <div class="container">
            <div class="row justify-content-center">
            	<div class="col-12 col-sm-8 col-md-6 col-lg-4">
                    <div class="roberto-sidebar-area pl-md-4">

                        <!-- Newsletter -->
                        <div class="single-widget-area mb-100">
                            <div class="newsletter-form">
                                <h5>객실</h5>
                                
                                <div>
                                    <a href="../room/room1.jsp">스탠다드</a>
                                </div><br>
                                <div class="menuinfo" >
                                	<a href="../room/room2.jsp">디럭스</span></a>                                                                        
                                </div><br>
                                <div>
                                    <a href="../room/room3.jsp">프리미어 디럭스</a>
                                </div><br>
                                <div>
                                    <a href="../room/room4.jsp">그랜드</a>
                                </div><br>
                                    <button type="submit" class="btn roberto-btn w-100"><a href="${pageContext.request.contextPath}/reservation/RoomUpdate.re" style="color:white;">전체 객실 보기</a></button>                                
                            </div>
                            <br>
                            <div class="rooment">
                                <div class="roombtn">
                                    <a href="${pageContext.request.contextPath}/board/BoardList.bo" style=" color: white;">문의하기</a>
                                </div>
                                &nbsp;&nbsp;
                                <div class="roombtn">
                                        <a href="../reservation/reservation.jsp" style=" color: white;">예약하기</a>
                                </div>
                            </div>
                        </div>
                       
                        <!-- Recent Post -->
                        <div class="single-widget-area mb-100">
                            <h4 class="widget-title mb-30">Hotel info.</h4>
                           
                            <ul> <h5>체크인/체크아웃시간</h5>
                                <li>- 체크인 : 오후 3시 이후</li>
                                <li>- 체크아웃: 정오</li>
                            </ul>
                            <br>
                            <ul> <h5>주차안내</h5>
                                <li>- 객실 이용 시 1박당 5,000원</li>
                                <li>· 객실당 1대</li>
                                <li>· 차량 추가 시 1박당 15,000원 추가 요금 발생</li>
                                <li>- 호텔 주차장 만차 시 인근 외부 주차장 이용 </li>
                            </ul>
                            <br>
                            <ul> <h5>Cafe 이용안내</h5>
                                <li>- [조식]</li>
                                <li class="Hotelinfo">(주중) 06:30~09:30</li>
                                <li class="Hotelinfo">(주말,공휴일) 07:00~10:00</li>
                                <li>- [중식]</li>
                                <li class="Hotelinfo">(주중) 11:30~14:00</li>
                                <li class="Hotelinfo">(주말,공휴일) 12:00~14:30</li>
                                <li>- [석식]</li>
                                <li class="Hotelinfo">(주중,주말,공휴일) 18:00~21:30</li>
                            </ul>
                            <br>
                            <ul><h5>피트니스 센터 이용안내</h5>
                                <li>- 06:00 ~ 23:00</li>
                            </ul>
                            <ul><h5>예약 변경 및 취소</h5>
                                <li>- 숙박예정일 1일전 18시까지는 위약금 없이 취소 가능</li>
                                <li>- 위 기간 이후 취소 또는 변경 시(No Show 포함)</li>
                                <li>· 성수기(4,5,6,10,11월, 12/24, 12/31) : 최초 1박 요금의 80% 부과</li>
                                <li>· 비수기(성수기 외 기간) : 최초 1박 요금의 10% 부과</li>
                            </ul>


                        <!-- Popular Tags -->
                        

                    </div>
                </div>
            </div>
                <div class="col-12 col-lg-8">
                    <!-- Post Thumbnail -->
                    <div class="post-thumbnail mb-50">
                        <img src="../image/deluxe.jpg" alt="">
                    </div>
                    <!-- Blog Details Text -->
                    <div class="blog-details-text">
                        <h3>17~26층에 위치한 디럭스룸은 도심에서의 여유로운 휴식을 누릴 수 있는 최상의 선택입니다.</h3>
                        <p>모던한 아름다움과 신나호텔의 고급 침구 및 침대 그리고 고급 어메니티로 <br> 한단계 업그레이드 된 휴식을 경험하십시오.  </p>
                        <br>
                        <p>문의 전화 : <h4>02 - 1234 - 5678</h4> </p>

                        <p>모든 객실과 레스토랑에서 유무선 인터넷 연결이 가능합니다.</p>

                        <p>위치 : 17 ~ 26층 | 전망 : 시티 뷰 | 침대 : 더블 | 크기 : 21.7m | 구성 : 침실 1, 욕실 1</p>
                    </div>
                   <!-- Post Author Area -->
                    <div class="post-author-area d-flex align-items-center justify-content-between mb-50">

                        <!-- Author Social Info -->
                        <div class="author-social-info d-flex align-items-center">
                        
                        </div>
                    </div>

                    <!-- Comments Area -->
                    <div class="comment_area mb-50 clearfix">                        
                        <ol>
                            <!-- Single Comment Area -->
                            <li class="single_comment_area">
                                <!-- Comment Content -->
                                <div class="comment-content d-flex">
                                    <!-- Comment Author -->
                                    <div class="comment-author">
                                     
                                    </div>
                                    <!-- Comment Meta -->
                                    <div class="comment-meta">
                                       <table width="400">
                                            <tr>
                                                <td colspan="2"></td>
                                            </tr>
                                            <tr>
                                                <td rowspan="11" style="text-align:left;">객실이용</td>                                                
                                                <td></td>
                                            </tr>
                                            <tr><td></td><td>- LED TV</td></tr>
                                            <tr><td></td><td>- 책상</td></tr>
                                            <tr><td></td><td>- 냉장고</td></tr>
                                            <tr><td></td><td>- 무료커피, 티백</td></tr>
                                            <tr><td></td><td>- 무료 생수 2병 (1박 기준)</td></tr>
                                            <tr><td></td><td>- 무료 유무선 인터넷</td></tr>
                                            <tr><td></td><td>- 개인 금고</td></tr>
                                            <tr><td></td><td>- 유니버셜 어댑터(220V 전용)</td></tr>
                                            <tr><td></td><td>- 다회용 어메니티</td></tr>
                                            <tr><td></td><td>- 2개의 목욕가운</td></tr>

                                       </table>
                                    </div>
                                </div>
                                <hr>
                                <div class="comment-content d-flex">
                                    <!-- Comment Author -->
                                    <div class="comment-author">
                                     
                                    </div>
                                    <!-- Comment Meta -->
                                    <div class="comment-meta">
                                       <table width="400">
                                            <tr>
                                                <td colspan="2"></td>
                                            </tr>
                                            <tr>
                                                <td rowspan="3" style="text-align:left;">부대시설</td>                                                
                                                <td></td>
                                            </tr>
                                            <tr><td></td><td>- 피트니스 센터 무료 이용</td></tr>
                                            <tr><td></td><td>- 비즈니스 코너 인터넷 무료 이용</td></tr>
                                       </table>
                                    </div>
                                </div>                               
                            </li>

                          
                        </ol>
                    </div>

                    <!-- Leave A Reply -->
                    <div class="roberto-contact-form mt-80 mb-100">
                        
                        
                    </div>
                </div>

                
        </div>
    </div>
    <!-- Blog Area End -->
    
    
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