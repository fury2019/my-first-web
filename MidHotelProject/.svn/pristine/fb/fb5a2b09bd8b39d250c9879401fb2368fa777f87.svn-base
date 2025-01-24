package com.Hotel.dao.reservation;

import java.util.List;

import com.Hotel.vo.CouponVO;
import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Room_PaymentVO;

public interface IRoom_PayDao {
	
	/**결제 정보 넣기
	 * 
	 * @param pay
	 * @return
	 */
	public int insertPay(Room_PaymentVO pay);

	/**
	 *  예약 정보 삭제
	 * @param r_res_no
	 * @return
	 */
	public int deletePay(String r_res_no);

	/**
	 *  전체 결제 목록 보여주기
	 * @return
	 */
	public List<Room_PaymentVO> getAllRoomPayment();

	/**
	 *  예약 번호를 받아와 목록 보여주기
	 * @param r_res_no
	 * @return
	 */
	public List<Room_PaymentVO> selectRoomPayment(String r_res_no);

	/**
	 * 내 쿠폰 정보 가져오기
	 * @param mem_id
	 * @return
	 */
//	public List<CouponVO> getCoupon(String mem_id);
	
	/**
	 * 포인트/등급/등급별 적립률
	 * @param mem_id
	 * @return
	 */
	public List<MemberVO> getPointGrade(String mem_id);
	
	/**
	 * 계산된 금액의 ..% 를 point에 저장
	 * @param mem_id
	 * @return
	 */
	public int updatePoint(int addPoint, String mem_id);
	
	

}
