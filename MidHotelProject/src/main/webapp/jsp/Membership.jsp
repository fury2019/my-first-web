<%@page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DDIT 호텔 맴버십 - DDIT HOTEL MEMBERSHIP</title>
<!-- <link rel="icon" href="image/호텔이미지new.png" type="image/x-icon"> -->
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

nav {
	background-color: #002050;
	color: white;
	padding: 10px;
	display: flex;
	justify-content: space-between;
}

nav a {
	color: white;
	margin: 0 10px;
	text-decoration: none;
}

.container {
	width: 80%;
	margin: 0 auto;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 20px 0;
	font-size: 18px;
	text-align: center;
	font-family: 'MinSans-Regular', sans-serif;
	border: 1px solid lightgray;
}

th, td {
	padding: 12px 15px;
	border: 1px solid lightgray;
}

th {
	background-color: #f2f2f2;
	color: #333;
	border: 1px solid lightgray;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
	border: 1px solid lightgray;
}

tr:hover {
	background-color: #f1f1f1;
	border: 1px solid lightgray;
}

.diamond {
	color: #3c4767;
}

.platinum {
	color: #21826e;
}

.gold {
	color: #c59b5e;
}

.silver {
	color: #a7a7a7;
}

.bronze {
	color: #594044;
}

span {
	text-align: left;
	display: block;
}

h2 {
	text-align: left;
}
.tooltip-area { 
	position: relative; 
	display: flex;
}

.tooltip-area h1 { 
	margin: 0;
	font-size: 24px; 
	text-align:center;
}

.join_tooltip {
	margin-left: 10px;
}

.join_tooltip span {
	cursor: pointer;
	background-color: #666;
	border: none;
	padding: 5px 10px;
	border-radius: 50%;
	font-weight: bold;
	display: flex;
	color: white;
}

.tooltip_info {
	display: none;
	position: absolute;
	top:100%;
	left: 50%;
	transform: translateX(-50%);
	width: 250px;
	background-color: #666;
	color: #fff;
	text-align: center;
	border-radius: 5px;
	padding: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	z-index: 1;
	font-size: 14px;
	font-family: 'MinSans-Regular', sans-serif;
}

.tooltip-area:hover .tooltip_info {
	display: block;
}

.tooltip-area h1 {
	text-align: center;
}

.jo {
	text-align: center;
}

