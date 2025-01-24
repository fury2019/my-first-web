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
import com.Hotel.vo.MemberVO;
import com.Hotel.vo.Goods_CartVO;

@WebServlet("/goods_CartDelete")
public class Goods_CartDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cartNo = request.getParameter("cart_no");

        // 서비스 호출
        IGoods_CartService service = Goods_CartServiceImpl.getInstance();
        service.deleteGoods_Cart(cartNo); // 장바구니에서 삭제

        // 삭제 후 장바구니 목록을 다시 가져와서 세션에 저장
        MemberVO loggedInMember = (MemberVO) request.getSession().getAttribute("loginCode");
        String memId = (loggedInMember != null) ? loggedInMember.getMem_id() : null;

        // 장바구니 목록 가져오기
        List<Goods_CartVO> goods_CartList = service.getAllGoodsCart(memId);
        request.getSession().setAttribute("Goods_CartList", goods_CartList);

        // 장바구니 목록 페이지로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/Goods_CartList.jsp");
    }
}
