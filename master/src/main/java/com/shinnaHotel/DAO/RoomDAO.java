package com.shinnaHotel.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.shinnaHotel.mybatis.SqlMapConfig;

public class RoomDAO {

	
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlSession;
	
	public RoomDAO() {
		sqlSession = factory.openSession(true);
	}
}
