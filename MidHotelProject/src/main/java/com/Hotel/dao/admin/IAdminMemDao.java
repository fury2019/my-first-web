package com.Hotel.dao.admin;

import java.util.List;

import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Room_ReservationVO;

public interface IAdminMemDao {
	
	 public List<MemberVO> getRecentMembers();
	 
	 public List<MemberVO> getAllMembers();
	 
	 public boolean memberBlack(String memId);
	 
	 public boolean memberRevert(String memId);
	 
	 public List<Room_ReservationVO> getRecentReservations();
	 
	 
}
