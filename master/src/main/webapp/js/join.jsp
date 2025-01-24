<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title -->
    <title>Shinna Hotel</title>

    <!-- Favicon -->
    <link rel="icon" href="../image/headicon.png">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../header.css">   
    <link rel="stylesheet" href="../join/css/login.css">
</head>
<body>
     <%@ include file="/header_footer/header.jsp" %>
     
     <!-- Breadcrumb Area Start -->
     <div class="breadcrumb-area bg-img bg-overlay jarallax">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcrumb-content text-center">
                        <h2 class="page-title">회원가입</h2>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb justify-content-center">
                                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">회원가입</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
 <!-- 헤더 끝-->
 <br>
 
 <div style="margin: auto; " class="login-wrapper">
    <h2>회원가입</h2>
     회원 정보 입력
    <br>																		<!-- 유효성 검사 결과 리턴-->
    <form action="/user/UserJoin.us" method="post" class="login-form" onsubmit="return sendit();">                            
        <p>        
            <div>이름</div> <input type="text"  name="u_name"  placeholder="이름을 입력하세요">                
        </p>
        <p>
            <div>ID</div> <input type="text"  name="u_id"  placeholder="ID를 입력하세요">
        </p> 
        <p>
            <div>비밀번호</div> <input type="password"  name="u_password"   placeholder="비밀번호를 입력하세요">                
        </p> 
        <p>
            <div>비밀번호 확인</div> <input type="password"  name="u_password2"   placeholder="비밀번호를 확인해주세요">                
        </p>
        <p>
            <div>휴대폰 번호</div> <input type="text"  name="u_phone"   placeholder="휴대폰 번호를 입력하세요.">                
        </p> 
        <p>
            <div>이메일</div> <input type="text"  name="u_email"  placeholder="이메일을 입력하세요.">                
        </p>                      
            <input type="submit" value="회원가입">               
    </form>
   	<script>
		const login-form = document.login-form
	
		function sendit() {
			// 이름이 입력되지 않았다면
			const u_name = login-form.u_name
			if (u_name.value == "") {
				alert("이름을 입력해주세요") // alert 으로 경고
				u_id.focus();    // 아이디 입력창으로 포커스
				return false;
		  }
		}
	</script>
</div>

<br>

<%@ include file="/header_footer/footer.jsp" %>

<!-- **** All JS Files ***** -->
<!-- jQuery 2.2.4 -->
<script src="../js/jquery.min.js"></script>
<!-- Popper -->
<script src="../js/popper.min.js"></script>
<!-- Bootstrap -->
<script src="../js/bootstrap.min.js"></script>
<!-- All Plugins -->
<script src="../js/roberto.bundle.js"></script>
<!-- Active -->
<script src="../js/default-assets/active.js"></script>
</body>
</html>