package com.Hotel.dao.reservation;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.common.util.MybatisUtil;
import com.Hotel.vo.Hotel_RoomVO;
import com.Hotel.vo.Room_ReservationVO;
import com.Hotel.vo.Room_TypeVO;

public class Room_reserDaoImpl implements IRoom_reserDao{
	private static Room_reserDaoImpl dao;
	
	private Room_reserDaoImpl() {
		
	}
	
	public static Room_reserDaoImpl getInstance() {
		if(dao == null)
			dao = new Room_reserDaoImpl();
		return dao;
	}
	
	//예약 정보 삽입
	public int insertRes(Room_ReservationVO res) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("res.insertres", res);
			if(cnt>0)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
			session.close();
		}
		
		return cnt;		
	}
	
	//예약 업데이트
	public int updateRes(Room_ReservationVO memid) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("res.updateres", memid);
			if(cnt>0)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		return cnt;
		
	}
	
	//예약 삭제
	public int deleteRes(String resno) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.delete("res.deleteres", resno);
			if(cnt>0)
				session.commit();	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
			session.close();
		}

		return cnt;
		
	}
	
	//입력한 정보만 출력
	public Room_ReservationVO selectRes(String resno) {
		SqlSession session = null;
		Room_ReservationVO resSel = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			resSel = session.selectOne("res.selectres", resno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
			session.close();
		}
		
		return resSel;
	}
	
	
	/**
	 * 객실 예약 리스트를 회원이 뽑아옴
	 * @param memId
	 * @return
	 */
	public List<Room_ReservationVO> selectgetRes(String memId){
		SqlSession session = null;
		List<Room_ReservationVO> ResList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			ResList = session.selectList("res.selectgetmem",memId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		return ResList;
	}
	//전체 출력 
	public List<Room_ReservationVO> selectAllRes(){
		SqlSession session = null;
		List<Room_ReservationVO> ResList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			ResList = session.selectList("res.selectAllres");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
			session.close();
		}
		
		return ResList;
		
	}
	
	
	// 예약 가능한 객실 정보 조회
	@Override
	public List<Room_ReservationVO> getReservationsByHotelAndDates(Map<String, Object> params) {
		SqlSession session = null;
		List<Room_ReservationVO> ResList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			ResList = session.selectList("res.getReservations", params);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
		
		return ResList;
	}
	
	/**
	 * 호텔별 객실 가격 조회
	 * @param hotelId
	 * @return
	 */
	public List<Room_ReservationVO> getPrice(String hotelId) {
		SqlSession session = null;
		List<Room_ReservationVO> roomTypeList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			roomTypeList = session.selectList("res.getPrice", hotelId);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
		
		return roomTypeList;
		
	}
	
	public String getRandomNo(Room_ReservationVO hrrrVo) {
		SqlSession session = null;
		String room_no = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			room_no = session.selectOne("res.getRandomNo", hrrrVo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
		return room_no;
	}
	
	
}
