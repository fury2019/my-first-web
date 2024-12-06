<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<img src="../../images/고양이.jpg" width="300"><br><br>
<img src="../../images/고양이 저용량.jpg" width="300"><br><br>

<img src="<%=request.getContextPath() %>/images/고양이.jpg" width="300"><br><br>

<img src="<%=request.getContextPath() %>/images/imageView.do?fileno=3" width="300"><br><br>
</body>
</html>