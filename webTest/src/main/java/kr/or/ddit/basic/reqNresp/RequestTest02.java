package kr.or.ddit.basic.reqNresp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        // doGet 메서드에서도 처리할 수 있도록 작성하거나 비워두지 마세요.
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operator = request.getParameter("operator");
        int i1 = Integer.parseInt(request.getParameter("i1"));
        int i2 = Integer.parseInt(request.getParameter("i2"));
        double result = 0;
        
        boolean calcOk = true;	//계산 성공 여부를 나타내는 변수

        switch (operator) {
            case "+": result = i1 + i2; break;
            case "*": result = i1 * i2; break;
            case "-": result = i1 - i2; break;
            case "%": 
            	if(i2==0) {
            		calcOk = false;
            	}else {
            		result = i1 % i2;
            	}
            	break;
            case "/":
                if (i2 != 0) {
                    result = i1 / (double)i2;
                } else {
                    // 예외 처리를 추가할 수 있습니다.
                    response.getWriter().println("Cannot divide by zero.");
                    calcOk = false;
                    return;
                }
                break;
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>계산 결과</h3>");
        out.printf("<p>%d %s %d = %.1f</p>", i1, operator, i2, result); // %.1f를 사용하여 소수점 첫째 자리까지 출력
        
        if(calcOk==true) { //계산 성공
        	out.println(result);
        }else {
        	out.println("계산 실패");
        }
        
        out.println("</body></html>");
    }
}
