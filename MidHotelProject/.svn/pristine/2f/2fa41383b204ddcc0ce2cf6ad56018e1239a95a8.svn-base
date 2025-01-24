package com.Hotel.controller.Goods;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Hotel.service.Goods.IGoods_CartService;
import com.Hotel.service.Goods.Goods_CartServiceImpl;
import com.Hotel.vo.Goods_CartVO;
import com.Hotel.vo.MemberVO;

@WebServlet("/goods_CartInsert")
public class Goods_CartInsert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션에서 로그인 정보 가져오기
        MemberVO loggedInMember = (MemberVO) request.getSession().getAttribute("loginCode");
        String memId = (loggedInMember != null) ? loggedInMember.getMem_id() : null;

        // memId가 null인지 확인
        if (memId == null || memId.isEmpty()) {
            request.setAttribute("errorMessage", "로그인 후 장바구니에 추가해주세요.");
            request.getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
            return;
        }

        // 세션에서 카트 번호 가져오기
        Integer cartNo = (Integer) request.getSession().getAttribute("cartNo");

        // 파라미터 가져오기
        String goodsId = request.getParameter("goods_id");
        String goodsName = request.getParameter("goods_name");
        //String goodsName = "센터피스 1. Coral Pink"; // 상품명 (하드코딩)
        
        int goodsAmt = Integer.parseInt(request.getParameter("goods_amt"));
        int goodsPrice = Integer.parseInt(request.getParameter("goods_price"));

        // Goods_CartVO 객체 생성
        Goods_CartVO cartItem = new Goods_CartVO();
        cartItem.setCart_no(String.valueOf(cartNo)); // Integer를 String으로 변환하여 설정
        cartItem.setGoods_id(goodsId);
        cartItem.setMem_id(memId);
        cartItem.setGoods_amt(goodsAmt);
        cartItem.setGoods_price(goodsPrice);
        cartItem.setGoods_name(goodsName);

        // 서비스 호출
        IGoods_CartService service = Goods_CartServiceImpl.getInstance();
        service.insertGoods_Cart(cartItem); // 장바구니에 추가

        // 장바구니 목록 가져오기
        List<Goods_CartVO> goods_CartList = service.getAllGoodsCart(memId);
        request.getSession().setAttribute("Goods_CartList", goods_CartList); // 세션에 장바구니 목록 저장

        // 장바구니 목록 페이지로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/Goods_CartList.jsp");
    }
}








