package com.Hotel.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.Hotel.dao.member.MemberUpdateDaoImpl;
import com.Hotel.dao.member.MyPageDaoImpl;
import com.Hotel.service.member.IMemberUpdateService;
import com.Hotel.service.member.IMyPageService;
import com.Hotel.service.member.MemberUpdateServiceImpl;
import com.Hotel.vo.MemberVO;

@WebServlet("/memberUpdate")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberUpdateServiceImpl memUpdate = new MemberUpdateServiceImpl();	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        MemberVO memVo = (MemberVO) session.getAttribute("loginCode");

        
        String memId = memVo.getMem_id();

        MemberUpdateDaoImpl dao = MemberUpdateDaoImpl.getInstance();
        MemberVO memberInfo = dao.getMemberInfo(memId);

        request.setAttribute("memberInfo", memberInfo);
        request.getRequestDispatcher("/jsp/MemberUpdate.jsp").forward(request, response);
       
        
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 사용자 세션에서 ID 가져오기 (로그인 사용자)
		HttpSession session = request.getSession();
        MemberVO loggedInMember = (MemberVO) session.getAttribute("loginCode");      
        String mem_id = loggedInMember.getMem_id();
        
        // 폼 데이터 가져오기
        String mem_pw = request.getParameter("mem_pw");
        String mem_tel = request.getParameter("mem_tel");
        String mem_post = request.getParameter("mem_post");
        String mem_addr1 = request.getParameter("mem_addr1");
        String mem_addr2 = request.getParameter("mem_addr2");

        // 데이터 매핑
        Map<String, Object> member = new HashMap<>();
        member.put("mem_id", mem_id);
        member.put("mem_pw", mem_pw);
        member.put("mem_tel", mem_tel);
        member.put("mem_post", mem_post);
        member.put("mem_addr1", mem_addr1);
        member.put("mem_addr2", mem_addr2);

        // 회원 정보 수정 서비스 호출
        boolean isUpdated = memUpdate.updateMember(member);

        // 결과 처리
        if (isUpdated) {
            // 성공: 마이페이지로 리다이렉트
            response.sendRedirect("MyPage.jsp");
        } else {
            // 실패: 에러 페이지 또는 수정 페이지로 리다이렉트
            response.sendRedirect("/memberUpdate");
        }
    }
	
	
	


}
