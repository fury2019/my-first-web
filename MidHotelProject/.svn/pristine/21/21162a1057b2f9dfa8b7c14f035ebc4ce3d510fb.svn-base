package com.Hotel.dao.HotelNearbySpots;

import java.util.List;
import java.util.Map;

import com.Hotel.vo.HotelVO;
import com.Hotel.vo.Hotel_PlaceVO;
import com.Hotel.vo.Place_LikeVO;


public interface IHotelNearbySpotsDAO {

	/**
	 * 전체 호텔명소 정보를 가져와 List에 저장하여 반환하는 메서드
	 * 
	 * @return HotelPlaceVO객체가 저장된 List객체
	 */
	public List<Hotel_PlaceVO> HotelPlaceDisplayAll();
	
	/**
	 * 특정 호텔 근처의 명소 정보를 가져오는 메서드
	 * @param params
	 * @return
	 */
	public List<Hotel_PlaceVO> getPlacesByHotelId(String hotelId); 
	
	
	public List<HotelVO> getAllHotels(); 
	
	public boolean updateLikeCount(String placeId, String memId);
	
	public boolean insertLike(String placeId, String memId);
	
	public int selectLikeCount(String placeId);
	
	// place_like테이블에서 hotel_place로 좋아요 수를 업데이트하는 메소드
	public List<Hotel_PlaceVO> updatePlacesLikeCount(String hotelId);
	
	public List<Place_LikeVO> selectPlacesLikeList(String placeId); 

	public int deleteLike(Place_LikeVO vo);


}
