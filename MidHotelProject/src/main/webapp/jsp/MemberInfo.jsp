<%@page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>내 정보 조회</title>
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
  
    .info-container {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    .info-table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    .info-table th, .info-table td {
        border: 1px solid #deb887;
        padding: 10px;
        text-align: left;
    }

    .info-table th {
        background-color: #f5deb3;
        color: #8b4513;
    }

    .info-table tr:nth-child(even) {
        background-color: #fdf5e6;
    }
  </style>
</head>
<body>
  <div class="info-container">
      <h1 style="color: #8b4513;">내 정보 조회</h1>
      <p>현재 로그인된 회원님의 정보는 아래와 같습니다:</p>
      <form action="/myPage" method="post">
      <table class="info-table">
          <thead>
              <tr>
                  <th>항목</th>
                  <th>정보</th>
              </tr>
          </thead>
          <tbody>
              <% 
                MemberVO memberInfo = (MemberVO) request.getAttribute("memberInfo");
                if (memberInfo != null) { 
              %>
                  <tr>
                      <td>이름</td>  
                      <td><%= memberInfo.getMem_name() %></td>
                  </tr>
                  
                  <tr>
                      <td>생년월일</td>
                      <td><%= memberInfo.getMem_bir() %></td>
                  </tr>
                  
                  <tr>
                      <td>성별</td>
                      <td><%= memberInfo.getMem_gender() %></td>
                  </tr>
                  
                
                  <tr>
                      <td>전화번호</td>
                      <td><%= memberInfo.getMem_tel() %></td>
                  </tr>
                  
                  <tr>
                      <td>우편번호</td>
                      <td><%= memberInfo.getMem_post() %></td>
                  </tr>
                  
                  <tr>
                      <td>주 소</td>
                      <td><%= memberInfo.getMem_addr1() + " " + memberInfo.getMem_addr2() %></td>
                  </tr>
                  
                  <tr>
                      <td>가입일</td>
                      <td><%= memberInfo.getMem_create() %></td>
                  </tr>
                  
                  <tr>
                      <td>포인트</td>
                      <td><%= memberInfo.getMem_point() %></td>
                  </tr>
                  
                  <tr>
                      <td>회원등급</td>
                      <td><%= memberInfo.getGrade_no() %></td>
                  </tr>
              <% } else { %>
                  <tr>
                      <td colspan="2">회원 정보를 가져올 수 없습니다.</td>
                  </tr>
              <% } %>
          </tbody>
      </table>
      </form>
  </div>
</body>
</html>
