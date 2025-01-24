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
<title>Shinna Hotel - 문의하기</title>

    <!-- Favicon -->
    <link rel="icon" href="image/headicon.png">

    <!-- Stylesheet -->
        
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../inquiry/css/inquiry.css"> 
    <link rel="stylesheet" href="../header.css">
    <link rel="stylesheet" href="../room/room.css">
</head>

<body>
    <%@ include file="/header_footer/header.jsp" %>

    <!-- Breadcrumb Area Start -->
    <div class="breadcrumb-area bg-img bg-overlay jarallax" style="background-image: url(../image/grand.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcrumb-content text-center">
                        <h2 class="page-title">문의하기</h2>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb justify-content-center">
                                <li class="breadcrumb-item"><a href="../index.jsp">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page"><a href="../inquiry/inquiry.jsp">문의하기</a></li>                                
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Area End -->
<!-- Blog Area Start -->
    <div class="roberto-news-area section-padding-100-0">
        <div class="container">
            <div class="row justify-content-center">
            	
          	<div class="col-12 col-sm-8 col-md-6 col-lg-4">
	            <div class="roberto-sidebar-area pl-md-4">
	                <div class="single-widget-area mb-100">
	                    <div class="newsletter-form">
	                        <h5>문의 하기</h5>
	                        <div class="menuinfo">	                                                              
	                            <a href="../inquiry/inquiry.jsp">문의하기</a>                                    
	                        </div><br>
	                        <div>
	                            <a href="${pageContext.request.contextPath}/board/BoardList.bo">게시판</a>                         
	                        </div>                                
	                    </div>
	                    <br>                         
	                </div>                       
                </div>
            </div>
            
                <div class="col-12 col-lg-8">                       
                	<form action="${pageContext.request.contextPath}/board/BoardWriteOk.bo" method="post" name="boardForm" onsubmit="return formCheck();">
                		<div style="text-align: center;margin-bottom: 50px;" ><a style="color: #524b42;font-size: 40px;">문의하기</a></div>
                  	    <table style="width: 100%;table-layout: fixed;">
		                    <tr>
		                         <div class="col-12 col-lg-6 fadeInUp" data-wow-delay="100ms">
		                            이름 : <input type="text" name="b_writer" class="form-control mb-30" placeholder="이름을 입력하세요.">
		                        </div>
		                    </tr>
		                    <tr>
		                        <div class="col-12 col-lg-6 fadeInUp" data-wow-delay="100ms">
		                           제목 :  <input type="text" name="b_title" class="form-control mb-30" placeholder="제목을 입력하세요.">
		                        </div>
		                    </tr>
		                    <tr> &nbsp;&nbsp;&nbsp; 문의 내용 :
		                        <div class="col-12 fadeInUp" data-wow-delay="100ms">
		                            <textarea name="b_content" class="form-control mb-30 " placeholder="내용을 입력해주세요" rows="20"></textarea>
		                        </div>
		                    </tr>
		                    <tr>
		                        <div class="col-12 text-center fadeInUp" data-wow-delay="100ms">
		                            <button type="submit" class="btn roberto-btn mt-15" style="background-color: #524b42;">등록</button>
		                        </div>
		                    </tr>
		                </table>
              		</form>
                </div>

	       
            
        </div>
    </div>
    <!-- Blog Area End -->
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
    <script>
    
    function formCheck() {
        var b_title = document.forms[0].b_title.value;     
         // 사용하기 쉽도록 변수를 선언하여 담아주고,
        var b_writer = document.forms[0].b_writer.value;
        var b_content = document.forms[0].b_content.value; // 추가되었습니다. 글내용
        
        if (b_writer == null ||  b_writer  == ""){   
            alert('이름을 입력하세요'); 
            document.forms[0].b_writer.focus();            
            return false;               
        }
         
        if (b_title == null || b_title == ""){      // null인지 비교한 뒤
            alert('제목을 입력하세요');           // 경고창을 띄우고
            document.forms[0].b_title.focus();    // 해당태그에 포커스를 준뒤
            return false;                       // false를 리턴합니다.
        }
      
         
        // 글작성폼에 내용을 추가하였습니다. 게시판에 글내용은 당연히 있어야겠죠?
        // 추가할 html코드 : content : <textarea rows="10" cols="20" name="content"></textarea><br>
         
        if (b_content == null ||  b_content == ""){
            alert('내용을 입력하세요'); 
            document.forms[0].b_content.focus();
            return false;
        }
         
      
    }
    
    </script>

</body>

</html>

<style>
	@media only screen and (max-width: 767px){
	tr> div > textarea {
	width : auto;
	}}
</style>