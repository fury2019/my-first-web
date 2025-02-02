package com.Hotel.dao.Coupon;

import org.apache.ibatis.session.SqlSession;
import com.Hotel.common.util.MybatisUtil;
import com.Hotel.vo.CouponVO;

import java.util.List;

public class CouponDaoImpl implements ICouponDao {
    private static CouponDaoImpl dao;

    private CouponDaoImpl() { }

    public static ICouponDao getInstance() {
        if (dao == null) {
            dao = new CouponDaoImpl();
        }
        return dao;
    }

    @Override
    public List<CouponVO> getCouponsByMemberId(String memberId) {
        SqlSession session = MybatisUtil.getSqlSession();
        List<CouponVO> couponList = null;
        try {
            couponList = session.selectList("Coupon.getCouponsByMemberId", memberId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return couponList;
    }

	@Override
	public List<CouponVO> myCoupon(String mem_id) {
		SqlSession session = MybatisUtil.getSqlSession();
        List<CouponVO> couponList = null;
        try {
        	
        	couponList = session.selectList("Coupon.myCoupon", mem_id);
			
		} catch (Exception e) {
		} finally {
            if (session != null) session.close();
        }
        return couponList;
	}
}
