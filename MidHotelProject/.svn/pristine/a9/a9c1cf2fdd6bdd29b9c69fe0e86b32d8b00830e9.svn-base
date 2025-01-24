package com.Hotel.service.reservation;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.vo.Hotel_RoomVO;
import com.Hotel.vo.Room_ReservationVO;
import com.Hotel.vo.Room_TypeVO;

public interface IRoom_reserService {
	
	/**
	 * 객실 예약 정보 넘기기
	 * @param res
	 * @return
	 */
	public int insertRes(Room_ReservationVO res);
	
	/**
	 * 객실 예약 업데이트
	 * @param res
	 * @return
	 */
	public int updateRes(Room_ReservationVO memid);
	
	/**
	 * 객실 예약 삭제
	 * @param resno
	 * @return
	 */
	public int deleteRes(String resno);
	
	/**
	 * 객실 목록 -> 회원 번호 입력시 보임 
	 * @param resno
	 * @return
	 */
	public Room_ReservationVO selectRes(String resno);
	
	
	
	/**
	 * 객실 전체 출력 
	 * @return
	 */
	public List<Room_ReservationVO> selectAllRes();
	
	
	/**
	 * 객실 예약 리스트를 회원이 뽑아옴
	 * @param memId
	 * @return
	 */
	public List<Room_ReservationVO> selectgetRes(String memId);
	
	
	// DB에서 호텔 이름과 날짜로 예약 검색 (이 부분은 실제 DB와 연결된 코드로 구현 필요)
	// 예시로 예약 리스트를 반환
	public List<Room_ReservationVO> getReservationsByHotelAndDates(Map<String, Object> params);
	
	
	/**
	 * 호텔별 객실 가격 조회
	 * @param hotelId
	 * @return
	 */
	public List<Room_ReservationVO> getPrice(String hotelId);
	
	/**
	 * 객실 번호 랜덤값
	 * @param hrrrVo
	 * @return
	 */
	public String getRandomNo(Room_ReservationVO hrrrVo);
}
