package com.Hotel.service.admin;

import java.util.List;

import com.Hotel.dao.admin.AdminMemDaoImpl;
import com.Hotel.dao.admin.CouponDeleteDaoImpl;
import com.Hotel.dao.admin.IAdminMemDao;
import com.Hotel.dao.admin.ICouponDeleteDao;
import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Room_ReservationVO;

public class AdminMemServiceImpl implements IAdminMemService {
	
	private static IAdminMemService service;
	private IAdminMemDao dao;
	
	public AdminMemServiceImpl() {
		dao = AdminMemDaoImpl.getInstance();
	}
	
	public static IAdminMemService getInstance() {
		if(service == null) service = new AdminMemServiceImpl();
		
		return service;
	}

	@Override
	public List<MemberVO> getRecentMembers() {
		return dao.getRecentMembers();
	}

	@Override
	public List<MemberVO> getAllMembers() {
		return dao.getAllMembers();
	}
	
	@Override
	public List<Room_ReservationVO> getRecentReservations() {
		return null;
	}

	@Override
	public boolean memberBlack(String memId) {
		return dao.memberBlack(memId);
	}

	@Override
	public boolean memberRevert(String memId) {
		return dao.memberRevert(memId);
	}


}
