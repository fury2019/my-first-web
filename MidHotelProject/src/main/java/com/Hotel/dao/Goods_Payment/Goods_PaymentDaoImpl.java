package com.Hotel.dao.Goods_Payment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.common.util.MybatisUtil;
import com.Hotel.vo.Goods_PaymentVO;

public class Goods_PaymentDaoImpl implements IGoods_PaymentDao {
    private static Goods_PaymentDaoImpl dao;

    private Goods_PaymentDaoImpl() { }

    public static IGoods_PaymentDao getInstance() {
        if (dao == null) dao = new Goods_PaymentDaoImpl();
        return dao;
    }

    @Override
    public int insertPayment(Goods_PaymentVO payment) {
        SqlSession session = MybatisUtil.getSqlSession();
        int cnt = 0; 
        try {
            // 매퍼의 네임스페이스와 ID를 올바르게 사용
            cnt = session.insert("com.Hotel.dao.Goods_Payment.Goods_PaymentDaoImpl.insertPayment", payment);
            if (cnt > 0) session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback(); // 발생한 예외에 대해 롤백
        } finally {
            if (session != null) session.close();
        }
        return cnt;
    }

    @Override
    public int deletePayment(String payId) {
        SqlSession session = MybatisUtil.getSqlSession(); 
        int cnt = 0;
        try {
            cnt = session.delete("Payment.deletePayment", payId);
            if (cnt > 0) session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback(); // 발생한 예외에 대해 롤백
        } finally {
            if (session != null) session.close();
        }   
        return cnt;
    }

    @Override
    public int updatePayment(Goods_PaymentVO payment) {
        SqlSession session = MybatisUtil.getSqlSession();  
        int cnt = 0;
        try {
            cnt = session.update("Payment.updatePayment", payment);
            if (cnt > 0) session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback(); // 발생한 예외에 대해 롤백
        } finally {
            if (session != null) session.close();
        }   
        return cnt;
    }

    @Override
    public List<Goods_PaymentVO> getAllPayments() {
        SqlSession session = MybatisUtil.getSqlSession();  
        List<Goods_PaymentVO> paymentList = null;
        try {
            paymentList = session.selectList("Payment.getAllPayments");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }   
        return paymentList;
    }

    @Override
    public Goods_PaymentVO getPaymentById(String payId) {
        SqlSession session = MybatisUtil.getSqlSession(); 
        Goods_PaymentVO payment = null;
        try {
            payment = session.selectOne("Payment.getPaymentById", payId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        } 
        return payment;
    }
}
