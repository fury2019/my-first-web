<%@page import="com.Hotel.vo.Hotel_room_resVO"%>
<%@page import="com.Hotel.vo.Room_ServiceVO"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.Hotel.vo.HotelVO"%>
<%@page import="com.Hotel.vo.MemberVO"%>
<%@ page import="java.util.List"%>
<%@ page import="com.Hotel.vo.Room_ReservationVO"%>
<%@ page import="com.Hotel.service.reservation.IRoom_reserService"%>
<%@ page import="com.Hotel.service.reservation.Room_reserServiceImpl"%>
<%@ page session="true" %>

<%@include file="/jsp/include/top.jsp" %>

<%@include file="/jsp/include/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DDIT 호텔 - 예약페이지</title>
<style>
   @font-face {
    font-family: 'MinSans-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
  }

  body {
    font-family: 'MinSans-Regular', sans-serif;
  }

  .header1 { 
    text-align: center;
  }

  .header1 img {
    text-align: center; 
    margin-bottom: 20px;
  }

  button {
    background-color: #B09F7A;
    width: 100px;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 10px;
    transition: background-color 0.3s;
  }

  button:hover {
    background-color: #948668;
  }

  .container {
    display: flex;
    justify-content: space-between;
  }


  .section {
    width: 48%;
    background-color: #fff;
    border: 1px solid #ddd;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  }

  .info-box {
    display: flex;
    align-items: center;
    margin-bottom: 10px;
  }

  .info-box label {
    font-weight: bold;
    color: #666;
    width: 120px;
  }

  .info-value {
    background-color: #f9f9f9;
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ddd;
    flex-grow: 1;
  }
</style>
</head>
  <body>
  <br>
  	<form action="/payresult" method="post">
  	 <div class="header1">
		<img src="/image/예약3.png" alt="예약단계3">
    </div>
  

<%
	
    Room_ReservationVO reservation = (Room_ReservationVO) session.getAttribute("reservation");
    List<Hotel_room_resVO> services = (List<Hotel_room_resVO>) session.getAttribute("service");
    int totalServicePrice = 0;
	String type = reservation.getType_name();

%>

<div class="container">
	<div class="section">
	<h3 style="color: #B09F7A;">예약 정보</h3>
	<div class="info-box">
    <label>예약 번호: </label> 
    <div class="info-value"><%= reservation.getR_res_no() %></div>
    </div>
    <div class="info-box">
    <label>고객 아이디: </label>
    <div class="info-value"><%= reservation.getMem_id() %></div>
    </div>
    <div class="info-box">
    <label>객실 금액: </label> 
    <div class="info-value"><%= reservation.getR_res_price() %>원</div>
    </div>
    
   <% if (services != null && !services.isEmpty()) { %>
        <% for (Hotel_room_resVO service : services) { %>
            <div class="info-box">
            <label>서비스 ID: </label>
            <div class="info-value"> <%= service.getService_id() %></div>
            </div> 
            <div class="info-box">
            <label>추가 금액: </label>
            <div class="info-value"><%= service.getAddprice() %> 원</div>
            </div>
            <div class="info-box">
            <div class="info-value"><%
                totalServicePrice += service.getAddprice();
            %>
        <% } %>
    <% } else { %>
	<div class="info-box">
    <label>서비스 총 금액: </label> 
    <div class="info-value"><%= totalServicePrice %> 원</div>
    </div>
    <% } %> </div>
    </div>
    
    
</div>
    
    

</form>
<!-- 결제 모달 -->
	

		<div class="section">
        <h3 style="color: #B09F7A;">결제 정보</h3>
        <br>
        <form id="paymentForm" action="/jsp/Payment.jsp" method="post">
            <input type="hidden" name="r_res_no" value="<%= reservation.getR_res_no() %>">
           	<div class="info-box">
            <input type="hidden" name="type" value="<%= type %>">
            <label for="paymentMethod">결제 방법:</label>
                <div class="info-value">간편결제</div>
            </div>    
            <br><br>
            <div class="info-box">
            <label for="amount" >결제 금액:</label>
            <input type="text" name="amount" value="<%= reservation.getR_res_price() + totalServicePrice %>" readonly>
            </div>	
            <br><br>
            <div style="text-align: center;">
            <button type="submit" class="btnn">결제 진행</button>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script>
$(document).ready(function() {
    $("#openPaymentModal").click(function() {
        $("#paymentModal").css("display", "block");
    });

    $("#closeModal").click(function() {
        $("#paymentModal").css("display", "none");
    });

    $(window).click(function(event) {
        if ($(event.target).is($("#paymentModal"))) {
            $("#paymentModal").css("display", "none");
        }
    });
});
</script>

  
</body>
<%@include file="/jsp/include/footer.jsp"%>
</html>

