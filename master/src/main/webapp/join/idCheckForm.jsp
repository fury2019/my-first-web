<%@page import="com.shinnaHotel.DAO.UsersDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String u_id = request.getParameter("u_id");
	UsersDAO udao = new UsersDAO();
	
	//	user.js -> 이곳으로 요청을주고 -> dao -> DB-> dao -> t/f -> 이곳 -> user.js
	if( !udao.idCheck(u_id) ){
		// 회원가입이 가능한 경우
		out.print("ok");
	} else {
		// 회원가입이 불가능한 경우
		out.print("not-ok");
	}
	

%>