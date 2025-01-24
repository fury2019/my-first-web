package com.shinnaHotel.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.DAO.BoardDAO;
import com.shinnaHotel.action.Action;
import com.shinnaHotel.action.ActionForward;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		BoardDAO bdao = new BoardDAO();
		
		// 전체 게시글 개수
				int totalCnt = bdao.getBoardCnt();

				// 페이징 처리

				// 현재 넘겨받은 페이지
				String temp = req.getParameter("page");
				int page = 0;
				
//				if (temp == null) {
//					page = 1;
//				}else {
//					page=Integer.parseInt(temp);
//				}

				// 삼항연산자로 간단히 표현
				page = temp == null ? 1 : Integer.parseInt(temp);
				
				// 페이지 처리 [1][2]....[10] : 10개씩
				int pageSize = 10;
				
				// 1페이지 endRow = 10, 4페이지 endRow = 40
				int endRow = page * 10;
				
				// 1페이지의 startRow = 1, 4페이지의 startRow = 31
				int startRow = endRow - 9;
				
				// [1], [2], ... [10] : [1], [11], [12], ..., [20] : [11]
				int startPage = (page -1) / pageSize * pageSize + 1;
				
				// [1], [2], ... [10] : [10], [11], [12], ..., [20] : [20]
				int endPage = startPage + pageSize -1;
				
				int totalPage = (totalCnt -1)/pageSize + 1;
				
				endPage = endPage > totalPage? totalPage : endPage;

				req.setAttribute("totalPage", totalPage);
				req.setAttribute("nowPage", page);
				req.setAttribute("startPage", startPage);
				req.setAttribute("endPage", endPage);
				// 보고자하는 페이지 결과값을 가져온다.
				req.setAttribute("boardList", bdao.getBoardList(startRow, endRow)); 
				req.setAttribute("totalCnt", totalCnt);
				
				
				forward.setRedirect(false);
				forward.setPath("/inquiry/inquirylist.jsp" );
				
			
		
		return forward;
	}

}
