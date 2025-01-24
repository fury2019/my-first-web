package com.Hotel.controller.hotel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Hotel.service.hotel.HotelFindServiceImpl;
import com.Hotel.service.hotel.IHotelFindService;
import com.Hotel.vo.HotelVO;

@WebServlet("/hotelfindServlet")
public class HotelfindServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IHotelFindService hotelFindService;

    public HotelfindServlet() {
        super();
        hotelFindService = HotelFindServiceImpl.getInstance();
    }
    // 한 서블릿 내에서 get,post를 두개 다 쓸 수 있다. 두개 다 쓸 때는 경로를 해당 서블릿 경로로 바꿔줘야한다.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 지역 리스트 및 호텔 이름 전체 리스트 가져오기
        List<String> allRegions = hotelFindService.LocalSearch();
        List<HotelVO> allHotelNames = hotelFindService.getAllHotelNames();

        // 데이터 JSP로 전달
        request.setAttribute("regions", allRegions);
        request.setAttribute("hotels", allHotelNames);

        // JSP로 포워딩
        request.getRequestDispatcher("/jsp/hotelFind.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 호텔 주소를 파라미터로 받아 검색
        String hotel_addr = request.getParameter("hotel_addr");

        List<HotelVO> hotels = hotelFindService.searchHotelAddr(hotel_addr);

        // 검색된 결과를 JSP로 전달
        request.setAttribute("searchedHotels", hotels);

        // JSP로 포워딩
        request.getRequestDispatcher("/jsp/hotelFind.jsp").forward(request, response);
    }
}
