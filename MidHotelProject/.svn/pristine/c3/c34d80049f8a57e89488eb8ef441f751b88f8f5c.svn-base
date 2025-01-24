package com.Hotel.service.admin;

import java.util.List;

import com.Hotel.dao.admin.CouponDeleteDaoImpl;
import com.Hotel.dao.admin.ICouponDeleteDao;
import com.Hotel.dao.member.IMemberUpdateDao;
import com.Hotel.dao.member.MemberUpdateDaoImpl;
import com.Hotel.service.member.IMemberUpdateService;
import com.Hotel.service.member.MemberUpdateServiceImpl;
import com.Hotel.vo.CouponVO;

public class CouponDeleteServiceImpl implements ICouponDeleteService {
	
	private static ICouponDeleteService service;
	private ICouponDeleteDao dao;
	
	public CouponDeleteServiceImpl() {
		dao = CouponDeleteDaoImpl.getInstance();
	}
	
	public static ICouponDeleteService getInstance() {
		if(service == null) service = new CouponDeleteServiceImpl();
		
		return service;
	}
	

	@Override
	public List<CouponVO> viewAllCoupon() {
		return dao.viewAllCoupon();
	}

	@Override
	public boolean deleteCoupon(int couponId) {
		return dao.deleteCoupon(couponId);
	}

}
