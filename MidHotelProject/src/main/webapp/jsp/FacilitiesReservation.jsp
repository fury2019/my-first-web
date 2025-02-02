<%@page import="com.Hotel.vo.Facilities_ReservationVO"%>
<%@ page session="true" %>
<%@page import="com.Hotel.vo.hotel_fac_catVO"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.Hotel.vo.HotelVO"%>
<%@page import="com.Hotel.vo.MemberVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.Hotel.vo.Room_ReservationVO" %>
<%@page import="com.Hotel.service.reservation.IRoom_reserService" %>
<%@page import="com.Hotel.service.reservation.Room_reserServiceImpl" %>

<!-- 로그인 정보 -> 관리자 포함 -->
<%@include file="/jsp/include/top.jsp" %>

<%@include file="/jsp/include/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>다이닝 예약</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse; /* 테두리 겹침 방지 */
            margin-bottom: 200px;
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
        .submit-button {
		    background-color: #B09F7A;
		    color: white;
		    padding: 10px 15px;
		    border: none;
		    border-radius: 4px;
		    cursor: pointer;
		    margin-top: 10px; /* 버튼과 테이블 간의 간격 */
		    transition: background-color 0.3s; /* 배경색 전환 효과 */
		}
		.submit-button:hover {
		    background-color: #948668;
		}
        #hotel-dropdown, #dining-dropdown {
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
        #hotel-list, #dining-list {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }
        #hotel-list li, #dining-list li {
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
        
        #hotel-list li:hover, #dining-list li:hover {
            background-color: #f9f9f9;
        }
        .no-hotels {
            padding: 8px;
            color: #999;
            text-align: center;
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

.dining_button {
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

.dining_button:hover {
    background-color: #f5f5f5;
    color: #333;
}

		#hotel-dropdown, #dining-dropdown {
		    display: none; /* 기본적으로 닫혀있도록 설정 */
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
    
    </style>
</head>
<%
String type = (String)request.getAttribute("type");

%>
<body>
    <h2>다이닝 예약</h2>
        <table>
            <tr>
                <th>호텔 선택</th>
                <th>다이닝 선택</th>
            </tr>
            <tr>
                <td>
                    <input type="text" class="form-control" id="hotel-location" placeholder="호텔 선택" style="width: 100%;" onclick="toggleDropdown()" onkeyup="filterHotels()" readonly>
                    <div id="hotel-dropdown">
                        <ul id="hotel-list">        
                   <%
//                             	요청속성 데이터 가져오기
                            List<String> regions = (List<String>) session.getAttribute("regions");
                            List<HotelVO> hotels = (List<HotelVO>) session.getAttribute("hotels");
                            List<HotelVO> searchedHotels = (List<HotelVO>) request.getAttribute("searchedHotels");
//                                 지역별로 호텔매핑
                            Map<String, List<HotelVO>> regionHotelMap = new LinkedHashMap<>();
                            if (regions != null && hotels != null) {
                                for (String region : regions) {
                                    regionHotelMap.put(region, hotels.stream()
                                        .filter(h -> h.getHotel_addr().startsWith(region))
                                        .toList());
                                }
                            }
// 	                            지역별로 호텔 목록 출력    
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
// 								사용자가 검색한 결과가 있을 경우 검색된 호텔 목록 출력
                                if (searchedHotels != null && !searchedHotels.isEmpty()) {
                            %>
                            <div class="region-container">
                                <h3>검색 결과</h3>
                                <ul>
                                    <%
                                        for (HotelVO hotel : searchedHotels) {
                                    %>
                                    <li>
                                        <button type="button" class="hotel-button" onclick="selectHotel('<%= hotel.getHotel_name() %>')">
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
                <td>
                    <input type="text" class="form-control" id="dining-name" placeholder="다이닝 선택" style="width: 100%;" onclick="diningDropdown()" readonly>
                    <div id="dining-dropdown">
                        <div>다이닝</div>
                        <ul id="dining-list">
                            <%
                            // 다이닝 목록을 가져오는 로직
//                             List<hotel_fac_catVO> diningList = (List<hotel_fac_catVO>) request.getAttribute("fac_name");
                            List<hotel_fac_catVO> diningList = (List<hotel_fac_catVO>) request.getAttribute("dining");
                            System.out.println(diningList);

                            if (diningList != null && !diningList.isEmpty()) {
                                for (hotel_fac_catVO dining : diningList) {
                            %>
                            <li>
                                <button type="button" class="dining_button" onclick="selectDining('<%= dining.getFac_name() %>')">
                                    <%= dining.getFac_name() %>
                                </button>
                            </li>
                            <%
                            
                                }
                            } else {
                            %>
                                <li class="no-hotels">다이닝 정보가 없습니다.</li>
                            <%
                            }
                            %>
                        </ul>
                    </div>
                </td>
                
                <td>
                <button type="button" class="submit-button" onclick="handleRoomReservation()">검색</button>             
                </td>
            </tr>
            
        </table>
		<!-- 검색 결과 테이블 추가 -->
	<%
	List<hotel_fac_catVO> diningsearchList = (List<hotel_fac_catVO>) request.getAttribute("diningList");
	if (diningsearchList != null && !diningsearchList.isEmpty()) {
	%>
	<h3>검색 결과</h3>
	<table>
		<thead>
			<tr>
				<th>다이닝 시설명</th>
				<th>최대 인원수</th>
				<th>시설 상태</th>
				<th>아침 시간</th>
				<th>점심 시간</th>
				<th>저녁 시간</th>
				<th>시설 주소</th>
				<th>전화 번호</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (hotel_fac_catVO dining : diningsearchList) {
			%>
			<tr>
				<td><%=dining.getFac_name()%></td>
				<td><%=dining.getFac_max_mem()%></td>
				<td><%=dining.getFac_status()%></td>
				<td><%=dining.getFac_btime() %> </td>
				<td><%=dining.getFac_ltime()%> </td>
				<td><%=dining.getFac_dtime()%> </td>
				<td><%=dining.getFac_addr()%></td>
				<td><%=dining.getFac_tel()%></td>
				<td>
				 	<!-- 예약 버튼 -->
				 	<%
				 	MemberVO memberVO = (MemberVO)session.getAttribute("loginCode");
				 	
				 	%>
	                <form name="frm" method="POST" action="<%=request.getContextPath()%>/facilitiesResServlet">
	                	<input type="hidden" name="r_res_no" value="<%= request.getAttribute("r_res_no") %>">
	                    <input type="hidden" name="mem_id" value="<%=memberVO.getMem_id()%>">
	                    <input type="hidden" name="fac_id" value="<%=dining.getFac_id()%>">
	                    <input type="hidden" name="hotel_id" value="<%=dining.getHotel_id()%>">
	                    <input type="number" name="f_res_mem" placeholder="인원 수" required>
	                    <input type="datetime-local" name="f_fes_time" required>
	                    <button type="submit" class="submit-button">예약</button>
	                 </form>
				</td>
			</tr>
			<%
			}
			%>
			
			
		</tbody>
	</table>
	<%
	} else {
	%>
	<%
	}
	%>

    <script>
    
    
    
 	// 페이지 로드 시 RoomResultServlet 호출
    window.onload = function() {

	 	if(!sessionStorage.getItem('roomServletCalled')){
		 	const form = document.createElement("form");
		 	
	        form.method = "POST";
	        form.action = "<%=request.getContextPath() %>/roomResultServlet?type=fac"; // RoomResultServlet URL
	        document.body.appendChild(form);
	        form.submit(); // 폼 제출
	     	// 세션 스토리지에 호출 여부 기록
            sessionStorage.setItem('roomServletCalled', 'true');
		}
      
	 	
	 	//세션 스토리지에서 값 복원
	    const hotelName = sessionStorage.getItem("selectedHotelName");
	    const diningName = sessionStorage.getItem("selectedDiningName"); 
	 	
	    if (hotelName) {
	        document.getElementById("hotel-location").value = hotelName;
	    }

	   if (diningName) {
	        document.getElementById("dining-name").value = diningName;
	    } 
	    
    };
    
    
    
    
    
    
    //검색 결과 함수 
    function handleRoomReservation() {
        const hotelName = document.getElementById("hotel-location").value;
        const diningName = document.getElementById("dining-name").value;
        
        console.log("hotelName : " + hotelName);
        console.log("diningName : " + diningName);

        if (!hotelName) {
            alert("호텔을 선택해주세요.");
            return;
        }

        if (!diningName) {
            alert("다이닝을 선택해주세요.");
            return;
        }

        // 호텔 ID 가져오기
        const hotelId = sessionStorage.getItem("selectedHotelId");

        // 검색 결과로 이동
        const form = document.createElement("form");
        form.method = "GET";
        form.action = "<%=request.getContextPath() %>/facilitiesList"; // 검색 결과를 처리할 URL

        // Hidden input 추가
        /*
        String hotelId = request.getParameter("hotel_id");
		String diningName = request.getParameter("dining_name");
        */
        const hotelInput = document.createElement("input");
        hotelInput.type = "hidden";
        hotelInput.name = "hotel_id";
        hotelInput.value = hotelId;
        form.appendChild(hotelInput);

        const diningInput = document.createElement("input");
        diningInput.type = "hidden";
        diningInput.name = "dining_name";
        diningInput.value = diningName;
        form.appendChild(diningInput);
        
        const typeInput = document.createElement("input");
        typeInput.type = "hidden";
        typeInput.name = "type";
        typeInput.value = "<%=type%>";
        form.appendChild(typeInput);

        document.body.appendChild(form);
        form.submit();
    }
    
    
//     //예약할 때 
//     function reserveDining(diningName, diningId) {
//         const confirmReservation = confirm(diningName+"을(를) 예약하시겠습니까?");
//         if (!confirmReservation) return;

//         const form = document.createElement("form");
//         form.method = "POST";
<%--         form.action = "<%=request.getContextPath() %>/reserveDiningServlet"; --%>

//         const diningIdInput = document.createElement("input");
//         diningIdInput.type = "hidden";
//         diningIdInput.name = "dining_id";
//         diningIdInput.value = diningId;
//         form.appendChild(diningIdInput);

//         const diningNameInput = document.createElement("input");
//         diningNameInput.type = "hidden";
//         diningNameInput.name = "dining_name";
//         diningNameInput.value = diningName;
//         form.appendChild(diningNameInput);

//         document.body.appendChild(form);
//         form.submit();
//     }
    
    

    
    function selectHotel(hotelName, hotelId) {
        const inputField = document.getElementById("hotel-location");
        inputField.value = hotelName;
        document.getElementById("hotel-dropdown").style.display = "none"; // 드롭다운 닫기
        
        
     	// 다이닝 리스트 초기화
        const diningDropdown = document.getElementById("dining-dropdown");
        diningDropdown.style.display = "none"; // 다이닝 드롭다운 닫기
        
        //값 세션 스토리지에 저장
        sessionStorage.setItem("selectedHotelName", hotelName);
        sessionStorage.setItem("selectedHotelId", hotelId);
        
        location.href = "<%=request.getContextPath() %>/FacResServlet?type=<%=type%>&hotel_id=" + hotelId;
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

    function selectDining(diningName) {
        const inputField = document.getElementById("dining-name");
        inputField.value = diningName;
        document.getElementById("dining-dropdown").style.display = "none"; // 드롭다운 닫기
        
        
     	// 호텔 드롭다운 초기화
        document.getElementById("hotel-dropdown").style.display = "none";
        
        //값 세션 스토리지에 저장
        sessionStorage.setItem("selectedDiningName", diningName);
        
    }

    function diningDropdown() {
        const dropdown = document.getElementById("dining-dropdown");
        dropdown.style.display = dropdown.style.display === "none" ? "block" : "none";
    }
</script>

<%@include file="/jsp/include/footer.jsp" %>
</body>
</html>