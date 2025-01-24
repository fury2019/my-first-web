package com.shinnaHotel.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.shinnaHotel.mybatis.SqlMapConfig;

public class CommentDAO {

	
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlSession;
	
	public CommentDAO() {
		sqlSession = factory.openSession(true);
	}
}
