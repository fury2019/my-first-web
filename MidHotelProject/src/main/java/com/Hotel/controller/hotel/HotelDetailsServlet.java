package com.Hotel.controller.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.Hotel.service.hotel.HotelFindServiceImpl;
import com.Hotel.service.hotel.IHotelFindService;
import com.Hotel.vo.HotelVO;

@WebServlet("/hotelDetailsServlet")
public class HotelDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private IHotelFindService service;
    
    public HotelDetailsServlet() {
        service = HotelFindServiceImpl.getInstance();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hotelName = request.getParameter("hotel_name"); // AJAX에서 전달된 호텔 이름
        System.out.println("Received hotel_name: " + hotelName); // 전달받은 호텔 이름 출력

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            HotelVO hotel = service.getHotelByName(hotelName);
            
            if (hotel != null) {
                System.out.println("Hotel found: " + hotel.getHotel_name()); // 찾은 호텔 이름 출력
                String json = String.format(
                    "{\"hotelName\": \"%s\", \"hotelAddr\": \"%s\", \"hotelTel\": \"%s\"}",
                    hotel.getHotel_name(), hotel.getHotel_addr(), hotel.getHotel_tel()
                );
                out.print(json);
            } else {
                System.out.println("No hotel found with name: " + hotelName);
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                out.write("{\"error\": \"호텔 정보를 찾을 수 없습니다.\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.write("{\"error\": \"에러가 발생했습니다.\"}");
        } finally {
            out.flush();
            out.close();
        }
    }
}
