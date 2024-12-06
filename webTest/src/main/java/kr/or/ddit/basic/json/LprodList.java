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
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;


@WebServlet("/lprod/lprodList.do")
public class LprodList extends HttpServlet {
   private static final long serialVersionUID = 1L;

   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setCharacterEncoding("utf-8");
      response.setContentType("application/json; charset=utf-8");
      
      PrintWriter out = response.getWriter();
      
      Gson gson = new Gson();
      
      ILprodService service = LprodServiceImpl.getInstance();
      
      //전체 데이터를 db에서 가져옴 -> 서블릿에서 만든 응답데이터
      List<LprodVO> lprodList = service.getLprodAll();
      
      String jsonData = gson.toJson(lprodList);
      
      out.write(jsonData);
      response.flushBuffer();
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}
