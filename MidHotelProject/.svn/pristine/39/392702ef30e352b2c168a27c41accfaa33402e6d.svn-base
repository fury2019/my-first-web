package com.Hotel.service.CustomerInquiry;

import java.util.List;

import com.Hotel.dao.CustomerInquiry.CustomerDaoImpl;
import com.Hotel.dao.CustomerInquiry.ICustomerDao;
import com.Hotel.vo.HotelVO;

public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDao dao;
	private static CustomerServiceImpl service;
	
	private CustomerServiceImpl () {
		dao = CustomerDaoImpl.getInstance();
	}
	
	public static CustomerServiceImpl getInstance() {
		if(service==null) service = new CustomerServiceImpl();
		return service;
	}
	
	@Override
	public List<HotelVO> getAllHotel() {
		return dao.getAllHotel();
	}

}
