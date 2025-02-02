package com.Hotel.controller.Goods;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.Hotel.service.Goods.Goods_CartServiceImpl;
import com.Hotel.service.Goods.IGoods_CartService;
import com.Hotel.vo.Goods_CartVO;

@WebServlet("/goods_CartUpdate")
public class Goods_CartUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        String cartNo = request.getParameter("cart_no");
        System.out.println("장바구니 번호: " + cartNo);

        IGoods_CartService service = Goods_CartServiceImpl.getInstance();
        Goods_CartVO goodsCVo = service.getCart(cartNo); // getCart 메서드로 장바구니 정보 조회

        if (goodsCVo == null) {
            request.setAttribute("errorMsg", "장바구니 정보를 불러올 수 없습니다.");
        } else {
            request.setAttribute("goodsCVo", goodsCVo);
        }

        request.getRequestDispatcher("/jsp/GoodsCartUpdate.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String cartNo = request.getParameter("cart_no");
        String goodsId = request.getParameter("goods_id");
        String memId = request.getParameter("mem_id");
        int goodsAmt = Integer.parseInt(request.getParameter("goods_amt"));

        Goods_CartVO goodsCVo = new Goods_CartVO();
        goodsCVo.setCart_no(cartNo);
        goodsCVo.setGoods_id(goodsId);
        goodsCVo.setMem_id(memId);
        goodsCVo.setGoods_amt(goodsAmt);

        IGoods_CartService service = Goods_CartServiceImpl.getInstance();
        service.updateGoods_Cart(goodsCVo);

        response.sendRedirect(request.getContextPath() + "/cartList"); // 장바구니 목록으로 리다이렉트
    }
}
