<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	<form>태그의 속성
	1) action => form에서 구성한 데이터를 받아서 처리할 문서명 또는 서블릿 URL
	2) method => 전송방식 (GET 또는 POST) ==> 기본값 : GET
	3) target => 응답 결과가 나타날 프레임 지정 
	4) enctype => 주로 서버로 파일을 전송할 때 사용하는 속성으로
					이 때의 속성값은 'multipart/form-data'로 지정해야 한다.
 -->
 
<!-- 
	HTML 주석 영역
 -->

<%--
	이것은 JSP 주석 영역이다
 --%>
 
 <%
 	// 이 영역은 JSP문서에서 Java명령을 사용할 수 있는 영역입니다.
 	// 그리고 이 영역은 '스크립트릿(Scriptlet)'이라고 합니다.
 	String name = "홍길동";
 	
 %>
 
<%-- 
 <%=변수나 수식 %> ==> JSP에서 변수나 수식의 결과를 출력할 때 사용한다.
 				 ==> 이것을 '표현식(Expression)'이라고 한다.
 				 
--%>

<h2><%=name %>의 Request 연습 Form <%= 3+4*2 %></h2>
<form action="/webTest/requestTest01.do">
<table border="1">
<tr>
	<td>이 름</td>
	<td> <input type="text" name="username"> </td>
</tr>
<tr>
	<td>직 업</td>
	<td> 
		<select name="job">
			<option value="무직">== 무직 ==</option>
			<option value="회사원">== 회사원 ==</option>
			<option value="전문직">== 전문직 ==</option>
			<option value="학생">== 학생 ==</option>
		</select>
	</td>
</tr>

<tr>
	<td>취 미</td>
	<td> 
		<input type="checkbox" name="hobby" value="여행">여행
		<input type="checkbox" name="hobby" value="독서">독서
		<input type="checkbox" name="hobby" value="게임">게임
		<input type="checkbox" name="hobby" value="배드민턴">배드민턴
		<input type="checkbox" name="hobby" value="테니스">테니스
	</td>
</tr>


<!-- <tr>
	<td>취 미2</td>
	<td> 
		<input type="radio" name="hobby1" value="여행">여행
		<input type="radio" name="hobby1" value="독서">독서
		<input type="radio" name="hobby1" value="게임">게임
		<input type="radio" name="hobby1" value="배드민턴">배드민턴
		<input type="radio" name="hobby1" value="테니스">테니스
	</td>
</tr> -->

	

<tr>
	<td colspan="2" style="text-align: center.">
	<input type="submit" value="전 송">
	<input type="reset" value="초기화">
	</td>
</tr>
</table>
</form>


</body>
</html>