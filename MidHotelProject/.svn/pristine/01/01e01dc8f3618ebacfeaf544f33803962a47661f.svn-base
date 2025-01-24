package com.Hotel.service.hotel;

import java.util.List;

import com.Hotel.vo.HotelVO;

public interface IHotelFindService {
	
	
	/**
	 * 호텔 지역 두글자를 따와 분류 
	 * @return
	 */
	public List<String> LocalSearch();
	
	
	
	// DB에서 호텔 이름으로 검색 (이 부분은 실제 DB와 연결된 코드로 구현 필요)
	public List<HotelVO> getHotelsByName(String hotelName);
	
	
	
	
	public List<HotelVO> getAllHotelNames();
	/**
	 * 호텔 이름을 입력하면 입력한 값이 들어간 모든 정보를 불러온다.
	 * @param hotelname
	 * @param hoteladdr
	 * @return
	 */
	public List<HotelVO> searchHotelAddr(String hoteladdr);
	
	
	/**
	 * 호텔 id로 값을 받아와 데이터를 저장
	 * @param hotelid
	 * @return
	 */
	public HotelVO getHotelByName(String hotelName);
	
}