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
}

table {
    width: 100%; /* 테이블 너비 설정 */
    border-collapse: collapse; /* 테두리 겹침 방지 */
    font-family: 'MinSans-Regular', sans-serif;
}
th, td {
    padding: 10px; /* 패딩 추가 */
    border: 1px solid #ccc; /* 테두리 설정 */
    text-align: left; /* 왼쪽 정렬 */
}
th {
    background-color: #f8f8f8; /* 헤더 배경색 */
    color: #333; /* 헤더 글자색 */
}
.form-control {
    width: 100%; /* 입력 필드의 너비를 100%로 설정 */
    padding: 5px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box; /* 패딩 포함 너비 계산 */
}
.submit-button {
    background-color: #B09F7A;
    width: 80px;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 10px; /* 버튼과 테이블 간의 간격 */
    transition: background-color 0.3s; /* 배경색 전환 효과 */
}
.submit-button:hover {
    background-color: #948668;
}

#hotel-dropdown {
     position: absolute;
    background-color: #ffffff; /* 배경색 */
    border: 1px solid #ddd; /* 테두리 */
    width: 30%;
    z-index: 10;
    max-height: 300px; /* 최대 높이 */
    overflow-y: auto; /* 스크롤 가능 */
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
    border-radius: 6px; /* 모서리 둥글게 */
}

#hotel-list {
    list-style-type: none;
    padding: 0;
    margin: 0;
}

#hotel-list li {
    padding: 15px 20px; /* 내부 여백 */
    border-bottom: 1px solid #f0f0f0; /* 구분선 */
    cursor: pointer; /* 클릭 가능 표시 */
    display: flex; /* 내용 정렬 */
    align-items: center; /* 아이템 중앙 정렬 */
    transition: all 0.3s; /* 부드러운 전환 효과 */
}

/* 호텔 리스트 마지막 아이템 구분선 제거 */
#hotel-list li:last-child {
    border-bottom: none;
}

#hotel-list li:hover {
   background-color: #f9f9f9;
}

/* 호텔 이름 스타일 */
.hotel-name {
    font-weight: bold; /* 글씨 강조 */
    color: #333;
    font-size: 16px;
}

/* 호텔 지역 정보 스타일 */
.hotel-region {
    margin-left: auto; /* 우측 정렬 */
    font-size: 14px;
    color: #888;
}

/* 호텔 버튼 스타일 */
.hotel-button {
    width: 100%;
    padding: 10px 15px;
    border: none;
    background: transparent;
    text-align: left;
    cursor: pointer;
    font-size: 16px;
    color: #4B3D3D;
    transition: 0.3s ease;
}

.hotel-button:hover {
    background-color: #f5f5f5;
    color: #333;
}

