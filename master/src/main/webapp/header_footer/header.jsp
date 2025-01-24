<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%String u_id = (String)session.getAttribute("u_id");
    String login = "none";
    String info = "none";
    String admin = "none";
    if (u_id != null ){
    	if(u_id.equals("admin")){
    		admin = "";
    	} else{    		
    		info = "";	
    	}
    } else{
    	login = "";    
    }
    
    String join = "";
    if (u_id != null ){
    	join = "<a href=../login/logout.jsp style=background-color:#f1e3c4;color:#524b42;>로그아웃</a>";	
    } else{
    	join = "<a href=../join/join.jsp>회원가입 </a>";
    }
    %>
    
    <!-- Preloader -->
    <div id="preloader" style="background-color: #f1ebd6;">
        <div class="loader"></div>
    </div>
    <!-- /Preloader -->

    <!-- Header Area Start -->
    <header class="header-area">        
        <!-- Top Header Area Start -->
        <div class="top-header-area" style="background-color: white;">
            <div class="container">
                <div class="row">
                    <div class="col-6">
                        <div class="top-header-content">
                            <a href="#" style="color: #524b42;"><i class="icon_phone" style="color: #f1e3c4;"></i> <span>(02) 1234-5678</span></a>
                            <a href="#" style="color: #524b42;"><i class="icon_mail" style="color: #f1e3c4;"></i> <span>shinna@hotel.com</span></a>
                        </div>
                    </div>

                    <div class="col-6" >
                        <div class="top-header-content" >
                            <!-- Top Social Area -->
                            <div class="top-social-area ml-auto">
                                <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-tripadvisor" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- Top Header Area End -->

        <!-- Main Header Start -->
        <div class="main-header-area">
            <div class="classy-nav-container breakpoint-off" style="background-color: #f1e3c4;">
                <div class="container">
                    <!-- Classy Menu -->
                    <nav class="classy-navbar justify-content-between" id="robertoNav">

                        <!-- Logo -->
                        <a class="nav-brand" href="../login/index.jsp"><img src="../image/headerlogo.png" style="border-radius: 1px;" alt=""></a>

                        <!-- Navbar Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <!-- Menu -->
                        <div class="classy-menu" >
                            <!-- Menu Close Button -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>
                            <!-- Nav Start -->
                            <div class="classynav">
                                
<!--                                 <div class="book-now-btn"> -->
                                	<ul id="nav">                                	
	                                   <li><a href="${pageContext.request.contextPath}/reservation/RoomUpdate.re" >객실정보</a>
	                                   		<ul class="dropdown" style="backgroundcolor: #f1e3c4;">
	                                   		<li ><a href="${pageContext.request.contextPath}/reservation/RoomUpdate.re">전체 객실 보기</a></li>
	                                   		<p style="text-align:center;border-top: 1px solid black;border-bottom: 1px solid black;">- 인기 객실 -</p>
	                                   		<li class="headdrop"><a href="../room/room1.jsp"> - 스탠다드</a></li>
	                                   		<li class="headdrop"><a href="../room/room2.jsp"> - 디럭스</a></li>
	                                   		<li class="headdrop"><a href="../room/room3.jsp"> - 프리미어 디럭스</a></li>	                                   		
	                                   		<li ><a href="../room/room4.jsp"> - 그랜드</a></li>	                                   		
	                                   		</ul>
	                                   </li>
	                                   <li><a href="../inquiry/inquiry.jsp" >문의하기</a>
	                                   		<ul class="dropdown">
	                                   			<li><a href="../inquiry/inquiry.jsp">문의 하기</a></li>
	                                   			<li><a href="${pageContext.request.contextPath}/board/BoardList.bo">문의 게시판</a></li>
	                                   		</ul>
	                                   </li>
	                                   <li><a href="../location/location.jsp" >위치찾기</a></li>
	                                   <li><a href="../reservation/reservation.jsp" >예약 </a></li>
	                                   <li style="display:<%=info %>"><a href="${pageContext.request.contextPath}/user/userInfo.us">내 정보 </a>
	                                   		<ul class="dropdown">
	                                   			<li><a href="${pageContext.request.contextPath}/user/userInfo.us">내 정보 관리</a></li>
	                                   			<li><a href="${pageContext.request.contextPath}/reservation/ReservationSelect.re">예약 내역</a></li>
	                                   		</ul>
	                                   </li>
	                                   <li><a href="../login/login.jsp" style="display:<%=login %>">로그인 </a></li>
	                                   <li><a href="../admin/AdminMain.ad" style="display:<%=admin %>">관리자페이지 </a></li>                                 
	                                   <li><%=join %></li>
                                   </ul>
<!--                                 </div> -->
                               
                            </div>
                            <!-- Nav End -->
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- Header Area End -->
 