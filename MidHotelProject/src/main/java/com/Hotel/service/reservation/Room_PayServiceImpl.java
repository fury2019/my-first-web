package com.Hotel.service.reservation;

import java.util.List;

import com.Hotel.dao.reservation.IRoom_PayDao;
import com.Hotel.dao.reservation.Room_PayDaoImpl;
import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Room_PaymentVO;

public class Room_PayServiceImpl implements IRoom_PayService {
	private static Room_PayServiceImpl service;
	
	private IRoom_PayDao dao;
	
	private Room_PayServiceImpl() {
		dao = Room_PayDaoImpl.getInstance();
	}
	
	public static Room_PayServiceImpl getInstance() {
		if(service == null) {
			service = new Room_PayServiceImpl();
		}
		return service;
	}
	
	@Override
	public int insertPay(Room_PaymentVO pay) {
		return dao.insertPay(pay);
	}

	@Override
	public int deletePay(String r_res_no) {
		return dao.deletePay(r_res_no);
	}

	@Override
	public List<Room_PaymentVO> getAllRoomPayment() {
		return dao.getAllRoomPayment();
	}

	@Override
	public List<Room_PaymentVO> selectRoomPayment(String r_res_no) {
		return dao.selectRoomPayment(r_res_no);
	}
	
	/**
	 * 포인트/등급/등급별 적립률
	 * @param mem_id
	 * @return
	 */
	public List<MemberVO> getPointGrade(String mem_id){
		return dao.getPointGrade(mem_id);
	}
	
	/**
	 * 계산된 금액의 ..% 를 point에 저장
	 * @param mem_id
	 * @return
	 */
	public int updatePoint(int addPoint, String mem_id) {
		return dao.updatePoint(addPoint, mem_id);
	}

}
