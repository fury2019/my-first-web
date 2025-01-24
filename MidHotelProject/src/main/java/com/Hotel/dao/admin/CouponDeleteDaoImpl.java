package com.Hotel.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.dao.member.JoinLoginDaoImpl;
import com.Hotel.util.MybatisUtil;
import com.Hotel.vo.CouponVO;

public class CouponDeleteDaoImpl implements ICouponDeleteDao {
	
	private static CouponDeleteDaoImpl dao;

	private CouponDeleteDaoImpl() {

	}

	public static CouponDeleteDaoImpl getInstance() {
		if (dao == null)
			dao = new CouponDeleteDaoImpl();
		return dao;
	}
	
	@Override
	public List<CouponVO> viewAllCoupon() {
		SqlSession session = null;
		List<CouponVO> couponList = new ArrayList<>();
		
		
		try {
			session = MybatisUtil.getSqlSession();
			couponList = session.selectList("admin.viewAllCoupon");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return couponList;
	}

	@Override
	public boolean deleteCoupon(int couponId) {
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			int result = session.delete("admin.deleteCoupon", couponId);
			session.commit();
			return result > 0;
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

}
