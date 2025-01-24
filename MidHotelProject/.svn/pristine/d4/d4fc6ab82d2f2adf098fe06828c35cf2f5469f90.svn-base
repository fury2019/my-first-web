package com.Hotel.dao.Hotel_Place;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.common.util.MybatisUtil;
import com.Hotel.vo.Hotel_PlaceVO;

public class HotelPlaceDaoImpl implements HotelPlaceIDao {
	private static HotelPlaceDaoImpl dao;

	private HotelPlaceDaoImpl() {

	}

	public static HotelPlaceDaoImpl getInstance() {
		if (dao == null)
			dao = new HotelPlaceDaoImpl();
		return dao;
	}
	@Override
	public List<Hotel_PlaceVO> getAllPlace() {
		SqlSession session = MybatisUtil.getSqlSession(); // SqlSession 생성;
		List<Hotel_PlaceVO> HPlace = null;
		 
		try {
			
			HPlace = session.selectList("hp.HotelPlace");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); // SqlSession 닫기
			}
		}
		
		return HPlace;
	}

	
}
