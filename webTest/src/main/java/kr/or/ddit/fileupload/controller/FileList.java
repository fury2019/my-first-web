package kr.or.ddit.fileupload.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.fileupload.service.FileInfoServiceImpl;
import kr.or.ddit.fileupload.service.IFileInfoService;
import kr.or.ddit.vo.FileInfoVO;

@WebServlet("/fileList.do")
public class FileList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체 파일 목록을 가져와 View로 전달하는 서블릿
		
		IFileInfoService service = FileInfoServiceImpl.getInstance();
		
		// 전체 파일 목록을 가져와 List에 저장
		List<FileInfoVO> fileList = service.getAllFileinfo();
		
		// 전체 파일 목록을 View페이지로 보내기 위해 저장
		request.setAttribute("fileList", fileList);
		
		request.getRequestDispatcher("/basic/fileupload/fileList.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
