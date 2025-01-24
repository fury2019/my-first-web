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
<title>Shinna Hotel - 게시판</title>

    <!-- Favicon -->
    <link rel="icon" href="image/headicon.png">

    <!-- Stylesheet -->
        
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../inquiry/css/inquiry.css"> 
    <link rel="stylesheet" href="../inquiry/css/table.css">
    <link rel="stylesheet" href="../header.css">
        <link rel="stylesheet" href="../room/room.css">
</head>

<body>

<!--넘겨받음-->
	<c:set var="boardList" value="${requestScope.boardList }" />
	<c:set var="totalCnt" value="${requestScope.totalCnt }" />
	
	<c:set var="nowPage" value="${requestScope.nowPage }"/>
	<c:set var="totalPage" value="${requestScope.totalPage }"/>
	<c:set var="startPage" value="${requestScope.startPage }"/>
	<c:set var="endPage" value="${requestScope.endPage }"/>
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
							<div><a href="../inquiry/inquiry.jsp">문의하기</a></div><br>
							<div class="menuinfo"><a href="${pageContext.request.contextPath}/board/BoardList.bo">게시판</a></div>
						</div>
						<br>
						<div class="rooment">
                                <div class="roombtn">
                                    <a href="../inquiry/inquiry.jsp" style="color:white; border-radius=4px;">문의 글 작성</a>
                                </div>                               
                        </div>
						
<!-- 						<div style="text-align:center"> -->
<!-- 						<button type="button" class="btn roberto-btn mt-15" style="background-color: #524b42;"  onclick="location.href='/inquiry/inquiry.jsp'">문의글 작성</button> -->
<!-- 						</div> -->
					</div>
				</div>
			</div>
        
        
            <div class="col-12 col-lg-8">   
                
                <div style="text-align: center;margin-bottom: 50px;" ><a style="color: #524b42;font-size: 40px;">문의 목록</a></div>
                <div>
                    
                   
                       <div>
                            <span style="float:right;padding: 5px">글 개수 : ${totalCnt}개</span>
                        </div>
                   
                    <table class="member">
                        <tr align="center" valign="middle">
                            <th width="8%">번호</th>
                            <th width="50%">제목</th>
                            <th width="15%">작성자</th>
                            <th width="17%">날짜</th>
                            <th width="10%">조회수</th>
                        </tr>
                        <%-- 게시글 작성 --%>
						<c:choose>
							<%-- 게시글이 있는경우 --%>
							<c:when test="${boardList != null and fn:length(boardList) > 0 }">
							<c:forEach var="board" items="${boardList }">
                       <tr align="center" valign="middle" 
                      	    onmouseover="this.style.background='#bbdefb'"
							onmouseout="this.style.background=''">
                            <td height="23px">${board.b_number }</td>
                            <td height="23px"><a href="${pageContext.request.contextPath }/board/BoardView.bo?b_number=${board.b_number }">
									${board.b_title	 }
								</a>
								</td>
                            <td height="23px">${board.b_writer }</td>
                            <td height="23px">${board.b_date }</td>
                            <td height="23px">${board.b_readCnt }</td>
                        </tr>
                        </c:forEach>
				</c:when>
				<%-- 게시글이 없는경우 --%>
				<c:otherwise>
                        <tr style="height: 50px;">
                            <td colspan="5" style="text-align:center;" >등록된 게시물이 없습니다.</td>
                        </tr>   
                        </c:otherwise>
				</c:choose>                         
                    </table>
                    <br>
                    <!-- 페이징 처리 -->
                    <div style="border:0px; width:900px;text-align:center;">
                        <div>
                            <div>
                           		<c:if test="${nowPage > 1 }">
                                <a href="${pageContext.request.contextPath }/board/BoardList.bo?page=${nowPage - 1}" >[&lt;]</a>
                                </c:if>
                                <c:forEach var="i" begin="${startPage }" end="${endPage }">
									<c:choose>
							<%--현재 보고있는 페이지는 a tag 제거 --%>
										<c:when test="${i == nowPage }"> [${i }] </c:when>
										<c:otherwise>
		                                <a href="${pageContext.request.contextPath }/board/BoardList.bo?page=${i}" >[${i }]</a>
		                                
		                                </c:otherwise>
									</c:choose>
								</c:forEach>
					
								<c:if test="${nowPage < totalPage }">
                                <a href="${pageContext.request.contextPath }/board/BoardList.bo?page=${nowPage + 1}" >[&gt;]</a>
                               </c:if>
                            </div>
                        </div>
                    </div>
                    
                    <table style="border: 0px;width: 900px; ">
                        <tr align="center" valign="middle">
                           
                        </tr>
                    </table>
                </div>

                <!-- Leave A Reply -->
                
               
            </div>
                    
                   
                </div>

               
            </div>
        </div>
    
    <!-- Blog Area End -->
  
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