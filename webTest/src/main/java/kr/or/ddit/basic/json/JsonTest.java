package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.vo.SampleVO;


@WebServlet("/json/jsonTest.do")
public class JsonTest extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      // 서블릿에서 처리한 결과를 JSON으로 응답할 때의 설정
      response.setCharacterEncoding("utf-8");
      response.setContentType("application/json; charset=utf-8");
      
      PrintWriter out = response.getWriter();
      
      //---------------------------------------------------------
      
      String choice = request.getParameter("choice");
      
      // 데이터를 JSON으로 변환할 Gson객체 생성
      Gson gson = new Gson();
      
      // JSON으로 변환한 문자열 데이터가 저장될 변수 선언
      String jsonData = null;
      
      switch (choice) {
      
         // 문자열 데이터 처리
         case "String" : 
            String str = "안녕하세요.";
            
            // 처리된 자료를 JSON 문자열로 변환하기
            // Gson객체.toJson(처리된 자료)
            jsonData = gson.toJson(str);
            
            break;
            
         // 배열 데이터 처리
         case "array" :
        	 int[] arr = {1,2,3,4,5};
        	 
        	 jsonData = gson.toJson(arr);
        	 
        	 break;
        	 
         // 객체 데이터 처리
         case "object" :
        	 SampleVO samVo = new SampleVO(100, "홍길동");
        	 
        	 jsonData = gson.toJson(samVo);
        	 
        	 break;
        
         // List 데이터 처리
         case "list" :
        	List<SampleVO>samList = new ArrayList<SampleVO>();
        	
        	samList.add(new SampleVO(11, "엄준식"));
        	samList.add(new SampleVO(12, "김찬호"));
        	samList.add(new SampleVO(13, "손인욱"));
        	 
        	jsonData = gson.toJson(samList);
        	
        	break;
        	
        // Map 데이터 처리
         case "map" :
        	 Map<String, String> map = new HashMap<String, String>();
        	 
        	 map.put("name", "이추냥");
        	 map.put("tel", "010-1234-5678");
        	 map.put("addr", "대전시 중구 오류동");
        	 
        	 jsonData = gson.toJson(map);
        	 
        	 break;
      }
      
      
      
      System.out.println(choice + " ==> " + jsonData);
      
      // 변환된 JSON문자열 데이터를 응답으로 보내준다.
      //      ==> 즉, 클라이언트로 출력한다.
      out.write(jsonData);
      
      response.flushBuffer();
      
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
