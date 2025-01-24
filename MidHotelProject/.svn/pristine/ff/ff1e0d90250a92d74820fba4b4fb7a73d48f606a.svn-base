package com.Hotel.service.Coupon;

import java.util.List;

import com.Hotel.dao.Coupon.CouponDaoImpl;
import com.Hotel.dao.Coupon.ICouponDao;
import com.Hotel.dao.admin.CouponInsertDaoImpl;
import com.Hotel.dao.admin.ICouponInsertDao;
import com.Hotel.service.admin.CouponInsertServiceImpl;
import com.Hotel.vo.CouponVO;

public class CouponServiceImpl implements ICouponService {
	
	private static CouponServiceImpl service;

	private ICouponDao dao;

	private CouponServiceImpl() {
		dao = CouponDaoImpl.getInstance();
	}
	
	public static CouponServiceImpl getInstance() {
		if (service == null)
			service = new CouponServiceImpl();

		return service;
	}	

	@Override
	public List<CouponVO> myCoupon(String mem_id) {
		return dao.myCoupon(mem_id);
	}

}
