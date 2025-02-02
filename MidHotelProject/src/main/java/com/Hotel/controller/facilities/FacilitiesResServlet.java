package com.Hotel.controller.facilities;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import com.Hotel.service.facilities.Fac_reserServiceImpl;
import com.Hotel.service.facilities.IFac_reserService;
import com.Hotel.vo.Facilities_ReservationVO;

@WebServlet("/facilitiesResServlet")
public class FacilitiesResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IFac_reserService facservice;

	public FacilitiesResServlet() {
		super();
		facservice = Fac_reserServiceImpl.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청 데이터 가져오기
		String memId = request.getParameter("mem_id");
		String facId = request.getParameter("fac_id");
		String hotelId = request.getParameter("hotel_id");
		String fResMem = request.getParameter("f_res_mem");
		String fFesTime = request.getParameter("f_fes_time");

		
		Facilities_ReservationVO reservation = new Facilities_ReservationVO();
		reservation.setF_res_no("res_"+UUID.randomUUID().toString().substring(0,5)); // 예약 번호는 자동 생성
		reservation.setMem_id(memId);
		reservation.setFac_id(facId);
		reservation.setHotel_id(hotelId);
		reservation.setF_res_mem(Integer.parseInt(fResMem));
		reservation.setF_fes_time(fFesTime);

		// 예약 처리
		int Reserved = facservice.insertFacRes(reservation);

		// 응답 콘텐츠 타입 설정 -> jsp에서 작성하면 꼬일까봐 서블릿 자체에 넣음
	    response.setContentType("text/html; charset=UTF-8");
	    String message;
	    String redirectUrl;

	    if (Reserved > 0) {
	        // 예약 성공
	        message = "예약이 완료되었습니다.";
	        
	        //마이페이지에 예약 내역에 넣기 -> 임시로 Main에다가 해둠
	        redirectUrl = request.getContextPath() + "/MyPage.jsp";
	    } else {
	        // 예약 실패
	        message = "예약이 실패하였습니다. 다시 시도해주세요.";
	        //실패시 이동하는 경로 -> 다시 예약 버튼을 눌러야함
	        redirectUrl = request.getContextPath() + "/jsp/FacilitiesReservation.jsp";
	    }

	    // JavaScript 코드 작성 및 응답으로 전송
	    response.getWriter().write(
	        "<script>" +
	        "alert('" + message + "');" +
	        "window.location.href = '" + redirectUrl + "';" +
	        "</script>"
	    );
	
	}

}