.no-hotels {
        padding: 8px;
        color: #999;
        text-align: center;
}

 /* 신라호텔 스타일 적용 */
    .room-info {
    margin-left: 300;
    margin-top: 20px;
    padding: 20px;
    border-radius: 8px;
    background-color: #f8f9fa;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    width: 1300px;
}
    .room-info h2 {
      margin-bottom: 10px;
      font-size: 20px;
      color: #333;
    }
    .room-info ul {
      list-style-type: none;
      padding: 0;
    }
    .room-info li {
      padding: 10px;
      border-bottom: 1px solid #ddd;
      font-size: 14px;
      color: #555;
    }
    .room-info li:last-child {
      border-bottom: none;
    }
    .room-card {
      display: flex;
      flex-direction: column;
      gap: 10px;
      padding: 15px;
      margin-bottom: 15px;
      border: 1px solid #ddd;
      border-radius: 8px;
      background-color: white;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    .room-type {
      font-weight: bold;
      color: #333;
    }
    .price {
      font-size: 16px;
      font-weight: bold;
      color: #B09F7A;
    }
    .button {
      padding: 10px 20px;
      background-color: #B09F7A;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
    .button:hover {
      background-color: #948668;
    }

/* 추가 CSS */
.container {
    width: 800px; /* 적절한 너비 설정 */
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
}
 
.header1 { 
	text-align: center;
}

.header1 img {
    text-align: center; 
    margin-bottom: 20px;
}

hr {
 color: #4B3D3D;
 border: 2px;
}

</style>
</head>
<body>
<div class="container">
    <div class="header1">
		<img src="/image/예약1.png" alt="예약단계1">
    </div>
	<hr>
    <div class="search-form">
    <form action="/roomResultServlet" method="get" onsubmit="return validateForm()">
        <table>
            <tr>
                <th>호텔 또는 도시</th>
                <th>체크인</th>
                <th>체크아웃</th>
                <th>성인</th>
                <th>어린이</th>
                <th>유아</th>
            </tr>
            <tr>
                <td>
                	<input type="hidden" name="mem_Id" id="mem_Id" value="<%= loggedInMember != null ? loggedInMember.getMem_id() : "" %>">
                	<input type="hidden" name="res_No" id="res_No"/><!-- r_res_no에 대한 값을 추가한다. -->
                    <input type="text" class="form-control" id="hotel-location" placeholder="선택" style="width: 100%;" onclick="toggleDropdown()" onkeyup="filterHotels()" readonly>
                	<input type="hidden" name="hotel-id" id="hotel-id">
                </td>
                <td><input type="date" class="form-control" id="checkInDate" style="width: 100%;"></td>
                <td><input type="date" class="form-control" id="checkOutDate" style="width: 100%;"></td>
                <td><input type="number" class="form-control" id="r_res_adult" value="2" style="width: 100%;"></td>
                <td><input type="number" class="form-control" id="r_res_child" value="0" style="width: 100%;"></td>
                <td><input type="number" class="form-control" id="r_res_kids" value="0" style="width: 100%;"></td>
                <td><button type="button" class="submit-button" onclick="handleRoomReservation()">검색</button></td>
            </tr>
            <tr>
                <td>
                    <div id="hotel-dropdown" class="dropdown" style="display: none;">
                        <ul id="hotel-list">
                            <%
                                List<String> regions = (List<String>) session.getAttribute("regions");
                                List<HotelVO> hotels = (List<HotelVO>) session.getAttribute("hotels");
                                List<HotelVO> searchedHotels = (List<HotelVO>) request.getAttribute("searchedHotels");
                                // 예약 관리에서 검색하는
//                                 List<Room_ReservationVO> rooms = (List<Room_ReservationVO>) request.getAttribute("reservations");
                                
                                Map<String, List<HotelVO>> regionHotelMap = new LinkedHashMap<>();
                                if (regions != null && hotels != null) {
                                    for (String region : regions) {
                                        regionHotelMap.put(region, hotels.stream()
                                            .filter(h -> h.getHotel_addr().startsWith(region))
                                            .toList());
                                    }
                                }
                                if (!regionHotelMap.isEmpty()) {
                                    for (Map.Entry<String, List<HotelVO>> entry : regionHotelMap.entrySet()) {
                                        String region = entry.getKey();
                                        List<HotelVO> regionHotels = entry.getValue();
                            %>
                            <div class="region-container">
                                <h3><%= region %></h3>
                                <ul>
                                    <%
                                        if (regionHotels != null && !regionHotels.isEmpty()) {
                                            for (HotelVO hotel : regionHotels) {
                                    %>
                                    <li>
                                        <button type="button" class="hotel-button" onclick="selectHotel('<%= hotel.getHotel_name() %>','<%= hotel.getHotel_id() %>')">
                                            <%= hotel.getHotel_name() %>
                                        </button>
                                    </li>
                                    <%
                                            }
                                        }
                                    %>
                                </ul>
                            </div>
                            <%
                                    }
                                }
                                if (searchedHotels != null && !searchedHotels.isEmpty()) {
                            %>
                            <div class="region-container">
                                <h3>검색 결과</h3>
                                <ul>
                                    <%
                                        for (HotelVO hotel : searchedHotels) {
                                    %>
                                    <li>
                                        <button type="button" class="hotel-button" onclick="selectHotel('<%= hotel.getHotel_name() %>','<%= hotel.getHotel_id() %>')">
                                            <%= hotel.getHotel_name() %>
                                        </button>
                                    </li>
                                    <%
                                        }
                                    %>
                                </ul>
                            </div>
                            <%
                                } else if (request.getAttribute("searchedHotels") != null) {
                            %>
                            <div class="region-container">
                                <h3>검색 결과</h3>
                                
                                <p style="text-align: center; color: #777;">검색된 호텔이 없습니다.</p>
                            </div>
                            <% } %>
                        </ul>
                    </div>
                </td>
            </tr>
        </table>
    </form>
  </div>
</div>
    <div id="room-info" class="room-info">
        <ul id="room-details">
		        
        </ul>
    </div>

    <script>
    
    
    window.onload = function(){
        handleReservation();
    }
    
    
    function handleReservation() {
    	// 현재 페이지 URL 저장
        const currentPage = window.location.href;
    	 
    	// 숨겨진 입력 필드에서 mem_Id 가져오기
        const mem_Id = document.getElementById("mem_Id").value; 

        if (mem_Id === "") {
            alert("예약을 하려면 로그인해야 합니다.");
            
            // 로그인 페이지로 이동하면서 현재 페이지 URL 전달
            window.location.href = '/jsp/Login.jsp?redirect=' + encodeURIComponent(currentPage);
        } 
        console.log(mem_Id);
    }
        
//         /* 오류 해결을 위해 예약번호를 임의로 랜덤값으로 지정해서 받아옴 */
//         function generateReservationId() {
//             const r_res_no = 'res_' + Math.floor(Math.random() * 1000000);
//             document.getElementById('res_No').value = r_res_no;
//         }

        function selectHotel(hotelName, hotelId) {
            const inputField = document.getElementById("hotel-location");
            const inputField2 = document.getElementById("hotel-id");
            console.log(inputField,inputField2);
            inputField.value = hotelName;
            inputField2.value = hotelId;
            document.getElementById("hotel-dropdown").style.display = "none"; // 드롭다운 닫기
        }

        function toggleDropdown() {
            const dropdown = document.getElementById("hotel-dropdown");
            dropdown.style.display = dropdown.style.display === "none" ? "block" : "none";
        }

        function filterHotels() {
            const input = document.getElementById("hotel-location").value.toLowerCase();
            const hotelList = document.getElementById("hotel-list");
            const hotels = hotelList.getElementsByTagName("li");

            for (let i = 0; i < hotels.length; i++) {
                const hotel = hotels[i];
                hotel.style.display = hotel.textContent.toLowerCase().includes(input) ? "" : "none";
            }
        }
        
        
   		 //예약정보 저장하기
       function handleRoomReservation() {	 
// 		const resNo = document.querySelector("#res_No").value;
    	const hotelId = document.querySelector("#hotel-id").value;
    	const hotelName = document.querySelector("#hotel-location").value;
    	const checkInDate = document.querySelector("#checkInDate").value;
    	const checkOutDate = document.querySelector("#checkOutDate").value;
	
        console.log(document.querySelector("#hotel-id"),hotelId);
        if (!hotelName || !checkInDate || !checkOutDate) {
            alert("모든 필드를 입력해 주세요.");
            return;
        }

        // AJAX 요청을 통해 서버로 검색 조건을 전송하고 결과를 받아옵니다.
        const xhr = new XMLHttpRequest();
        xhr.open('GET', '/hotelRoomResServlet?hotelId=' + encodeURIComponent(hotelId) + // 호텔 ID 추가
                '&hotelName=' + encodeURIComponent(hotelName) +
                '&checkInDate=' + encodeURIComponent(checkInDate) + 
                '&checkOutDate=' + encodeURIComponent(checkOutDate), true);

        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                try {
					console.log(xhr.responseText);
                    const response = JSON.parse(xhr.responseText);
                    console.log(response);
                    displayRoomDetails(response);
                }
                catch (error) {
                    alert("데이터를 처리하는 중 문제가 발생했습니다.");
                    console.error(error);
                }
            }
        };

        xhr.onerror = function() {
            alert("요청을 처리하는 중 문제가 발생했습니다.");
        };

        xhr.send();
    }

    function displayRoomDetails(rooms) {
        const roomDetailsElement = document.getElementById("room-details");
        const roomInfoContainer = document.getElementById("room-info");
        roomDetailsElement.innerHTML = ''; // 이전에 표시된 객실 정보를 지웁니다.
        roomInfoContainer.style.display = 'block'; // 객실 정보 섹션 표시

        if (rooms && rooms.length > 0) {
            rooms.forEach(function(room) {
            	 const roomCard = document.createElement('div');
                 roomCard.classList.add('room-card');

                 // room-type div 생성
                 const roomTypeDiv = document.createElement('div');
                 roomTypeDiv.classList.add('room-type');
                 roomTypeDiv.textContent = room.type_name;
                 roomCard.appendChild(roomTypeDiv);
				

                 // price div 생성
                 const priceDiv = document.createElement('div');
                 priceDiv.classList.add('price');
                 priceDiv.textContent = room.type_price + ' 원';
                 roomCard.appendChild(priceDiv);

                 // button 생성
                 const button = document.createElement('button');
                 button.classList.add('button');
                 button.textContent = '예약';
                 roomCard.appendChild(button);
                 
              	// 버튼 클릭 시 예약 처리 함수 호출
                 button.addEventListener('click', function() {
                     handleReservationButtonClick(room); // room 객체를 인자로 전달
                 });
 
                 roomDetailsElement.appendChild(roomCard);

            });
        } else {
            const noRoomsItem = document.createElement('li');
            noRoomsItem.textContent = "해당 조건에 맞는 객실이 없습니다.";
            roomDetailsElement.appendChild(noRoomsItem);
        }
    }
    
    function handleReservationButtonClick(room) {
		
//     	const resNo = document.querySelector("#res_No").value;
    	const memId = document.querySelector("#mem_Id").value;
    	const hotelId = document.querySelector("#hotel-id").value;
    	const hotelName = document.querySelector("#hotel-location").value;
    	const checkInDate = document.querySelector("#checkInDate").value;
    	const checkOutDate = document.querySelector("#checkOutDate").value;
    	const adultCount = document.querySelector("#r_res_adult").value;
    	const childCount = document.querySelector("#r_res_child").value;
    	const kidsCount = document.querySelector("#r_res_kids").value;

        // 모든 필드 검증
        if (!hotelName || !checkInDate || !checkOutDate) {
            alert("모든 필드를 입력해 주세요.");
            return;
        }

        // 동적으로 form 생성 및 서블릿으로 데이터 전송
        const form = document.createElement('form');
        form.method = 'get';
        form.action = '/RoomResServlet'; 
        
    	 // action 값 추가
        const actionInput = document.createElement('input');
        actionInput.type = 'hidden';
        actionInput.name = 'action';
        actionInput.value = 'create'; // 원하는 action 값 설정
        form.appendChild(actionInput); // form에 actionInput 추가

        // form에 데이터 추가
        const fields = {
// 			resNo,
			memId: memId,
            hotelId: hotelId,
            hotelName: hotelName,
            checkInDate: checkInDate,
            checkOutDate: checkOutDate,
            adultCount: adultCount,
            childCount: childCount,
            kidsCount: kidsCount,
            roomType: room.type_name,
//             bedType: room.bed_type,
            price: room.type_price
        };
        
        console.log(fields);

        for (const key in fields) {
            const input = document.createElement('input');
            input.type = 'hidden';
            input.name = key;
            input.value = fields[key];
            form.appendChild(input);
        }

        document.body.appendChild(form);
        form.submit(); // 서블릿으로 데이터 전송
    }

    function selectRoomHotel(hotelName) {
        const inputField = document.getElementById("hotel-location");
        inputField.value = hotelName;
        document.getElementById("hotel-dropdown").style.display = "none"; // 드롭다운 닫기
    }

    function toggleDropRoomdown() {
        const dropdown = document.getElementById("hotel-dropdown");
        dropdown.style.display = dropdown.style.display === "none" ? "block" : "none";
    }

    function filterRoomHotels() {
        const input = document.getElementById("hotel-location").value.toLowerCase();
        const hotelList = document.getElementById("hotel-list");
        const hotels = hotelList.getElementsByTagName("li");

        for (let i = 0; i < hotels.length; i++) {
            const hotel = hotels[i];
            hotel.style.display = hotel.textContent.toLowerCase().includes(input) ? "" : "none";
        }
    }
    
    

        
        
        
    </script>

<%@include file="/jsp/include/footer.jsp"%>
</body>
</html>

