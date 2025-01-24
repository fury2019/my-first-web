package com.Hotel.service.facilities;

import java.util.List;

import com.Hotel.dao.facilities.Fac_reserDaoImpl;
import com.Hotel.dao.facilities.IFac_reserDao;
import com.Hotel.vo.Facilities_ReservationVO;
import com.Hotel.vo.hotel_fac_catVO;

public class Fac_reserServiceImpl implements IFac_reserService {
	private static Fac_reserServiceImpl service;
	
	private IFac_reserDao dao;
	
	private Fac_reserServiceImpl() {
		dao = Fac_reserDaoImpl.getInstance();
	}
	
	public static Fac_reserServiceImpl getInstance() {
		if(service == null) {
			service = new Fac_reserServiceImpl();
		}
		return service;
	}
	
	//편의시설 예약
	@Override
	public int insertFacRes(Facilities_ReservationVO facres) {
		return dao.insertFacRes(facres);
	}

	@Override
	public int updateFacRes(Facilities_ReservationVO facres) {
		return dao.updateFacRes(facres);
	}

	@Override
	public int deleteFacRes(String fresno) {
		return dao.deleteFacRes(fresno);
	}

	@Override
	public Facilities_ReservationVO selectgetFacRes(String freno) {
		return null;
	}
	
	public List<Facilities_ReservationVO> selectFacRes(String memId){
		return dao.selectFacRes(memId);
	}
	
	@Override
	public List<Facilities_ReservationVO> selectAllFacRes() {
		return dao.selectAllFacRes();
	}
	@Override
	public List<hotel_fac_catVO> gethotelDining(String hotelId){
		return dao.gethotelDining(hotelId);
	}
	@Override
	public List<hotel_fac_catVO> getSearchDining(String hotelId, String diningName){
		return dao.getSearchDining(hotelId, diningName);
	}
	
}