</style>
</head>
<body>
	<div class="container">
		<br> <br>
		<div class="tooltip-area">
		<h1>등급별 혜택 한눈에 보기</h1>
			<a href="javascript:void(0);" class="join_tooltip"
				aria-controls="uiToggle-14">
				<span>?</span>
			</a>
			<p class="tooltip_info" tabindex="-1"
				id="uiToggle-14" aria-hidden="true" style="display: none;">등급평가
				및 조정은 전 년도 1월 1일부터 12월 31일까지(체크아웃 기준) 1년 동안의 이용실적을 기반으로 하며, 승급은 매월
				10일(월 1회), 유지 및 강등은 매년 1월 첫째 주에 반영됩니다(연 1회)</p>
		</div>
		<hr>
	<table>
		<tr>
			<th></th>
			<th class="diamond">
			<img src="/image/Diamond.png" alt="다이아"> Diamond</th>
			<th class="platinum">
			<img src="/image/Platinum.png" alt="플래"> Platinum</th>
			<th class="gold">
			<img src="/image/Gold.png" alt="골드"> Gold</th>
			<th class="silver">
			<img src="/image/Silver.png" alt="실버"> Silver</th>
			<th class="bronze" colspan="2">
			<img src="/image/Bronze.png" alt="브론즈">Bronze</th>
			<th></th>
		</tr>
		<tr class="jo">
			<td>등급 조건</td>
			<td>투숙 박수 50박 이상 또는 유효적립포인트 70,000P 이상</td>
			<td>투숙 박수 25박 이상 또는 유효적립포인트 35,000P 이상</td>
			<td>투숙 박수 15박 이상 또는 유효적립포인트 15,000P 이상</td>
			<td>투숙 박수 5박 이상 또는 유효적립포인트 1,500P 이상</td>
			<td colspan="2">회원 가입 즉시</td>
			<td></td>
		</tr>
		<tr>
			<td>호텔 및 리조트 포인트 적립</td>
			<td>15%</td>
			<td>10%</td>
			<td>5%</td>
			<td>3%</td>
			<td colspan="2">1%</td>
			<td></td>
		</tr>
		<tr>
			<td>E-SHOP 포인트 적립</td>
			<td>5%</td>
			<td>5%</td>
			<td>5%</td>
			<td>5%</td>
			<td colspan="2"></td>
			<td></td>
		</tr>
		<tr>
			<td>식음 할인*</td>
			<td>17%</td>
			<td>15%</td>
			<td>7%</td>
			<td>5%</td>
			<td colspan="2">3%</td>
			<td></td>
		</tr>
		<tr>
			<td>Laundry 할인*</td>
			<td>25%</td>
			<td>20%</td>
			<td>15%</td>
			<td>10%</td>
			<td colspan="2"></td>
			<td></td>
		</tr>
		<tr>
			<td>금액 바우처</td>
			<td>5만원권 4매</td>
			<td>5만원권 3매</td>
			<td>5만원권 2매</td>
			<td>1만원권 2매</td>
			<td colspan="2"></td>
			<td></td>
		</tr>
		<tr>
			<td>객실 업그레이드*</td>
			<td>O</td>
			<td>O</td>
			<td></td>
			<td></td>
			<td colspan="2"></td>
			<td></td>
		</tr>
		<tr>
			<td>객실 업그레이드 이용권(온라인 쿠폰)*</td>
			<td>5매</td>
			<td>3매</td>
			<td>1매</td>
			<td></td>
			<td colspan="2"></td>
			<td></td>
		</tr>
		<tr>
			<td>웰컴 어메니티*</td>
			<td>O</td>
			<td>O</td>
			<td>O</td>
			<td></td>
			<td colspan="2"></td>
			<td></td>
		</tr>
		<tr>
			<td>Late Check out</td>
			<td>14:00</td>
			<td>14:00</td>
			<td></td>
			<td></td>
			<td colspan="2"></td>
			<td></td>
		</tr>
		<tr>
			<td>무료 숙박권</td>
			<td>연 2회</td>
			<td>연 1회</td>
			<td></td>
			<td></td>
			<td colspan="2"></td>
			<td></td>
		</tr>
		<tr>
			<td>공통 특전</td>
			<td colspan="6"><span>• 모든 특전은 본인 투숙 객실(1실)에 한해 제공됩니다.<br>
					• 맴버십 회원 전용 요금 제공<br> • 레스토랑 할인은 DDIT 서울, DDIT 제주, DDIT호텔 양곤에
					한해 다이아,플래티넘 10%, 골드 5% 할인 적용 (실버/브론즈 제외)<br> • 온라인 쿠폰은 국내 소재
					DDIT호텔에서만 사용 가능<br> • [다이아/플래티넘]<br> &nbsp; - 객실 업그레이드 혜택<br>
					&nbsp; - Late Checkout 14:00 혜택<br> &nbsp; - 전 체인호텔 7월 &amp;
					8월(체크아웃 기준) 제외, 캐릭터룸, 온돌 등 특화 객실 및 일부 스위트 객실 제외<br> • *표기의 혜택은
					DDIT호텔에서 제공<br> • ① : 클럽 라운지 객실 이용 시, 동반 1인 라운지 무료이용 혜택이
					제공됩니다.<br> • ② : 클럽 라운지 미포함 객실 이용 시 적용 가능한 혜택입니다<br>
					&nbsp; - ①,②의 클럽 라운지 혜택은 중복 사용이 불가합니다.
			</span></td>
		</tr>
	</table>
	</div>
<script>
	document.querySelector(".tooltip-area span").addEventListener("click", function(){
		var tooltip = document.querySelector("#uiToggle-14");
		tooltip.style.display = (tooltip.style.display === "none" || tooltip.style.display === "") ? "block" : "none";
	});

</script>


	<%@include file="include/footer.jsp"%>

</body>
</html>