package com.Hotel.service.HotelNearbySpots;

import java.util.List;
import java.util.Map;

import com.Hotel.dao.HotelNearbySpots.HotelNearbySpotsDAO;
import com.Hotel.dao.HotelNearbySpots.IHotelNearbySpotsDAO;
import com.Hotel.vo.HotelVO;
import com.Hotel.vo.Hotel_PlaceVO;
import com.Hotel.vo.Place_LikeVO;

public class HotelNearbySpotsService implements IHotelNearbySpotsService {
    private static HotelNearbySpotsService service;  
    private IHotelNearbySpotsDAO dao;

    // 생성자
    private HotelNearbySpotsService() {
        dao = HotelNearbySpotsDAO.getInstance();  
    }

    public static HotelNearbySpotsService getInstance() {
        if (service == null) {
            service = new HotelNearbySpotsService();
        }
        return service;
    }

    /**
     * 모든 주변 장소 정보를 가져오는 메서드
     */
    @Override
    public List<Hotel_PlaceVO> HotelPlaceDisplayAll() {
        return dao.HotelPlaceDisplayAll();
    }

    /**
     * 특정 호텔 ID에 해당하는 주변 장소 정보를 가져오는 메서드
     */
    @Override
    public List<Hotel_PlaceVO> getPlacesByHotelId(String hotelId) {
        return dao.getPlacesByHotelId(hotelId);
    }
    
    /**
     * 모든 호텔정보를 가져오는 메서드
     * @param params
     * @return
     */
    @Override
    public List<HotelVO> getAllHotels() {
    	return dao.getAllHotels();
    }
    
    @Override
    public boolean updateLikeCount(String placeId, String memId) {
    	return dao.updateLikeCount(placeId, memId);
    }
    
    @Override
	public boolean insertLike(String placeId, String memId) {
		return dao.insertLike(placeId, memId);
	}
	
    @Override
	public int selectLikeCount(String placeId) {
		return dao.selectLikeCount(placeId);
	}
    
    @Override
    public List<Hotel_PlaceVO> updatePlacesLikeCount(String hotelId) {
        return dao.updatePlacesLikeCount(hotelId); // DAO 메소드 호출
    }

	@Override
	public List<Place_LikeVO> selectPlacesLikeList(String placeId) {
		return dao.selectPlacesLikeList(placeId);
	}
	
	@Override
	public int deleteLike(Place_LikeVO vo) {
		return dao.deleteLike(vo);
	}
}

