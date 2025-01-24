<%@ page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" type="text/css" href="/css/styles.css">
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
    #content-area {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
    .form-table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }
    .form-table th, .form-table td {
        padding: 10px 15px;
        text-align: left;
        border: 1px solid #e3d5b8;
    }
    .form-table th {
        background-color: #f5deb3;
        color: #333;
        width: 20%;
    }
    .form-table td {
        background-color: #fff8dc;
    }
    .form-table input {
        width: calc(100% - 20px);
        padding: 8px 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 14px;
    }
    .button-group {
        text-align: center;
        margin-top: 20px;
    }
    .button-group .btn {
        padding: 10px 20px;
        font-size: 16px;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin: 0 5px;
    }
    .button-group .btn-primary {
        background-color: #8b4513;
    }
    .button-group .btn-secondary {
        background-color: #deb887;
    }
    .button-group .btn:hover {
        opacity: 0.8;
    }
</style>
</head>
<body>

<%
    MemberVO memVo = (MemberVO) request.getAttribute("memberInfo");
%>
<div id="content-area">
    <h1>회원 정보 수정</h1>
    <form id="update-form" action="/memberUpdate" method="post">
        <table class="form-table">
            <tr>
                <th><label for="mem_pw">비밀번호</label></th>
                <td><input type="password" id="mem_pw" name="mem_pw" placeholder="새 비밀번호를 입력하세요" required></td>
            </tr>
            <tr>
                <th><label for="mem_tel">연락처</label></th>
                <td><input type="tel" id="mem_tel" name="mem_tel" value="<%= memVo.getMem_tel() %>"></td>
            </tr>
            <tr>
                <th><label for="mem_post">우편번호</label></th>
                <td>
                    <input type="text" id="mem_post" name="mem_post" value="<%= memVo.getMem_post() %>">
                    <button type="button" id="addrBtn" class="btn btn-info btn-sm">주소검색</button>
                </td>
            </tr>
            <tr>
                <th><label for="mem_addr1">주소</label></th>
                <td><input type="text" id="mem_addr1" name="mem_addr1" value="<%= memVo.getMem_addr1() %>"></td>
            </tr>  
            <tr>
                <th><label for="mem_addr2">상세주소</label></th>
                <td><input type="text" id="mem_addr2" name="mem_addr2" value="<%= memVo.getMem_addr2() %>"></td>
            </tr>
        </table>
        <div class="button-group">
            <button type="submit" class="btn btn-primary">수정하기</button>
            <button type="reset" class="btn btn-secondary">취소</button>
        </div>
    </form>
</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        document.getElementById('addrBtn').addEventListener('click', function () {
            new daum.Postcode({
                oncomplete: function (data) {
                    document.getElementById('mem_post').value = data.zonecode;
                    document.getElementById('mem_addr1').value = data.roadAddress;
                }
            }).open();
        });
    });
</script>

</body>
</html>
