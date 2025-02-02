<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.Hotel.vo.HotelVO"%>
<%@page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.Hotel.vo.Room_ReservationVO" %>
<%@ page import="com.Hotel.service.reservation.IRoom_reserService" %>
<%@ page import="com.Hotel.service.reservation.Room_reserServiceImpl" %>
<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>근처 명소</title>
    
    <style>
        table {
            width: 15%; /* 테이블 너비 설정 */
            border-collapse: collapse; /* 테두리 겹침 방지 */
        }
        
        tr{
        	height: 15%;
        }
        
        th, td {
            padding: 10px; /* 패딩 추가 */
            border: 1px solid #ccc; /* 테두리 설정 */
            text-align: left; /* 왼쪽 정렬 */
        }
        .form-control {
            width: 100%; /* 입력 필드의 너비를 100%로 설정 */
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        
         .submit-button {
            background-color: #4B3D3D;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px; /* 버튼과 테이블 간의 간격 */
        }
        .submit-button:hover {
            background-color: #3A2E2E;
        }
        
        
        
        #hotel-dropdown {
          position: absolute;
          background-color: white;
            border: 1px solid #ccc;
          width: 14%;
          z-index: 1;
          
/*           cursor: pointer; */
      }

      #hotel-list {
          list-style-type: none;
          padding: 0;
          margin: 0;
      }
      
      #hotel-list li {
          padding: 5px;
          cursor: pointer;
      }
      
      #hotel-list li:hover {
          background-color: #f0f0f0;
      }
      
      

    </style>
</head>
<body>
    <h3>호텔 근처 명소 검색</h3>
      <form>
		     
      
        <table>
            <tr>
                <th>호텔 지점</th>
                
            </tr>
            <tr>
                <td><input type="text" class="form-control" id="hotel-location" placeholder="선택" style="width: 100%;" onclick="toggleDropdown()" onkeyup="filterHotels()"> </td>
                <td><button type="submit" class="submit-button">검색</button></td>

            </tr>
            <tr>
               <td>
                  <div id="hotel-dropdown" class="dropdown" style="display: none;">
                    <ul id="hotel-list">
                        <li>DDIT 서울</li>
                        <li>DDIT STAY JEJU</li>
                        <li>DDIT STAY BUSAN</li>
                        <li>DDIT STAY YEOKSAM</li>
                    </ul>
                </div>
               </td>
            </tr>
        </table>
         
        
    </form>
    

    

    <script>
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
                if (hotel.textContent.toLowerCase().includes(input)) {
                    hotel.style.display = "";
                } else {
                    hotel.style.display = "none";
                }
            }
        }

        // 클릭 시 호텔 이름을 입력 필드에 설정
        document.getElementById("hotel-list").addEventListener("click", function(e) {
            if (e.target.tagName === "LI") {
                document.getElementById("hotel-location").value = e.target.textContent;
                document.getElementById("hotel-dropdown").style.display = "none"; // 드롭다운 닫기
            }
        });
    </script>
    
<%@include file="/jsp/include/footer.jsp" %>
</body>
</html>
