<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Shinna Hotel - 예약 내역</title>
    <link rel="icon" href="../image/headicon.png">
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../header.css">
    <link rel="stylesheet" href="../room/room.css">
</head>
<body>

    <%@ include file="/header_footer/header.jsp" %>
 	<c:set var="reservationlist" value="${requestScope.reservationlist }"/>
  
    <div class="breadcrumb-area bg-img bg-overlay jarallax" style="background-image: url(../image/조선객실.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcrumb-content text-center">
                        <h2 class="page-title">예약 내역</h2>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb justify-content-center">
                                <li class="breadcrumb-item"><a href="../index.jsp">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath }/user/userInfo.us">내 정보</a></li>
                                <li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath }/reservation/ReservationSelect.re">예약내역</a></li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
 

    <div class="roberto-news-area section-padding-100-0">
        <div class="container">
            <div class="row justify-content-center">
            	
                <%-- 사이드 바 --%>
                <div class="col-12 col-sm-8 col-md-6 col-lg-3">
                    <div class="roberto-sidebar-area pl-md-4">
                        <div class="single-widget-area mb-100">
                            <div class="newsletter-form">
                                <h5>내 정보</h5>
                                <div>
                                    <a href="${pageContext.request.contextPath }/user/userInfo.us" >내 정보 관리</a>                                    
                                </div><br>
                                <div class="menuinfo" >
                                    <a href="${pageContext.request.contextPath }/reservation/ReservationSelect.re">예약 내역</a>
                                </div>                               
                            </div>                            
                        </div>                        
                    </div>
                    <%-- 사이드 바 --%>
		        </div>

                    <%-- 본문--%>
                <div class="col-12 col-lg-8">
                    
                    <h2 style="text-align: center;height: 50px;"><span style="color: black;padding: 10px;font-weight: 800;">예약 내역</span></h2>
                    <div class="post-thumbnail mb-50">
                        <div>
                            <table class="col-12 table-b">
                            	<colgroup>
                            		<col width= "120px">                            		
                            		<col width= "50px">                            		
                            		<col width= "75px">                            		
                            		<col width= "145px">                            		
                            		<col width= "145px">                            		
                            		<col width= "100px">                            		
                            		<col width= "100px">                            		
                            		<col width= "150px">                            		
                            		<col width= "140px">                            		
                            	</colgroup>
                                <thead style="border-radius:3px;">                            
                                    <th style="font-size: 16px;line-height: inherit;">예약번호</th>
                                    <th>성인</th>
                                    <th style="font-size: 15px;line-height: inherit;">어린이</th>
                                    <th>체크인</th>
                                    <th>체크아웃</th>
                                    <th>객실</th>
                                    <th>금액</th>                                    
                                    <th>예약일</th>
                                    <th>취소</th>                                
                                </thead>                                
                                <tbody>

                                    <%-- 반복분 돌릴 구간--%>
                                    <c:choose>
                                    	<c:when test="${reservationlist != null and fn:length(reservationlist) > 0 }">
			                                 <c:forEach var="reservation" items="${reservationlist }">
				                                    <tr style="height: 40px;">
					                                    <form action="${pageContext.request.contextPath }/reservation/ReservationCancel.re?res_number=${reservation.res_number }&res_price=${reservation.res_price }&res_checkin=${reservation.res_checkin }&res_checkout=${reservation.res_checkout }&res_rtype=${reservation.res_rtype }" method="POST">
					                                        <td name="res_number">${reservation.res_number }</td>
					                                        <td>${reservation.res_adults }</td>
					                                        <td>${reservation.res_kids }</td>
					                                        <td name="res_checkin">${reservation.res_checkin }</td>
					                                        <td name="res_checkout">${reservation.res_checkout }</td>
					                                        <td name="res_rtype">${reservation.res_rtype }</td>
					                                        <td name="res_price">${reservation.res_price }</td>
					                                        <td>${reservation.res_time}</td>
					                                        <td><button type='submit' id="cancel" onclick="cancelCheck()">예약 취소</button></td>
					                                   </form>
				                                    </tr>
			                                  </c:forEach>
	                                    </c:when>
	                                    <c:otherwise>
                                          <tr style="height: 40px;">
                                             <td colspan="9" style="text-align: center; font-size:20px; color: #524b42;">예약 내역이 없습니다.</td>
                                          </tr>
                                       </c:otherwise>
                                    </c:choose>
                                    <%-- 반복분 돌릴 구간--%>
                                    
                                </tbody>
                    
                                                               
                            </table>
                            <hr>
                       </div>
                    </div>                    
                </div>
            </div>
        </div>
    </div>
    
    
    <%@ include file="/header_footer/footer.jsp" %>

    
    
    <script src="../js/jquery.min.js"></script>
    
    <script src="../js/popper.min.js"></script>
    
    <script src="../js/bootstrap.min.js"></script>
    
    <script src="../js/roberto.bundle.js"></script>
    
    <script src="../js/default-assets/active.js"></script>
    
    <script type="text/javascript">
    
    	function cancelCheck() {
			alert("취소하시겠습니까??");
		}
    </script>
    
</body>
</html>

<style>
table{
border-radius : 3px;
}
thead{
background-color: #f1e3c4;
height: 70px;
border-top: #524b42;
border-radius: 6px;
}
tbody{
line-height : 50px;
margin-bottom: 2px;
}
#cancel{
	margin: 3px 5px;
	width:auto;
	background-color: #524b42;
	color: white;
	border:0px;
	padding:5px;
	border-radius: 6px;
	}
</style>