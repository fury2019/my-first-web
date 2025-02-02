<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DDIT 호텔 - 회원가입 완료</title>
<link rel="stylesheet" type="text/css" href="/css/styles.css">
<style>
  @font-face {
    font-family: 'MinSans-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
/* 전역 스타일 */
body {
    font-family: 'MinSans-Regular', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #ffffff;
    color: #3f3f3f;
}

.container {
    width: 600px;
    margin: 50px auto;
    text-align: center;
    border: none;
    padding: 30px 20px;
    font-family: 'MinSans-Regular', sans-serif;
}

/* 헤더 스타일 */
header h1 {
    font-size: 20px;
    color: #3f3f3f;
    font-weight: bold;
    margin-bottom: 15px;
}

/* 진행 상태 테이블 */
.progress-table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 30px;
}

.progress-table td {
    text-align: center;
    font-size: 14px;
    color: #999;
    padding: 10px 0;
    border-bottom: 2px solid #e5e5e5;
}

.progress-table .active {
    color: #3f3f3f;
    font-weight: bold;
    border-bottom: 3px solid #eed787;
}

/* 메인 콘텐츠 스타일 */
main h2 {
    font-size: 18px;
    color: #a97b50;
    margin-bottom: 20px;
}

.user-info {
    font-size: 16px;
    margin-bottom: 30px;
}

/* 정보 박스 스타일 */
.info-box {
    border: 1px solid #e5e5e5;
    padding: 20px 0;
    margin: 20px auto 30px auto;
    background-color: #fafafa;
    text-align: left;
    width: 400px;
    max-width: 90%;
    
}

.info-row {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 20px;
    font-size: 16px;
    border-bottom: 1px solid #e5e5e5;
}

.info-row:last-child {
    border-bottom: none;
}

.info-row .label {
    font-weight: bold;
    color: #3f3f3f;
    margin-right: 10px;
    flex-grow: 1;
}

.info-row .value {
    color: #a97b50;
    margin-left: 10px;
    flex-grow: 2; /* value가 label보다 더 많은 공간을 차지하도록 함 */
    text-align: right; /* value를 오른쪽 정렬 */
}

/* 부가 텍스트 스타일 */
.note {
    font-size: 14px;
    color: #999;
    line-height: 1.6;
    margin-bottom: 30px;
}

/* 버튼 스타일 */
.login-button {
    background-color: #3f3f3f;
    color: #fff;
    border: none;
    padding: 10px 20px;
    font-size: 14px;
    font-weight: bold;
    cursor: pointer;
    border-radius: 3px;
    text-decoration: none; /* 링크 밑줄 제거 */
    display: inline-block; /* 버튼처럼 보이게 설정 */
    text-align: center;
}

.login-button:hover {
    background-color: #555;
}
</style>
</head>
<body>
	  <div class="container">
        <header>
            <h1>회원가입 완료</h1>
             <table class="progress-table">
                <tr>
                    <td>약관동의</td>
                    <td>회원정보 입력</td>
                    <td class="active">가입완료</td>
                </tr>
            </table>
        </header>
        <main>
            <h2>감사합니다.</h2>
            <p class="user-info">
                <strong id="userName"></strong>님께서는 DDIT HOTEL에 정상적으로 가입되셨습니다.
            </p>
            <div class="info-box">
                <div class="info-row">
                    <span class="label">아이디</span>
                    <span class="value" id="userId"></span>
                </div>
                <div class="info-row">
                    <span class="label">맴버십 등급</span>
                    <span class="value" id="gradeNo">Bronze</span>
                </div>
            </div>
            <p class="note">
                DDIT HOTEL 번호는 가입 시 기재하신 이메일로도 발송되었습니다.<br>
                로그인하신 후 다양한 혜택과 서비스를 경험해보시기 바랍니다.
            </p>
            <a href="/jsp/Login.jsp" class="login-button">로그인</a>
        </main>
    </div>
 <script>
//localStorage에서 값 가져오기
 const userId = localStorage.getItem("userId");
 const name = localStorage.getItem("name");

 // 값 화면에 표시
 document.getElementById("userId").textContent = userId || "알 수 없음";
 document.getElementById("userName").textContent = name || "사용자";
 </script>   
    
    
    
</body>
<%@include file="/jsp/include/footer.jsp" %>
</html>