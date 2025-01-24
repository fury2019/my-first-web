package com.Hotel.controller.Goods_Payment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.dao.Goods_Payment.IGoods_PaymentDao;
import com.Hotel.dao.Goods_Payment.Goods_PaymentDaoImpl;
import com.Hotel.service.Goods_Payment.IGoods_PaymentService;
import com.Hotel.service.Goods_Payment.Goods_PaymentServiceImpl;
import com.Hotel.vo.Goods_PaymentVO;
import com.Hotel.common.util.MybatisUtil;

@WebServlet("/goods_PaymentInsert")
public class Goods_PaymentInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IGoods_PaymentService service = Goods_PaymentServiceImpl.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IGoods_PaymentDao goodsPaymentDao = Goods_PaymentDaoImpl.getInstance();
        SqlSession session = MybatisUtil.getSqlSession(); // MyBatis SqlSession 가져오기

        try {
            // 파라미터 받기
            String payId = request.getParameter("payId");
            String cartNo = request.getParameter("cartNo");
            String goodsIdList = request.getParameter("goodsIdList"); 
            int pUsePoint = Integer.parseInt(request.getParameter("pUsePoint"));
            String couponNo = request.getParameter("couponNo");
            int pEarnPoint = Integer.parseInt(request.getParameter("pEarnPoint"));
            int pTotPrice = Integer.parseInt(request.getParameter("pPrice"));

            // 유효성 검사
            if (goodsIdList == null || goodsIdList.isEmpty()) {
                request.setAttribute("errorMessage", "상품 ID가 필요합니다.");
                request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
                return;
            }

            if (cartNo == null || cartNo.isEmpty() || cartNo.equals("0")) {
                request.setAttribute("errorMessage", "유효하지 않은 장바구니 번호입니다.");
                request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
                return;
            }

            // goodsIdList를 배열로 변환
            String[] goodsIds = goodsIdList.split(",");

            // 각 상품에 대해 결제 처리
            for (String goodsId : goodsIds) {
                if (goodsId == null || goodsId.trim().isEmpty()) {
                    request.setAttribute("errorMessage", "유효하지 않은 상품 ID입니다.");
                    request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
                    return;
                }

                // Goods_PaymentVO 객체 생성
                Goods_PaymentVO payment = new Goods_PaymentVO();
                payment.setPayId(payId);
                payment.setCart_no(cartNo);
                payment.setGoods_id(goodsId);
                payment.setP_use_point(pUsePoint);
                payment.setCoupon_no(couponNo);
                payment.setP_earn_point(pEarnPoint);
                payment.setP_tot_price(pTotPrice);
                payment.setP_price(pTotPrice);
                payment.setP_date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

                // 데이터베이스에 삽입
                int result = goodsPaymentDao.insertPayment(payment);
                if (result <= 0) {
                    session.rollback(); // 오류 발생 시 롤백
                    request.setAttribute("errorMessage", "결제 정보 삽입에 실패했습니다.");
                    request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
                    return;
                }
                request.setAttribute("payment", payment);
            }

            // 모든 작업이 성공하면 커밋
            session.commit();

            // 결제 성공 시 처리
//            request.setAttribute("message", "결제가 완료되었습니다.");
//            request.getRequestDispatcher("/jsp/paymentConfirmation.jsp").forward(request, response);
            request.getRequestDispatcher("/jsp/GoodsPayment.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace(); // 에러 로그 출력
            if (session != null) {
                session.rollback(); // 오류 발생 시 롤백
            }
            request.setAttribute("errorMessage", "결제 처리 중 오류가 발생했습니다.");
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        } finally {
            if (session != null) {
                session.close(); // 연결 해제
            }
        }
    }
}

	

