<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String joinCd = (String)request.getAttribute("joinCode");
	String loginCd = (String)request.getAttribute("loginCode");
	if(joinCd == "join"){
		//메인페이지에 회원가입 페이지 끼워놓기
%>		

		<%@include file="join.jsp" %>
<%		
	}else{
		//원래 메인페이지 보이기
%>		
로그인코드 ----- >> [<%=loginCd %>] 
 
<% 
    	if(loginCd != null){
    		//board.jsp보여주기
%>
			<%@include file="Login.jsp" %>
<%
    	}
    	else{
    		//웰컴페이지
%>
    	<div class="col-sm-8 text-left"> 
	      <h1>Welcome</h1>
	    </div>
<%
    	}
%>
<%    
	}//if end
%>