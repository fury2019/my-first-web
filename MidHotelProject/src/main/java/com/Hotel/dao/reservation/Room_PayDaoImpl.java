package com.Hotel.dao.reservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.common.util.MybatisUtil;
import com.Hotel.vo.CouponVO;
import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Room_PaymentVO;

public class Room_PayDaoImpl implements IRoom_PayDao {
	private static Room_PayDaoImpl dao;
	
	private Room_PayDaoImpl() {
		
	}
	
	public static Room_PayDaoImpl getInstance() {
		if(dao == null)
			dao = new Room_PayDaoImpl();
		return dao;
	}
	
	
	
	//결제 정보 삽입
	@Override
	public int insertPay(Room_PaymentVO pay) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("pay.insertPay", pay);
			if(cnt>0)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
			session.close();
		}
		
		return cnt;		
	}
	
	//예약 정보 삭제 
	public int deletePay(String r_res_no) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.delete("pay_delectPay",r_res_no);
			if(cnt>0)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return cnt;
		
	}
	
	//전체 결제 목록 보여주기
	public List<Room_PaymentVO> getAllRoomPayment(){
		List<Room_PaymentVO> PayList = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			PayList = session.selectList("pay.selectAllPay");	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return PayList;
	}
	
	//예약 번호를 받아와 목록 보여주기
	public List<Room_PaymentVO> selectRoomPayment(String r_res_no){
		List<Room_PaymentVO> selList = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			selList = session.selectList("pay.selectgetPay", r_res_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return selList;
	}
	
	/**
	 * 내 쿠폰 정보 가져오기
	 * @param mem_id
	 * @return
	 */
	public List<CouponVO> getCoupon(String mem_id){
		List<CouponVO> coupon = null;
		return coupon;
	}
	
	/**
	 * 포인트/등급/등급별 적립률
	 * @param mem_id
	 * @return
	 */
	public List<MemberVO> getPointGrade(String mem_id){
		List<MemberVO> getPointGrade = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			getPointGrade = session.selectList("pay.getPointGrade", mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		
		return getPointGrade;
	}
	
	public int updatePoint(int addPoint, String mem_id) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session=MybatisUtil.getSqlSession();
			
			Map<String, Object> params = new HashMap<>();
			params.put("addPoint", addPoint);
			params.put("mem_id", mem_id);

			cnt = session.update("pay.updatePoint", params);
			
			cnt = session.update("pay.updatePoint",params);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return cnt;
	}
	
}
