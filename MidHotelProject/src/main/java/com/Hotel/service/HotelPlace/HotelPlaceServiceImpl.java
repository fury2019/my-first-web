package com.Hotel.service.HotelPlace;

import java.util.List;

import com.Hotel.dao.Hotel_Place.HotelPlaceDaoImpl;
import com.Hotel.dao.Hotel_Place.HotelPlaceIDao;
import com.Hotel.vo.Hotel_PlaceVO;

public class HotelPlaceServiceImpl implements IHotelPlaceService {
	private static HotelPlaceServiceImpl service;
	
	private HotelPlaceIDao dao;
	
	private HotelPlaceServiceImpl() {
		dao = HotelPlaceDaoImpl.getInstance();
	}
	
	public static HotelPlaceServiceImpl getInstance() {
		
		if(service == null)
		   service = new HotelPlaceServiceImpl();
		
		return service;
	}

	@Override
	public List<Hotel_PlaceVO> getAllPlace() {
		return dao.getAllPlace();
	}

}
