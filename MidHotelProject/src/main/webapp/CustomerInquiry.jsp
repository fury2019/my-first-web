<%@page import="java.util.List"%>
<%@page import="com.Hotel.vo.MemberVO"%>
<%@page import="com.Hotel.vo.HotelVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>고객 문의</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>    
<style>
   .line {
     border: 2px solid #8b4513;
   }
   body {
	    font-family: Arial, sans-serif;
	    background-color: #fdf5e6;
	    margin: 0;
	    padding: 0;
	}
	
	.layout {
	    display: flex;
	    flex-direction: column;
	    min-height: 100vh;
	    background-color: #f9f9f9;
	}
	
	.content {
	    display: flex;
        flex: 1;
        margin-top: 0px;
	    background-color: #fff;
	    border-radius: 10px;
	    box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.1);
	    box-sizing: border-box;
	}
	
	h2 {
	    text-align: center;
	    color: #8b4513;
	    margin-bottom: 10px;
	}
	
	p {
	    text-align: center;
	    color: #5a2d0c;
	    font-size: 14px;
	    margin-bottom: 20px;
	}
	
	
	.table-container {
	    overflow-x: auto; /* 긴 테이블 가로 스크롤 추가 */
	}
	
	.main-content {
	    flex: 1;
	    justify-content: center; /* 수평 가운데 정렬 */
	    align-items: center; /* 수직 가운데 정렬 */
	    flex-direction: column; /* 콘텐츠를 위아래로 정렬 */
	}
	
	table {
	    flex: 1;
	    border-collapse: collapse;
	    margin: 20px 0;
	    background-color: #fff;
	    justify-content: center;
	}
	
	table th,
	table td {
	    border: 1px solid #ddd;
	    padding: 12px;
	    text-align: center; /* 텍스트를 중앙 정렬 */
	    font-size: 14px;
	}
	
	table th {
	    background-color: #f5deb3; /* 헤더 배경색 */
	    color: #5a2d0c; /* 헤더 텍스트 색상 */
	    font-weight: bold;
	    text-align: center; /* 헤더 텍스트 중앙 정렬 */
	}
	
	table td {
	    background-color: #fff7e6; /* 셀 배경색 */
	    color: #333;
	}
	
	table tr:nth-child(even) td {
	    background-color: #f9f9f9; /* 짝수 행 배경 */
	}
	
	table tr:hover td {
	    background-color: #f0e6d6; /* 마우스 오버 배경 */
	}
   
</style>
<body>
    <div class="layout">
        <div class="content">
            
            <div class="main-content">
                <h2>연락처</h2>
                <hr class="line">
                <p>호텔 이용에 관련된 문의는 해당 호텔의 대표전화 이용하시면 더 빠르게 답변을 받으실 수 있습니다.</p>
                <table class="table">
                    <thead>
                        <tr>
                            <th>호텔명</th>
                            <th>호텔주소</th>
                            <th>대표전화</th>
                            <th>객실예약</th>
                            <th>운영시간</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                       List<HotelVO> hotelList = (List<HotelVO>) request.getAttribute("hotelList");
                       if(hotelList != null){
                          for (HotelVO hvo : hotelList){
                       
                    %>
                                        
                        <tr>
                            <td><%=hvo.getHotel_name() %></td>
                            <td><%=hvo.getHotel_addr() %></td>
                            <td><%=hvo.getHotel_tel() %></td>
                            <td><%=hvo.getHotel_tel2() %></td>
                            <td><%=hvo.getHotel_resertime() %></td>
                        </tr>
                        
                        <% 
                           } 
                       }
                        %>
                        
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    
   
</body>

</html>