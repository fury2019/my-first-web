package com.Hotel.dao.facilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.common.util.MybatisUtil;
import com.Hotel.vo.Facilities_ReservationVO;
import com.Hotel.vo.hotel_fac_catVO;

public class Fac_reserDaoImpl implements IFac_reserDao {
	private static Fac_reserDaoImpl dao;
	
	private Fac_reserDaoImpl() {}
	
	public static Fac_reserDaoImpl getInstance() {
		if(dao == null)
			dao = new Fac_reserDaoImpl();
		return dao;
	}
	
	

	// 예약 정보 삽입
	public int insertFacRes(Facilities_ReservationVO facres) {
		SqlSession session = null;
		
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("facRes.insertDReservation",facres);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateFacRes(Facilities_ReservationVO facres) {
		return 0;
	}

	
	/**
	 * 다이닝 예약 정보 삭제
	 */
	@Override
	public int deleteFacRes(String fresno) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.delete("facRes.deleteDReservation", fresno);
			if(cnt > 0)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}
	
	public Facilities_ReservationVO selectgetFacRes(String freno) {
		return null;
	}
	
	/**
	 * 특정 회원 다이닝 예약 정보 보여주기
	 */
	@Override
	public List<Facilities_ReservationVO> selectFacRes(String memId) {
		SqlSession session = null;
		List<Facilities_ReservationVO>  FacRes = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			FacRes = session.selectList("facRes.selectDReservation", memId);
		} catch (Exception e) {
			e.printStackTrace();	
		}finally {
			if(session!=null) session.close();
		}
		
		return FacRes;
	}
	
	/**
	 * 모든 다이닝 예약 정보 불러오기
	 */
	@Override
	public List<Facilities_ReservationVO> selectAllFacRes() {
		SqlSession session = null;
		List<Facilities_ReservationVO> FacList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			FacList = session.selectList("facRes.selectAllDReservation");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return FacList;
	}
	
	/**
	 * 호텔별 다이닝 출력
	 * @param hotelId
	 * @return
	 */
	public List<hotel_fac_catVO> gethotelDining(String hotelId){
		List<hotel_fac_catVO> facilities = null;
		SqlSession session = null;
		
		try {
            session = MybatisUtil.getSqlSession();
            facilities = session.selectList("facRes.getDining", hotelId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	if(session!=null) session.close();
        }
        
        return facilities;
	}
	
	public List<hotel_fac_catVO> getSearchDining(String hotelId, String diningName){
		 List<hotel_fac_catVO> facilities = null;
		 SqlSession session = null;
		 
		 try {
			session = MybatisUtil.getSqlSession();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("hotelId", hotelId);
			params.put("diningName",diningName);
			facilities = session.selectList("facRes.getHotelDining",params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return facilities;
	}
	

}
