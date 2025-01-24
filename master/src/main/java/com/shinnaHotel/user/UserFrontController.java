package com.shinnaHotel.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.action.ActionForward;

@WebServlet("*.us")
public class UserFrontController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doprocess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException, IOException {
		doprocess(req, resp);
	}
	
	
	protected void doprocess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String requestURI = req.getRequestURI();
		ActionForward forward = null;
		
		switch(requestURI) {
			// 회원가입 insert 요청
			case "/user/UserJoin.us" :
				forward = new UserJoinAction().execute(req, resp);
				break;
			// 로그인 요청
			case "/user/UserLoginOk.us" :
				forward = new UserLoginOkAction().execute(req, resp);
				break;
			// 내정보 관리 페이지 이동
			case "/user/userInfo.us" :
				forward = new UserInfoAction().execute(req, resp);
				break;
			// 내정보 관리 > 내정보 수정	
			case "/user/UserUpdate.us" :
				forward = new UserUpdateAction().execute(req, resp);
				break;
			// 내정보 관리 > 회원탈퇴
			case "/user/UserWithdraw.us" :
				forward = new UserWithdraw().execute(req, resp);
				break;
			// 내정보 관리 > 회원탈퇴 > 회원탈퇴 확인
			case "/user/UserWithdrawOk.us" :
				forward = new UserWithdrawOkAction().execute(req, resp);
				break;
				
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				// 리다이렉트 전송방식
				resp.sendRedirect(forward.getPath());
			}else {
				// forward 전송방식
				RequestDispatcher disp = req.getRequestDispatcher(forward.getPath());
				disp.forward(req, resp);
			}
	}
}
}