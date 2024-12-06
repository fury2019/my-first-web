package kr.or.ddit.basic.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.login.service.IMemberService;
import kr.or.ddit.login.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import java.io.IOException;


@WebServlet("/sessionLoginDB.do")
public class SessionLoginDB extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userid");
		String userPass = request.getParameter("userpass");
		
		System.out.println(userId);
		
		// id와 password를 VO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(userId);
		memVo.setMem_pass(userPass);
		
		//Service 객체 생성
		IMemberService service = MemberServiceImpl.getInstance();
		
		//DB에서 해당 회원정보 가져오기
		MemberVO loginMemberVO = service.getLoginMember(memVo);
		
		HttpSession session = request.getSession();
		
		// 로그인 성공 여부 확인  
		if(loginMemberVO!=null) {	// 로그인 성공
			// 세션에 로그인 한 회원의 회원 정보를 저장한다.
			session.setAttribute("loginMember", loginMemberVO);
			
		}
		
		response.sendRedirect(request.getContextPath()
				+ "/basic/sessiondb/sessionLoginDB.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
