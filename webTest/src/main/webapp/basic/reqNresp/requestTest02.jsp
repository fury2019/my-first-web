<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Request 연습 Form(정수형 숫자 입력)</h2>
<form action="/webTest/requestTest02.do">
<table border="1">
<tr>
	<td> <input type="text" name="i1"> </td>
	<td>
		<select name="operator">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
			<option value="%">%</option>
		</select>
	</td>
	<td> <input type="text" name="i2"> </td>
</tr>
	
<tr>
	<td colspan="2" style="text-align: center.">
	<input type="submit" value="계산">
	<input type="reset" value="초기화">
	</td>
</tr>
</table>
</form>
</body>
</html>