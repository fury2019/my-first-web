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
    <title>Shinna Hotel - 회원 탈퇴</title>
    <link rel="icon" href="../image/headicon.png">
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../header.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>

    <%@ include file="/header_footer/header.jsp" %>
    <c:set var="exist" value="${sessionScope.exist}"/>	
    
    <div class="breadcrumb-area bg-img bg-overlay jarallax" style="background-image: url(../image/제주프리미어.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcrumb-content text-center">
                        <h2 class="page-title">내 정보 관리</h2>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb justify-content-center">
                                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">내 정보</li>
                                <li class="breadcrumb-item active" aria-current="page">내 정보 관리</li>
                                <li class="breadcrumb-item active" aria-current="page">회원탈퇴</li>
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
                                <h4 style="margin-bottom: 30px;font-weight: bold">내 정보</h4>
                                <div style="background-color:#524b42;text-align: center;">
                                    <a href="${pageContext.request.contextPath }/user/userInfo.us" style="color: white;">내 정보 관리</a>                                    
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
                    <h2 style="text-align: center;height: 50px;"><span style="background-color: #524b42;color: white;padding: 10px;">회원 탈퇴</span></h2>
                    <div class="post-thumbnail mb-50">
                       
                    		<p style="padding : 50px 20px;text-align:center;">
                    		  정말로 탈퇴하시겠습니까?
                    		  <br>
                    		  탈퇴 후 예약 내역과 회원 정보는 조회 할 수 없습니다.   
                    		                  		  
                    		</p>
                       
                           
                            <hr>
							
								
                        </div>
							<div style="text-align: center; line-height: 50px;">
								<div>
									<input type="button" id="change" class="change" onclick="withdraw('${exist }')" value="탈퇴하기">
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

function withdraw(exist){
	
	if ( exist == "true" ){
		alert("예약 내역이 존재하여 탈퇴 할 수 없습니다. \n 예약 내역 페이지로 이동합니다.");
		location.href="${pageContext.request.contextPath }/reservation/ReservationSelect.re"
	} else { 
		alert("회원 탈퇴되었습니다.")
		location.href="/user/UserWithdrawOk.us"
	}
	
}

</script>


<style>
table{
display: inline-block;
text-align: center;
width: 600px;
font-size: 20px;
margin: 50px 1px 50px;
}
thead{
    display: inline-block;
    background-color:  #f1e3c4;
    float: left;
    margin-left: 50px;
    padding: 10px 50px;
  
}

tbody{
    display:inline-block;
    padding: 10px 50px;
    
}

tr{
   height: 50px;
}

th,td{display:block
    back
}
input{
	border:none;
}
.change{
 	display: inline-block;  
	background-color: #524b42; 
  	width: 100px;  
 	 height: 50px; 
 	 color : white; 
	margin:20px;
 } 

</style>

</html>