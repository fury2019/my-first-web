package kr.or.ddit.fileupload.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.fileupload.service.FileInfoServiceImpl;
import kr.or.ddit.fileupload.service.IFileInfoService;
import kr.or.ddit.vo.FileInfoVO;

@WebServlet("/images/imageView.do")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터로 넘어온 파일번호를 구한다.
		String strFileNo = request.getParameter("fileno");
		int fileNo = Integer.parseInt(strFileNo);
		
		// DB에 저장된 파일 정보를 가져온다.
		IFileInfoService service = FileInfoServiceImpl.getInstance();
		
		FileInfoVO fvo = service.getFileInfo(fileNo);
		
		// 이미지가 저장된 폴더 경로
		String filePath = "d:/d_other/uploadFiles";
		
		// 이미지의 전체 경로 지정 ==> '저장파일명'을 이용하여 구성한다.
		String imgPath = filePath + File.separator + fvo.getSave_file_name();
		
		File imgFile = new File(imgPath);
		
		if(imgFile.exists()) {
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			
			try {
				// 출력용 스트림 객체 생성
				bout = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림 객체 생성
				bin = new BufferedInputStream(new FileInputStream(imgFile));
				
				byte[] temp = new byte[1024];
				int len = 0;
				
				while((len = bin.read(temp)) > 0) {
					bout.write(temp, 0, len);
				}
				
				bout.flush();
				
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
	            if(bin!=null) try { bin.close(); }catch (IOException e) {}
	            if(bout!=null) try { bout.close(); }catch (IOException e) {}
	         }
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


