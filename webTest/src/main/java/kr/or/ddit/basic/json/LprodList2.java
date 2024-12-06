package kr.or.ddit.basic.json;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.vo.LprodVO;

import java.io.IOException;
import java.util.List;

@WebServlet("/lprod/lprodList2.do")
public class LprodList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에서 자료를 가져와 View페이지(jsp페이지)로 데이터를 넘긴다.
		//	=> 이때 forward방식을 사용한다.
		ILprodService service = LprodServiceImpl.getInstance();
		
		List<LprodVO> lproList = service.getLprodAll();
		
		// 가져온 자료를 Request객체의 setAttribute()메서드를 이용하여 저장한다.
		request.setAttribute("lprodList", lproList);
		
		// View페이지로 제어 이동
		request.getRequestDispatcher("/basic/json/lprodList.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
