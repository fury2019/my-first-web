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

    <!-- Title -->
    <title>Shinna Hotel - 로그인</title>

    <!-- Favicon -->
    <link rel="icon" href="../image/headicon.png">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../header.css">
   
    <link rel="stylesheet" href="../join/css/login.css">
</head>

<body>
    <%@ include file="/header_footer/header.jsp" %>

		 <c:if test="${!empty param.flag }">
	 		<c:if test="${!param.flag }">
	 		<script>
	 			alert("로그인 실패");
	 		</script>
	 		</c:if>
	 	</c:if>
	
    <!-- Breadcrumb Area Start -->
    <div class="breadcrumb-area bg-img bg-overlay jarallax" style="background-image: url(../image/제주프리미어.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcrumb-content text-center">
                        <h2 class="page-title">로그인</h2>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb justify-content-center">
                                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">로그인</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <div style="margin: auto; " class="login-wrapper">
        <h2>로그인</h2>
         사이트에 오신 것을 환영합니다. <br>
         로그인 아이디와 비밀번호를 입력해 주시기 바랍니다.
        <br>
<%--         action="${pageContext.request.contextPath}/user/UserLoginOk.us" --%>
	        <form method="post"  name="myform" class="login-form">                            
	            아이디
	            <input type="text" name="u_id" placeholder="아이디를 입력하세요">
	            비밀번호
	            <input type="password" name="u_password" placeholder="비밀번호를 입력하세요">                
<!--                 <label for="remember-check"> -->
<!--                     <input type="checkbox">아이디 저장하기 -->
<!--                 </label> -->
                    <input type="submit" onclick="sendit()" value="로그인"> 
                    <input type="button" value="회원가입" onclick="location.href='/join/join.jsp'">               
	        </form>

	 
	 		
	 		
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>	 

<div style="display:inline-block">
<ul>
	<li onclick="kakaoLogin();">
   <a id="kakao-login-btn" href="javascript:loginWithKakao()">
  <img src="../image/카카오이미지1.png" alt="카카오 로그인 버튼" />
</a>
	</li>
	
</ul>
</div>
<!-- <div style="display:inline-block;"> -->
<!-- 	<li onclick="kakaoLogout();"> -->
<!--       <a href="javascript:void(0)"> -->
<!--           <span>카카오 로그아웃</span> -->
<!--       </a> -->
<!-- 	</li> -->
<!-- </div> -->
<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('6fe3352539eb33c1a5aeefa1c717ba84'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단

//카카오로그인 (도메인에 등록한 카카오 로그인 버튼 클릭시 카카오 아이디로 로그인)
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  location.href="${pageContext.request.contextPath}/user/UserLoginOk.us?u_id=test&u_password=1234"
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
  
//카카오로그아웃 (클릭시 카카오톡 로그아웃)
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>
<div style="margin-top:10px;">
<ul>
	<li>
      <!-- 아래와같이 아이디를 꼭 써준다. -->
     	<a id="naverIdLogin_loginButton" href="#">
		<img src="https://static.nid.naver.com/oauth/big_g.PNG?version=js-2.0.1" height="55" width="auto">
	</a>
	</li>
<!-- 	<li onclick="naverLogout(); return false;"> -->
<!--       <a href="javascript:void(0)"> -->
<!--           <span>네이버 로그아웃</span> -->
<!--       </a> -->
<!-- 	</li> -->
</ul>
</div>
<!-- 네이버 스크립트 -->
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>

<script>

var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "dWAS6NvLyiwViWuAVRwy", //내 애플리케이션 정보에 cliendId를 입력해줍니다. (네이버 디벨로퍼 가입)
			callbackUrl: "http://localhost:8081/login/naverlogin.jsp", // Callback URL 을 입력해줍니다. (로그인 성공후 이동할 주소)
// 			callbackUrl: "${pageContext.request.contextPath}/user/UserLoginOk.us?u_id=test&u_password=1234", // Callback URL 을 입력해줍니다. (로그인 성공후 이동할 주소)
			isPopup: false,
			callbackHandle: true
		}
	);	

naverLogin.init();

window.addEventListener('load', function () {
	naverLogin.getLoginStatus(function (status) {
		if (status) {
			var email = naverLogin.user.getEmail(); // 필수로 설정할것을 받아와 아래처럼 조건문을 줍니다. (일단 이메일 한개만 지정함)
    		
			console.log(naverLogin.user); 
    		
            if( email == undefined || email == null) {
				alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
				naverLogin.reprompt();
				return;
			}
		} else {
			console.log("callback 처리에 실패하였습니다.");
		}
	});
});


var testPopUp;
function openPopUp() {
    testPopUp= window.open("https://nid.naver.com/nidlogin.logout", "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,width=1,height=1");
}
function closePopUp(){
    testPopUp.close();
}

function naverLogout() {
	openPopUp();
	setTimeout(function() {
		closePopUp();
		}, 1000);
}
</script>

    </div>

    <br>
   

 <%@ include file="/header_footer/footer.jsp" %>

    <script type="text/javascript"> // 로그인 버튼 클릭시 유효성 검사
    // 폼에 있는 변수를 가져옴	
//     f.addEventListener("submit" , function(e) {
		
//     	// ================ ID 유효성검사 ================ //  
//     	// 입력창에 값이 없을 경우 alert 발생
//     	if(f.u_id.value.length == 0 ) {
//        	 	alert("ID를 입력하세요");
//         	e.preventDefault();
//         	f.u_id.focus();
//        		 return;
//     	}
    	
//     	// ================ Password 유효성검사 ================ //  
//     	// 입력창에 값이 없을 경우 alert 발생
//     	if(f.u_password.value.length == 0 ) {
//        	 	alert("비밀번호를 입력하세요");
//         	e.preventDefault();
//         	f.u_password.focus();
//        		 return;
//     	}
//     });
    

    function sendit(){
	
		 let frm = document.myform;
    	 let userid = frm.u_id;
    	 let userpw = frm.u_password;

    	 
    	 if(!userid.value){
    	    alert("아이디를 입력하세요");
    	    userid.focus();
    	    return false;
    	}

    	if(!userpw.value){
    	    alert("비밀번호를 입력하세요");
    	    userpw.focus();
    	    return false;
    	}
    	document.myform.action="${pageContext.request.contextPath}/user/UserLoginOk.us"
    	}
    
    
  </script>
 
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

