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
    <title>Shinna Hotel - 회원가입</title>

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
     <div class="breadcrumb-area bg-img bg-overlay jarallax" style="background-image: url(../image/제주프리미어.jpg);">
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
    <br>																		
    <form action="/user/UserJoin.us" method="post" id="myform" class="login-form" onclick="sendit();">             
        <p>        
            <div>이름</div> <input type="text"  name="u_name"  placeholder="이름을 입력하세요">                
        </p>
        
        <p id="text">아이디를 입력해 주세요</p>
        <p>
            <div>ID</div> <input type="text"  name="u_id"  placeholder="ID를 입력하세요">
      		<input type="button"  onclick="idCheck(myform.u_id.value);" value="중복체크">
        </p> 
        
        <p>
            <div>비밀번호</div> <input type="password"  name="u_password"   placeholder="비밀번호를 입력하세요">                
        </p> 
        <p>
            <div>비밀번호 확인</div> <input type="password"  name="u_password2"   placeholder="비밀번호를 확인해주세요">                
        </p>
        <p>
            <div>휴대폰 번호</div> <input type="tel"  name="u_phone"   placeholder="휴대폰 번호를 입력하세요.(- 없이 숫자만)"> 
        </p> 
        <p>
            <div>이메일</div> <input type="text"  name="u_email"  placeholder="이메일을 입력하세요.">                
        </p>                      
            <input type="submit" value="회원가입" >               
    </form>
   
</div>

<br>

<%@ include file="/header_footer/footer.jsp" %>

<script type="text/javascript">  // 회원가입 버튼 클릭시 유효성 검사 
// 	function idCheck(){
// 		alert("idCheck!");
// 		window.open("idCheckForm.jsp", "idwin", "width=400, height=350");
// }
    // 폼에 있는 변수를 가져옴	
    var f = document.getElementById("myform");
    
function sendit(){
    let usertxt = document.getElementById('text').innerHTML;
	
    if(usertxt == "중복된 아이디입니다."){
		alert("중복된 아이디입니다. 아이디를 확인해주세요");
		userid.focus();
		return false;
	}
    frm.submit();
}
    
    
    function idCheck(u_id){
    	if( u_id == "" ){
    		alert("아이디를 입력해주세요.");
    	} else {
    		// 중복처리, ajax
    		
    		let xhr = new XMLHttpRequest();
    		xhr.open("GET", "idCheckForm.jsp?u_id="+ u_id, true);		
    		xhr.send();
    		xhr.onreadystatechange = function(){
    			if( xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200 ){
    				//alert( xhr.responseText );
    				
    				if( xhr.responseText.trim() == "ok" ){
    					document.getElementById("text").innerHTML = "사용할 수 있는 아이디입니다.";
    				} else {
    					document.getElementById("text").innerHTML = "중복된 아이디입니다.";
    				}
    				
    			}
    		}	
    	}
    }
    
    

    
    
    
    
    f.addEventListener("submit" , function(e) {
         // ================ 이름 유효성검사 ================ // 	
         // 입력창에 값이 없을 경우 alert 발생
    	if(f.u_name.value.length == 0 ) {
       	 	alert("이름을 입력하세요");
        	e.preventDefault();  // submit(회원가입버튼) 눌렀을 때 값이 틀릴 경우 진행 불가
        	f.u_name.focus();
       		 return;
      	}
        // 이름 유효성 검사 정규식
    	var n_RegExp = /^[가-힣]{2,15}$/; 
         // 이름에 특수문자,영어, 숫자 사용 불가
        if(!n_RegExp.test(f.u_name.value)) {
       	 	alert("특수문자,영어,숫자는 사용할수 없습니다. 한글만 입력하여주세요.");
        	e.preventDefault();
        	f.u_name.focus();
       		 return;
      	} 
         
    	// ================ ID 유효성검사 ================ //  
    	// 입력창에 값이 없을 경우 alert 발생
    	if(f.u_id.value.length == 0 ) {
       	 	alert("ID를 입력하세요");
        	e.preventDefault();
        	f.u_id.focus();
       		 return;
    	}
    	
    	if(f.u_id.value.length == 0 ) {
       	 	alert("ID를 입력하세요");
        	e.preventDefault();
        	f.u_id.focus();
       		 return;
    	}

    	// 아이디 중복체크!!!!!!!!!!!!!!!!
//     	if(f.chk.value != "idCheck"){
//     		alert("아이디중복체크해주세요");
//         	e.preventDefault();
//     		return;
//     	}
    	
   		//id와 pwassword 유효성 검사 정규식
		var RegExp = /^[a-zA-Z0-9]{4,12}$/;
		
		// 아이디 형식이 잘못되었을 경우 alert 발생
    	if(!RegExp.test(f.u_id.value)) {
       	 	alert("ID는 4~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");
        	f.u_id.focus();
        	e.preventDefault();
       		 return;
    	}
    	
    	// ================ Password 유효성검사 ================ //  
    	// 입력창에 값이 없을 경우 alert 발생
    	if(f.u_password.value.length == 0 ) {
       	 	alert("비밀번호를 입력하세요");
        	e.preventDefault();
        	f.u_password.focus();
       		 return;
    	}
    	
    	//pwassword 유효성 검사 정규식
		var RegExp2 = /^[a-zA-Z0-9]{4,12}$/;
    	
		// 비밀번호 형식이 잘못되었을 경우 alert 발생
     	if(!RegExp2.test(f.u_password.value)){ 
            alert("비밀번호는 4~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");
            e.preventDefault();
            f.u_password.focus();
       		 return;
   	 	}	
    	
    	// ================ Password확인 유효성검사 ================ // 
    	// 입력창에 값이 없을 경우 alert 발생
    	if(f.u_password2.value.length == 0 ) {
       	 	alert("비밀번호 확인창을 입력하세요");
        	e.preventDefault();
        	f.u_password2.focus();
       		 return;
    	}
    	// 비밀번호와 비밀번호 확인이 서로 다른 값일 경우 alert 발생
    	if(f.u_password2.value!=f.u_password.value){ //비밀번호와 비밀번호확인이 동일한지 검사
            alert("비밀번호가 틀립니다. 다시 확인하여 입력해주세요.");
            e.preventDefault();
            f.u_password.focus();
       		 return;
        }
    	
    	// ================ 휴대폰 유효성검사 ================ //  
    	// 입력창에 값이 없을 경우 alert 발생
    	if(f.u_phone.value.length == 0 ) {
       	 	alert("휴대폰 번호를 입력하세요");
        	e.preventDefault();
        	f.u_phone.focus();
       		 return;
    	}
    	// - 없는 형식의 전화번호 (010 + 8자리 숫자)
        var patternPhone = /(01[016789])([1-9]{1}[0-9]{2,3})([0-9]{4})$/; 

      	if(!patternPhone.test(f.u_phone.value)){ 
         alert("핸드폰 번호를 확인 해주세요.(010XXXXXXXX)");
         e.preventDefault();
         f.u_phone.focus();
         return;
     }
 
    	// ================ 이메일 유효성검사 ================ //  
    	// 입력창에 값이 없을 경우 alert 발생
    	if(f.u_email.value.length == 0 ) {
       	 	alert("이메일을 입력하세요");
        	e.preventDefault();
        	f.u_email.focus();
       		 return;
    	}	 
   		 //이메일 유효성검사
        var e_RegExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
        // 올바른 이메일 형식이 아니라면 alert
        if(!e_RegExp.test(f.u_email.value)){
            alert("올바른 이메일 형식이 아닙니다.");
            e.preventDefault();
            f.u_email.focus();
       		 return;
        }
    });
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