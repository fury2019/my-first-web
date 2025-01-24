<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.Hotel.vo.HotelVO"%>
<%@page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>DDIT 호텔 - 예약 관리</title>
<style>
  @font-face {
    font-family: 'MinSans-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

body {
    font-family: 'MinSans-Regular', sans-serif;
    margin: 20px;
    background-color: #f4f4f4; /* 배경색 추가 */
    color: #333;
}

.container {
    width: 80%;
    margin: 40px auto;
    padding: 30px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
    font-family: 'MinSans-Regular', sans-serif;
}

h1, h2 {
    color: #222;
    font-weight: 700;
    margin-bottom: 20px;
    font-family: 'MinSans-Regular', sans-serif;
}

h2 {
    border-bottom: 1px solid #ddd;
    padding-bottom: 10px;
    margin-top: 20px;
}

.room-options .option {
    display: flex;
    align-items: center;
    margin-bottom: 15px;
}

.room-options label {
    flex-grow: 1;
    font-weight: 500;
}

input[type="checkbox"] {
    transform: scale(1.2);
    margin-right: 10px;
}

textarea {
    width: 100%;
    height: 100px;
    margin-bottom: 15px;
    border: 1px solid #ddd;
    padding: 10px;
    border-radius: 5px;
}

ul {
    padding-left: 20px;
    line-height: 1.6;
}

li {
    margin-bottom: 5px;
}

.header1 {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-bottom: 20px;
}

.header1 img {
    width: 120px;
    height: auto;
}

button {
    padding: 10px 20px;
    border: none;
    background-color: #B09F7A;
    color: white;
    font-size: 16px;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #948668;
}

.notes {
    margin-top: 30px;
    padding: 20px;
    background-color: #f9f9f9;
    border: 1px solid #ddd;
    border-radius: 5px;
}

.notes h2 {
    font-size: 1.2em;
    color: #333;
    margin-bottom: 10px;
}

.notes ul {
    list-style: disc;
    padding-left: 20px;
}

.notes li {
    margin-bottom: 5px;
    font-size: 0.95em;
}


</style>
</head>
<body>

<%
    // r_res_no 가져오기
    String r_res_no = (String) request.getAttribute("r_res_no");
	System.out.println("r_res_no : "+r_res_no);
    
%>
<br>
 <div class="header1">
		<img src="/image/예약2.png" alt="예약단계2">
    </div>
<div class="container">
    <h1>옵션 선택</h1>
    <form id="reservationForm" action="RoomServiceResServlet" method="post">
        <input type="hidden" id="r_res_no" name="r_res_no" value="<%= r_res_no %>">
		<input type="hidden" id="selectedOptions" name="selectedOptions" value=""> <!-- 선택된 옵션을 저장할 hidden 필드 -->

        <div class="room-options">
            <div class="option">
                <label>조식</label>
                <input type="checkbox" id="breakfast" name="options" value="breakfast">
            </div>
            <div class="option">
                <label>early-checkIn</label>
                <input type="checkbox" id="early_checkin" name="options" value="early_checkin">
            </div>
            <div class="option">
                <label>late-checkOut</label>
                <input type="checkbox" id="late_checkout" name="options" value="late_checkout">
            </div>
        </div>
        
        <div>
        	<input type="hidden" name="action" value="insert">
            <button type="button" onclick="showSelectedOptions()">완료</button> <!-- 완료 버튼 -->
        </div>

        <h2>선택된 옵션:</h2>
        <ul id="optionsList">
        </ul>

        <!-- 다음 버튼은 목록 아래에 위치 -->
        <div id="nextButtonContainer" style="display:none; margin-top: 10px;">
            <button type="submit">다음</button> <!-- 다음 버튼 -->
        </div>
    </form>
</div>

<script>
function showSelectedOptions() {
    const checkboxes = document.querySelectorAll('input[name="options"]');
    const optionsList = document.getElementById('optionsList');
    optionsList.innerHTML = ''; // 이전 옵션 리스트 초기화

    let selectedOptions = []; // 선택된 옵션을 저장할 배열

    checkboxes.forEach((checkbox) => {
        if (checkbox.checked) {
            const li = document.createElement('li');
            li.textContent = checkbox.value; // 체크된 옵션의 값을 가져옴
            optionsList.appendChild(li); // 리스트에 추가
            selectedOptions.push(checkbox.value); // 선택된 옵션 배열에 추가
        }
        
      // 선택된 서비스가 없을 경우 메시지 표시
        if (!selectedOptions) {
            const li = document.createElement('li');
            li.textContent = "선택된 서비스가 없습니다."; // 메시지 추가
            optionsList.appendChild(li); // 리스트에 추가
        }	
    });

    // 선택된 옵션을 hidden 필드에 설정
    document.getElementById('selectedOptions').value = selectedOptions.join(',');

    // 다음 버튼은 항상 보여줌
    document.getElementById('nextButtonContainer').style.display = 'block';
}

function validateForm() {
    const selectedOptions = document.getElementById('selectedOptions').value;
    if (!selectedOptions) {
        // 선택된 옵션이 없으면 결제 페이지로 이동
        window.location.href = '/jsp/Reservation3.jsp';
        return false; // 폼 전송 방지
    }
    return true; // 폼 전송
}
</script>
		

        <div class="notes">
            <h2>유의사항</h2>
            <ul>
                <li>요금에는 10% 부가가치세가 부과됩니다.</li>
                <li>2인 1실 기준</li>
                <li>체크인 시 등록카드 작성 및 투숙객 본인 확인을 위해 본인 사진이 포함된 신분증을 반드시 제시해 주시기 바랍니다.</li>
                <li>만 12세 이하 어린이는 객실 인원 추가 요금을 받지 않습니다.</li>
                <li>37개월 미만 유아는 조식이 무료입니다.</li>
                <li>안내견을 제외한 애완견 등 동물 입장은 불가합니다.</li>
                <li>부모 등 법정대리인을 동반하지 않은 만 19세 미만 미성년자는 투숙할 수 없습니다.<br>
                	(체크인 시점에 생일이 지난 만 19세부터 법정대리인 동반 없이 투숙이 가능합니다.)</li>
                <li>상기 요금은 기본 요금이며, 쿠폰할인을 제외한 할인은 적용되지 않습니다.</li>
                <li>객실 이용 시 주차는 추가 1대당 20,000원 입니다.(객실당 1대만 무료 주차 가능)</li>
                <li>자세한 객실안내는 고객문의를 이용해 주시기 바랍니다.</li>
            </ul>
        </div>
        <div class="notes">
            <h2>취소 및 환불 규정</h2>
            <ul>
                <li>숙박예정일 1일전 18시까지는 위약금 없이 취소 가능</li>
                <li>위 기간 이후 취소 또는 변경시(No Show 포함)</li>
                <li style="list-style-type: none;">- 성수기 (4, 5, 6, 10, 11월, 12월24일, 12월 31일): 최초 1박 요금의 80% 부과</li>
                <li style="list-style-type: none;">- 비수기 (성수기 외 기간): 최초 1박 요금의 10% 부과
            </ul>
        </div>
    

<%@include file="/jsp/include/footer.jsp"%>
</body>
</html>

 