package com.Hotel.dao.hotel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.common.util.MybatisUtil;
import com.Hotel.vo.HotelVO;

public class HotelFindDaoImpl implements IHotelFindDao {
	private static HotelFindDaoImpl dao;
	
	private HotelFindDaoImpl() {
		
	}
	
	public static HotelFindDaoImpl getInstance() {
		if(dao==null)
			dao = new HotelFindDaoImpl();
		return dao;
	}
	
	
	//지역 별로 호텔을 분류 -> ex)서울이면 서울에 관한 호텔만 출력
	public List<String> LocalSearch(){
		SqlSession session = null;
		List<String> locallist = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			locallist = session.selectList("hotel.localsearch");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
			session.close();
		}
		
		
		return locallist;
		
	}
	
	//호텔 전체 검색하기 전에 출력함
	public List<HotelVO> getAllHotelNames(){
		SqlSession session = null;
		List<HotelVO> Namelist = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			Namelist = session.selectList("hotel.getAllNameHotels");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return Namelist;
	}
	
	//주소 정보를 일부 입력 했을때 해당 주소에 대한 검색 결과가 뜬다.
	public List<HotelVO> searchHotelAddr(String hoteladdr){
		SqlSession session = null;
		List<HotelVO> result = null;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hotel_addr", hoteladdr);
		
		try {
			session = MybatisUtil.getSqlSession();
			result = session.selectList("hotel.searchHotel",params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null)
			session.close();
		}
		
		return result;
		
		
		
		
	}
	
	
	// name값으로 호텔 정보를 불러온다.
	public HotelVO getHotelByName(String hotelName) {
		SqlSession session = null;
		
		HotelVO gethotel = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			gethotel = session.selectOne("hotel.getHotelByName",hotelName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null)
			session.close();
		}
		
		return gethotel;
		
	}
	// name값 List로 호텔 정보를 불러온다.
	public List<HotelVO> getHotelsByName(String hotelName){
		SqlSession session = null;
		
		List<HotelVO> hotel = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			hotel = session.selectList("hotel.getHotelsByName", hotelName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		
		return hotel;
		   
	}
	
}
