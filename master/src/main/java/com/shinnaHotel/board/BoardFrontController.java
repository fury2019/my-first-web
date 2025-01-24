package com.shinnaHotel.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.action.ActionForward;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doprocess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doprocess(req, resp);
	}

	
	
	
	protected void doprocess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String requestURI = req.getRequestURI();
		ActionForward forward = null;
		
		switch(requestURI) {
			// 게시판페이지로 이동요청
			case "/board/BoardList.bo" :
				forward = new BoardListAction().execute(req, resp);
				break;
			// 게시판 상세조회페이지 + 댓글 이동요청
			case "/board/BoardView.bo" :
				forward = new BoardViewAction().execute(req, resp);
				break;
			// 게시판 글쓰기페이지 이동요청
			case "/board/BoardWrite.bo" :
				forward = new ActionForward(false, "/inquiry/inquiry.jsp");
				break;
				
			case "/board/BoardWriteOk.bo" :
				forward = new BoardWriteOkAction().execute(req, resp);
				break;
			// 댓글 작성 후 저장버튼 클릭 시 이동요청
			case "/board/AddComment.bo" : 
				forward = new AddCommentAction().execute(req, resp);
				break;
			// 댓글 작성 후 수정버튼 클릭 시 이동요청
			case "/board/UpdateComment.bo" :
				forward = new UpdateCommentAction().execute(req, resp);
				break;
			// 댓글 삭제버튼 클릭시 이동요청
			case "/board/DeleteComment.bo" :
				forward = new DeleteCommentAction().execute(req, resp);
				break;
			
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				// 리다이렉트 전송방식
				resp.sendRedirect(forward.getPath());
			}else {
				// forward 전송방식
				RequestDispatcher disp = req.getRequestDispatcher(forward.getPath());
				disp.forward(req, resp);
			}
		}
	}
}
