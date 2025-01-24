package com.Hotel.controller.HotelNearbySpots;

import java.io.IOException;
import java.util.List;

import com.Hotel.service.HotelNearbySpots.HotelNearbySpotsService;
import com.Hotel.service.HotelNearbySpots.IHotelNearbySpotsService;
import com.Hotel.vo.Hotel_PlaceVO;
import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Place_LikeVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HotelNearbySpots")
public class HotelNearbySpots extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hotelId = request.getParameter("hotelId");
        if (hotelId == null || hotelId.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "호텔 ID가 제공되지 않았습니다.");
            return;
        }

        HttpSession session = request.getSession();
        MemberVO loginMember = null;
        if (session != null) {
            loginMember = (MemberVO) session.getAttribute("loginCode");
        }

        String placeId = request.getParameter("placeId");
        String action = request.getParameter("action"); // 좋아요 또는 취소 동작을 판단하는 파라미터 추가

        IHotelNearbySpotsService service = HotelNearbySpotsService.getInstance();

        if (placeId != null && loginMember != null) {
            boolean isSuccess = false;
            if ("like".equals(action)) { // 좋아요 처리
                isSuccess = service.updateLikeCount(placeId, loginMember.getMem_id());
            } else if ("unlike".equals(action)) { // 좋아요 취소 처리
                Place_LikeVO likeVO = new Place_LikeVO();
                likeVO.setPlace_id(placeId);
                likeVO.setMem_id(loginMember.getMem_id());
                isSuccess = service.deleteLike(likeVO) > 0; // deleteLike는 성공 시 삭제된 행의 개수를 반환
            }

            if (!isSuccess) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "요청 처리에 실패했습니다.");
                return;
            }
        }

        // 특정 호텔 ID에 대한 장소 목록 가져오기
        List<Hotel_PlaceVO> spots = service.getPlacesByHotelId(hotelId);
        for (Hotel_PlaceVO spot : spots) {
            spot.setPlaceLikeVo(service.selectPlacesLikeList(spot.getPlace_id()));
        }

        // 뷰에 데이터 전달
        request.setAttribute("spots", spots);
        request.setAttribute("loginMember", loginMember);

        // 결과를 JSP로 포워드
        request.getRequestDispatcher("/jsp/displaySpots.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // POST 요청도 GET 요청과 동일하게 처리
    }
}
