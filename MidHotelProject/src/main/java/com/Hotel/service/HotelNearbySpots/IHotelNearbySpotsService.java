package com.Hotel.service.HotelNearbySpots;

import java.util.List;
import java.util.Map;

import com.Hotel.vo.HotelVO;
import com.Hotel.vo.Hotel_PlaceVO;
import com.Hotel.vo.Place_LikeVO;


public interface IHotelNearbySpotsService {

	// 모든 주변 장소를 가져오는 메서드
    List<Hotel_PlaceVO> HotelPlaceDisplayAll();
    
    // 특정 호텔 ID에 해당하는 장소를 가져오는 메서드
    public List<Hotel_PlaceVO> getPlacesByHotelId(String hotelId);

    // 모든 호텔정보를 가져오는 메서드
    public List<HotelVO> getAllHotels();

	/**
	 * 모든 호텔정보를 가져오는 메서드
	 * @param params
	 * @return
	 */
	//public List<HotelVO> getAllHotels(Map<String, Object> params);
    
    public boolean updateLikeCount(String placeId, String memId);
	
	public boolean insertLike(String placeId, String memId);
	
	public int selectLikeCount(String placeId);
	
	// place_like테이블에서 hotel_place로 좋아요 수를 업데이트하는 메소드
	public List<Hotel_PlaceVO> updatePlacesLikeCount(String hotelId);
	
	public List<Place_LikeVO> selectPlacesLikeList(String placeId); 
	
	public int deleteLike(Place_LikeVO vo);
}
