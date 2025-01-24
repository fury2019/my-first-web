package com.Hotel.service.reservation;

import java.util.List;
import java.util.Map;

import com.Hotel.dao.reservation.IRoom_reserDao;
import com.Hotel.dao.reservation.Room_reserDaoImpl;
import com.Hotel.vo.Facilities_ReservationVO;
import com.Hotel.vo.Hotel_RoomVO;
import com.Hotel.vo.Room_ReservationVO;
import com.Hotel.vo.Room_TypeVO;

public class Room_reserServiceImpl implements IRoom_reserService {
	private static Room_reserServiceImpl service;
	
	private IRoom_reserDao dao;
	
	private Room_reserServiceImpl() {
		dao = Room_reserDaoImpl.getInstance();
	}
	
	public static Room_reserServiceImpl getInstance() {
		if(service == null) {
			service = new Room_reserServiceImpl();		
		}
		return service;
	}
	
	public int insertRes(Room_ReservationVO res) {
		return dao.insertRes(res);
		
	}
	public int updateRes(Room_ReservationVO memid) {
		return dao.updateRes(memid);
		
	}
	
	public int deleteRes(String resno) {
		return dao.deleteRes(resno);
		
	}
	
	public Room_ReservationVO selectRes(String resno) {
		return dao.selectRes(resno);
		
	}
	
	/**
	 * 객실 예약 리스트를 회원이 뽑아옴
	 * @param memId
	 * @return
	 */
	public List<Room_ReservationVO> selectgetRes(String memId){
		return dao.selectgetRes(memId);
	};
	
	
	public List<Room_ReservationVO> selectAllRes(){
		return dao.selectAllRes();
		
	}

	public List<Room_ReservationVO> getReservationsByHotelAndDates(Map<String, Object> params) {
		return dao.getReservationsByHotelAndDates(params);
	}
	
	
	/**
	 * 호텔별 객실 가격 조회
	 * @param hotelId
	 * @return
	 */
	public List<Room_ReservationVO> getPrice(String hotelId) {
		return dao.getPrice(hotelId);
	}
	
	public String getRandomNo(Room_ReservationVO hrrrVo) {
		return dao.getRandomNo(hrrrVo);
	}
}