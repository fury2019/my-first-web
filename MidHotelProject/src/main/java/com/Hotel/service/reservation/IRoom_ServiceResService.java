package com.Hotel.service.reservation;

import java.util.List;
import java.util.Map;

import com.Hotel.vo.Room_ReservationVO;
import com.Hotel.vo.Room_ServiceVO;

public interface IRoom_ServiceResService {
	
	public int insertService(Room_ServiceVO roomService);
	
	public int deleteService(String resId);
	
	public List<Room_ServiceVO> getServiceRes(String resId);

	public List<Room_ReservationVO> getServicePrice(Map<String, Object> params);
}
