<%@page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 검증</title>
    <style>
      @font-face {
    font-family: 'MinSans-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
    
    body {
    font-family: 'MinSans-Regular', sans-serif;
    background-color: #fff8e6; /* 부드러운 배경 색상 */
    color: #5a3e36; /* 어두운 갈색 계열 */
    margin: 0;
    padding: 0;
}

h1 {
    text-align: center;
    margin-top: 50px;
    font-size: 28px;
    color: #8c5a44;
}

form {
    width: 300px;
    margin: 0 auto;
    padding: 30px;
    background-color: #fdf4e4;
    border: 1px solid #e0c9b3;
    border-radius: 8px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

label {
    display: block;
    font-weight: bold;
    margin-bottom: 8px;
    color: #8c5a44;
}

input[type="password"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #d3b18d;
    border-radius: 5px;
    font-size: 16px;
    background-color: #fff;
}

button {
    width: 100%;
    padding: 10px;
    background-color: #cc7a49;
    border: none;
    border-radius: 5px;
    color: #fff;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #b8683d;
}

button:active {
    background-color: #9e5a34;
}

@media (max-width: 480px) {
    form {
        width: 90%;
    }
}
    
    </style>
</head>
<body>
    <h1>비밀번호 입력</h1>
    <form>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <button type="button" id="pwChk">확인</button>
    </form>
</body>
</html>
<%

/*
        //return; // 폼 출력 후 나머지 코드 실행 중단
    } else if (memPw == null) {
        // 세션이 만료된 경우 처리
        out.println("<h1>세션이 만료되었습니다. 다시 로그인해주세요.</h1>");
        response.sendRedirect("/jsp/Login.jsp");
        return;
    } else if (!memPw.equals(inPw)) {
        // 비밀번호 검증 실패 처리
        out.println("<h1>비밀번호가 일치하지 않습니다. 다시 입력해주세요.</h1>");
        out.println("<a href='/jsp/include/PWTest.jsp'>다시 시도하기</a>");
        return; // 검증 실패 시 실행 중단
    } else {
    	test = true;
    response.sendRedirect("/memberUpdate");
    }
    */
%>
