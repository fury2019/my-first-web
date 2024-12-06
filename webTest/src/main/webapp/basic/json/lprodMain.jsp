<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
$(function(){
	$('#lprodBtn').on("click", function() {
		
	$.ajax({
		url : "<%=request.getContextPath()%>/lprod/lprodList.do",
		type : "post",
		// data : 전송할 자료, // 전송할 자료가 없어서 생략한다.
		
		success : function(data) {
// 			console.log("data");
			let htmlCode = "<table border='1'>";
			htmlCode += "<tr><th>LPROD_ID</th><th>LPROD_GU</th><th>LPROD_NM</th></tr>";
			
			$.each(data, function(i,v) {
				htmlCode += "<tr><td>" + v.lprod_id + "</td>";
				htmlCode += "<td>" + v.lprod_gu + "</td>";
				htmlCode += "<td>" + v.lprod_nm + "</td></tr>";
			});
			
			htmlCode += "</table>";
			
			$("#result").html(htmlCode);
			
		},
		
		error : function(xhr) {
			alert("code : " + xhr.code);
		},
		dataType : "json"
		});
	});
	
	$("#lprodBtn2").on("click", function() {
		location.href = "<%=request.getContextPath()%>/lprod/lprodList2.do";
	})

});

</script>
</head>
<body>
	<form>
		<input type="button" id="lprodBtn" value=" Lprod자료가져오기(Ajax)">
		<input type="button" id="lprodBtn2" value=" Lprod자료가져오기(Non Ajax)">
	</form>
	<br>
	<h3>LPROD 자료 목록</h3>
	<div id="result"></div>

</body>
</html>