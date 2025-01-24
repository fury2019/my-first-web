package com.Hotel.dao.admin;

import java.util.List;

import com.Hotel.vo.CouponVO;

public interface ICouponDeleteDao {
	
	public List<CouponVO> viewAllCoupon();
	
	public boolean deleteCoupon(int couponId);
}
