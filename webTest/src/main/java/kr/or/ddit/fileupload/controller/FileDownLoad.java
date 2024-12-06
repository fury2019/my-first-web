package kr.or.ddit.fileupload.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.fileupload.service.FileInfoServiceImpl;
import kr.or.ddit.fileupload.service.IFileInfoService;
import kr.or.ddit.vo.FileInfoVO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;


@WebServlet("/fileDownLoad.do")
public class FileDownLoad extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      
      // 파라미터로 넘어온 파일번호를 구한다.
      String strFileNo = request.getParameter("fileno");
      int fileNo = Integer.parseInt(strFileNo);
      
      // 파일번호를 이용하여 DB에서 해당 파일의 정보를 가져온다.
      IFileInfoService service = FileInfoServiceImpl.getInstance();
      
      FileInfoVO fvo = service.getFileInfo(fileNo);
      
      // 업로드된 파일들이 저장될 폴더 설정
      String uploadPath = "d:/d_other/uploadFiles";
            
      // 저장될 폴더가 없으면 새로 생성한다.
      File f = new File(uploadPath);
      
      if(!f.exists()) {
         f.mkdirs();
      }
      
      // --------------------------------------------------------
      
      // 다운 받을 파일 정보를 갖는 File객체 생성 ==> 실제 저장된 파일명을 지정한다.
      File downFile = new File(f, fvo.getSave_file_name());
      
      if(downFile.exists()) {      // 해당 폴더에 파일이 있을 경우..
         response.setContentType("application/octet-stream; charset=utf-8");
         
         // Response객체의 Header에 'content-disposition' 속성을 설정한다.
         String key = "content-disposition";
         
         // 'content-disposition' 속성값으로는 클라이언트에 저장될 파일 이름을 설정한다.
         //      ==> 이곳에는 '원래의 파일명'으로 지정한다.
         String value = "attachment; filename*=UTF-8''" +
                  URLEncoder.encode(fvo.getOrigin_file_name(), "utf-8")
                  .replaceAll("\\+", "%20");
         
         response.setHeader(key, value);
         // ------------------------------------------------
         
         // 서버에 저장된 파일을 읽어서 클라이언트로 전송한다.
         BufferedInputStream bin = null;
         BufferedOutputStream bout = null;
         
         try {
            // 출력용 스트림 객체생성 ==> Response객체 이용
            bout = new BufferedOutputStream(response.getOutputStream());
            
            // 파일 입력용 스트림 객체 새성
            bin = new BufferedInputStream(new FileInputStream(downFile));
            
            byte[] temp = new byte[1024];
            int len = 0;
            while((len = bin.read(temp)) > 0) {
               bout.write(temp, 0, len);
            }
            
            bout.flush();
            
         } catch (Exception e) {
            System.out.println("입출력 오류 : " + e.getMessage());
         } finally {
            if(bin!=null) try { bin.close(); }catch (IOException e) {}
            if(bout!=null) try { bout.close(); }catch (IOException e) {}
         }
         
         
         
      }else {   // 해당 폴더에 파일이 없을 경우
         response.setContentType("text/html; charset=utf-8");
         response.getWriter().println("<h3>" + fvo.getOrigin_file_name()
                                       + "파일이 존재하지 않습니다..</h3>");
      }
      
      
      
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
