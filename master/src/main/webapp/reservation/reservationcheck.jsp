<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
int r_price = Integer.parseInt(request.getParameter("r_price"));
String r_type = request.getParameter("r_type");
String r_id = request.getParameter("r_id");
int diffday = Integer.parseInt(request.getParameter("diffday"));
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title -->
<title>Shinna Hotel - 예약</title>
    <!-- Favicon -->
    <link rel="icon" href="../image/headicon.png">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../header.css">
    <link rel="stylesheet" href="../room/room.css">
</head>


<body>
     <%@ include file="/header_footer/header.jsp" %>
     <% session = request.getSession(); %>
     <c:set var="checkin_date" value="${sessionScope.checkin_date}"/>
     <c:set var="checkout_date" value="${sessionScope.checkout_date}"/>
     <c:set var="room" value="${sessionScope.room}"/>
     <c:set var="adults" value="${sessionScope.adults}"/>
     <c:set var="children" value="${sessionScope.children}"/>
     
      <!-- Breadcrumb Area Start -->
    <div class="breadcrumb-area bg-img bg-overlay jarallax" style="background-image: url(../image/조선객실.jpg);">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="breadcrumb-content text-center mt-100">
                        <h2 class="page-title">예약하기</h2>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb justify-content-center">
                                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">예약하기</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Area End -->
     
     
    <section class="roberto-about-area section-padding-100-0">
        <!-- Hotel Search Form Area -->
        <div class="hotel-search-form-area">
            <div class="container-fluid">
                <div class="hotel-search-form">
                    <form action="#" method="post">
                        
                        <div class="row">
                            <!-- Section Heading -->
                            <div class="col-12">
                                <div class="section-heading text-center wow fadeInUp" data-wow-delay="100ms">
                                    <h6 style="color: #524b42;">Shinna</h6>
                                    <h2 style="color: #524b42;"> 결제 확인</h2>
                                </div>
                            </div>
                        </div>
           
                    </form>
                </div>
            </div>
        </div>
        </section>
	
           <!-- Blog Area Start -->
