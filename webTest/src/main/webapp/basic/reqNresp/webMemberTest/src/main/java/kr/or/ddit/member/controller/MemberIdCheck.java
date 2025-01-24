package kr.or.ddit.member.controller;

import java.io.IOException;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;


@WebServlet("/member/memberIdCheck.do")
public class MemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		// 검색할 회원ID를 받는다.
		String memId = request.getParameter("mem_id");
		
		IMemberService service = MemberServiceImpl.getInstance();
		int cnt = service.getMemberCount(memId);
		
		Gson gson = new Gson();
		String result = null;  // 결과가 JSON으로 저장될 변수
		
		if(cnt>0) {  // 회원ID가 중복
			result = gson.toJson("Fail");
		}else {		// 회원ID가 중복되지 않음
			result = gson.toJson("OK");
		}
		
		response.getWriter().write(result);
		response.flushBuffer();
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
