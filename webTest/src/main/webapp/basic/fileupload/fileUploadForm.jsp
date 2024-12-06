<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>File Upload 연습용 Form</h2>
<!-- 
	파일 업로드를 위해서는 <form>태그의 method속성은 반드시 'POST'이어야 하고
	enctype 속성도 'multipart/form-data'로 설정해야 한다.
 -->
<form action="<%=request.getContextPath()%>/fileUpload.do" '
		method="post" enctype="multipart/form-data">
	작성자 이름 : <input type="text" name="username"><br><br>
	
	한 개 파일 선택 : <input type="file" name="upFile1"><br><br>
	
	여러 개 파일 선택 : <input type="file" name="upFile2" multiple><br><br>
	
	<input type="submit" value="전 송">
	
</form>
<br><hr>
<a href="<%=request.getContextPath() %>/fileList.do">파일 목록</a>

</body>
</html>