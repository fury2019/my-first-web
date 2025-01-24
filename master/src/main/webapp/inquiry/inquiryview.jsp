<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
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
        
    <link rel="stylesheet" href="../inquiry/css/inquiry.css"> 
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../header.css">
    <link rel="stylesheet" href="../room/room.css">
</head>

<body>
    <%@ include file="/header_footer/header.jsp" %>
    <c:set var="board" value="${requestScope.board}"/>
	<c:set var="replylist" value="${requestScope.commentlist}"/>

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
		                        <div style="margin-top:15px;">                                                            
		                            <a href="../inquiry/inquiry.jsp">문의 글 쓰기</a>                                    
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
                    
                    <div style="text-align: center;margin-bottom: 50px;" ><a style="color: #524b42;font-size: 40px;">문의하기</a></div>
                    <table style="width: 100%;table-layout: fixed;border:1px solid gray;">
                   
                        <tr height="30px;">                        	
                            <th align="center" width="20%">제목</th>
                            <td>
                             ${board.b_title }
                                <span style="font-weight: bold; color: #524b42;float: right;margin-right:10px;">
                                조회수 : ${board. b_readCnt }
                                </span>
                            </td>
                        </tr>
                        <tr height="30px;">
                            <th align="center" width="20%" >글쓴이</th>
                            <td>  ${board.b_writer}     </td>                         
                            
                        </tr>
                        <tr height="300px;">
                            <th align="center" width="20%">내용</th>
                            <td  valign="top" style="padding: 10px;"> ${board.b_content}  </td>                        
                            
                        </tr>                        
                    </table>                    
                	<div class="rooment">
                        	<div class="roombtn">
									 <a href="${pageContext.request.contextPath}/board/BoardList.bo" style="color: white;">[목록]</a>
							</div>
                  	</div>
                    
                    <!-- 댓글 -->
                    <hr>
                      <c:if test="${u_id !=null }">
                      <%  if(u_id.equals("admin")) { %> 
                    <form action="${pageContext.request.contextPath}/board/AddComment.bo" name="commentForm" method ="post" >
                        <input type="hidden" name="b_number" value="${board.b_number }" >
                        <table style="width: 100%;height:auto;">
                            <tr>
                                <th align="center" width="20%" >
                                    댓글 <br>
                                   
                                </th>				
                                <td style="padding-left:10px;width: 100%;" >
                                    <textarea style="border:none;resize: none;width:100%" name="c_comment" ></textarea><br>
                                    <div class="rooment" style="margin-right:85%">
	                                    <div class="roombtn">
										 <a href="javascript:document.commentForm.submit()" style="color: white;">[등록]</a>
										</div>	
                                    </div>
                                </td>
                            </tr>								
                        </table>     
                        
                        <% } %>
                        </c:if>
                                           
                        <hr>
                       <div style="text-align: left;margin-bottom: 10px;" ><a style="color: #524b42;font-size:20px;font-weight:500">댓글목록</a></div>
                        <table style="width: 100%;">
                        <c:choose>
					<c:when test="${commentlist != null and fn:length(commentlist) > 0 }">
						<c:forEach var="comment" items="${commentlist }">
                            <tr>
                                <th align="center" width="20%" > 게시판 관리자 </th>
                                    <td valign="top" style="padding-left: 10px;">
                                        <textarea id="comment${comment.c_number }" name="comment${comment.c_number }" 
                                        style="text-align: left; border: none;width: 60%;height: 85px;resize: none;" readonly>${comment.c_comment}</textarea><br>
                                        <div style="display: inline-block;width:100%;">
	                                        <div class="rooment" style="float: left;">
	                                        
	                                        <c:if test="${u_id !=null }">
	                                      <%  if(u_id.equals("admin")) { %> 
			                                    <div class="roombtn">
												 	<a href="javascript:updateReadonlycomment(${comment.c_number });" style="color: white;">[수정하기]</a>
												</div>	
	                                 	  	</div>
	                                 	  	
	                                 	  	<div class="rooment" style="float: left;">
			                                	<div class="roombtn">
										 			<a href="javascript:updatecomment( ${comment.c_number });" style="color: white;">[수정 완료]</a>
											 	</div>	
	                                 	  	</div>
	                                 	  	
											<div class="rooment" style="float: left;">
			                                    <div class="roombtn">
												 	<a href="javascript:deletecomment(${comment.c_number })" style="color: white;">[삭제]</a>		
											 	</div>	
	                                 	  	</div>									 
                                        </div>
                                                <td align="center" width="20%" >${comment.c_date }</td>					
                                            </td>				
                                        </tr>  
                                        <% } %>
                                         </c:if> 
                                         
                                        </c:forEach>
									</c:when>
								<c:otherwise>                                 
                                    <tr>
                                        <td align="center">댓글이 없습니다.</td>
                                    </tr>
                                    </c:otherwise>
							</c:choose>	
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

</body>

<script>
	function deletecomment( c_number){
		
			document.commentForm.action = "${pageContext.request.contextPath}/board/DeleteComment.bo?c_number=" + c_number; 		
			document.commentForm.submit();
		
		
	}
	
	function updatecomment( c_number){
	
			// 댓글 수정 가능
			document.commentForm.action = "${pageContext.request.contextPath}/board/UpdateComment.bo?c_number=" + c_number; 		
			document.commentForm.submit();
		
	}
	
	function updateReadonlycomment( c_number ){
		document.getElementById('comment' + c_number).readOnly = false;
	}
	
	
</script>

</html>

<style>
	tr , th, td{
	border: 1px solid;
	padding: 8px;
	}
	
	th{
	background-color: #f1e3c4;
	font-weight: 900;
	text-align:center;
	}
	
	.roombtn{
	margin: 10px;
	height: auto;
	line-height: 30px;
	width: 56px
	display: block;
	}
	table{
	box-shadow: 0 2px 15px 13px rgb(15 15 15 / 15%);
	}
</style>