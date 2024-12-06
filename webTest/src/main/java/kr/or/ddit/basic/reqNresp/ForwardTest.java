package kr.or.ddit.basic.reqNresp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/forwardTest.do")
public class ForwardTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	- forward
		특정 서블릿이나 JSP에 대한 요청을 다른 서블릿이나 JSP로 넘겨준다.
		(이때 HttpServletRequest객체와 HttpServletResponse객체를 공유한다.)
		클라이언트의 요청 URL은 처음 요청할 때의 값이 바뀌지 않는다.
		단, 서버 내부에서만 접근이 가능하다.
	 */
		
	/*
	 	이동하는 페이지로 값을 넘기려면 HttpServletRequest객체의 setAttribute()메서드로
	 	데이터를 셋팅하여 보내고 받는 쪽에서는 getAttribute()메서드로 데이터를 읽어온다.
	 	
	 	보낼 때 형식) Request객체.setAttribute("key값", 데이터);
	 			==> 'key값'은 문자열로 지정하고 '데이터'는 모든 자료형을 지정할 수 있다.
	 	
	 	받은 때 형식) Request객체.getAttribute"key값");
	 	
	 */
		request.setAttribute("tel", "010-1234-5678");
		
		
		
		// forward방식으로 다른 문서로 이동하기
		// ==> HttpServletRequest객체의 getRequestDipather()메서드에 이동할 서블릿이나
		//	   JSP를 지정해 주는데 전체 URI경로 중에서 ContextPath이후의 경로를 지정해준다.
		
		// 예) 이동하고 싶은 문서의 URI주소가 '/webTest/forwardTarget.do'이면 
		//     이 전체 주소중 ContextPath에 해당하는 '/webTest'를 생략한 부분을 지정해 준다.
		RequestDispatcher rd = request.getRequestDispatcher("/forwardTarget.do");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
