package com.Hotel.dao.admin;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.dao.member.JoinLoginDaoImpl;
import com.Hotel.util.MybatisUtil;
import com.Hotel.vo.CouponVO;

public class CouponInsertDaoImpl implements ICouponInsertDao {
	
	private static CouponInsertDaoImpl dao;

	private CouponInsertDaoImpl() {

	}

	public static CouponInsertDaoImpl getInstance() {
		if (dao == null)
			dao = new CouponInsertDaoImpl();
		return dao;
	}

	@Override
	public int insertCoupon(CouponVO couponVo) {
		
		SqlSession session = null;
		
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("admin.insertCoupon", couponVo);
				if(cnt > 0)
					session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
		return cnt;
	}

}
