package com.Hotel.controller.reservation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.Hotel.service.facilities.Fac_reserServiceImpl;
import com.Hotel.service.facilities.IFac_reserService;
import com.Hotel.service.reservation.IRoom_reserService;
import com.Hotel.service.reservation.Room_reserServiceImpl;
import com.Hotel.vo.Facilities_ReservationVO;
import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Room_ReservationVO;

@WebServlet("/reservationList")
public class ReservationList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFac_reserService facservice;
	private IRoom_reserService reserservice;

	public ReservationList() {
		super();
		facservice = Fac_reserServiceImpl.getInstance();
		reserservice = Room_reserServiceImpl.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인된 회원 정보 가져오기
		HttpSession session = request.getSession();
		MemberVO log = (MemberVO) session.getAttribute("loginCode");
		String memId = log != null ? log.getMem_id() : null;

		if (memId != null) {
			// 회원의 객실 예약 정보 가져오기
			List<Room_ReservationVO> roomReservations = reserservice.selectgetRes(memId);
			// 회원의 시설 예약 정보 가져오기
			List<Facilities_ReservationVO> facilitiesReservations = facservice.selectFacRes(memId);

			// 데이터를 요청 속성에 저장하여 JSP로 전달
			request.setAttribute("roomReservations", roomReservations);
			request.setAttribute("facilitiesReservations", facilitiesReservations);

			// JSP 페이지로 포워딩
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/MypageResList.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/jsp/Login.jsp"); // 로그인되지 않은 경우 로그인 페이지로 리디렉션
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        MemberVO log = (MemberVO) session.getAttribute("loginCode");
        String memId = log != null ? log.getMem_id() : null;

        if (memId == null) {
            response.sendRedirect("/jsp/Login.jsp");
            return;
        }

        if ("Roomdelete".equals(action)) {
            // 객실 예약 삭제 처리
            String r_res_no = request.getParameter("r_res_no");
            int result = reserservice.deleteRes(r_res_no);
            if (0<result) {
                request.setAttribute("message", "객실 예약이 성공적으로 삭제되었습니다.");
            } else {
                request.setAttribute("message", "객실 예약 삭제에 실패했습니다.");
            }
        } else if ("delete".equals(action)) {
            // 시설 예약 삭제 처리
            String f_res_no = request.getParameter("f_res_no");
            int result = facservice.deleteFacRes(f_res_no);
            if (0<result) {
                request.setAttribute("message", "시설 예약이 성공적으로 삭제되었습니다.");
            } else {
                request.setAttribute("message", "시설 예약 삭제에 실패했습니다.");
            }
        }

        // 갱신된 예약 목록을 다시 가져와서 JSP로 전달
        List<Room_ReservationVO> roomReservations = reserservice.selectgetRes(memId);
        List<Facilities_ReservationVO> facilitiesReservations = facservice.selectFacRes(memId);
        request.setAttribute("roomReservations", roomReservations);
        request.setAttribute("facilitiesReservations", facilitiesReservations);

        // JSP 페이지로 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/MypageResList.jsp");
        dispatcher.forward(request, response);
    }

}
