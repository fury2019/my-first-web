package com.Hotel.controller.reservation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Hotel.service.reservation.IRoom_reserService;
import com.Hotel.service.reservation.Room_reserServiceImpl;
import com.Hotel.vo.Room_ReservationVO;
import com.google.gson.Gson;

@WebServlet("/hotelRoomResServlet")
public class HotelRoomResServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IRoom_reserService reserService;

    public HotelRoomResServlet() {
        super();
        reserService = Room_reserServiceImpl.getInstance();
    }

    // GET 요청 처리
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        // 파라미터 받기
    	String hotelId = request.getParameter("hotelId");
    	String hotelName = request.getParameter("hotelName");
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");

        // 날짜 형식 지정
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");  // 입력된 날짜 형식

        // 파라미터를 Map에 담기
        Map<String, Object> params = new HashMap<>();
        params.put("hotelId", hotelId);
        params.put("hotelName", hotelName);
        
        params.put("checkInDate", checkInDate);
        params.put("checkOutDate", checkOutDate);
        
        // 날짜 형변환
//        try {
//            if (checkInDate != null && !checkInDate.isEmpty()) {
//                Date checkIn = inputFormat.parse(checkInDate);
//                params.put("checkInDate", checkIn);
//            }
//            if (checkOutDate != null && !checkOutDate.isEmpty()) {
//                Date checkOut = inputFormat.parse(checkOutDate);
//                params.put("checkOutDate", checkOut);
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//            // 날짜 형식이 잘못된 경우 예외 처리
//            System.out.println("날짜 형식이 잘못되었습니다.");
//            return; // 날짜 형식이 잘못된 경우 응답 종료
//        }

        // 성인 수, 어린이 수, 유아 수를 검증하고 값이 있을 때만 Map에 추가
        String adultCount = request.getParameter("adultCount");
        String childCount = request.getParameter("childCount");
        String kidsCount = request.getParameter("kidsCount");
        
        try {
        	
        	if (adultCount != null && !adultCount.isEmpty()) {
                params.put("adultCount", Integer.parseInt(adultCount));
            }
            if (childCount != null && !childCount.isEmpty()) {
                params.put("childCount", Integer.parseInt(childCount));
            }
            if (kidsCount != null && !kidsCount.isEmpty()) {
                params.put("babyCount", Integer.parseInt(kidsCount));
            }
        	
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(new Gson().toJson("인원 수가 잘못되었습니다."));
            return; // 인원 수가 잘못된 경우 응답 후 종료
		}
        
        // 예약 가능한 객실 정보 조회
        List<Room_ReservationVO> availableRooms = reserService.getReservationsByHotelAndDates(params);
        
        // 객실 가격 조회
//        List<Room_ReservationVO> roomPrice = reserService.getPrice(hotelId);

        // 결과를 JSON 형태로 반환
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        // 응답 객체 생성
//        Map<String, Object> jsonResponse = new HashMap<>();
//        jsonResponse.put("availableRooms", availableRooms); // "availableRooms"라는 키에 객실 리스트 추가
//        jsonResponse.put("roomPrice", roomPrice);
        
        // JSON 응답 전송
        response.getWriter().write(new Gson().toJson(availableRooms));
//        response.getWriter().write(new Gson().toJson(availableRooms) + ", " +  new Gson().toJson(roomPrice));
//        response.getWriter().write(new Gson().toJson(availableRooms) + new Gson().toJson(roomPrice));
//        response.getWriter().write(new Gson().toJson(roomPrice));
        

       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