<form name="paymentform" onsubmit="return doSubmit();"  action="${pageContext.request.contextPath}/reservation/DoReservation.re" method="GET">
        
    <section class="roberto-blog-area section-padding-100-0">
        <div class="container">
            <br><br>

        

          <div class="col2 colR" >
            <div class="cont" style="text-align:center">
                <div class="fmTitWrap mt0" style="text-align:center">
                    <strong class="fmTit">신용카드 정보</strong> <!-- 로그인 한 고객 노출 -->
                    </div><br>

                <table class="customerInfo" style="border-spacing: 30px;border: 1px;">
                    <colgroup>
                        <col style="width: 450px;">
                        <col style="width: auto;">
                    </colgroup>
                    <tbody>
                        <tr style="width: 100px;height: 50px; ">
                            <th scope="row">
                                카드종류<em class="necessary">
                                </em>
                            </th>
                            <td>
                                <div class="optionList" style="text-align:center">
                                    <div class="selectWrap4" style="text-align:center">
                                        <select title="카드종류 선택" id="guestCardTypCd" name="guestCardTypCd" >
                                            <option value="">선택</option>
                                                    <option value="AX" >AMEX CARD</option>
                                                    <option value="BC" >BC CARD</option>
                                                    <option value="CB" >CITIBANK CARD</option>
                                                    <option value="DI" >DINERS CARD</option>
                                                    <option value="HD" >HYUNDAI CARD</option>
                                                    <option value="JC" >JCB CARD</option>
                                                    <option value="KE" >KEB CARD</option>
                                                    <option value="KM" >KOOKMIN CARD</option>
                                                    <option value="LO" >LOTTE CARD</option>
                                                    <option value="MA" >MASTER OVERSEAS</option>
                                                    <option value="SH" >SHINHAN CARD</option>
                                                    <option value="SS" >SAMSUNG CARD</option>
                                                    <option value="VS" >VISA OVERSEAS</option>
                                                    <option value="UN" >UNION PAY</option>
                                                    </select>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr style="width: 100px;height: 50px; ">
                            <th scope="row">
                                카드번호<em class="necessary">
                                </em>
                            </th>
                            <td>
                                <div class="optionList">
                                     <input type="text" id="cardNo1" class="text textResv" title="카드번호 첫번째 네 자리 입력" style="width: 71px;" maxlength="4" onkeyup="this.value=this.value.replace(/[^\d\ ]/g, '');" name="cardnumber">
                                    	<span class="hyphen">-</span>
              						<input type="password" id="cardNo2" class="text textResv" title="카드번호 두번쨰 네 자리 입력" style="width: 71px" maxlength="4" onkeyup="this.value=this.value.replace(/[^\d\ ]/g, '');" name="cardnumber1">
                                    	<span class="hyphen">-</span>
                                    <input type="password" id="cardNo3" class="text textResv" title="카드번호 세번쨰 네 자리 입력" style="width: 71px" maxlength="4" onkeyup="this.value=this.value.replace(/[^\d\ ]/g, '');" name="cardnumber2">
                                    	<span class="hyphen">-</span>
                                    <input type="password" id="cardNo4" class="text textResv last" title="카드번호 마지막 네 자리 입력" style="width: 71px" maxlength="4" onkeyup="this.value=this.value.replace(/[^\d\ ]/g, '');" name="cardnumber3">
                                </div>
                            </td>
                        </tr>
                        <tr style="width: 100px;height: 50px; ">
                            <th scope="row">
                                유효기간<em class="necessary">
                                </em>
                            </th>
                            <td>
                                    <div class="optionList">
                                        <div style="float:left"><select id="cardExprMonth" name="cardExprMonth" class="endDayMonth uiform" title="월 선택">
                                            <option value="">월</option>
                                            <option value="01">01</option>
                                            <option value="02">02</option>
                                            <option value="03">03</option>
                                            <option value="04">04</option>
                                            <option value="05">05</option>
                                            <option value="06">06</option>
                                            <option value="07">07</option>
                                            <option value="08">08</option>
                                            <option value="09">09</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                            </select></div>
                                   
                                            <div style="float:left;margin-left: 10px;"><select id="cardExprYear" name="cardExprYear" class="endDayYear uiform" title="년 선택">
                                            <span style="width: 100px; user-select: none;"></span>
                                            <option value="">년</option>
                                            <option value="2032" >2032</option>
                                            <option value="2031" >2031</option>
                                            <option value="2030" >2030</option>
                                            <option value="2029" >2029</option>
                                            <option value="2028" >2028</option>
                                            <option value="2027" >2027</option>
                                            <option value="2026" >2026</option>
                                            <option value="2025" >2025</option>
                                            <option value="2024" >2024</option>
                                            <option value="2023" >2023</option>
                                            <option value="2022" >2022</option>
                                            </select></div>
                                    </div>
                            </td>
                        </tr>
                    </tbody>
                </table><br><br>
                <ul class="notiList1">
                    <li>신용카드 정보는 고객님의 투숙을 개런티하기 위한 용도 외에는 어떤 목적으로도</li> 
                    <li>사용되지 않으며, 체크카드 및 일부 신용 카드의 경우 사용이 제한 될 수 있습니다.</li>
                            <li><em class="pointColor1">온라인 예약 시 직접 결제가 이루어지지 않으며,</em> 최종 결제는 프론트 데스크에서 해주시기 바랍니다.</li>
                        </ul>
                        </div>
        <!-- //colR -->
    </div>
    <hr style="border: solid 1px black;">
            
                <div class="container" style="float:center;">
                               
                        <div class="select-wrap">
                            <div style="text-align: center;line-height: 50px;">
                                
                       
                                <div class="roombtn" style="display: inline-block;background-color: #524b42;width: auto; height: 50px;">
                                        <a href="" style=" color: white; margin-left: 10px;margin-right: 10px;">결제 금액 : </a><a href="" style=" color: white; margin-left: 10px;margin-right: 10px;"> <%=r_price * diffday %> 원</a>
                                </div>
                               
                                &nbsp;&nbsp;
                                <div style="display: inline-block;background-color: #524b42;width: 100px; height: 50px;">
                              <%--       <form action="${pageContext.request.contextPath}/reservation/DoReservation.re" method="GET">		--%>
                                              <input type="hidden" name="checkin_date"  value="${checkin_date }">
                                              <input type="hidden" name="checkout_date"  value="${checkout_date }">
                                              <input type="hidden" name="room"  value="${room }">
                                              <input type="hidden" name="adults"  value="${adults }">
                                              <input type="hidden" name="children"  value="${children }">
                                              <input type="hidden" name="r_price"  value="<%=r_price %>">
                                              <input type="hidden" name="r_type"  value="<%=r_type %>">
                                              <input type="hidden" name="r_id"  value="<%=r_id %>">
                                              <input type="hidden" name="diffday"  value="<%=diffday %>">
                                              <button type="submit" class="roombtn" style="display: inline;color: white;background-color: #524b42; border:0;">예약하기 ></button>

                               <%--       </form>		--%>
                                </div>
                            </div>
                       </div>
                   </div> <br><br><br>
          </div>
        </section>
        
 </form>        
<%--           <%=r_price %><%=r_type %><%=r_id%><%=checkin_date %><%=checkout_date %> --%>

     		
     <%@ include file="/header_footer/footer.jsp" %>
     
     
     
 <script>
	function doSubmit(){
		// 폼 객체
		let frm = document.paymentform;
		
		// 카드 종류 선택
		if(frm.guestCardTypCd.selectedIndex < 1){
			alert("카드 종류를 선택해 주세요");
			
			return false;
		}
		
		// 카드 번호 입력
		if(frm.cardnumber.value.length == 0 ||
			frm.cardnumber1.value.length == 0 ||
			frm.cardnumber2.value.length == 0 ||
			frm.cardnumber3.value.length == 0	){
			alert('카드 번호를 입력해 주세요.');

			return false;
		} 

		// 카드 유효기간		
		if(frm.cardExprMonth.selectedIndex < 1){
			alert("카드 유효기간을 선택해 주세요");
			
			return false;
		}
		
		if(frm.cardExprYear.selectedIndex < 1){
			alert("카드 유효기간을 선택해 주세요");
			
			return false;
		}
		
	}
		

</script>
 
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