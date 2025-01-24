<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>Shinna - 관리자 - 객실등록</title>
<!-- Twitter Bootstrap3 & jQuery -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
<script src="http://code.jquery.com/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<style>

.container{
      position: relative;
    transform: translate(0%, 25%);
    background-color: #ffffff;
    box-shadow: 0 45px 50px rgb(0 0 0 / 10%), 0 4px 18px rgb(0 0 0 / 10%);
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
</style>
<body>
	<div class="container">
		<h1 class='page-header'>객실추가</h1>
		<!-- 추가를 위한 HTML 폼 시작 -->
		<form class="form-horizontal" method="post" name="writeForm" enctype="multipart/form-data">
			<div class="form-group">
				<label for="r_type" class="col-sm-2 control-label">객실 종류</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="r_type" name="r_type" />
				</div>
			</div>

			<div class="form-group">
				<label for="r_capacity" class="col-sm-2 control-label">수용 인원</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="r_capacity" name="r_capacity" />
				</div>
			</div>

			<div class="form-group">
				<label for="r_price" class="col-sm-2 control-label">가격</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="r_price" name="r_price" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10">
					<input type="hidden" class="form-control" id="r_img" name="r_img" />
				</div>
			</div>
			<div style="margin-bottom: 2%;">첨부파일</div>
			<div class="addimage">
				<div class="files">
					<div>
						<label for="board_file1" style="display: inline;"> 
							<img id="board_file1Img" src="${pageContext.request.contextPath}/image/add.png" width="auto" height="auto" style="display: inline;">
						</label>
					</div>
					<input id="board_file1" name="board_file1" type="file">
					<input type="button" onclick="cancelFile('board_file1')" value="첨부 삭제">
				</div>				
			</div>

			<div class="form-group roomadd">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default" onclick="send()">저장하기</button>
					<input type="button" class="btn" value="취소" onclick="history.back()">
				</div>
			</div>
		</form>
		<!--// 추가를 위한 HTML 폼 끝  -->
	</div>
</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	let imgName = "";
	
	function send() {
// 		if(!$("input#r_id").val()){
// 			alert("객실 아이디를 입력해주세요.");
// 			$("#r_id").focus();
// 			return;
// 		}
		if(!$("input#r_type").val()){
			alert("객실 종류를 입력해주세요.");
			$("#r_type").focus();
			return;
		}
		if(!$("input#r_capacity").val()){
			alert("수용 인원을 입력해주세요.");
			$("#r_capacity").focus();
			return;
		}
		if(!$("input#r_price").val()){
			alert("가격을 입력해주세요.");
			$("#r_price").focus();
			return;
		}
// 		if(!$("input#r_img").val()){
// 			alert("이미지를 등록해주세요.");
// 			$("#r_img").focus();
// 			return;
// 		}

		let r_type = $("#r_type").val();
		let r_capacity = $("#r_capacity").val();
		let r_price = $("#r_price").val();
		
		
		document.writeForm.action="${pageContext.request.contextPath }/admin/AdminRoomAddOk.ad?r_type="+r_type+"&r_capacity="+r_capacity+"&r_price="+r_price+"&imgName="+imgName;
		document.writeForm.submit();
	}
	
	
	$(".files").change(function(e){
		console.log(e.target.files);
		console.log(e.target.files[0]['name']);
		
		imgName = e.target.files[0]['name'];
		let file = e.target.files[0];
		let img = $(this).find("img");
		
		if(!file.type.match("image.*")){
			img.attr("src", "${pageContext.request.contextPath}/image/noimages.png")
		}else{
			let reader = new FileReader();
			reader.onload = function(e) {
				console.log(e.target.result);
				img.attr("src", e.target.result)
			}
			reader.readAsDataURL(file);
		}
		
	});
	
	function cancelFile(fileTagName) {
		$("input[name='"+ fileTagName +"']").val("");
		$("img#" +fileTagName + "Img").attr("src", "${pageContext.request.contextPath}/image/add.png");
	}
</script>
</html>



