package com.Hotel.service.Coupon;

import com.Hotel.dao.Coupon.ICouponDao;
import com.Hotel.dao.Coupon.CouponDaoImpl;
import com.Hotel.vo.CouponVO;

import java.util.List;

public class CouponService {
    private ICouponDao couponDao;

    public CouponService() {
        couponDao = CouponDaoImpl.getInstance(); // DAO 인스턴스 생성
    }

    public List<CouponVO> getAvailableCoupons(String memberId) {
        return couponDao.getCouponsByMemberId(memberId); // DAO 호출
    }
    
    
    
}
