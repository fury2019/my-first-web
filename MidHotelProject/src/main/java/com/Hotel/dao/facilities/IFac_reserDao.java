package com.Hotel.dao.facilities;

import java.util.List;

import com.Hotel.vo.Facilities_ReservationVO;
import com.Hotel.vo.hotel_fac_catVO;

public interface IFac_reserDao { 
	
	/**
	 * 편의시설 예약 정보 삽입
	 * @param facres
	 * @return
	 */
	public int insertFacRes(Facilities_ReservationVO facres);
	
	/**
	 * 편의시설 예약 정보 변경
	 * @param facres
	 * @return
	 */
	public int updateFacRes(Facilities_ReservationVO facres);
	
	/**
	 * 편의시설 예약 정보 삭제
	 * @param fresno
	 * @return
	 */
	public int deleteFacRes(String fresno);
	
	/**
	 * 편의시설 예약 번호 입력 후 정보 조회 
	 * @param freno
	 * @return
	 */
	public  List<Facilities_ReservationVO> selectFacRes(String memId);
	
	/**
	 * 편의시설 예약 정보 전체 출력
	 * @return
	 */
	public List<Facilities_ReservationVO> selectAllFacRes();
	
	
	/**
	 * 호텔별 다이닝 출력
	 * @param hotelId
	 * @return
	 */
	public List<hotel_fac_catVO> gethotelDining(String hotelId);
	/**
	 * 호텔별 다이닝 검색
	 * @param hotelId
	 * @param diningName
	 * @return
	 */
	public List<hotel_fac_catVO> getSearchDining(String hotelId, String diningName);

}
