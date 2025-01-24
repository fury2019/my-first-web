<%@page import="com.Hotel.vo.NoticeVO"%>
<%@page import="com.Hotel.vo.FAQVO"%>
<%@page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8"/>
<title>공지사항 게시글 수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/FAQUpdate.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<script type="text/javascript">

$(function() {
    // 저장 버튼 클릭 시 확인 메시지
    $("#btnUpdate").on("submit", function(e) {
        if (!confirm("저장하시겠습니까?")) {
            e.preventDefault(); // 확인 취소 시 저장 중단
        }
    });

    // FAQ 목록 이동 버튼
    $("#btnList").on("click", function() {
        location.href = "<%=request.getContextPath()%>/noticeList";
    });
});

</script>
</head>

<body>
    <div class="layout">
        <div class="content">
            
				
					<% NoticeVO noticevo = (NoticeVO) request.getAttribute("noticeVo");
					if (noticevo != null) {%>
				
			
			
			<div class="faq-info">
				<h2>공지사항 게시글 수정</h2>
				<hr class="line">
				<form id="btnUpdate" method="post" action="<%=request.getContextPath()%>/noticeUpdate">
					<table class="table">

				   	<tr>
        			<th>게시물 번호</th>
        			<td><input type="text" name="notice_no" id="faq_no" value="<%=noticevo.getNotice_no()%>" required readonly></td>
    				</tr>
				
					<tr>
						<th class="faq-title">제목</th>
						<th><input type="text" name="notice_title" id="faq_title" value="<%=noticevo.getNotice_title()%>" required></th>
					</tr>
					<tr>
						<th class="faq-content">내용</th>
						<th><textarea name="notice_content" id="faq_content" required><%=noticevo.getNotice_content()%></textarea></th>
						 
					</tr>
					
					
					</table>


					<tbody>
   					<tr>
 				        <td>
				        <select name="class_id" id="class_id" required>
               				<option value="N_Hotel">호텔 운영 관련</option>
		                    <option value="N_Event">이벤트</option>
		                    <option value="N_Policy">고객 안전 및 정책</option>
		                    <option value="N_Other">기  타</option>
           				</select>
       					</td>  
   					</tr>
    				<tr>

        				<td colspan="2" style="text-align:center;">
            			<input type="submit" value="저장"> 
            			<input type="reset" value="초기화">
    				</tr>
					</tbody>
			
			</form> <% } else { out.println("<p>공지사항 정보를 불러올 수 없습니다.</p>"); } 	%>

        	</div>
        </div>
    </div>
    
</body>
</html>




