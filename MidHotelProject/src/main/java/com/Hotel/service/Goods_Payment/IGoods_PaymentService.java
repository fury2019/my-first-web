package com.Hotel.service.Goods_Payment;

import java.util.List;

import com.Hotel.vo.Goods_PaymentVO;

public interface IGoods_PaymentService {

    // 결제 정보 삽입
	public int insertPayment(Goods_PaymentVO payment);

    // 결제 ID로 결제 정보 조회
	public Goods_PaymentVO getPaymentById(String payId);

    // 결제 정보 수정
    public int updatePayment(Goods_PaymentVO payment);

    // 결제 정보 삭제
    public int deletePayment(String payId);

    // 모든 결제 정보 조회
    public List<Goods_PaymentVO> getAllPayments();
}
