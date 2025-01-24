<%@page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="icon" type="image/x-icon" href="/image/logo.png">
    
<style>
  @font-face {
    font-family: 'MinSans-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
</style>
<%
    MemberVO loggedInMember2 = (MemberVO) session.getAttribute("loginCode");

    if (loggedInMember2 != null) { // 로그인 상태 확인
        String gradeNo = loggedInMember2.getGrade_no(); // 등급 가져오기
        if ("Admin".equals(gradeNo)) { // 관리자 등급 확인
%>
            <a href="/AdminPage.jsp">관리페이지</a>
<%
        } else { // 일반 사용자
%>
            <a href="/MyPage.jsp">마이페이지</a>
<%
        }
    } else { // 로그인되지 않은 사용자
%>
        <a href="/jsp/Login.jsp">마이페이지</a>
<%
    }
%>
