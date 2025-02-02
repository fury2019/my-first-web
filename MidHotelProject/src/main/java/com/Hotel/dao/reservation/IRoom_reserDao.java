package com.Hotel.dao.reservation;

import java.util.List;
import java.util.Map;

import com.Hotel.vo.Hotel_RoomVO;
import com.Hotel.vo.Room_ReservationVO;
import com.Hotel.vo.Room_TypeVO;

public interface IRoom_reserDao {
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
	 * 객실 목록 -> 객실 번호 입력시 보임 
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
	/**
	 * 날짜에 맞춰 예약 가능한 객실정보 조회
	 * 
	 * @return 값들을 이용해서 가져오기
	 */
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
