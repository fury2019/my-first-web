package com.Hotel.controller.reservation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.Hotel.service.reservation.IRoom_ServiceResService;
import com.Hotel.service.reservation.IRoom_reserService;
import com.Hotel.service.reservation.Room_PayServiceImpl;
import com.Hotel.service.reservation.Room_ServiceResServiceImpl;
import com.Hotel.service.reservation.Room_reserServiceImpl;
import com.Hotel.vo.Hotel_EventVO;
import com.Hotel.vo.Hotel_RoomVO;
import com.Hotel.vo.Hotel_room_resVO;
import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Room_ReservationVO;
import com.Hotel.vo.Room_ServiceVO;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet("/RoomResServlet")
public class RoomResServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IRoom_reserService reservationService;
    private IRoom_ServiceResService serviceResService;

    public RoomResServlet() {
        super();
        //예약 서비스를 받아와서 인스턴스로 불러옴
        reservationService = Room_reserServiceImpl.getInstance();
        serviceResService = Room_ServiceResServiceImpl.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	String r_res_no= request.getParameter("r_res_no");
    	String action = request.getParameter("action");
    	System.out.println(r_res_no);
    	System.out.println("서블릿:"+action);
    	
    	//문자열.equals가 action일 때 조건문 
        if ("create".equals(action)) {
        	//리스트 전체를 보여주는 서블릿
            createReservation(request, response);
        } else if ("insert".equals(action)) {
        	//r_res_no에 대한 리스트를 보여주는 서블릿
            viewReservation(request, response);
        }
    }
    
    private int parseIntWithDefault(String value, int defaultValue) {
        if (value == null || value.isEmpty()) {
            return defaultValue; // 기본값 반환
        }
        
        try {
            return Integer.parseInt(value); // 변환 시도
        } catch (NumberFormatException e) {
            return defaultValue; // 변환 실패 시 기본값 반환
        }
    }
    

    private void createReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 요청 데이터 가져오기
    	//각각의 값을 파라미터로 받음 -> 파라미터 값을 String으로만 가능 -> 형변환 필요
        String mem_id = request.getParameter("memId");
        String type_name = request.getParameter("roomType");
        String hotel_id = request.getParameter("hotelId");
        String r_res_chkindate = request.getParameter("checkInDate");
        String r_res_chkoutdate = request.getParameter("checkOutDate");
       
        // 가격 및 인원 수 파라미터 가져오기 및 null 체크
        int r_res_price = parseIntWithDefault(request.getParameter("price"),0);
        int r_res_adult = parseIntWithDefault(request.getParameter("adultCount"),0);
        int r_res_child = parseIntWithDefault(request.getParameter("childCount"),0);
        int r_res_kids = parseIntWithDefault(request.getParameter("kidsCount"),0);
        
        
        Room_ReservationVO room = new Room_ReservationVO();
        room.setHotel_id(hotel_id);
        room.setType_name(type_name);
        room.setR_res_chkindate(r_res_chkindate);
        room.setR_res_chkoutdate(r_res_chkoutdate);
        
        System.out.println(room);
        
        String room_no = reservationService.getRandomNo(room);
        
        //setAttribute로 리스트의 저장값을 넘겨줌
        request.setAttribute("room_no", room_no);
        
        System.out.println(room_no);
        
        String r_res_no = "res_"+UUID.randomUUID().toString().substring(0,5);
        
        //VO객체 생성 -> 생성자 생성
        Room_ReservationVO reservation = new Room_ReservationVO();
        //db에 저장된 값에 파라미터값으로 선언한 변수들을 집어넣음
        reservation.setR_res_no(r_res_no);	// 예약 번호는 자동 생성
//        reservation.setR_res_no("res_"+UUID.randomUUID().toString().substring(0,5));	// 예약 번호는 자동 생성
        reservation.setMem_id(mem_id);
        reservation.setRoom_no(room_no);
        reservation.setType_name(type_name);
        reservation.setHotel_id(hotel_id);
        reservation.setR_res_chkindate(r_res_chkindate);
        reservation.setR_res_chkoutdate(r_res_chkoutdate);
        reservation.setR_res_price(r_res_price);
        reservation.setR_res_adult(r_res_adult);
        reservation.setR_res_child(r_res_child);
        reservation.setR_res_kids(r_res_kids);
        
        
        
        
        //예약처리
        int insert = reservationService.insertRes(reservation);

     // 응답 콘텐츠 타입 설정
	    response.setContentType("text/html; charset=UTF-8");
	    String message;
	    String redirectUrl;

	    if (insert > 0) {
	        // 예약 성공
	    	request.setAttribute("reservation", reservation); // 예약 객체 자체를 전달
	    	request.setAttribute("hotelName", request.getParameter("hotelName")); // 호텔 이름 전달
	    	request.setAttribute("memId", mem_id);
	    	request.setAttribute("r_res_no", reservation.getR_res_no()); // r_res_no 추가
//	    	request.setAttribute("r_res_no", r_res_no);
	    	request.setAttribute("RoomNo", room_no);
	    	request.setAttribute("TypeName", type_name);
	    	request.setAttribute("checkInDate", r_res_chkindate);
	    	request.setAttribute("checkOutDate", r_res_chkoutdate);
	    	request.setAttribute("R_res_price", r_res_price);
	    	request.setAttribute("R_res_adult", r_res_adult);
	    	request.setAttribute("R_res_child", r_res_child);
	    	request.setAttribute("R_res_kids", r_res_kids);
//	        message = "예약이 완료되었습니다.";
//	        redirectUrl = request.getContextPath() + "/jsp/Reservation2.jsp";
	    	// 여기서 포워딩을 수행
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Reservation2.jsp");
	        dispatcher.forward(request, response);
	    } else {
	        // 예약 실패
	        message = "예약이 실패하였습니다. 다시 시도해주세요.";
	        redirectUrl = request.getContextPath() + "/jsp/Reservation.jsp";
	        
	     // JavaScript 코드 작성 및 응답으로 전송
		    response.getWriter().write(
		        "<script>" +
		        "alert('" + message + "');" +
		        "window.location.href = '" + redirectUrl + "';" +
		        "</script>"
		    );
	    }

	    
	    
        
        
