package com.Hotel.controller.reservation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.Hotel.service.reservation.IRoom_ServiceResService;
import com.Hotel.service.reservation.Room_ServiceResServiceImpl;
import com.Hotel.vo.Room_ServiceVO;


@WebServlet("/RoomServiceResServlet")
public class RoomServiceResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IRoom_ServiceResService roomServiceResService;
    
    public RoomServiceResServlet() {
        super();
        // TODO Auto-generated constructor stub
        roomServiceResService = Room_ServiceResServiceImpl.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] optionsList = request.getParameterValues("options"); // 배열로 받기
		String action = request.getParameter("action"); // getParameter 사용
        String r_res_no = request.getParameter("r_res_no");
//        String optionsListParam = request.getParameter("selectedOptions"); // 수정된 부분

        System.out.println("action: " + action);
        System.out.println("r_res_no: " + r_res_no);
        System.out.println("optionsList: " + Arrays.toString(optionsList));
        
		
		
		if ("insert".equals(action)) {
        	//리스트 전체를 보여주는 서블릿
            insertService(request, response, optionsList, r_res_no);
        } else if ("delete".equals(action)) {
        	//r_res_no에 대한 리스트를 보여주는 서블릿
            deleteService(request, response);
        }
	}
	
	private void insertService(HttpServletRequest request, HttpServletResponse response, String[] optionsList, String r_res_no) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // 응답의 문자 인코딩 설정
		System.out.println("insertService-optionsList : " + Arrays.toString(optionsList));
		
		if (optionsList == null || optionsList.length == 0) {
		    // 선택된 옵션이 없을 경우 처리
		    request.setAttribute("r_res_no", r_res_no); // 예약 넘버 추가
		    request.setAttribute("action", "view"); // action 값 추가
		    request.getRequestDispatcher("/RoomResServlet").forward(request, response); // 서블릿으로 포워딩
		    return;
		}

		
		
		List<Room_ServiceVO> service = new ArrayList<>();
		
		for(String service_id : optionsList) {
			Room_ServiceVO roomService = new Room_ServiceVO();
			roomService.setR_res_no(r_res_no);
			roomService.setService_id(service_id);
			service.add(roomService);
			
		}
		
		boolean allInserted = true; // 모든 삽입이 성공했는지 여부를 추적
		
		for (Room_ServiceVO roomService : service) {
	        int insertService = roomServiceResService.insertService(roomService);
	        if (insertService <= 0) { // 삽입 실패 시
	            allInserted = false; // 플래그를 false로 설정
	            break; // 더 이상 진행하지 않음
	        }
		}
		
		// 성공 여부에 따라 알림 및 리다이렉트
	    response.setContentType("text/html; charset=UTF-8");
//	    if (allInserted) {
//	        response.getWriter().write(
//	            "<script>" +
//	            "alert('서비스가 성공적으로 추가되었습니다.');" +
//	            "window.location.href = '/jsp/Reservation3.jsp';" +
//	            "</script>"
//	        );
//	    } else {
//	        response.getWriter().write(
//	            "<script>" +
//	            "alert('서비스 추가에 실패하였습니다. 다시 시도해주세요.');" +
//	            "window.location.href = '/jsp/Reservation2.jsp';" +
//	            "</script>"
//	        );
//	    }
		
	    if (allInserted) {
	        // 서비스 추가 후 viewReservation 서블릿으로 이동
	        request.setAttribute("r_res_no", r_res_no); // 예약 넘버를 request에 추가
	        request.setAttribute("action", "view"); // action 값 추가
	        request.getRequestDispatcher("/RoomResServlet").forward(request, response);
	    
	    } else {
	        response.getWriter().write(
	            "<script>" +
	            "alert('서비스 추가에 실패하였습니다. 다시 시도해주세요.');" +
	            "window.location.href = '/jsp/Reservation2.jsp';" +
	            "</script>"
	        );
	    }
	}
	
	private void deleteService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}

}
