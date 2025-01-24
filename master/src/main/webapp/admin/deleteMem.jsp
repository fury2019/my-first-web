<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shinna - 회원삭제</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<style>

.container{
      position: relative;
    transform: translate(0%, 40%);
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
	<c:set var="exist" value="${requestScope.exist }" />


	<div class="container">
			<h2 style="text-align: center; height: 50px;">
				<span style="background-color: #524b42; color: white; padding: 10px;">회원 삭제</span>
			</h2>
			<div class="post-thumbnail mb-50">
				<p style="padding: 50px 20px; text-align: center;">
					정말로 회원삭제 하시겠습니까? <br> 회원 삭제 후 예약 내역과 회원 정보는 조회 할 수 없습니다.
				</p>
				<hr>
			</div>
			<div style="text-align: center; line-height: 50px;">
				<div>
					<input type="button" id="change" class="change btn"	onclick="deleteMemberOk('${exist }');" value="삭제하기">
				</div>
			</div>		
	</div>

</body>
<script>
	
function deleteMemberOk(exist) {	
	let pw = prompt("비밀번호를 입력해주세요!");

	if (pw == 1234) {
		if( ${exist } == true){
			alert("예약내역을 확인해주세요.");
			location.href="${pageContext.request.contextPath }/admin/AdminReservationList.ad"
		} else {
			alert("회원 삭제가 완료되었습니다.")
			location.href="${pageContext.request.contextPath }/admin/AdminMemberDelete.ad"
		}
	} else {	
		alert("비밀번호를 확인해 주세요!");
	}
	
	
}
</script>
</html>