package com.Hotel.service.admin;

import com.Hotel.dao.admin.CouponInsertDaoImpl;
import com.Hotel.dao.admin.ICouponInsertDao;
import com.Hotel.dao.member.IJoinLoginDao;
import com.Hotel.dao.member.JoinLoginDaoImpl;
import com.Hotel.service.member.JoinLoginServiceImpl;
import com.Hotel.vo.CouponVO;

public class CouponInsertServiceImpl implements ICouponInsertService {
	
	private static CouponInsertServiceImpl service;

	private ICouponInsertDao dao;

	private CouponInsertServiceImpl() {
		dao = CouponInsertDaoImpl.getInstance();
	}

	public static CouponInsertServiceImpl getInstance() {
		if (service == null)
			service = new CouponInsertServiceImpl();

		return service;
	}	

	@Override
	public int insertCoupon(CouponVO couponVo) {
		return dao.insertCoupon(couponVo);
	}

}
