package com.shinnaHotel.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinnaHotel.action.ActionForward;
@WebServlet("*.ad")
public class AdminFrontController extends HttpServlet {

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

		switch (requestURI) {
			// 전체 메인 리스트
			case "/admin/AdminMain.ad":
				forward = new AdminMainAction().execute(req, resp);
				break;
			// 전체 회원 리스트 
			case "/admin/AdminMemberList.ad":
				forward = new AdminMemberListAction().execute(req, resp);
				break;
			// 예약내역 리스트 
			case "/admin/AdminReservationList.ad":
				System.out.println("예약내역");
				forward = new AdminReservationListAction().execute(req, resp);
				break;
			// 매출내역 리스트 
			case "/admin/AdminSalesList.ad":
				forward = new AdminSalesListAction().execute(req, resp);
				break;
			// 객실정보 리스트 
			case "/admin/AdminRoomList.ad":
				forward = new AdminRoomListAction().execute(req, resp);
				break;
				
//------------------------------------------------------------------------------------------------				
				
			// 회원정보 삭제하기 
			case "/admin/AdminMemberDelete.ad":
				forward = new AdminMemberDeleteAction().execute(req, resp);
				break;
				
			// 회원정보 변경하기
			case "/admin/AdminMemberUpdateOk.ad":
				System.out.println("프론트도착");
				forward = new AdminMemberUpdateOkAction().execute(req, resp);
				break;
				
			// 예약 취소하기 
			case "/admin/AdminReservationCancel.ad":
				System.out.println("취소하기");
				forward = new AdminReservationCancelAction().execute(req, resp);
				break;
//------------------------------------------------------------------------------------------------				
				
			// 객실 상세 정보
			case "/admin/AdminRoomView.ad":
				forward = new AdminRoomViewAction().execute(req, resp);
				break;
			
			// 객실 추가
			case "/admin/AdminRoomAddOk.ad":
				forward = new AdminRoomAddOkAction().execute(req, resp);
				break;
			// 객실 수정 페이지 받기
			case "/admin/AdminRoomEdit.ad":
				forward = new AdminRoomEditAction().execute(req, resp);
				break;
			// 객실 수정
			case "/admin/AdminRoomEditOk.ad":
				forward = new AdminRoomEditOkAction().execute(req, resp);
				break;
			// 객실 삭제
			case "/admin/AdminRoomDelete.ad":
				forward = new AdminRoomDeleteAction().execute(req, resp);
				break;
			
			case "/admin/AdminMemberDeleteCheck.ad":
	            forward = new AdminMemberDeleteCheckAction().execute(req, resp);
	            break;
				
				
				
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				// 리다이렉트 전송방식
				resp.sendRedirect(forward.getPath());
			} else {
				// forward 전송방식
				RequestDispatcher disp = req.getRequestDispatcher(forward.getPath());
				disp.forward(req, resp);
			}
		}

	}
}
