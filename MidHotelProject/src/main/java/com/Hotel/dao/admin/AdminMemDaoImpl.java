package com.Hotel.dao.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.util.MybatisUtil;
import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Room_ReservationVO;

public class AdminMemDaoImpl implements IAdminMemDao {
	
	 private static AdminMemDaoImpl dao;

	    private AdminMemDaoImpl() {}

	    public static AdminMemDaoImpl getInstance() {
	        if (dao == null) dao = new AdminMemDaoImpl();
	        return dao;
	    }
	

	@Override
	public List<MemberVO> getRecentMembers() {
		 try (SqlSession session = MybatisUtil.getSqlSession()) {
	            return session.selectList("admin.recentMembers");
	        }
	}

	@Override
	public List<Room_ReservationVO> getRecentReservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> getAllMembers() {
		try (
				SqlSession session = MybatisUtil.getSqlSession()) 
		{
            return session.selectList("admin.viewAllMember");
        }
	}

	@Override
	public boolean memberBlack(String memId) {
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			int result = session.update("admin.memberBlack",memId);
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

	@Override
	public boolean memberRevert(String memId) {
SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			int result = session.update("admin.memberRevert",memId);
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
