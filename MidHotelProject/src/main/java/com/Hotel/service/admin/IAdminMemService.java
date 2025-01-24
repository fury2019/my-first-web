package com.Hotel.service.admin;

import java.util.List;

import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Room_ReservationVO;

public interface IAdminMemService {

	public List<MemberVO> getRecentMembers();
	
	public List<MemberVO> getAllMembers();
	 
	public List<Room_ReservationVO> getRecentReservations();
	
	public boolean memberBlack(String memId);
	
	public boolean memberRevert(String memId);
	 
}
