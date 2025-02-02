package com.Hotel.dao.hotel;

import java.util.List;

import com.Hotel.vo.HotelVO;

public interface IHotelFindDao {
	
	
	/**
	 * 호텔 지역을 받아온다 -> 서브스트링으로 2글자를 따옴 -> ex)서울,부산 등등
	 * @return
	 */
	public List<String> LocalSearch();
	
	/**
	 * 호텔 전체 따와 리스트로 출력
	 * @return
	 */
	public List<HotelVO> getAllHotelNames();
	/**
	 * 호텔 주소을 받아서 검색한다.
	 * @param hotelname
	 * @return
	 */
	public List<HotelVO> searchHotelAddr(String hoteladdr);
	
	/**
	 * 검색 
	 * @param hotelName
	 * @return
	 */
	public HotelVO getHotelByName(String hotelName);
	
	public List<HotelVO> getHotelsByName(String hotelName);
}
