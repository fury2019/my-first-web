<%@page import="com.Hotel.dao.member.JoinLoginDaoImpl"%>
<%@page import="com.Hotel.vo.MemberVO"%>
<%@page import="com.Hotel.dao.member.IJoinLoginDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String uId = request.getParameter("userId");
    System.out.println("아이디: " + uId);

    IJoinLoginDao dao = JoinLoginDaoImpl.getInstance();
    int count = dao.loginJSCheck(uId);
    
    if (count>0) {
%>
        {"rst":"no"}
<% 
    } else {
%>        
        {"rst":"ok"}
<%
    }
%>
