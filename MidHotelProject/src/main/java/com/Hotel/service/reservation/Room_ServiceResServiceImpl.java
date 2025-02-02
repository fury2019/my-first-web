package com.Hotel.service.reservation;

import java.util.List;
import java.util.Map;

import com.Hotel.dao.reservation.IRoom_ServiceResDao;
import com.Hotel.dao.reservation.IRoom_reserDao;
import com.Hotel.dao.reservation.Room_ServiceResDaoImpl;
import com.Hotel.dao.reservation.Room_reserDaoImpl;
import com.Hotel.vo.Room_ReservationVO;
import com.Hotel.vo.Room_ServiceVO;

public class Room_ServiceResServiceImpl implements IRoom_ServiceResService {
	private static Room_ServiceResServiceImpl service;
	
	private IRoom_ServiceResDao dao;
	
	private Room_ServiceResServiceImpl() {
		dao = Room_ServiceResDaoImpl.getInstance();		
	}
	
	public static Room_ServiceResServiceImpl getInstance() {
		if(service == null) {
			service = new Room_ServiceResServiceImpl();
		}
		return service;
	}
	
	@Override
	public int insertService(Room_ServiceVO roomService) {
		return dao.insertService(roomService);
	}

	@Override
	public int deleteService(String resId) {
		return dao.deleteService(resId);
	}
	
	public List<Room_ServiceVO> getServiceRes(String resId){
		return dao.getServiceRes(resId);
	}
	
	public List<Room_ReservationVO> getServicePrice(Map<String, Object> params) {
		return dao.getServicePrice(params);
	}

}
