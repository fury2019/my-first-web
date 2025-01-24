package com.shinnaHotel.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.shinnaHotel.DTO.ResCancelDTO;
import com.shinnaHotel.DTO.ReservationDTO;
import com.shinnaHotel.DTO.RoomDTO;
import com.shinnaHotel.mybatis.SqlMapConfig;

public class ReservationDAO {

	
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlSession;
	
	public ReservationDAO() {
		sqlSession = factory.openSession(true);
		
	}
	

	public List<ReservationDTO> searchRoom(Map<String, Object> param) {
		System.out.println("dao도착");
		System.out.println(param);
		List<ReservationDTO> roomArr = sqlSession.selectList("Reservation.searchRoom", param);
		
		System.out.println(roomArr);
		
		
		return roomArr;
	}


	public boolean insertReservation(ReservationDTO rdto) {
		boolean result = false;
		
		if(sqlSession.insert("Reservation.insertReservation", rdto) == 1) {
			result = true;
		}
		return result;
	}
	
	public List<ReservationDTO> selectReservation(String u_id){
		List<ReservationDTO> result = sqlSession.selectList("Reservation.selectReservation", u_id);
		return result;
	}
	
	
	public boolean insertResCancel(ResCancelDTO rcdto) {
		boolean result = false;
		
		if(sqlSession.insert("Reservation.insertResCancel", rcdto) != 0) {
			result = true;
		}
		
		return result;	
	}


	public boolean updateReservation(int res_number) {
		boolean result = false;
		
		if(sqlSession.delete("Reservation.updateReservation", res_number) != 0) {
			result = true;
		}
		return result;
		
	}


	public List<RoomDTO> getAllRoomList() {

		List<RoomDTO> result = sqlSession.selectList("Reservation.getAllRoomList");
		return result;
	}
	

	
	

}
