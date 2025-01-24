<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>My JSP Page</title>
	<!-- Twitter Bootstrap3 & jQuery -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<style>

.container{
      position: relative;
    transform: translate(0%, 25%);
    background-color: #ffffff;
    box-shadow: 0 45px 50px rgb(0 0 0 / 10%), 0 4px 18px rgb(0 0 0 / 10%);
    padding: 15px;
}
@media (min-width: 1200px){
.container{
    width: 700px;
    border: 3px solid #ebeeef;
    border-radius: 17px;
}
}
.addimage{
    display: block;
    width: 50%;
    margin-left: 30%;
    margin-bottom: 30px;
}
.roomadd{
	    margin-right: -50% !important;
    margin-left: 20% !important;
}
#board_file1Img{
width: 240px;
}
.btn{
	background-color:#524b42;
	color:white;
}
 .table>tbody>tr>th.info{
 background-color: #f5e9cb;
 }
 img{
     max-width: 100%;
 }
</style>
<body>
	<c:set var="room" value="${requestScope.room }" />
	
	<div class="container">
		<h1 class='page-header'>객실수정</h1>

		<!-- 수정을 위한 HTML 폼 시작 -->
		<form class="form-horizontal" method="post" action="/admin/AdminRoomEditOk.ad">

		  <!-- 상태유지를 위한 일련번호 값의 처리 -->
		  <input type="hidden" name="r_id" value="${room.r_id }" />

		  <div class="form-group">
		    <label for="r_type" class="col-sm-2 control-label">객실 종류</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="r_type" name="r_type"  value="${room.r_type }"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="r_capacity" class="col-sm-2 control-label">수용 인원</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="r_capacity" name="r_capacity" value="${room.r_capacity }" />
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="r_price" class="col-sm-2 control-label">가격</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="r_price" name="r_price"  value="${room.r_price}"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="r_img" class="col-sm-2 control-label">이미지</label>
		    <div class="col-sm-10">
		      <img alt="" src="/upload/${file }">
		    </div>
		  </div>
		  

		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">저장하기</button>
		    </div>
		  </div>
		</form>
		<!--// 수정을 위한 HTML 폼 끝  -->
	</div>
</body>
</html>



