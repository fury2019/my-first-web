package kr.or.ddit.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.print.DocFlavor.STRING;

/*
 	서블릿의 동작 과정(LifeCycle)
 	1. 사용자(클라이언트)가 URL을 클릭하면 HTTP 요청을 Servlet Container로 전송한다.
 	2. 컨테이너는 web.xml에 정의된 url패턴을 확인하여 어느 서블릿을 통해서 처리할 지를 검색한다.
 	 	(로딩이 안된 경우에는 로딩을 한다. 처음 로딩시 init()메서드가 호출된다.)
 		(서블릿 버전 3.0이상에서는 애노테이션 (@WebServlet)으로 설정할 수 있다.)
 	3. 컨테이너는 개별 요청을 처리할 쓰레드를 생성하여 해당 서블릿 객체의 service()메서드를 호출한다.
 		(이 때 HttpServletRequest객체 및 HttpServletResponse객체를 생성하여 매개변수로 넘겨준다.)
 	4. service()메서드는 전송방식 (GET, POST등)을 체크해서 적절한 메서드를 호출한다.
 		( doGet(), doPost(), doPut(), doDelete() 등)
 	5. 요청 및 응답 처리가 모두 완료되면 HttpServletRequest객체와 HttpServletResponse객체는 자동으로 소멸된다.
 	6. 컨테이너에서 서블릿이 제거되는 경우에는 destroy()메서드가 호출된다.
 	
 */

// 서블릿의 LifeCycle예제
@WebServlet("/servletTest03.do")
public class ServletTest03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException{
		System.out.println(this.getServletName() + "에서 init()메서드 호출");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service()메서드 실행 중");
		
		// GET방식과 POST방식에 맞는 메서드 호출하기
		
		// 방법1 ==> 부모 클래스인 HttpServlet의 service()메서드로 위임하는 방법
//		super.service(request, response);
		
		// 방법2 ==> 클라이언트의 전송 방식(GET, POST등)을 구분해서
		// 			직접 메서드를 호출하는 방법
		// HttpServletRequest객체의 getMethod()메서드를 이용하여 구할 수 있다.
		String method = request.getMethod();
		System.out.println("method = " + method);
		
		if("GET".equals(method)) {
			doGet(request, response);
		}else {
			doPost(request, response);
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()메서드 실행");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'></head>"
				+ "<body><h2 style='color:blue;'>doGet()메서드를 처리한 결과입니다.</h2></body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()메서드 실행");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'></head>"
				+ "<body><h2 style='color:red;'>doPost()메서드를 처리한 결과입니다.</h2></body></html>");
		
	}
	
	@Override
	public void destroy() {
		System.out.println(this.getServletName() + "에서 destroy()메서드 호출");
	}

}
