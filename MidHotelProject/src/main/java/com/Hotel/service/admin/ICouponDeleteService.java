package com.Hotel.service.admin;

import java.util.List;

import com.Hotel.vo.CouponVO;

public interface ICouponDeleteService {

	public List<CouponVO> viewAllCoupon();
	
	public boolean deleteCoupon(int couponId);
	
}
