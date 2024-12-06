package kr.or.ddit.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.servlet.http.Part;
import kr.or.ddit.fileupload.service.FileInfoServiceImpl;
import kr.or.ddit.fileupload.service.IFileInfoService;
import kr.or.ddit.vo.FileInfoVO;

/*
 	- Servlet 3.0 이상에서 파일 업로드를 하려면 서블릿에 @MultipartConfig 애노테이션을 
 		설정해야 한다.
 		
 	- @MultipartConfig 애노테이션에 설정할 속성들...
 	1) location : 업로드한 파일이 임시적으로 저장될 경로 지정 (기본값 : "")
 	2) fileSizeThreshold : 이 곳에 지정한 값보다 큰 파일이 전송되면
 			location 속성에 지정한 디렉토리애 저장한다.
 			(단위 : byte, 기본값 : 0 (무조건 location 속성에 설정한 디렉토리 사용한다.)
 	3) maxFileSize : 1개 파일의 최대 크기 (단위 : byte, 기본값 : -1L (무제한) ) 
 	4) maxRequestSize : 서버로 전송되는 Request  전체 데이터의 최대 크기
 				(단위 : byte, 기본값 : -1L(무제한) ) 
 */

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30,
		maxRequestSize = 1024 * 1024 * 100 )

@WebServlet("/fileUpload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET방식으로 요청하면 FileUpload용 form문서로 이동하고
		request.getRequestDispatcher("/basic/fileupload/fileUploadForm.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식으로 요청하면 파일 업로드 처리를 하고 업로드한 파일을
		// DB에 추가한다.
		
		request.setCharacterEncoding("utf-8");
		 
		// 업로드된 파일들이 저장될 폴더 설정
		String uploadPath ="d:/d_other/uploadFiles";	
		
		// 저장될 폴더가 없으면 새로 생성한다.
		File f = new File(uploadPath);
		
		if(!f.exists()) {
			f.mkdirs();
		}
		//---------------------------------------
		
		// 파일이 아닌 일반 데이터들은 getParameter()메서드나 getParameterValues()메서드를
		// 이용해서 구한다.
		
		String userName = request.getParameter("username");
		
		System.out.println("일반 파라미터 데이터 : " + userName);
		
		//---------------------------------------
		
		// 수신 받은 파일 데이터 처리하기
		
		// upload된 파일이 여러 개 일 경우 파일 목록이 저장될 List 객체 생성
		List<FileInfoVO>fileList = new ArrayList<FileInfoVO>();
		
		/*
		 서블릿 3.0 이상에서 새롭게 추가된 upload 처리용 메서드들.
		 1) Request객체.getParts( ) ==> 전체 Part객체를 Collection객체에 담아서 반환한다.
		 2) Request객체.getPart("Part이름") ==> 지정한 'Part이름'을 가진 개별 Part객체를 반환한다.
		 			'Part이름'은 <form>태그 안의 입력 요소의 name 속성값으로 구별한다.
		 			
		 */
		
		// 전체 Part객체 개수만큼 반복처리
		for(Part part : request.getParts()) {
			
			// Upload한 파일의 원본 파일명 구하기
			String fileName = extractFileName(part);
			
			// 찾은 파일명이 빈문자열("")이면 이것은 파일이 아닌 일반 파라미터라는 의미이다.
			if(!"".equals(fileName)) {	//파일인지 검사
				// 파일 정보를 저장할 VO객체 생성
				FileInfoVO fvo = new FileInfoVO();
				
				fvo.setFile_writer(userName);		// 작성자를 VO에 저장
				fvo.setOrigin_file_name(fileName);	// 원본 파일명을 VO에 저장
				
				// 실제 저장되는 파일 이름이 중복되는 것을 방지하기 위해서 UUID객체를 이용하여 
				// 저장 파일명을 만든다.
				String saveFileName = UUID.randomUUID().toString() + "_" + fileName;
				
				fvo.setSave_file_name(saveFileName);	// 저장 파일명을 vo에 저장
				
				// Part객체.getSize() ==> Upload된 파일의 크기를 반환한다.(단위 : byte)
				
				// byte 단위의 파일 크기를 KB단위로 변환해서 VO에 저장한다.
				fvo.setFile_size( (long)Math.ceil(part.getSize() / 1024)  );
				
				try {
					// Part객체.write()메서드 ==> Upload된 파일을 지정한 경로에 저장하는 메서드
					part.write(uploadPath + File.separator + saveFileName);  // 파일 저장
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				fileList.add(fvo);	// VO객체를 List에 추가
				
			}	// if문 끝...
			
		}	// for문 끝...
		
		// 저장된 파일 정보들을 DB에 저장한다.
		IFileInfoService service = FileInfoServiceImpl.getInstance();
		
		// List 개수만큼 반복
		for(FileInfoVO fvo : fileList) {
			service.insertFileinfo(fvo);
		}
		
		// DB에 저장이 완료되면 파일 목록을 보여주는 페이지로 이동한다.
		response.sendRedirect(request.getContextPath() + "/fileList.do");
		
		
	} // doPost메서드 끝...
		
	//--------------------------------------
	/*
	- Part의 구조
	1) 파일이 아닌 일반 데이터일 경우
	---------------234kj234kl223		==> 각 Part를 구분하는 구분선
	content-disposition; form-data: name="username"		==>파라미터 명
														==> 빈줄
	홍길동												==> 파라미터 값
	
	2) 파일일 경우
	---------------234kj234kl223		==> 각 Part를 구분하는 구분선
	content-disposition; form-data; name="upFile1"; filename="test1.txt"  ==> 파일 정보
	content-type: text/plain			==> 파일의 종류
										==> 빈줄
	abcd1234안녕							==> 파일 내용
	 
	 */
	//--------------------------------------
	
	// Part구조 안에서 원본 파일명을 찾는 메서드
	private String extractFileName(Part part) {
		String fileName = "";
		
		String disposition = part.getHeader("content-disposition");
		
		String[] itemArr = disposition.split(";");
		
		for(String item : itemArr) {
			if(item.trim().startsWith("filename")) {	// 파일 정보 찾기
					// item.indexOf("=") + 2 ==> 파일명의 첫번째 글자 위치
					// item.lenth()-1		 ==> 파일명의 마지막 글자 다음 위치				
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		
		return fileName;
	}
	
	
	
}
