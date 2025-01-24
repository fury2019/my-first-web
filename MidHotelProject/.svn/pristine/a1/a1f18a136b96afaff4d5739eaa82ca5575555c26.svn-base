package com.Hotel.dao.CustomerInquiry;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.common.util.MybatisUtil;
import com.Hotel.vo.HotelVO;

public class CustomerDaoImpl implements ICustomerDao {

	private static CustomerDaoImpl dao;
	
	private CustomerDaoImpl() {   }
	
	public static ICustomerDao getInstance() {
		if(dao==null) dao = new CustomerDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public List<HotelVO> getAllHotel() {
		
		SqlSession session = MybatisUtil.getSqlSession();  

		List<HotelVO> HotelList = null;
		
		try {
			
			HotelList = session.selectList("Cus.getAllHotel");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		return HotelList;
	}

}
