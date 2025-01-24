<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Shinna Hotel - 내 정보 관리</title>
    <link rel="icon" href="../image/headicon.png">
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../header.css">
    <link rel="stylesheet" href="../room/room.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>

    <%@ include file="/header_footer/header.jsp" %>
 
 	<c:set var="userInfo" value="${requestScope.userInfo }" />
  
    <div class="breadcrumb-area bg-img bg-overlay jarallax" style="background-image: url(../image/R0000001PC6L_KR.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcrumb-content text-center">
                        <h2 class="page-title">내 정보 관리</h2>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb justify-content-center">
                                <li class="breadcrumb-item"><a href="../index.jsp">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath }/user/userInfo.us">내 정보</a></li>
                                <li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath }/user/userInfo.us">내 정보 관리</a></li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
 

    <div class="roberto-news-area section-padding-100-0">
        <div class="container">
            <div class="row justify-content-center">
            	
                <%-- 사이드 바 --%>
                <div class="col-12 col-sm-8 col-md-6 col-lg-3">
                    <div class="roberto-sidebar-area pl-md-4">
                        <div class="single-widget-area mb-100">
                            <div class="newsletter-form">
                                <h5>내 정보</h5>
                                <div class="menuinfo">
                                    <a href="${pageContext.request.contextPath }/user/userInfo.us">내 정보 관리</a>                                    
                                </div><br>
                                <div>
                                    <a href="${pageContext.request.contextPath }/reservation/ReservationSelect.re">예약 내역</a>
                                </div>                               
                            </div>                            
                        </div>                        
                    </div>
                    <%-- 사이드 바 --%>
		        </div>

                    <%-- 본문--%>
                <div class="col-12 col-lg-8">
                    <h2 style="text-align: center;height: 50px;"><span style="color: black;padding: 10px;font-weight: 800;">내 정보 관리</span></h2>
                    <div class="post-thumbnail mb-50">
                        <div>
                    <form action="" method="post" name="userupdate">
                    	<c:choose>
                               	<c:when test="${userInfo != null and fn:length(userInfo) > 0 }">
                               	<c:forEach var="info" items="${userInfo}">      
                            <table class="table-b">
                            	<colgroup>
                            		<col width= "250px">
                            		<col width= "250x">
                            	</colgroup>                                                        	
                            	<tbody>
	                           		<tr>
		                           		<th class="trth">ID</th>
		                           		<td><input type="text" value="${info.u_id }" readonly></td>
                                    </tr>
                                    <tr>
	                                    <th class="trth">이름</th>
		                              	<td><input type="text" class="edit" name="u_name" value="${info.u_name }" readonly></td>
                                    </tr>	                                   
                                    <tr>
	                                    <th class="trth">비밀번호</th>
		                                <td><input type="password" class="edit" name="u_password" value="${info.u_password }" readonly></td>
	                                </tr>
                                    <tr>
	                                    <th class="trth">핸드폰번호</th>
		                                <td><input type="text" class="edit" name="u_phone" value="${info.u_phone }" readonly></td>
	                                </tr>
                                    <tr>
	                                    <th class="trth">이메일</th>
		                                <td><input type="text" class="edit" name="u_email" value="${info.u_email }" readonly></td>
	                                </tr>
                                 
                                </tbody>
                                
                            </table>
                            <div style="text-align: center; line-height: 50px;">
									<input type="hidden" id="changeedit" class="change" onclick="useredit('${info.u_password }','${info.u_id }');" value="수정 완료">
									</div>
									</c:forEach>
                                </c:when>
                                </c:choose>							
                        </form>
                       </div>  
                           
                            <hr>
							
								
                        </div>
							<div style="text-align: center; line-height: 50px;">
								<div>
									<input type="button" id="change" class="change" onclick="change()" value="수정하기">
									<a href="${pageContext.request.contextPath }/user/UserWithdraw.us" class="change" >회원탈퇴</a>
								</div>
							</div>
                        </div>
                    </div>
                </div>

                    
                    <div class="comment_area mb-50 clearfix">                        
                        
                    </div>

                  
                   
            </div>

     
 
    
    <%@ include file="/header_footer/footer.jsp" %>

    
    
    <script src="../js/jquery.min.js"></script>
    
    <script src="../js/popper.min.js"></script>
    
    <script src="../js/bootstrap.min.js"></script>
    
    <script src="../js/roberto.bundle.js"></script>
    
    <script src="../js/default-assets/active.js"></script>
    
</body>


<script>
function change(){
	$('#change').replaceWith('<input type="button" id="changere" class="change" onclick="changere()" value="취소">');
	$('.edit').attr("readonly", false);
	$('#changeedit').attr("type","button");
};

function changere(){
    $('#changere').replaceWith('<input type="button" id="change" class="change" onclick="change()" value="수정하기">');
    $('#changeedit').attr("type","hidden");
    location.href="${pageContext.request.contextPath }/user/userInfo.us";
    
};

function useredit(u_password, u_id){
	let pw = prompt("비밀번호를 입력하세요");
	
	if ( pw == u_password ){
		document.userupdate.action = "${pageContext.request.contextPath }/user/UserUpdate.us?u_id="+u_id;
		document.userupdate.submit();
	} else {
		alert("비밀번호가 일치하지 않습니다.");
	}
	
}

</script>


<style>
.table-b {
width:100%;
box-shadow: 0 2px 40px 8px rgb(15 15 15 / 15%);
}
 .table-b .trth{
background-color: #f1e3c4; 
 }
 
 .table-b tr, th {
 border: none;
 }
  input{
  border : none;
  }
 
 .table-b td {
 background-color: white;
 }
.change{
 	display: inline-block;  
	background-color: #524b42; 
  	width: 100px;  
 	 height: 50px; 
 	 color : white; 
	margin:20px;
 } 
 .change:hover{
 		font-weight: 500;
    -webkit-box-shadow: 0 2px 40px 8px rgb(15 15 15 / 15%);
    box-shadow: 0 2px 40px 8px rgb(15 15 15 / 15%);
    background-color: #7c4949;
    color: white;
 }

</style>

</html>