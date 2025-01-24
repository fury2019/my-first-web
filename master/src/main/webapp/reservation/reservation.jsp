<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
  
<title>Shinna Hotel - 예약</title>
<link rel="icon" href="../image/headicon.png">
<link rel="stylesheet" href="../style.css">
<link rel="stylesheet" href="../header.css">
</head>
<body>
	<%@ include file="/header_footer/header.jsp"%>
	<c:set var="RoomList" value="${requestScope.RoomList }" />
	<c:set var="param" value="${requestScope.param }" />
	<c:set var="diffday" value="${requestScope.diffday }"/>
	
	<c:set var="u_id" value="${sessionScope.u_id}"/>
	<%--Breadcrumb Area Start  --%>
	    <div class="breadcrumb-area bg-img bg-overlay jarallax" style="background-image: url(../image/조선객실.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcrumb-content text-center">
						<h2 class="page-title">예약</h2>
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb justify-content-center">
								<li class="breadcrumb-item"><a href="index.html">Home</a></li>
								<li class="breadcrumb-item active" aria-current="page">예약</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%--Hotel Search Form Area  --%>
	<div class="hotel-search-form-area">
		<div class="container-fluid">
			<div class="hotel-search-form">
				<form name="searchForm" action="${pageContext.request.contextPath }/reservation/RoomSearch.re" method="GET">
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
								<option value="00">00</option>
								<option value="01">01</option>
								<option value="02">02</option>
								<option value="03">03</option>
							</select>
						</div>
						<div class="col-12 col-md-3">
							<button type="submit" class="form-control btn roberto-btn w-100" style="background-color: #f1e3c4; color: #524b42;" onclick="return search()" >검색</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	
<%--게시물이 있는 경우  --%>
    <%--Rooms Area Start  --%>
		<div class="roberto-rooms-area section-padding-100-0">
			<div class="container">
				<div class="row">
					<div class="col-12 col-lg-12">
						<c:choose>
							<c:when test="${RoomList != null and fn:length(RoomList) > 0 }">
								<c:forEach var="room" items="${RoomList }">
						<%--Single Room Area  --%>
									<div class="single-room-area d-flex align-items-center mb-50 wow fadeInUp"	data-wow-delay="100ms">
										<%--Room Thumbnail  --%>
										<div class="room-thumbnail">
											<img src="/upload/${room.r_img }" alt="">
										</div>
										<%--Room Content  --%>
										<div class="room-content" style="width: 300px;">
											<h2>${room.r_type }</h2>
										
											<h4>
												${room.r_price * diffday }  <span>/ ${diffday}박</span>
											</h4>
											<div class="room-feature">
												<h6>
													Size: <span>21.7m</span>
												</h6>
												<h6>
													객실 수: <span>212객실</span>
												</h6>
												<h6>
													Bed: <span>더블, 트윈</span>
													일수: <span>${diffday }</span>
												</h6>
												<h6>
													전망: <span>시티 뷰</span>
													호수: <span>${room.r_id }</span>
												</h6>
												
											</div>
											<a href="#" class="btn view-detail-btn">View Details 
												<i class="fa fa-long-arrow-right" aria-hidden="true"></i>
											</a>
										</div>
			
										<div class="room-content">
												<div class="form-group" style="text-align: right;">
			 										<a class="resmain" onclick="return resclick();" href="reservationcheck.jsp?r_price=${room.r_price }&r_type=${room.r_type }&r_id=${room.r_id }&diffday=${diffday}" onclick="reservation()">예약</a> 
												<%-- <button type="submit" class="btn roberto-btn w-100">예약</button>  --%>
												</div>										
										</div>
									</div>
								</c:forEach>					
							</c:when>
							

						<%--게시물이 없는 경우 --%>
		                   <c:otherwise>
		                      <div style="margin-top: 50px;margin-bottom: 130px;">
		<!--                              <p style="text-align: center;font-size: 30px;color: #524b42;">예약 가능한 객실이 없습니다.</p> -->
		                           <input type="text" class="hi" value="예약을 원하시는  날짜, 인원을 선택하세요." readonly>
		                       </div>
		                   </c:otherwise>               
		                </c:choose>   
					</div>
					
					<div class="col-12 col-lg-4">
						<%--Hotel Reservation Area  --%>
						
					</div>
				</div>
			</div>
		</div>
	<%--Rooms Area End  --%>


	<%@ include file="/header_footer/footer.jsp"%>
	
	<script>
		function resclick(){
			//e.preventDefault();
			
			let u_id = '<%=u_id %>';
			
			if(u_id == "null"){
				alert("로그인이 필요합니다.");
				location.href="/login/login.jsp";
				return false;
			}
		}
	
	</script>
	
	<%--All JS Files  --%>
	<%--jQuery 2.2.4  --%>
	<script src="../js/jquery.min.js"></script>
	<%--Popper  --%>
	<script src="../js/popper.min.js"></script>
	<%--Bootstrap  --%>
	<script src="../js/bootstrap.min.js"></script>
	<%--All Plugins  --%>
	<script src="../js/roberto.bundle.js"></script>
	<%--Active  --%>
	<script src="../js/default-assets/active.js"></script>

	<script type="text/javascript" src="reservation.js"></script>
</body>

</html>

<style>
.resmain{
        background-color: #524b42;
        padding: 13px;
        padding-left : 60px;
        padding-right : 60px;
        color: white;
    }
 
</style>
