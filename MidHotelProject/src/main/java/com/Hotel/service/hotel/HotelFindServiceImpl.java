package com.Hotel.service.hotel;

import java.util.List;

import com.Hotel.dao.hotel.HotelFindDaoImpl;
import com.Hotel.dao.hotel.IHotelFindDao;
import com.Hotel.vo.HotelVO;

public class HotelFindServiceImpl implements IHotelFindService {
	private static HotelFindServiceImpl service;
	
	private IHotelFindDao dao;
	
	private HotelFindServiceImpl() {
		dao = HotelFindDaoImpl.getInstance();
	}
	
	public static HotelFindServiceImpl getInstance() {
		if(service == null) {
			service = new HotelFindServiceImpl();
		}
		return service;
	}
	
	
	// 모든 호텔 전체 리스트 가져오기
	public List<HotelVO> getAllHotelNames(){
		return dao.getAllHotelNames();
	}
	// 호텔 지역별로 분류 
	public List<String> LocalSearch(){
		return dao.LocalSearch();
	}
	
	//호텔 이름으로 찾기
	@Override
	public List<HotelVO> searchHotelAddr(String hoteladdr){
		return dao.searchHotelAddr(hoteladdr);
	}
	
	//호텔 아이디로 정보를 불러온다.
	@Override
	public HotelVO getHotelByName(String hotelName) {
		return dao. getHotelByName(hotelName);
	}
	
	@Override
	public List<HotelVO> getHotelsByName(String hotelName) {
		return dao.getHotelsByName(hotelName);
	}
	
	
	
	
	
	
}
