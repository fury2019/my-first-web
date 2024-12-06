package kr.or.ddit.basic;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspApplicationContext;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/servletTest04.do")
public class ServletTest04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Servlet 클래스나 JSP 페이지의 환경에 관련된 정보를 ServletContext를 이용해서
		// 얻을 수 있다. ==> 이 객체를 구하는 메서드 getServletContext()
		
		ServletContext context = this.getServletContext();
		
		// Servlet이 속하는 웹 서버의 종류 구하기
		String serverInfo = context.getServerInfo();
		
		// Servlet의 메이저 버전과 마이너 버전 구하기
		int major = context.getMajorVersion();
		int minor = context.getMinorVersion();
			
		String servletName = this.getServletName();
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html: charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'<title>웹 서버의 정보</title></head>");
		out.println("<body>");
		
		out.println("<ul>");
		out.printf("<li>웹 서버의 종류(ServerInfo) : %s</li>", serverInfo);
		out.printf("<li>Servlet Name : %s </li>", servletName);
		out.printf("<li>servlet 버전 : (%d.%d)</li>", major, minor);
		out.println("</ul>");
		
		out.println("</body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
