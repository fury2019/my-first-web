package com.Hotel.service.Goods_Payment;

import java.util.List;

import com.Hotel.dao.Goods_Payment.IGoods_PaymentDao;
import com.Hotel.dao.Goods_Payment.Goods_PaymentDaoImpl; // 적절한 DAO 구현 클래스를 import
import com.Hotel.vo.Goods_PaymentVO;

public class Goods_PaymentServiceImpl implements IGoods_PaymentService {
    
    private IGoods_PaymentDao dao;
    private static Goods_PaymentServiceImpl service;

    private Goods_PaymentServiceImpl() {
        dao = Goods_PaymentDaoImpl.getInstance(); // 적절한 DAO 구현 클래스 사용
    }

    public static Goods_PaymentServiceImpl getInstance() {
        if(service == null) service = new Goods_PaymentServiceImpl();
        return service;
    }
    
    @Override
    public int insertPayment(Goods_PaymentVO payment) {
        return dao.insertPayment(payment);
    }
    
    @Override
    public int updatePayment(Goods_PaymentVO payment) {
        return dao.updatePayment(payment);
    }
    
    @Override
    public int deletePayment(String payId) {
        return dao.deletePayment(payId);
    }

    @Override
    public List<Goods_PaymentVO> getAllPayments() {
        return dao.getAllPayments(); // 모든 결제를 조회하는 메서드 호출
    }

    @Override
    public Goods_PaymentVO getPaymentById(String payId) {
        return dao.getPaymentById(payId); // 결제 ID로 조회하는 메서드 호출
    }
}