//        //json 객체로 불러와 성공이면 : 1 실패면 0을 띄워줌
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write("{\"success\":" + insert + "}");
//       
//        //이동할 문서의 위치 -> 오류 부모키 문제... MEM_ID, ROOM_NO, HOTEL_ID
//        //insert가 성공하면 메인페이지로 이동하게 해줌
//        response.sendRedirect("/jsp/Reservation2.jsp");
    }

    private void updateReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	//각각의 값을 파라미터로 받음 -> 파라미터 값을 String으로만 가능 -> 형변환 필요
    	String r_res_no = request.getParameter("r_res_no");
        String mem_id = request.getParameter("mem_id");
        String room_no = request.getParameter("room_no");
        String type_name = request.getParameter("type_name");
        String hotel_id = request.getParameter("hotel_id");
        String r_res_chkindate = request.getParameter("r_res_chkindate");
        String r_res_chkoutdate = request.getParameter("r_res_chkoutdate");
        int r_res_price = Integer.parseInt(request.getParameter("r_res_price"));
        int r_res_adult = Integer.parseInt(request.getParameter("r_res_adult"));
        int r_res_child = Integer.parseInt(request.getParameter("r_res_child"));
        int r_res_kids = Integer.parseInt(request.getParameter("r_res_kids"));
        
        
        //VO객체 생성 -> 생성자 생성
        Room_ReservationVO reservation = new Room_ReservationVO();
        //db에 저장된 값에 파라미터값으로 선언한 변수들을 집어넣음
        reservation.setR_res_no(r_res_no);
        reservation.setMem_id(mem_id);
        reservation.setRoom_no(room_no);
        reservation.setType_name(type_name);
        reservation.setHotel_id(hotel_id);
        reservation.setR_res_chkindate(r_res_chkindate);
        reservation.setR_res_chkoutdate(r_res_chkoutdate);
        reservation.setR_res_price(r_res_price);
        reservation.setR_res_adult(r_res_adult);
        reservation.setR_res_adult(r_res_child);
        reservation.setR_res_adult(r_res_kids);
        
        //성공 여부 확인을 위한 변수선언
        int isSuccess = reservationService.updateRes(reservation);
        
        
        //update가 성공하면 메인페이지로 이동하게 해줌
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"success\":" + isSuccess + "}");
        
        
    }

    private void deleteReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	//delete할 예약 넘버를 파라미터로 받아서 변수선언 
    	String r_res_no = request.getParameter("r_res_no");
    	
    	 //성공 여부 확인을 위한 변수선언
        int isSuccess = reservationService.deleteRes(r_res_no);
        
        //성공하면 1 실패하면 0 
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"success\":" + isSuccess + "}");
    }

    private void viewReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	//보여줄 예약 넘버를 파라미터로 받아서 변수선언 
    	String r_res_no = request.getParameter("r_res_no");
    	
    	// 세션에서 mem_id를 가져옴
    	HttpSession session = request.getSession();
		MemberVO loggedInMember = (MemberVO) session.getAttribute("loginCode");      
		String mem_id = loggedInMember.getMem_id();
        
		System.out.println(mem_id);
    	System.out.println("view : "+ r_res_no);
    	
    	//리스트 일부를 보여주기 위한 변수 생성
        Room_ReservationVO reservation = reservationService.selectRes(r_res_no);
        System.out.println("mem_id"+mem_id);
        
        Map<String, Object> params = new HashMap<>();
        params.put("mem_id", mem_id);
        params.put("r_res_no", r_res_no);
        
        List<Room_ReservationVO> service = serviceResService.getServicePrice(params);
        System.out.println("service목록 : "+ service);
        
        //setAttribute로 리스트의 저장값을 넘겨줌
        session.setAttribute("service", service);
        session.setAttribute("reservation", reservation);
        //파일로 정보를 넘겨줌  
        request.getRequestDispatcher("/jsp/Reservation3.jsp").forward(request, response);
    
    }

    private void listReservations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//리스트 전체를 보여주기 위한 변수 생성
    	List<Room_ReservationVO> reservations = reservationService.selectAllRes();
    	 //setAttribute로 리스트의 저장값을 넘겨줌
        request.setAttribute("reservations", reservations);
        //파일로 정보를 넘겨줌 
        request.getRequestDispatcher("/jsp/Reservation.jsp").forward(request, response);
    }
}
